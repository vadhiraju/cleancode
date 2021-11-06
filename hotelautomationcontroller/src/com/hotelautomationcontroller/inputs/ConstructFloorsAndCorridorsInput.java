package com.hotelautomationcontroller.inputs;
/**
 * 
 * @author Raju
 *
 */
public class ConstructFloorsAndCorridorsInput {

	private int noOfFloors;
	private int noOfMainCorridors;
	private int noOfSubCorridors;

	public ConstructFloorsAndCorridorsInput(int noOfFloors, int noOfMainCorridors, int noOfSubCorridors) {
		this.noOfFloors = noOfFloors;
		this.noOfMainCorridors = noOfMainCorridors;
		this.noOfSubCorridors = noOfSubCorridors;
	}

	public int getNoOfFloors() {
		return noOfFloors;
	}

	public int getNoOfMainCorridors() {
		return noOfMainCorridors;
	}

	public int getNoOfSubCorridors() {
		return noOfSubCorridors;
	}

}
