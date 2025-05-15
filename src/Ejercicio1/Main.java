package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Figura> figuras = new ArrayList<>();

        Scanner read = new Scanner(System.in);

        int menuChoice = 0;

        while (menuChoice == 0){

            Funciones.menu();
            menuChoice = Funciones.menuSelection(read);

            switch (menuChoice) {

                case 1 -> {

                    System.out.println(" ");
                    Funciones.addFigure(read, figuras);
                    menuChoice = 0;

                } case 2 -> {

                    System.out.println(" ");
                    Funciones.addAccessory(read, figuras);
                    menuChoice = 0;

                } case 3 -> {

                    System.out.println(" ");
                    Funciones.showList(figuras);
                    menuChoice = 0;

                } case 4 -> {

                    System.out.println(" ");
                    Funciones.showLimitedFunkos(figuras);
                    menuChoice = 0;

                } case 5 -> {

                    System.out.println(" ");
                    System.out.println("Has salido del programa.");

                }

            }

        }

        read.close();

    }

}
