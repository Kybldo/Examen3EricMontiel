package Ejercicio2;

abstract class Figura {

    private String name;
    private int releaseYear;
    private double basePrice;
    private Status status;

    public Figura(String name, int releaseYear, double basePrice, Status status) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.basePrice = basePrice;
        this.status = status;
    }


    public Figura() {

        this.name = "";
        this.releaseYear = 0;
        this.basePrice = 0;
        this.status = Status.PRECINTADA;

    }

    @Override
    public String toString() {

        return this.name + ", " + this.releaseYear + ", $" + this.basePrice + ", " + this.status;

    }

    public double calcRealPrice(){

        double realPrice = 0;

        if (this.status == Status.PRECINTADA) {

            return realPrice = (this.basePrice * 2);

        } else if (this.status == Status.EMBALAJE_ORIGINAL) {

            return realPrice = this.basePrice;

        } else return realPrice = (this.basePrice / 2);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}