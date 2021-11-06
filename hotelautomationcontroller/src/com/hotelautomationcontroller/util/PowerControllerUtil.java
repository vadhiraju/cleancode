package com.hotelautomationcontroller.util;

import java.util.Optional;

import com.hotelautomationcontroller.impl.SubCorridor;
import com.hotelautomationcontroller.model.Floor;
import com.hotelautomationcontroller.model.Hotel;

/**
 * 
 * @author Raju
 *
 */
public class PowerControllerUtil {

	/**
	 * it will find the matching floor.
	 * 
	 * @param hotel
	 * @param floorNo
	 * @return
	 */
	public Floor matchingFloor(Hotel hotel, int floorNo) {
		Optional<Floor> matchingFloor = hotel.getFloors().stream().filter(floor -> floor.getFloorNo() == floorNo)
				.findFirst();
		return matchingFloor.get();
	}

	/**
	 * it will find the matching sub corridor
	 * 
	 * @param subCorridorNo
	 * @param floor
	 * @return
	 */
	public SubCorridor findMatchingSubCorridor(int subCorridorNo, Floor floor) {
		Optional<SubCorridor> matchingSubCorridor = floor.getSubCorridors().stream()
				.filter(subCorridor -> subCorridor.getSubCorridorNo() == subCorridorNo).findFirst();
		return matchingSubCorridor.get();
	}

	/**
	 * it will find some other sub corridor
	 * 
	 * @param subCorridorNo
	 * @param floor
	 * @return
	 */
	public SubCorridor findOtherSubCorridor(int subCorridorNo, Floor floor) {
		return floor.getSubCorridors().stream().filter(subCorridor -> subCorridor.getSubCorridorNo() != subCorridorNo)
				.findFirst().get();

	}

	/**
	 * it switches off ac
	 * 
	 * @param subCorridor
	 */
	public void switchOffAcAtSubCorridor(SubCorridor subCorridor) {
		subCorridor.getAirConditioners().get(0).setSwitchState(false);
	}

	/**
	 * it switches on ac
	 * 
	 * @param subCorridor
	 */
	public void switchONAcAtSubCorridor(SubCorridor subCorridor) {
		subCorridor.getAirConditioners().get(0).setSwitchState(true);
	}

	/**
	 * it will checks for the switched on light.
	 * 
	 * @param subCorridor
	 * @return
	 */
	public boolean isLightSwitchedOnAtSubCorridor(SubCorridor subCorridor) {
		return subCorridor.getLights().get(0).isSwitchState();
	}

	/**
	 * it switches off the light.
	 * 
	 * @param subCorridor
	 */
	public void switchOffLightAtSubCorridor(SubCorridor subCorridor) {
		subCorridor.getLights().get(0).setSwitchState(false);
	}

}
