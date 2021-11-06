package com.hotelautomationcontroller.command.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hotelautomationcontroller.builder.HotelBuilder;
import com.hotelautomationcontroller.command.IntermediateStateCommand;
import com.hotelautomationcontroller.controller.PowerController;
import com.hotelautomationcontroller.model.Hotel;
/**
 * 
 * @author Raju
 *
 */
public class IntermediateStateCommandTest {

	private HotelBuilder hotelBuilder;
	private PowerController powerController;
	private Hotel hotel;
	private IntermediateStateCommand intermediateStateCommand;

	public IntermediateStateCommandTest() {
		this.hotelBuilder = new HotelBuilder();
		this.hotel = hotelBuilder.setFloors(2).setMainCorridors(1).setSubCorridor(2).build();
		this.powerController = new PowerController(hotel);
		this.intermediateStateCommand = new IntermediateStateCommand(powerController);
	}

	@Test
	public void testExecute() {

		assertFalse("Light Not Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(1).getLights().get(0).isSwitchState());
		assertTrue("Ac Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(0).getAirConditioners().get(0).isSwitchState());
		intermediateStateCommand.execute();
		assertTrue("Light Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(1).getLights().get(0).isSwitchState());
		assertFalse("Ac Not Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(0).getAirConditioners().get(0).isSwitchState());

	}

}
