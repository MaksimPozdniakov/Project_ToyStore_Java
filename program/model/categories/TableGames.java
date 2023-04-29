package program.model.categories;

import program.model.baseClass.Toy;

public class TableGames extends Toy {

    protected String typeTableGames;
    protected int minNumberOfPlayers;
    protected int maxNumberOfPlayers;


    public TableGames(int id, String type, int quantity, String countryOfManufacture, String minimumAge, String material,
                      String typeTableGames, int minNumberOfPlayers, int maxNumberOfPlayers, String brand) {
        super(id, type, quantity, countryOfManufacture, minimumAge, material, brand);
        this.typeTableGames = typeTableGames;
        this.minNumberOfPlayers = minNumberOfPlayers;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
    }

//    public String toString(){
//        return "Артикул: " + id + ", " + type + ", " + brand + ", Страна производства: " + countryOfManufacture + ", Минимальный возраст: " +
//                " Материал изготовления: " + material + ", Тип настольной игры: " + typeTableGames +
//                ", Минимальное количество игроков: " + minNumberOfPlayers + ", Максимальное количество игроков: " +
//                maxNumberOfPlayers;
//    }

    public String toString(){
        return id + "," + type + "," + quantity + "," + countryOfManufacture + "," + minimumAge + "," + material + "," +
                typeTableGames + "," + minNumberOfPlayers + "," + maxNumberOfPlayers + "," + brand;
    }

}
