package com.pfa.main;

import java.util.List;

import com.pfa.obj.MemoryBlock;
import com.pfa.obj.Processus;

public class Allocator {

	private boolean run = false;
	private List<Processus> processusList;

	public Allocator(List<Processus> processusList) {
		this.processusList = processusList;
	}

	public void allocate(Processus processus, MemoryBlock block) throws InterruptedException {
		block.setFree(false);
		block.setProcessus(processus);
		Thread.sleep(processus.getRunTime());
		deallocate(block);
	}

	private void deallocate(MemoryBlock block) {
		block.setProcessus(null);
		block.setFree(true);
		run = true;
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean running) {
		this.run = running;
	}

}
