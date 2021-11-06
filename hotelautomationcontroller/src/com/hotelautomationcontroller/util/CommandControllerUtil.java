package com.hotelautomationcontroller.util;

import java.util.ArrayList;
import java.util.List;

import com.hotelautomationcontroller.command.Command;
import com.hotelautomationcontroller.command.InitialStateCommand;
import com.hotelautomationcontroller.command.IntermediateStateCommand;
import com.hotelautomationcontroller.command.RevokeCommand;
import com.hotelautomationcontroller.controller.PowerController;
/**
 * 
 * @author Raju
 *
 */
public class CommandControllerUtil {

	/**
	 * it will parse the commands.
	 * @param commands
	 * @param powerController
	 * @return
	 */
	public static List<Command> parseCommands(List<String> commands, PowerController powerController) {

		List<Command> parsedCommand = new ArrayList<>();
		for (String command : commands) {
			if (command.equals(HelperConstant.DEFAULT_STATE)) {
				parsedCommand.add(new InitialStateCommand(powerController));
			} else if (command.equals(HelperConstant.FLOOR_ONE_SUB_CORRIDOR_TWO)) {
				parsedCommand.add(new IntermediateStateCommand(powerController));
			} else if (command.equals(HelperConstant.NO_MOVEMENT)) {
				parsedCommand.add(new RevokeCommand(powerController));
			}
		}
		return parsedCommand;

	}

}
