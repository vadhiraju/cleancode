package com.hotelautomationcontroller.command;

import com.hotelautomationcontroller.controller.PowerController;
import com.hotelautomationcontroller.util.HelperConstant;

/**
 * 
 * @author Raju
 *
 */
public class IntermediateStateCommand implements Command {

	PowerController powerController;

	public IntermediateStateCommand(PowerController powerController) {
		this.powerController = powerController;
	}

	/**
	 * it tells the intermediate state.
	 */
	@Override
	public void execute() {
		System.out.println(HelperConstant.FLOOR_ONE_SUB_CORRIDOR_TWO + " : ");
		powerController.switchState();
		System.out.println(powerController.getHotel());
	}

}
