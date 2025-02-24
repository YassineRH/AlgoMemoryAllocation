package com.pfa.main;

import java.util.ArrayList;
import java.util.List;

import com.pfa.obj.MemoryBlock;
import com.pfa.obj.Processus;

public class FirstFit {

	private List<Processus> processusList;
	private Allocator allocator;
	private boolean run = true;

	public FirstFit(Allocator allocator) {
		this.allocator = allocator;
	}

	public void algo(List<Processus> processusList, List<MemoryBlock> memoryBlocks) throws InterruptedException {
		List<Processus> waitingList = new ArrayList<>();

		for (Processus processus : processusList) {
			int blockId = -1;
			for (int i = 0; i < memoryBlocks.size(); i++) {
				MemoryBlock block = memoryBlocks.get(i);

				if (!block.isFree())
					continue;

				if (block.getSize() >= processus.getMemoryRequired()) {
					new Thread(() -> {
						try {
							allocator.allocate(processus, block);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}).start();
					break;
				}
			}
			if (blockId != -1)
				waitingList.add(processus);
		}
		processusList = waitingList;
	}

	public void Loop() {
		while (processusList.size() != 0) {
			if (!allocator.isRun())
				continue;
		}
	}
}
