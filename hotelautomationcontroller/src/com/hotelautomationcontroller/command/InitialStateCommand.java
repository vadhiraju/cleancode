package com.hotelautomationcontroller.command;

import com.hotelautomationcontroller.controller.PowerController;
import com.hotelautomationcontroller.util.HelperConstant;

/**
 * 
 * @author Raju
 *
 */
public class InitialStateCommand implements Command {

	PowerController powerController;

	public InitialStateCommand(PowerController powerController) {
		this.powerController = powerController;
	}

	/**
	 * it tells the initial state.
	 */
	@Override
	public void execute() {
		System.out.println(HelperConstant.DEFAULT_STATE + " : ");
		// powerController.initialState();
		System.out.println(powerController.getHotel());
	}

}
