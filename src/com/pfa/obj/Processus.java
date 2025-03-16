package com.pfa.obj;

import java.util.Date;

public class Processus {

	private static int idCount;

	private Date birthDate;
	private int pId;
	private int memoryRequired;
	private int runTime;

	public Processus(int memoryRequired, int runTime) {
		birthDate = new Date();
		this.memoryRequired = memoryRequired;
		this.runTime=runTime;
		idCount++;
		pId = idCount;
	}

	// GETTERS AND SETTERS
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

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

}
