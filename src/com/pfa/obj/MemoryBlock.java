package com.pfa.obj;

public class MemoryBlock {

	private int size;
	private boolean free;
	private Processus processus;

	public MemoryBlock(int size, boolean free) {
		this.size = size;
		this.free = free;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public Processus getProcessus() {
		return processus;
	}

	public void setProcessus(Processus processus) {
		this.processus = processus;
	}

}
