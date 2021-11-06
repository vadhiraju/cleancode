package com.hotelautomationcontroller.command.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hotelautomationcontroller.builder.HotelBuilder;
import com.hotelautomationcontroller.command.InitialStateCommand;
import com.hotelautomationcontroller.controller.PowerController;
import com.hotelautomationcontroller.model.Hotel;
/**
 * 
 * @author Raju
 *
 */
public class InitialStateCommandTest {

	private HotelBuilder hotelBuilder;
	private PowerController powerController;
	private InitialStateCommand initialStateCommand;
	private Hotel hotel;

	public InitialStateCommandTest() {
		this.hotelBuilder = new HotelBuilder();
		this.hotel = hotelBuilder.setFloors(2).setMainCorridors(1).setSubCorridor(2).build();
		this.powerController = new PowerController(hotel);
		this.initialStateCommand = new InitialStateCommand(powerController);
	}
	@Test
	public void testExecute() {
		initialStateCommand.execute();
		assertEquals(hotel, powerController.getHotel());

	}

}
