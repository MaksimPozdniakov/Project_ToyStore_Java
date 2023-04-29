package program.model.categories;

import program.model.baseClass.Toy;

public class LEGO extends Toy {

    protected String collection;
    protected String constructorType;

    public LEGO(int id, String type, int quantity, String countryOfManufacture, String minimumAge, String material,
                String collection, String constructorType, String brand) {
        super(id, type, quantity, countryOfManufacture, minimumAge, material, brand);
        this.collection = collection;
        this.constructorType = constructorType;
    }

//    public String toString(){
//        return "Артикул: " + id + ", " + type + ", " + brand + ", Страна производства: " + countryOfManufacture +
//                ", Минимальный возраст: " +
//                " Материал изготовления: " + material + ", Коллекция: " + collection +
//                ", Тип конструктора: " + constructorType;
//    }

    public String toString(){
        return id + "," + type + "," + quantity + "," + countryOfManufacture + "," + minimumAge + "," + material + "," +
                collection + "," + constructorType + "," + brand;
    }
}
