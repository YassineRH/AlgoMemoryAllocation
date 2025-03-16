package com.pfa.main;

import com.pfa.obj.MemoryBlock;
import com.pfa.obj.Processus;

public class Allocator {

	private boolean run = true;
	private int memoryBlocksInUse = 0;

	public void allocate(Processus processus, MemoryBlock block) throws InterruptedException {
		synchronized (block) {
			block.setFree(false);
			block.setProcessus(processus);
			memoryBlocksInUse++;
		}
		Thread.sleep(block.getProcessus().getRunTime());
		deallocate(block);
	}

	private void deallocate(MemoryBlock block) {
		synchronized (block) {
			System.out.println("freeing block containing: " + block.getProcessus().getpId());
			block.setProcessus(null);
			block.setFree(true);
			run = true;
			memoryBlocksInUse--;
		}
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean running) {
		this.run = running;
	}

	public int getMemoryBlocksInUse() {
		return memoryBlocksInUse;
	}

	public void setMemoryBlocksInUse(int memoryBlocksInUse) {
		this.memoryBlocksInUse = memoryBlocksInUse;
	}
}