package Ejercicio3;

public class Main {

    public static void main(String[] args) {

        String[] credentials = FunkoDB.loadDatabaseProperties();
        String sentencia1 = "SELECT * FROM funko";
        String sentencia2 = "SELECT * FROM funko WHERE ano_lanzamiento = 2010";
        //String sentencia3 = "SELECT * FROM funko WHERE nombre = 'A%'"; -- Lo he intentado pero no me acuerdo, te la hago a lo bruto por código
        String sentencia4 = "SELECT * FROM funko WHERE estado = 'EMBALAJEORIGINAL'";

        // Demostración conexión básica
        FunkoDB.demostracion(credentials, sentencia1);

        System.out.println(" ");

        // Mostrar Funkos del año 2010
        FunkoDB.showFunkosFrom2010(credentials, sentencia2);

        System.out.println(" ");

        // Mostrar Funkos que empiezan por 'A'
        FunkoDB.showFunkosWithA(credentials, sentencia1);

        System.out.println(" ");

        // Mostrar Funkos con el embalaje original
        FunkoDB.showOriginalPackage(credentials, sentencia4);

    }

}
