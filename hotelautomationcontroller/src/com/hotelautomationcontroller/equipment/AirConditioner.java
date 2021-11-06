package com.hotelautomationcontroller.equipment;

import com.hotelautomationcontroller.util.HelperConstant;
/**
 * 
 * @author Raju
 *
 */
public class AirConditioner {

	private int units = HelperConstant.AC_POWER_UNIT;
	private boolean switchState;

	public AirConditioner(boolean switchState) {
		this.switchState = switchState;
	}

	public void setSwitchState(boolean switchState) {
		this.switchState = switchState;
	}

	public int getUnits() {
		return units;
	}

	public boolean isSwitchState() {
		return switchState;
	}

	@Override
	public String toString() {
		return "AC  : " + (switchState ? "ON" : "OFF") + " ";
	}

}
