//		FASE 1: 
	
		/*
	 
		* Ens demanen crear una classe Main que realitzi els següents passos:

		* 1) Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.

		* 2) Crear el cotxe amb les dades anteriors. 

		* 3) Afegir-li dues rodes traseres demanant a l’usuari la marca i el diametre.

		* 4) Afegir-li dues rodes davanteres demanant a l’usuari la marca i el diametre.
		 
		
		*	els métodes de LA FASE 2 ESTAN FETS DIRECTAMEENT A LES CLASSES DEL COTXE I DE LA MOTO 
		
		*	FASE 3 (MAIN, COTXE I MOTO ): 
	 
		*	Modifica el projecte anterior afegint els mètodes necessaris a Bike, de manera que es pugui afegir rodes davanteres i traseres. 
			
		*	Modificar el Main anterior, afegint la opció de Bike o Car:

		*	0) Preguntar a l’usuari si vol crear un cotxe o una moto. 

		*	1) Demanar a l’usuari la matrícula, la marca i el seu color.

		*	2) Crear el vehícle amb les dades anteriors. 

		*	3) Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.

		*	4) Afegir-li les rodes davanteres corresponents, demanant a l’usuari la marca i el diametre
		
		*	rodes davanteres demanant a l’usuari la marca i el diametre.
		 
		 */

package com.vehicles.project;

import java.util.Scanner;

public class Main {
	
	
	 public static void main(String[] args) {

		 
		        Scanner sc = new Scanner(System.in);
		        String vehicleType;
		        boolean isBikeOrCar = false;

		        do {
		            try {
		                System.out.println("Qué vols Crear?:\n"
		                        + "-Cotxe\n"
		                        + "-Moto");
		                vehicleType = sc.next().toLowerCase();

		                IsBikeOrCar(vehicleType);
		           
		                System.out.println("Introdueix la marca");
		                String brand = sc.next();
	
		                System.out.println("Introdueix el color");
		                String color = sc.next();
		                
		                System.out.println("Introdueix la matrícula:");
		                String plate = sc.next();

		                switch (vehicleType) {
		                
		                    case "cotxe":
		                        Car car = new Car(plate, brand, color);
		                 
		                        boolean isCarCorrect = true;
		                        do {
		                            try {
		                            	
		                            	//demano les rodes del davant de cop
		                              
		                                System.out.println("Introdueix la informació del set de rodes davanteres");
		                                car = car.Wheels(sc, car);
		                                
		                                //demano les rodes del darrera de cop

		                                System.out.println("Introdueix la informació del set de rodes del darrera");
		                                car = car.Wheels(sc, car);

		                                car.addWheels(car.getFrontWheels(), car.getBackWheels());

		                                System.out.println("Molt bè, ja has creat el cotxe!");
		                                isBikeOrCar=true;
		                            } catch (Exception ex) {
		                                System.out.println(ex.getMessage());
		                                isCarCorrect = false;
		                            }
		                        } while (isCarCorrect == false);
		                        break;
		                        
		                    case "moto":
		                    	
		                        Bike bike = new Bike(plate, brand, color);
		                        boolean isBikeCorrect = true;
		                        do {
		                            System.out.println("Introdueix la informació de la roda davantera");
		                            do {
		                                bike = bike.InfoWheels(sc, bike);
		                            } while (bike.isWheelCorrect == false);
		                            System.out.println("Introdueix la informació de la roda del darrera:");
		                            do {
		                                bike = bike.InfoWheels(sc, bike);
		                            } while (bike.isWheelCorrect == false);

		                            try {
		                                bike.addWheels(bike.getFrontWheel(), bike.getBackWheel());
		                                System.out.println("Molt bè! Ja has creat la moto!");
		                                isBikeOrCar=true;                               
		                            } catch (Exception ex) {
		                                System.out.println(ex.getMessage());
		                                isBikeCorrect = false;
		                            }
		                        } while (isBikeCorrect == false);
		                        break;
		                }

		            } catch (Exception ex) {
		                System.out.println(ex.getMessage());
		                isBikeOrCar = false;

		            }

		        } while (isBikeOrCar == false);

		    }
	 
	 

		   
		    private static void IsBikeOrCar(String vehicleType) throws Exception {
		        if (vehicleType.equals("cotxe") || vehicleType.equals("moto")) {

		        } else {
		            throw new Exception("T'has equivocat");
		        }

		    }
		    
		   

		}