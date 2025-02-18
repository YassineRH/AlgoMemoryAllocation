package com.pfa.obj;

import java.util.Date;

public class Processus {

	private static int idCount;
	private Date birthDate;
	private int pId;
	private int memoryRequired;

	public Processus(int memoryRequired) {
		birthDate = new Date();
		this.memoryRequired = memoryRequired;
		idCount++;
		pId = idCount;
	}

	// GETTERS AND SETTERS
	// ...

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getMemoryRequired() {
		return memoryRequired;
	}

	public void setMemoryRequired(int memoryRequired) {
		this.memoryRequired = memoryRequired;
	}

}
