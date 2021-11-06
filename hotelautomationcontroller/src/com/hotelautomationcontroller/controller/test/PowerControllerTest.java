package com.hotelautomationcontroller.controller.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hotelautomationcontroller.builder.HotelBuilder;
import com.hotelautomationcontroller.controller.PowerController;
import com.hotelautomationcontroller.model.Hotel;
/**
 * 
 * @author Raju
 *
 */
public class PowerControllerTest {

	private Hotel hotel;
	private PowerController powerController;

	public PowerControllerTest() {
		this.hotel = new HotelBuilder().setFloors(2).setMainCorridors(1).setSubCorridor(2).build();
		this.powerController = new PowerController(hotel);
	}

	@Test
	public void testSwitchState() {

		assertFalse("Light Not Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(1).getLights().get(0).isSwitchState());
		assertTrue("Ac Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(0).getAirConditioners().get(0).isSwitchState());

		powerController.switchState();

		assertTrue("Light Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(1).getLights().get(0).isSwitchState());
		assertFalse("Ac Not Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(0).getAirConditioners().get(0).isSwitchState());

		powerController.revokeState();

		assertFalse("Light Not Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(1).getLights().get(0).isSwitchState());
		assertTrue("Ac Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(0).getAirConditioners().get(0).isSwitchState());

	}

}
