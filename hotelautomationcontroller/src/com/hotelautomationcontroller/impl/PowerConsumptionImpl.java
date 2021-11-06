package com.hotelautomationcontroller.impl;

import java.util.List;

import com.hotelautomationcontroller.intf.PowerCriteria;
import com.hotelautomationcontroller.model.Floor;
/**
 * 
 * @author Raju
 *
 */
public class PowerConsumptionImpl implements PowerCriteria {

	/**
	 * checks the power consumption criteria.
	 */
	@Override
	public boolean powerConsumptionCriteria(Floor floor) {
		return powerConsumedPerFloor(floor) <= getMaxPowerAllowedPerFloor(floor);
	}

	/**
	 * 
	 * @param matchingFloor
	 * @return
	 */
	private int powerConsumedPerFloor(Floor matchingFloor) {

		List<MainCorridor> mainCorridors = matchingFloor.getMainCorridors();
		List<SubCorridor> subCorridors = matchingFloor.getSubCorridors();

		int sumOfPowersOfLightInMainCorridors = mainCorridors.stream()
				.flatMap(mainCorridor -> mainCorridor.getLights().stream()).filter(light -> light.isSwitchState())
				.mapToInt(light -> light.getUnits()).sum();
		int sumOfPowersOfAcInMainCorridors = mainCorridors.stream()
				.flatMap(mainCorridor -> mainCorridor.getAirConditioners().stream())
				.filter(airConditioner -> airConditioner.isSwitchState())
				.mapToInt(airConditioner -> airConditioner.getUnits()).sum();

		int sumOfPowersOfLightInSubCorridors = subCorridors.stream()
				.flatMap(SubCorridor -> SubCorridor.getLights().stream()).filter(light -> light.isSwitchState())
				.mapToInt(light -> light.getUnits()).sum();

		int sumOfPowersOfAcInSubCorridor = subCorridors.stream()
				.flatMap(SubCorridor -> SubCorridor.getAirConditioners().stream())
				.filter(airConditioner -> airConditioner.isSwitchState())
				.mapToInt(airConditioner -> airConditioner.getUnits()).sum();

		return sumOfPowersOfLightInMainCorridors + sumOfPowersOfAcInMainCorridors + sumOfPowersOfLightInSubCorridors
				+ sumOfPowersOfAcInSubCorridor;
	}

	/**
	 * 
	 * @param floor
	 * @return
	 */
	private int getMaxPowerAllowedPerFloor(Floor floor) {
		return (floor.getMainCorridors().size() * 15) + (floor.getSubCorridors().size() * 10);
	}

}
