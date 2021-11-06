package com.hotelautomationcontroller.command.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hotelautomationcontroller.builder.HotelBuilder;
import com.hotelautomationcontroller.command.RevokeCommand;
import com.hotelautomationcontroller.controller.PowerController;
import com.hotelautomationcontroller.model.Hotel;
/**
 * 
 * @author Raju
 *
 */
public class RevokeCommandTest {

	private HotelBuilder hotelBuilder;
	private PowerController powerController;
	private Hotel hotel;
    private RevokeCommand command;

	public RevokeCommandTest(){
		
		this.hotelBuilder = new HotelBuilder();
		this.hotel = hotelBuilder.setFloors(2).setMainCorridors(1).setSubCorridor(2).build();
		this.powerController = new PowerController(hotel);
		this.command=new RevokeCommand(powerController);
	}
	
	@Test
	public void testExecute(){
		
		assertFalse("Light Not Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(1).getLights().get(0).isSwitchState());
		assertTrue("Ac Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(0).getAirConditioners().get(0).isSwitchState());
		
		powerController.switchState();
		
		assertTrue("Light Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(1).getLights().get(0).isSwitchState());
		assertFalse("Ac Not Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(0).getAirConditioners().get(0).isSwitchState());
		
		command.execute();
		
		assertTrue("Light Not Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(1).getLights().get(0).isSwitchState());
		assertFalse("Ac Switched On",
				hotel.getFloors().get(0).getSubCorridors().get(0).getAirConditioners().get(0).isSwitchState());

		
	}
	
}
