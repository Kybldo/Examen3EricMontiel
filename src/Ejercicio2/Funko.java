package Ejercicio2;

public class Funko extends Figura {

    private boolean limitedEdition;

    public Funko(String name, int releaseYear, double basePrice, Status status, boolean limitedEdition) {

        super(name, releaseYear, basePrice, status);
        this.limitedEdition = limitedEdition;

    }

    @Override
    public double calcRealPrice() {

        return this.getBasePrice() + ((2025 - this.getReleaseYear()) * 10);
    }

    @Override
    public String toString() {

        String bool = "";

        if (this.limitedEdition) {
            bool = "Sí";
        } else bool = "No";

        return super.toString() + ", Edición Limitada: " + bool;

    }

    public boolean isLimitedEdition() {
        return limitedEdition;
    }

    public void setLimitedEdition(boolean limitedEdition) {
        this.limitedEdition = limitedEdition;
    }
}
