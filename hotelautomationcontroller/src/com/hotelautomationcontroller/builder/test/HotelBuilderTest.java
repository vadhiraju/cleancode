package com.hotelautomationcontroller.builder.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hotelautomationcontroller.builder.HotelBuilder;
import com.hotelautomationcontroller.model.Hotel;

public class HotelBuilderTest {

	private HotelBuilder hotelBuilder;

	public HotelBuilderTest() {
		hotelBuilder = new HotelBuilder();

	}

	@Test
	public void testSetFloors() {

		Hotel hotel = hotelBuilder.setFloors(2).build();
		assertTrue("Invalid floor count", hotel.getFloors().size() == 2);

	}

	@Test
	public void testSetMainCorridors() {
		Hotel hotel = hotelBuilder.setFloors(2).setMainCorridors(1).build();
		assertTrue("Invalid Main Corridors count", hotel.getFloors().get(0).getMainCorridors().size() == 1);
		assertTrue("Invalid Main Corridors count", hotel.getFloors().get(1).getMainCorridors().size() == 1);

	}

	@Test
	public void testSetSubCorridors() {
		Hotel hotel = hotelBuilder.setFloors(2).setSubCorridor(2).build();
		assertTrue("Invalid Sub Corridors count", hotel.getFloors().get(0).getSubCorridors().size() == 2);
		assertTrue("Invalid Sub Corridors count", hotel.getFloors().get(1).getSubCorridors().size() == 2);

	}

	@Test
	public void testBuild() {
		Hotel hotel = hotelBuilder.build();
		assertNotNull("Hotel is Null", hotel);
	}

}
