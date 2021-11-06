package com.hotelautomationcontroller.controller;

import java.util.HashMap;
import java.util.Map;

import com.hotelautomationcontroller.impl.PowerConsumptionImpl;
import com.hotelautomationcontroller.impl.SubCorridor;
import com.hotelautomationcontroller.model.Floor;
import com.hotelautomationcontroller.model.Hotel;
import com.hotelautomationcontroller.util.HelperConstant;
import com.hotelautomationcontroller.util.PowerControllerUtil;

/**
 * 
 * @author Raju
 *
 */
public class PowerController {

	private Hotel hotel;
	private PowerControllerUtil util;
	private Map<SubCorridor, SubCorridor> previousSubCorridorValues;

	public PowerController(Hotel hotel) {
		this.hotel = hotel;
		this.util = new PowerControllerUtil();
		previousSubCorridorValues = new HashMap<>();
	}

	/**
	 * it toggles light and Ac switches for the power consumption criteria.
	 */

	public void switchState() {

		int floorNo = HelperConstant.FLOOR_ONE;
		int subCorridorNo = HelperConstant.SUB_CORRIDOR_TWO;
		boolean motion = HelperConstant.MOTION;

		Floor matchingFloor = util.matchingFloor(hotel, floorNo);
		SubCorridor matchingSubCorridor = util.findMatchingSubCorridor(subCorridorNo, matchingFloor);
		if (util.isLightSwitchedOnAtSubCorridor(matchingSubCorridor)) {
			return;
		}
		matchingSubCorridor.getLights().forEach(light -> {
			light.setSwitchState(motion);
		});
		if (isPowerConsumptionExceededForFloor(matchingFloor)) {
			SubCorridor otherSubCorridor = util.findOtherSubCorridor(subCorridorNo, matchingFloor);
			util.switchOffAcAtSubCorridor(otherSubCorridor);
			previousSubCorridorValues.put(matchingSubCorridor, otherSubCorridor);
		}

	}

	/**
	 * it revokes back to the state.
	 */
	public void revokeState() {

		int floorNo = HelperConstant.FLOOR_ONE;
		int subCorridorNo = HelperConstant.SUB_CORRIDOR_TWO;
		Floor matchingFloor = util.matchingFloor(hotel, floorNo);
		SubCorridor matchingSubCorridor = util.findMatchingSubCorridor(subCorridorNo, matchingFloor);
		SubCorridor otherSubCorridor = previousSubCorridorValues.get(matchingSubCorridor);
		util.switchONAcAtSubCorridor(otherSubCorridor);
		util.switchOffLightAtSubCorridor(matchingSubCorridor);

	}

	/**
	 * it tells the power consumption criteria
	 * 
	 * @param floor
	 * @return
	 */
	private boolean isPowerConsumptionExceededForFloor(Floor floor) {
		PowerConsumptionImpl powerConsumptionCriteria = new PowerConsumptionImpl();
		return !powerConsumptionCriteria.powerConsumptionCriteria(floor);
	}

	/**
	 * it gets the hotel state.
	 * 
	 * @return
	 */
	public Hotel getHotel() {
		return hotel;
	}

}
