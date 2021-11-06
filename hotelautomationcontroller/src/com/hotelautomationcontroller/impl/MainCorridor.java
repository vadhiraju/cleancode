package com.hotelautomationcontroller.impl;

import com.hotelautomationcontroller.intf.Corridor;
import com.hotelautomationcontroller.util.CorridorType;
/**
 * 
 * @author Raju
 *
 */
public class MainCorridor extends Corridor {

	private CorridorType type;
	private int mainCorridorNo;

	public MainCorridor(int mainCorridorNo) {
		super(CorridorType.MAIN);
		this.mainCorridorNo = mainCorridorNo;
	}

	@Override
	public void setCorridorType(CorridorType corridorType) {
		this.type = corridorType;

	}

	@Override
	public CorridorType getCorridorType() {
		return type;
	}

	public int getMainCorridorNo() {
		return mainCorridorNo;
	}

	@Override
	public String toString() {
		return " Main corridor " + mainCorridorNo + " ";
	}

	
}
