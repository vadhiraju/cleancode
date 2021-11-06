package com.hotelautomationcontroller.inputs;

import com.hotelautomationcontroller.util.CommandInputUtil;
import com.hotelautomationcontroller.util.HelperConstant;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Raju
 *
 */
public class CommandInput {

	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * gets the input through keyboard and construct the floors and corridors.
	 * 
	 * @return
	 */
	public static ConstructFloorsAndCorridorsInput initialStateInput() {

		System.out.println(HelperConstant.FLOOR_COUNT);
		throwExceptionForInvalidValue();
		int floorCount = emptyOrBlankCheck(SCANNER.nextLine());
		System.out.println(HelperConstant.MAIN_CORRIDOR_COUNT);
		throwExceptionForInvalidValue();
		int mainCorridorCount = emptyOrBlankCheck(SCANNER.nextLine());
		System.out.println(HelperConstant.SUB_CORRIDOR_COUNT);
		throwExceptionForInvalidValue();
		int subCorridorCount = emptyOrBlankCheck(SCANNER.nextLine());
		ConstructFloorsAndCorridorsInput constructingInput = new ConstructFloorsAndCorridorsInput(floorCount,
				mainCorridorCount, subCorridorCount);
		return constructingInput;
	}

	/**
	 * it takes the commands and process the commands.
	 * 
	 * @return
	 */
	public static List<String> keyInCommand() {

		List<String> commandKeyInList = new ArrayList<>();
		System.out.println(HelperConstant.ENTER_COMMAND);

		String sensorInputCmnd1 = SCANNER.nextLine();
		CommandInputUtil.checkForBlank(sensorInputCmnd1);
		commandKeyInList.add(sensorInputCmnd1);
		CommandInputUtil.checkCommands(commandKeyInList);

		System.out.println(HelperConstant.ENTER_COMMAND);
		String sensorInputCmnd2 = SCANNER.nextLine();
		CommandInputUtil.checkForBlank(sensorInputCmnd2);
		commandKeyInList.add(sensorInputCmnd2);
		CommandInputUtil.checkCommands(commandKeyInList);

		System.out.println(HelperConstant.ENTER_COMMAND);
		String sensorInputCmnd3 = SCANNER.nextLine();
		CommandInputUtil.checkForBlank(sensorInputCmnd3);
		commandKeyInList.add(sensorInputCmnd3);
		CommandInputUtil.checkCommands(commandKeyInList);

		return commandKeyInList;
	}

	/**
	 * check for non-integer values.
	 */
	private static void throwExceptionForInvalidValue() {
		while (!SCANNER.hasNextInt()) {
			System.err.println(HelperConstant.INVALID_VALUE);
			SCANNER.nextLine();
		}
	}

	/**
	 * empty check for key-in values.
	 * 
	 * @param str
	 * @return
	 */
	private static int emptyOrBlankCheck(String str) {
		int value = 0;
		if (StringUtils.isBlank(str)) {
			System.err.println(HelperConstant.INVALID_VALUE);

		} else {
			value = Integer.parseInt(str);
		}
		return value;
	}
}
