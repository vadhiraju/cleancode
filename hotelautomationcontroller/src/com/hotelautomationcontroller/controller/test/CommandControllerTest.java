package com.hotelautomationcontroller.controller.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.hotelautomationcontroller.builder.HotelBuilder;
import com.hotelautomationcontroller.controller.CommandController;
import com.hotelautomationcontroller.controller.PowerController;
import com.hotelautomationcontroller.model.Hotel;
/**
 * 
 * @author Raju
 *
 */
public class CommandControllerTest {

	private CommandController commandController;
	private PowerController powerController;
	private Hotel hotel;

	public CommandControllerTest() {
		this.hotel=new HotelBuilder().setFloors(2).setMainCorridors(1).setSubCorridor(2).build();
		this.commandController = new CommandController();
		this.powerController = new PowerController(hotel);
	}

	@Test
	public void testCommands() {

		List<String> commands = commandController.getKeyInCommands();
		assertEquals("Default State", commands.get(0));
		assertEquals("Floor 1,Sub corridor 2", commands.get(1));
		assertEquals("No movement", commands.get(2));
		commandController.setCommands(commands, powerController);
		assertEquals(hotel,powerController.getHotel());

	}

}
