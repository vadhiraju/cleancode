package com.hotelautomationcontroller.equipment;

import com.hotelautomationcontroller.util.HelperConstant;
/**
 * 
 * @author Raju
 *
 */
public class Light {

	private int units = HelperConstant.LIGHT_POWER_UNIT;
	private int lightNo;
	private boolean switchState;

	public Light(boolean switchState) {
		this.switchState = switchState;

	}

	public int getLightNo() {
		return lightNo;
	}

	public void setLightNo(int lightNo) {
		this.lightNo = lightNo;
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
		return "Light " + lightNo + " : " + (switchState ? " ON" : "OFF");
	}

}
