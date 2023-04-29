package program.model.categories;

import program.model.baseClass.Toy;

public class BabyProducts extends Toy {


    public BabyProducts(int id, String type, int quantity, String countryOfManufacture, String minimumAge,
                        String material, String brand) {
        super(id, type, quantity, countryOfManufacture, minimumAge, material, brand);
    }
}
