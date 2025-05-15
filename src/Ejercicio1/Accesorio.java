package Ejercicio1;

public class Accesorio {

    private String name;
    private String material;
    private String desc;

    public Accesorio(String name, String material, String desc) {

        this.name = name;
        this.material = material;
        this.desc = desc;

    }

    public Accesorio() {

        this.name = "";
        this.material = "material";
        this.desc = "desc";

    }

    @Override
    public String toString() {

        return this.name + ", " + this.material + ", " + this.desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
