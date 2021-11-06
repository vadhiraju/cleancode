package com.hotelautomationcontroller.intf;

import java.util.ArrayList;
import java.util.List;

import com.hotelautomationcontroller.equipment.AirConditioner;
import com.hotelautomationcontroller.equipment.Light;
import com.hotelautomationcontroller.util.CorridorType;
/**
 * 
 * @author Raju
 *
 */
public abstract class Corridor {

	
	private List<Light> lights;
	private List<AirConditioner> airConditioners;

	public Corridor(CorridorType type) {
		this.lights = new ArrayList<>();
		this.airConditioners = new ArrayList<>();
		setCorridorType(type);
		
	}

	public List<Light> getLights() {
		return lights;
	}

	public List<AirConditioner> getAirConditioners() {
		return airConditioners;
	}

	 
	public  void addLightToCorridor(Light light){
		lights.add(light);
	}

	public void addAcToCorridor(AirConditioner ac){
		airConditioners.add(ac);
	}

	public abstract void setCorridorType(CorridorType corridorType);
	
	public abstract CorridorType getCorridorType();

}
