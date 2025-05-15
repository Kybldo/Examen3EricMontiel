package Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;

public class FiguraAccion extends Figura {

    private ArrayList<Accesorio> accessories;

    public FiguraAccion(String name, int releaseYear, double basePrice, Status status, ArrayList<Accesorio> accessories) {

        super(name, releaseYear, basePrice, status);
        this.accessories = accessories;

    }

    @Override
    public double calcRealPrice() {
        return super.calcRealPrice();
    }

    @Override
    public String toString() {

        return super.toString() + ", " + accessories.toString();

    }

    public ArrayList<Accesorio> getAccessories() {
        return accessories;
    }

    public void setAccessories(ArrayList<Accesorio> accessories) {
        this.accessories = accessories;
    }
}
