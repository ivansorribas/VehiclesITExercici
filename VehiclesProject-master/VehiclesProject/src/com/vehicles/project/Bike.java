package com.vehicles.project;


import java.util.Scanner;


public class Bike extends Vehicle {
	
	boolean isPlateCorrect = false;

	
      
	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
		
		//per comprovar la matrícula:
		
		this.isPlateCorrect = this.isPlate(plate);
	}
	
	  
		Wheel FrontWheel;
     	Wheel BackWheel;
      

    public Wheel getFrontWheel() {
        return FrontWheel;
    }

    public void setFrontWheel(Wheel FrontWheel) {
        this.FrontWheel = FrontWheel;
    }

    public Wheel getBackWheel() {
        return BackWheel;
    }

    public void setBackWheel(Wheel BackWheel) {
        this.BackWheel = BackWheel;
    }
        
        
    public void addWheels(Wheel FrontWheel, Wheel BackWheel) throws Exception {

        this.wheels.add(FrontWheel);
        this.wheels.add(BackWheel);
    }
    
  //FASE 2: 
    /*
     *	Millorar el codi anterior comprovant la informació necesaria alhora de crear els objectes. S’ha de tenir en compte:

     *	Un diametre de la roda ha de ser superior a 0.4 i inferior a 4
     
     *	Comprobar matrícula
     
     */

    public Bike InfoWheels(Scanner sc, Bike bike) {
        
        System.out.println("Introdueix el diàmetre (entre 0.4 i 4):");
        Double wheeldiameter = sc.nextDouble();
        if (wheeldiameter >= 0.4 && wheeldiameter<=4) {
             System.out.println("la marca");
             String wheelBrand = sc.next().toLowerCase();
            
            if(bike.getFrontWheel()==null){
               bike.setFrontWheel(new Wheel(wheelBrand, wheeldiameter)); 
            }else{
                bike.setBackWheel(new Wheel(wheelBrand, wheeldiameter));
            }
               
            bike.isWheelCorrect=true;
        }else{
            System.out.println("el diametre ha de ser un número entre 0.4 y 4");
            bike.isWheelCorrect=false;
        }
        
        return bike;
        
        
    }
    
    
    public boolean isPlate(String plate) {
    	
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