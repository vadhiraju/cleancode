package com.hotelautomationcontroller.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Raju
 *
 */
public class CommandInputUtil {

	/**
	 * it will check and verify the commands.
	 * 
	 * @param commands
	 * @return
	 */
	public static List<String> checkCommands(List<String> commands) {
		List<String> verifiedCommandList = new ArrayList<>();
		for (String cmnd : commands) {
			if (cmnd.equals(HelperConstant.DEFAULT_STATE)) {
				verifiedCommandList.add(cmnd);
			} else if (cmnd.equals(HelperConstant.FLOOR_ONE_SUB_CORRIDOR_TWO)) {
				verifiedCommandList.add(cmnd);
			} else if (cmnd.equals(HelperConstant.NO_MOVEMENT)) {
				verifiedCommandList.add(cmnd);
			} else {
				System.out.println(HelperConstant.INVALID_COMMAND);
				System.exit(0);
			}
		}

		return verifiedCommandList;
	}

	/**
	 * it will check blank for the key in commands.
	 * 
	 * @param sensorInputCmnd
	 */
	public static void checkForBlank(String sensorInputCmnd) {

		if (StringUtils.isBlank(sensorInputCmnd)) {
			System.out.println(HelperConstant.INVALID_COMMAND);

		}

	}

}
