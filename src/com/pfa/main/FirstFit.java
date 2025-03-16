package com.pfa.main;

import java.util.ArrayList;
import java.util.List;

import com.pfa.obj.MemoryBlock;
import com.pfa.obj.Processus;

public class FirstFit {

	private List<Processus> processusList;
	private List<MemoryBlock> memoryBlocks;
	private Allocator allocator;

	public FirstFit(Allocator allocator, List<Processus> processusList, List<MemoryBlock> memoryBlocks) {
		this.allocator = allocator;
		this.processusList = processusList;
		this.memoryBlocks = memoryBlocks;
	}

	public List<Processus> algo(List<Processus> processusList) throws InterruptedException {
		List<Processus> waitingList = new ArrayList<>();

		for (Processus processus : processusList) {
			boolean allocated = false;
			for (MemoryBlock block : memoryBlocks) {
				synchronized (block) {
					if (block.isFree() && block.getSize() >= processus.getMemoryRequired()) {
						System.out.println(
								"allocating process: " + processus.getpId() + " in memory block: " + block.getId());
						block.setFree(false);
						block.setProcessus(processus);
						new Thread(() -> {
							try {
								allocator.allocate(processus, block);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}).start();
						allocated = true;
						break;
					}
				}
			}
			if (!allocated) {
				waitingList.add(processus);
				System.out.println(processus.getpId() + " has been added to waiting list");
				allocator.setRun(false);
			}
		}
		return waitingList;
	}

	public void Loop() {
		while (processusList.size() != 0) {
			if (allocator.isRun()) {
				try {
					processusList = algo(processusList);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}