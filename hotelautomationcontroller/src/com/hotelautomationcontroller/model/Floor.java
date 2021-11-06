package com.hotelautomationcontroller.model;

import java.util.List;

import com.hotelautomationcontroller.impl.MainCorridor;
import com.hotelautomationcontroller.impl.SubCorridor;

/**
 * 
 * @author Raju
 *
 */
public class Floor {

	private int floorNo;
	private List<MainCorridor> mainCorridors;
	private List<SubCorridor> subCorridors;

	public Floor(int floorNo) {
		this.floorNo = floorNo;
	}

	public List<MainCorridor> getMainCorridors() {
		return mainCorridors;
	}

	public void setMainCorridors(List<MainCorridor> mainCorridors) {
		this.mainCorridors = mainCorridors;
	}

	public List<SubCorridor> getSubCorridors() {
		return subCorridors;
	}

	public void setSubCorridors(List<SubCorridor> subCorridors) {
		this.subCorridors = subCorridors;
	}

	public int getFloorNo() {
		return floorNo;
	}

	/*
	 * public Corridor getCorridor(){ return CorridorType.MAIN != null?
	 * getMainCorridors().get(0):getSubCorridors().get(0); }
	 */

	@Override
	public String toString() {
		return "Floor " + floorNo + " ";
	}

}
