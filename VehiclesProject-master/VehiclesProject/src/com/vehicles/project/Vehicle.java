package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	public String plate;
		boolean isPlate = false;
	public String brand;
	public String color;
	public List<Wheel> wheels = new ArrayList<Wheel>();
        boolean isWheelCorrect = false;

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
        
}