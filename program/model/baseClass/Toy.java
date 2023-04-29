package program.model.baseClass;


public class Toy {
    protected int id;
    protected String brand;
    protected String countryOfManufacture;
    protected String type;
    protected String minimumAge;
    protected String material;
    protected int quantity;

    public Toy(int id, String type, int quantity, String countryOfManufacture, String minimumAge, String material,
               String brand) {
        this.id = id;
        this.brand = brand;
        this.countryOfManufacture = countryOfManufacture;
        this.minimumAge = minimumAge;
        this.material = material;
        this.type = type;
        this.quantity = quantity;
    }

//    public String toString(){
//        return "Артикул: " + id + ", Тип товара: " + type + ", Бренд: " + brand +
//                ", Страна производства: " + countryOfManufacture + ", Минимальный возраст: " + minimumAge +
//                ", Материал изготовления: " + material;
//    }

    public String toString(){
        return id + "," + type + "," + quantity + "," + countryOfManufacture + "," + minimumAge + "," + material + "," +
                brand;
    }
}
