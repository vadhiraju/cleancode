package com.hotelautomationcontroller.controller;

import java.util.List;

import com.hotelautomationcontroller.builder.HotelBuilder;
import com.hotelautomationcontroller.command.Command;
import com.hotelautomationcontroller.inputs.CommandInput;
import com.hotelautomationcontroller.inputs.ConstructFloorsAndCorridorsInput;
import com.hotelautomationcontroller.util.CommandControllerUtil;

/**
 * 
 * @author Raju
 *
 */
public class CommandController {
	/**
	 * it initializes the controller with necessary inputs.
	 */
	public void initializeController() {

		ConstructFloorsAndCorridorsInput initialInput = CommandInput.initialStateInput();
		PowerController powerController = new PowerController(new HotelBuilder().setFloors(initialInput.getNoOfFloors())
				.setMainCorridors(initialInput.getNoOfMainCorridors())
				.setSubCorridor(initialInput.getNoOfSubCorridors()).build());

		List<String> command = getKeyInCommands();
		setCommands(command, powerController);

	}

	/**
	 * it returns the string of commands from the user.
	 * 
	 * @return
	 */
	public List<String> getKeyInCommands() {
		List<String> keyIncommands = CommandInput.keyInCommand();
		return keyIncommands;
	}

	/**
	 * it executes the set of commands.
	 * 
	 * @param commands
	 * @param powerController
	 */
	public void setCommands(List<String> commands, PowerController powerController) {
		List<Command> commandList = CommandControllerUtil.parseCommands(commands, powerController);
		for (Command cmnd : commandList) {
			cmnd.execute();
		}
	}

}
