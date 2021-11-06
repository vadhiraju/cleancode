package com.hotelautomationcontroller.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hotelautomationcontroller.builder.HotelBuilder;
import com.hotelautomationcontroller.impl.PowerConsumptionImpl;
import com.hotelautomationcontroller.intf.PowerCriteria;
import com.hotelautomationcontroller.model.Floor;
import com.hotelautomationcontroller.model.Hotel;
/**
 * 
 * @author Raju
 *
 */
public class PowerConsumptionImplTest {
	
	private PowerCriteria powerConsumption;
	
	public PowerConsumptionImplTest(){
		this.powerConsumption=new PowerConsumptionImpl();
	}

	@Test
	public void testPowerCriteria(){
	
		Hotel hotel=new HotelBuilder().setFloors(2).setMainCorridors(1).setSubCorridor(2).build();
		Floor floor=hotel.getFloors().get(0);
		assertTrue("Criteria met",powerConsumption.powerConsumptionCriteria(floor));
		
		floor.getSubCorridors().get(1).getLights().get(0).setSwitchState(true);
		assertFalse("Criteria not met",powerConsumption.powerConsumptionCriteria(floor));
		
		floor.getSubCorridors().get(0).getAirConditioners().get(0).setSwitchState(false);
		assertTrue("Criteria met",powerConsumption.powerConsumptionCriteria(floor));
		
		floor.getSubCorridors().get(1).getLights().get(0).setSwitchState(false);
		floor.getSubCorridors().get(0).getAirConditioners().get(0).setSwitchState(true);
		assertTrue("Criteria met",powerConsumption.powerConsumptionCriteria(floor));
		
	}
}
