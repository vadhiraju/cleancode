package com.hotelautomationcontroller.model;

import java.util.List;

/**
 * 
 * @author Raju
 *
 */
public class Hotel {

	private List<Floor> floors;

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("        ");
		getFloors().forEach(floor -> {
			builder.append("           ");
			builder.append(floor.toString());
			builder.append(System.lineSeparator());
			floor.getMainCorridors().forEach(mainCorridor -> {
				builder.append(mainCorridor).toString();
				builder.append(" ");
				mainCorridor.getLights().forEach(light -> {
					builder.append(light.toString());
					builder.append(" ");

				});

				mainCorridor.getAirConditioners().forEach(ac -> {
					builder.append(ac.toString());
					builder.append(System.lineSeparator());
				});
			});

			floor.getSubCorridors().forEach(subCorridor -> {
				builder.append(subCorridor.toString());
				builder.append(" ");
				subCorridor.getLights().forEach(light -> {
					builder.append(light.toString());
					builder.append(" ");

				});

				subCorridor.getAirConditioners().forEach(ac -> {
					builder.append(ac.toString());
					builder.append(System.lineSeparator());
				});
			});

		});
		return builder.toString();
	}

}
