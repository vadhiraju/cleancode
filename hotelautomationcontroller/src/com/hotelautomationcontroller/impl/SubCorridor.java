package com.hotelautomationcontroller.impl;

import com.hotelautomationcontroller.intf.Corridor;
import com.hotelautomationcontroller.util.CorridorType;
/**
 * 
 * @author Raju
 *
 */
public class SubCorridor extends Corridor {

	private int subCorridorNo;
	private CorridorType type;

	public SubCorridor(int subCorridorNo) {
		super(CorridorType.SUB);
		this.subCorridorNo = subCorridorNo;
	}

	@Override
	public void setCorridorType(CorridorType corridorType) {
		this.type = corridorType;
	}

	@Override
	public CorridorType getCorridorType() {
		return type;
	}

	public int getSubCorridorNo() {
		return subCorridorNo;
	}

	@Override
	public String toString() {
		return " Sub corridor  "  + subCorridorNo + " ";
	}
	

}
