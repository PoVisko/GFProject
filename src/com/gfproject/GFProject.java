package com.gfproject;

import java.util.Scanner;

public class GFProject {
    public static void main(String[] args) {
        int numOfInboundCars;                       //Įvažiuojančių automobilių kiekis
        int numOfFloors = 5;                        // Kiek aukštų turi stovėjimo aikštelė
        int inboundCarIndex = 0;                    // Kelintas automobilis įvažiuoja
        int parkingSpaceIndex = 0;                  // Kuriam intervalui/aukštui priklauso įvažiuojančio automobilio vieta

        int[] parkingSpaceNumbersByFloor = new int[numOfFloors];    //Nuoseklus masyvas su stovėjimo vietų numeriais kiekviename aukšte
        int[] closestFloorNumbers = new int[numOfFloors];   //Nuoseklus masyvas su stovėjimo aikštelės aukštų numeriais

        final String closestFloorPrefix = "Laisva vieta ";
        final String closestFloorSuffix = " aukšte.";

        final int numOfParkingSpacesPerFloor = 20;  // kiek stovėjimo vietų yra kiekviename aikštelės aukšte

        /*
        Sudaro nuoseklų masyvą su stovėjimo aikštelės aukštų numeriais pagal tai kiek aukštų turi aikštelė
         */
        for (int i=0; i<numOfFloors; i++) {
            if ((i % 2) == 0) {
                closestFloorNumbers[i] = Math.round((i + 2) / 2);
            } else {
                closestFloorNumbers[i] = Math.round((-1) * (i + 2) / 2);
            }
        }

        /*
        Sudaro nuoseklų masyvą su stovėjimo vietų numeriais kiekviename aukšte pagal tai, kiek aukštų turi aikštelė ir
        kiek stovėjimo vietų yra kiekviename aukšte
         */
        for (int i=0; i<numOfFloors; i++) {
            parkingSpaceNumbersByFloor[i] = (i+1) * numOfParkingSpacesPerFloor;
        }

        /*
        Nuskaito vartotojo įvestą įvažiuojačių automobilių kiekį
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Įveskite įvažiuojančių automobilių kiekį.");
        numOfInboundCars = sc.nextInt();
        sc.close();

        /*
        Išspausdina pranešimą, kur yra artimiausia stovėjimo vieta kiekvienam įvažiuojančiam automobiliui
         */
        while (inboundCarIndex < numOfInboundCars) {
            if (inboundCarIndex < parkingSpaceNumbersByFloor[parkingSpaceIndex]) {
                System.out.println(closestFloorPrefix + closestFloorNumbers[parkingSpaceIndex] + closestFloorSuffix);
                inboundCarIndex++;
                if (inboundCarIndex >= parkingSpaceNumbersByFloor[numOfFloors-1]) {
                    System.out.println("Laisvų vietų nebė○○ra");
                    break;
                }
            } else {
                parkingSpaceIndex++;
            }
        }
    }
}
