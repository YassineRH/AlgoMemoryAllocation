package com.pfa.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pfa.obj.MemoryBlock;
import com.pfa.obj.Processus;

public class Main {

	public static void main(String[] args) {
		List<Processus> processusList = new ArrayList<Processus>();
		List<MemoryBlock> memoryBlocks = new ArrayList<MemoryBlock>();
		Random random = new Random();
		System.out.println("\t\tid\tmemory\truntime");
		for (int i = 0; i < 5; i++) {
			Processus processus = new Processus(random.nextInt(3), random.nextInt(5) * 1000);
			processusList.add(processus);
			System.out.println("Created Process\t" + processus.getpId() + "\t" + processus.getMemoryRequired() + "\t"
					+ processus.getRunTime());
		}
		for (int i = 0; i < 2; i++) {
			MemoryBlock memoryBlock = new MemoryBlock(i + 1, random.nextInt(1, 2));
			memoryBlocks.add(memoryBlock);
			System.out.println(memoryBlock.getSize());
		}
		memoryBlocks.add(new MemoryBlock(3, 3));

		Allocator allocator = new Allocator();
		FirstFit firstFit = new FirstFit(allocator, processusList, memoryBlocks);
		firstFit.Loop();
	}

}
