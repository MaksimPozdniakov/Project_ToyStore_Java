package program.model.categories;

import program.model.baseClass.Toy;

public class SoftToys extends Toy {

    protected String filler;


    public SoftToys(int id, String type, int quantity, String countryOfManufacture, String minimumAge, String material,
                    String filler, String brand) {
        super(id, type, quantity, countryOfManufacture, minimumAge, material, brand);
        this.filler = filler;
    }

//    public String toString(){
//        return "Артикул: " + id + ", " + type + ", " + brand + ", Страна производства: " + countryOfManufacture + ", Минимальный возраст: " +
//                " Материал изготовления: " + material + ", Наполнитель: " + filler;
//    }

    public String toString(){
        return id + "," + type + "," + quantity + "," + countryOfManufacture + "," + minimumAge + "," + material + "," +
                filler + "," + brand;
    }

}
