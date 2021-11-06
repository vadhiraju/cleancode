package com.hotelautomationcontroller.builder;

import java.util.ArrayList;

import com.hotelautomationcontroller.equipment.AirConditioner;
import com.hotelautomationcontroller.equipment.Light;
import com.hotelautomationcontroller.impl.MainCorridor;
import com.hotelautomationcontroller.impl.SubCorridor;
import com.hotelautomationcontroller.model.Floor;
import com.hotelautomationcontroller.model.Hotel;
import com.hotelautomationcontroller.util.CorridorType;

/**
 * 
 * @author Raju
 *
 */
public class HotelBuilder {

	private Hotel hotel;

	public HotelBuilder() {
		this.hotel = new Hotel();
		hotel.setFloors(new ArrayList<>());
	}

	/**
	 * for setting the floor
	 * @param floorCount
	 * @return
	 */
	public HotelBuilder setFloors(int floorCount) {

		for (int floorCounter = 1; floorCounter <= floorCount; floorCounter++) {
			Floor floor = new Floor(floorCounter);
			floor.setSubCorridors(new ArrayList<>());
			floor.setMainCorridors(new ArrayList<>());
			hotel.getFloors().add(floor);

		}
		return this;

	}

	/**
	 * for setting main corridors
	 * @param mainCorridorCnt
	 * @return
	 */
	public HotelBuilder setMainCorridors(int mainCorridorCnt) {
		int floorCnt = hotel.getFloors().size();
		for (int floorCounter = 1; floorCounter <= floorCnt; floorCounter++) {
			for (int mainCorridorCounter = 1; mainCorridorCounter <= mainCorridorCnt; mainCorridorCounter++) {
				MainCorridor mainCorridor = new MainCorridor(mainCorridorCounter);
				mainCorridor.setCorridorType(CorridorType.MAIN);
				Light light = new Light(true);
				light.setLightNo(mainCorridorCounter);
				mainCorridor.addLightToCorridor(light);

				mainCorridor.addAcToCorridor(new AirConditioner(true));
				hotel.getFloors().get(floorCounter-1).getMainCorridors().add(mainCorridor);
			}
		}
		return this;

	}

	/**
	 * for setting sub corridors
	 * @param subCorridorCnt
	 * @return
	 */
	public HotelBuilder setSubCorridor(int subCorridorCnt) {

		int floorCnt = hotel.getFloors().size();
		for (int floorCounter = 1; floorCounter <= floorCnt; floorCounter++) {
			for (int subCorridorCounter = 1; subCorridorCounter <= subCorridorCnt; subCorridorCounter++) {
				SubCorridor subCorridor = new SubCorridor(subCorridorCounter);
				subCorridor.setCorridorType(CorridorType.SUB);

				Light light = new Light(false);
				light.setLightNo(subCorridorCounter);
				subCorridor.addLightToCorridor(light);

				subCorridor.addAcToCorridor(new AirConditioner(true));
				hotel.getFloors().get(floorCounter-1).getSubCorridors().add(subCorridor);
			}
		}
		return this;

	}

	/**
	 * builds hotel.
	 * @return
	 */
	public Hotel build() {
		return hotel;
	}

}
