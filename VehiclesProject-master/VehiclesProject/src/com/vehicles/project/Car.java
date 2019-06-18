package com.vehicles.project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Car extends Vehicle {
	
	boolean isPlateCorrect = false;		

    private List<Wheel> FrontWheels;
    private List<Wheel> BackWheels;
    
    public Car(String plate, String brand, String color) {

    	//per comprovar la matrícula:
    	
    	super(plate, brand, color);
        this.isPlateCorrect = this.isPlate(plate);
        
        this.FrontWheels = new ArrayList<>();
        this.BackWheels = new ArrayList<>();
        
    }


    public List<Wheel> getFrontWheels() {
        return FrontWheels;
    }

    public void setFrontWheels(List<Wheel> FrontWheels) {
        this.FrontWheels = FrontWheels;
    }

    public List<Wheel> getBackWheels() {
        return BackWheels;
    }

    public void setBackWheels(List<Wheel> BackWheels) {
        this.BackWheels = BackWheels;
    }
 

    public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
        addTwoWheels(frontWheels);
        addTwoWheels(backWheels);
    }

    public void addTwoWheels(List<Wheel> wheels) throws Exception {
        if (wheels.size() != 2) {
            throw new Exception("El número de rodes no és igual a 2");
        }

        Wheel rightWheel = wheels.get(0);
        Wheel leftWheel = wheels.get(1);

        if (!rightWheel.equals(leftWheel)) {
            throw new Exception("Les dos rodes no són iguals");
        }

        this.wheels.add(leftWheel);
        this.wheels.add(rightWheel);
    }
    

    //FASE 2: 
    
    /*
     
     *	Millorar el codi anterior comprovant la informació necesaria alhora de crear els objectes. S’ha de tenir en compte:

     *	Un diametre de la roda ha de ser superior a 0.4 i inferior a 4
     
     *	Comprobar matrícula
     
     */

    public Car Wheels(Scanner sc, Car car) {

        List<Wheel> twoWheels = new ArrayList<>();
        do{
            
            System.out.println("Introdueix el diàmetre (entre 0.4 i 4):  ");
            String diameter = sc.next();
            double wheeldiameter = Double.parseDouble(diameter);

            if (wheeldiameter >= 0.4 && wheeldiameter <= 4.0) {
                System.out.println("Introdueix la marca:");
                String wheelBrand = sc.next().toLowerCase();

                Wheel wheel = new Wheel(wheelBrand, wheeldiameter);
                twoWheels.add(wheel);
                twoWheels.add(wheel);
                if (car.FrontWheels.isEmpty()==true) {
                    car.setFrontWheels(twoWheels);

                } else {
                    car.setBackWheels(twoWheels);
                }
   
                car.isWheelCorrect = true;
            } else {
                System.out.println("el diametre ha de ser un número entre 0.4 y 4");
                car.isWheelCorrect = false;
            }
        }while(isWheelCorrect==false);

        return car;

    }
    
    public boolean isPlate (String plate) {
        char[] license = plate.toCharArray();
        int contNum = 0;
        int contLetter = 0;
        for (char c : license) {
            if (Character.isDigit(c)) {
                contNum = contNum + 1;
            }
            if (Character.isLetter(c)) {
                contLetter = contLetter + 1;
            }
        }
        if (contNum == 4 && (contLetter == 2 || contLetter == 3)) {
            return false;
        } else {
            System.out.println("La matrícula ha de ser en format 4 números + 2 o 3 lletres (9999XXX o 9999XX), \n"
            + "No s'ha pogut gravar");
            
            return true;
        }
    }

 
}