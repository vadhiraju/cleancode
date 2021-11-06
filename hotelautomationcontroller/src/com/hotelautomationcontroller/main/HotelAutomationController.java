package com.hotelautomationcontroller.main;

import com.hotelautomationcontroller.controller.CommandController;

/**
 * 
 * @author Raju
 *
 */
public class HotelAutomationController {

	public static void main(String[] args) {

		CommandController controller = new CommandController();
		controller.initializeController();

	}

}
