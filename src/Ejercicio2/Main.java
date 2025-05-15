package Ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Funko> funkoList = Funciones.importList();

        Scanner read = new Scanner(System.in);

        int menuChoice = 0;

        while (menuChoice == 0){

            System.out.println(" ");

            for (int i = 0; i < funkoList.size(); i++) {

                System.out.println(funkoList.get(i));

            }

            Ejercicio2.Funciones.menu();
            menuChoice = Ejercicio2.Funciones.menuSelection(read);

            switch (menuChoice) {

                case 1 -> {

                    System.out.println(" ");
                    Funciones.addFunko(read, funkoList);
                    menuChoice = 0;

                } case 2 -> {

                    System.out.println(" ");
                    Funciones.deleteFunko(read, funkoList);
                    menuChoice = 0;

                } case 3 -> {

                    System.out.println(" ");
                    Funciones.showTotalFunkos(funkoList);
                    menuChoice = 0;

                } case 4 -> {

                    System.out.println(" ");
                    Funciones.showNewestFunko(funkoList);
                    menuChoice = 0;

                } case 5 -> {

                    System.out.println(" ");
                    Funciones.showOldestFunko(funkoList);
                    menuChoice = 0;

                } case 6 -> {

                    System.out.println(" ");
                    Funciones.showAvgPrice(funkoList);
                    menuChoice = 0;

                } case 7 -> {

                    System.out.println(" ");
                    System.out.println("Has salido del programa.");

                }

            }

        }

        read.close();

    }

}
