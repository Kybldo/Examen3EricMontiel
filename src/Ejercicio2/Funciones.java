package Ejercicio2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class Funciones {

    public static void menu(){

        System.out.println("_____________________________________________________________________________________________");
        System.out.println(" ");
        System.out.println("1. Añadir Funko");
        System.out.println("2. Borrar Funko");
        System.out.println("3. Mostar total de Funkos");
        System.out.println("4. Mostrar año del Funko más nuevo");
        System.out.println("5. Mostar año del Funko más antiguo");
        System.out.println("6. Mostrar media de precio base de los Funkos");
        System.out.println("7. Salir");
        System.out.print("Selección: ");

    }

    public static int menuSelection(Scanner read) {

        int choice = 0;

        try {

            choice = read.nextInt();

        } catch (Exception e) {

            System.out.println(" ");
            System.out.println("Por favor, introduce un entero.");
            read.nextLine();

        } finally {

            if (choice < 1 || choice > 8) {

                System.out.println(" ");
                System.out.println("Por favor, introduce una opción válida.");
                choice = 0;

            }

        }

        return choice;

    }

    public static ArrayList<Funko> importList() throws IOException {

        ArrayList<Funko> funkoListImported = new ArrayList<>();

        try (Stream<String> csvContent = Files.lines(Paths.get("funkos.csv"))) {

            List<List<String>> tempFunkoList = csvContent.map(l -> Arrays.asList(l.split("#"))).toList();

            for (int i = 1; i < tempFunkoList.size(); i++) {

                boolean limited = false;
                Status status;

                int year = Integer.parseInt(tempFunkoList.get(i).get(1));
                double price = Double.parseDouble(tempFunkoList.get(i).get(3));

                if (Objects.equals(tempFunkoList.get(i).get(2), "SÍ")) {

                    limited = true;

                }

                if (Objects.equals(tempFunkoList.get(i).get(4), "EMBALAJE ORIGINAL")) {

                    status = Status.EMBALAJE_ORIGINAL;

                } else if (Objects.equals(tempFunkoList.get(i).get(4), "SIN EMBALAJE ORIGINAL")) {

                    status = Status.SIN_EMBALAJE;

                } else status = Status.PRECINTADA;

                Funko funko = new Funko(tempFunkoList.get(i).get(0), year, price, status, limited);

                funkoListImported.add(funko);

            }

        }

        System.out.println(" ");
        System.out.println("Fichero de Funkos cargado.");
        return funkoListImported;

    }

    public static void saveListToCSV(ArrayList<Funko> funkoList) {

        try {

            Files.write(Paths.get("funkos.csv"), "".getBytes());

            for (Funko funko : funkoList){

                String bool;
                String status;

                if (funko.isLimitedEdition()){

                    bool = "SÍ";

                } else bool = "No";

                if (funko.getStatus() == Status.EMBALAJE_ORIGINAL) {

                    status = "EMBALAJE ORIGINAL";

                } else if (funko.getStatus() == Status.SIN_EMBALAJE) {

                    status = "SIM EMBALAJE ORIGINAL";

                } else status = "PRECINTADA";

                String string = "\n" + funko.getName() + "#" + funko.getReleaseYear() + "#" + bool + "#" + funko.getBasePrice() + "#" + status;

                Files.write(Paths.get("funkos.csv"), string.getBytes(), StandardOpenOption.APPEND);

            }

        } catch (IOException e) {

            System.out.println("Error.");

        }

    }

    public static void addFunko(Scanner read, ArrayList<Funko> funkoList) {

        String name = "";
        int releaseYear = 0;
        double basePrice = 0;
        Status status = Status.EMBALAJE_ORIGINAL;
        boolean limitedEdition = false;
        boolean canEnter = false;

        try {

            System.out.println(" ");
            System.out.print("Nombre de la figura: ");
            read.nextLine();
            name = read.nextLine();

            System.out.print("Año de lanzamiento: ");
            releaseYear = read.nextInt();

            System.out.print("Precio base: ");
            basePrice = read.nextDouble();

            System.out.println(" ");
            System.out.println("Edición limitada: ");
            System.out.println("1. Sí");
            System.out.println("2. No");

            int bool = 0;

            try {

                bool = read.nextInt();

            } catch (Exception e) {

                System.out.println(" ");
                System.out.println("Por favor, introduce un entero.");
                read.nextLine();

            } finally {

                if (bool < 1 || bool > 2) {

                    System.out.println(" ");
                    System.out.println("Introduce una opción válida. Se estabécerá a no.");
                    bool = 2;

                }

                if (bool == 1) {

                    limitedEdition = true;

                } else limitedEdition = false;

            }

            System.out.println(" ");
            System.out.println("Tipo de embalaje:");
            System.out.println("1. Precintada");
            System.out.println("2. Embalaje Original");
            System.out.println("3. Sin Embalaje");

            int type = 0;

            try {

                type = read.nextInt();

            } catch (Exception e) {

                System.out.println(" ");
                System.out.println("Por favor, introduce un entero.");
                read.nextLine();

            } finally {

                if (type < 1 || type > 3) {

                    System.out.println(" ");
                    System.out.println("Por favor, introduce una opción válida.");
                    type = 0;

                }

                switch (type) {

                    case 1 -> status = Status.PRECINTADA;
                    case 2 -> status = Status.EMBALAJE_ORIGINAL;
                    case 3 -> status = Status.SIN_EMBALAJE;

                }

                canEnter = true;

            }

        } catch (Exception e) {

            System.out.println(" ");
            System.out.println("Ha ocurrido un error con la introducción de datos. Por favor, inténtalo de nuevo.");
            read.nextLine();

        } finally {

            if (canEnter) {

                Funko funko = new Funko(name, releaseYear, basePrice, status, limitedEdition);
                funkoList.add(funko);

                Funciones.saveListToCSV(funkoList);

            }

        }

    }

    public static void deleteFunko(Scanner read, ArrayList<Funko> funkoList) {

        System.out.println(" ");
        System.out.println("Introduce el nombre del Funko a eliminar: ");

        String userName = "";
        int funkoToDelete = -1;

        try {

            read.nextLine();
            userName = read.nextLine();

        } catch (Exception e) {

            System.out.println("Error.");

        } finally {

            for (int i = 0; i < funkoList.size(); i++) {

                if (funkoList.get(i).getName().equalsIgnoreCase(userName)) {

                    funkoToDelete = i;

                }

            }

            if (funkoToDelete != -1) {

                funkoList.remove(funkoToDelete);
                Funciones.saveListToCSV(funkoList);

            }

        }

    }

    public static void showTotalFunkos(ArrayList<Funko> funkoList) {

        int counter = 0;

        for (int i = 0; i < funkoList.size(); i++) {

            counter++;

        }

        System.out.println("Hay " + counter + " Funkos en la lista.");

    }

    public static void showNewestFunko(ArrayList<Funko> funkoList) {

        int higher = 0;

        for (int i = 0; i < funkoList.size(); i++) {

            if (funkoList.get(i).getReleaseYear() > higher) {

                higher = funkoList.get(i).getReleaseYear();

            }

        }

        System.out.println("El Funko más nuevo de la lista es de " + higher);

    }

    public static void showOldestFunko(ArrayList<Funko> funkoList) {

        int lowest = 2025;

        for (int i = 0; i < funkoList.size(); i++) {

            if (funkoList.get(i).getReleaseYear() < lowest) {

                lowest = funkoList.get(i).getReleaseYear();

            }

        }

        System.out.println("El Funko más viejo de la lista es de " + lowest);

    }

    public static void showAvgPrice(ArrayList<Funko> funkoList) {

        double avg = 0;
        int counter = 0;

        for (int i = 0; i < funkoList.size(); i++) {

            counter++;

            avg += funkoList.get(i).getBasePrice();

        }

        avg = avg / counter;

        System.out.println("La media de precio de todos los Funkos es: " + avg);

    }

}
