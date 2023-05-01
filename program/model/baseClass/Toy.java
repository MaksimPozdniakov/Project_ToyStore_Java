package program.model.baseClass;


public class Toy {
    protected int id;
    protected String brand;
    protected String countryOfManufacture;
    protected String type;
    protected String minimumAge;
    protected String material;
    protected int quantity;
    protected int frequency;

    public Toy(int id, String type, int quantity, String countryOfManufacture, String minimumAge, String material,
               String brand, int frequency) {
        this.id = id;
        this.brand = brand;
        this.countryOfManufacture = countryOfManufacture;
        this.minimumAge = minimumAge;
        this.material = material;
        this.type = type;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public String toString(){
        return  id + "," + type + "," + quantity + "," + countryOfManufacture + "," + minimumAge + "," + material + "," +
                brand + "," + frequency;
    }

}
