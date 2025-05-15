package Ejercicio1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Funciones {

    public static void menu(){

        System.out.println("_____________________________________________________________________________________________");
        System.out.println(" ");
        System.out.println("1. Añadir Figura");
        System.out.println("2. Añadir Accesorio a una Figura de Acción");
        System.out.println("3. Mostrar lista");
        System.out.println("4. Mostrar Funkos de Edicion Limitada");
        System.out.println("5. Salir");
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

            if (choice < 1 || choice > 6) {

                System.out.println(" ");
                System.out.println("Por favor, introduce una opción válida.");
                choice = 0;

            }

        }

        return choice;

    }

    public static void addFigure(Scanner read, ArrayList<Figura> figuras){

        System.out.println("¿Tipo de figura?");
        System.out.println("1. Acción");
        System.out.println("2. Estátua");
        System.out.println("3. Funko");

        int type = 0;

        try {

            type = read.nextInt();
            read.nextLine();

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

                case 1 -> Funciones.addAction(read, figuras);
                case 2 -> Funciones.addStatue(read, figuras);
                case 3 -> Funciones.addFunko(read, figuras);

            }

        }

    }

    public static void addAction(Scanner read, ArrayList<Figura> figuras){

        String name = "";
        int releaseYear = 0;
        double basePrice = 0;
        Status status = Status.EMBALAJE_ORIGINAL;
        ArrayList<Accesorio> accesorios = new ArrayList<>();
        boolean canEnter = false;

        try {

            System.out.println(" ");
            System.out.print("Nombre de la figura: ");
            name = read.nextLine();

            System.out.print("Año de lanzamiento: ");
            releaseYear = read.nextInt();

            System.out.print("Precio base: ");
            basePrice = read.nextDouble();

            System.out.println(" ");
            System.out.println("Tipo de embalaje:");
            System.out.println("1. Precintada");
            System.out.println("2. Embalaje Original");
            System.out.println("3. Sin Embalaje");

            int type = 0;

            try {

                type = read.nextInt();
                read.nextLine();

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

                FiguraAccion figuraAccion = new FiguraAccion(name, releaseYear, basePrice, status, accesorios);
                figuras.add(figuraAccion);

            }

        }

    }

    public static void addStatue(Scanner read, ArrayList<Figura> figuras) {

        String name = "";
        int releaseYear = 0;
        double basePrice = 0;
        Status status = Status.EMBALAJE_ORIGINAL;
        String franchise = "";
        boolean canEnter = false;

        try {

            System.out.println(" ");
            System.out.print("Nombre de la figura: ");
            name = read.nextLine();

            System.out.print("Año de lanzamiento: ");
            releaseYear = read.nextInt();

            System.out.print("Precio base: ");
            basePrice = read.nextDouble();
            read.nextLine();

            System.out.print("Franquicia: ");
            franchise = read.nextLine();

            System.out.println(" ");
            System.out.println("Tipo de embalaje:");
            System.out.println("1. Precintada");
            System.out.println("2. Embalaje Original");
            System.out.println("3. Sin Embalaje");

            int type = 0;

            try {

                type = read.nextInt();
                read.nextLine();

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

                Estatua estatua = new Estatua(name, releaseYear, basePrice, status, franchise);
                figuras.add(estatua);

            }

        }

    }

    public static void addFunko(Scanner read, ArrayList<Figura> figuras) {

        String name = "";
        int releaseYear = 0;
        double basePrice = 0;
        Status status = Status.EMBALAJE_ORIGINAL;
        boolean limitedEdition = false;
        boolean canEnter = false;

        try {

            System.out.println(" ");
            System.out.print("Nombre de la figura: ");
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
                figuras.add(funko);

            }

        }

    }

    public static void addAccessory(Scanner read, ArrayList<Figura> figuras) {

        String nameToCompare = "";
        int figuraToChange = -1;

        try {

            System.out.println(" ");
            System.out.println("Introduce el nombre de la figura de acción para añadirle un accesorio.");
            read.nextLine();
            nameToCompare = read.nextLine();

            for (int i = 0; i < figuras.size(); i++) {

                if (Objects.equals(figuras.get(i).getName().toLowerCase(), nameToCompare.toLowerCase())) {

                    figuraToChange = i;

                }

            }

            if (figuraToChange != -1) {

                String name = "";
                String material = "";
                String desc = "";
                boolean canAdd = false;

                try {

                    System.out.println(" ");
                    System.out.print("Introduce el nombre del accesorio: ");
                    name = read.nextLine();

                    System.out.print("Introduce el material del accesorio: ");
                    material = read.nextLine();

                    System.out.print("Introduce la descripción del accesorio: ");
                    desc = read.nextLine();

                    canAdd = true;

                } catch (Exception e) {

                    System.out.println("Se ha producido un error.");

                } finally {

                    Accesorio accesorio = new Accesorio(name, material, desc);

                    if (canAdd) {

                        ((FiguraAccion) figuras.get(figuraToChange)).getAccessories().add(accesorio);

                    }

                    System.out.println(" ");
                    System.out.println("Figura cambiada:");
                    System.out.println(figuras.get(figuraToChange));

                }

            }

        } catch (Exception e) {

            System.out.println("Se ha producido un error.");

        }

    }

    public static void showList(ArrayList<Figura> figuras){

        for (Figura figura : figuras) {

            System.out.println(figura.getName() + ", Precio base: " + figura.getBasePrice() + ", Precio real: " + figura.calcRealPrice());

        }

    }

    public static void showLimitedFunkos(ArrayList<Figura> figuras) {

        for (int i = 0; i < figuras.size(); i++) {

            Funko funko = null;
            boolean flag = false;

            try {

                funko = (Funko) figuras.get(i);
                flag = true;

            } catch (Exception e) {

                flag = false;

            } finally {

                if (flag) {

                    if (funko.isLimitedEdition()){

                        System.out.println(funko);

                    }

                }

            }

        }

    }

}
