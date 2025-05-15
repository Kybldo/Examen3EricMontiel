package Ejercicio1;

public class Estatua extends Figura{

    private String franchise;

    public Estatua(String name, int releaseYear, double basePrice, Status status, String franchise) {

        super(name, releaseYear, basePrice, status);
        this.franchise = franchise;

    }

    @Override
    public double calcRealPrice() {
        return super.calcRealPrice();
    }

    @Override
    public String toString() {

        return super.toString() + ", " + this.franchise;

    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }
}
