package com.hotelautomationcontroller.command;

import java.util.Timer;
import java.util.TimerTask;

import com.hotelautomationcontroller.controller.PowerController;
import com.hotelautomationcontroller.util.HelperConstant;

/**
 * 
 * @author Raju
 *
 */
public class RevokeCommand implements Command {

	PowerController powerController;

	public RevokeCommand(PowerController powerController) {
		this.powerController = powerController;
	}

	/**
	 * it tells the revoked state after a small delay.
	 */
	@Override
	public void execute() {

		waitingTime().cancel();
		waitingTime().purge();

	}

	private Timer waitingTime() {

		long delay = 6000;

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				System.out.println(HelperConstant.NO_MOVEMENT + " : ");
				powerController.revokeState();
				System.out.println(powerController.getHotel());

			}

		};
		timer.schedule(task, delay);
		return timer;

	}

}
