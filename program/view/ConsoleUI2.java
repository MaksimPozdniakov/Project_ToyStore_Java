package program.view;



import program.model.categories.BabyProducts;
import program.model.categories.LEGO;
import program.model.categories.SoftToys;
import program.model.categories.TableGames;
import program.model.commands.MainMenu;
import program.model.commands.Validator;
import program.presenter.Presenter;
import program.presenter.View;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleUI2 implements View {

    protected Presenter presenter;
    protected Scanner scanner;
    protected MainMenu menu;
    protected Validator validator = new Validator();

    public ConsoleUI2(){
        scanner = new Scanner(System.in);
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }



    @Override
    public void start() throws FileNotFoundException {
        while (true){
            menu = new MainMenu(this);
            System.out.println("~~~~Главное меню~~~~");
            printMenu();
            System.out.print("Сделайте выбор: ");
            String text = scanner.next();
            int choice = validator.checkInput(text, menu.getSizeMenu());
            if (choice != -1) {
                menu.execute(choice - 1);
            } else {
                System.out.printf("\nВведите число от 1 до %d!\n", menu.getSizeMenu());
            }
        }
    }

    public void printMenu(){
        System.out.println(menu.showMenu());
    }


    public void openBook() throws FileNotFoundException {
        presenter.open();
        System.out.println("Каталог открыт!");
    }

    public void showCatalog(){
        presenter.print();
    }

    public void win(){
        presenter.lottery2();
    }

    public void saveCatalog(){
        presenter.save();
    }

    public void closeCatalog(){
        System.out.println("Каталог закрыт. Ждем вас снова!");
        System.exit(0);
    }

    public void newToy() throws FileNotFoundException {
        while (true){
            boolean flag = true;
            String menu = """
                1. Добавить детский товар
                2. Добавить LEGO
                3. Добавить мягкую игрушку
                4. Добавить настольную игру
                5. Выйти в главное меню
                """;
            System.out.println(menu);
            System.out.print("Что буем добавлять? ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.print("Укажите артикул: ");
                    int id = scanner.nextInt();
                    System.out.print("Укажите тип товара: ");
                    String type = scanner.next();
                    System.out.print("Укажите количество: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Укажите страну производства: ");
                    String countryOfManufacture = scanner.next();
                    System.out.print("Укажите минимальный возраст: ");
                    String minimumAge = scanner.next();
                    System.out.print("Укажите материал изготовления: ");
                    String material = scanner.next();
                    System.out.print("Укажите бренд: ");
                    String brand = scanner.next();

                    presenter.addNewToy(new BabyProducts(id,type,quantity,countryOfManufacture,minimumAge,material,brand));
                }
                case 2 ->{
                    System.out.print("Укажите артикул: ");
                    int id = scanner.nextInt();
                    System.out.print("Укажите тип товара: ");
                    String type = scanner.next();
                    System.out.print("Укажите количество: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Укажите страну производства: ");
                    String countryOfManufacture = scanner.next();
                    System.out.print("Укажите минимальный возраст: ");
                    String minimumAge = scanner.next();
                    System.out.print("Укажите материал изготовления: ");
                    String material = scanner.next();
                    System.out.println("Укажите коллекцию: ");
                    String collection = scanner.next();
                    System.out.println("Укажите тип конструктора: ");
                    String constructorType = scanner.next();
                    System.out.print("Укажите бренд: ");
                    String brand = scanner.next();

                    presenter.addNewToy(new LEGO(id,type,quantity,countryOfManufacture,minimumAge,material,collection,
                            constructorType,brand));
                }
                case 3 -> {
                    System.out.print("Укажите артикул: ");
                    int id = scanner.nextInt();
                    System.out.print("Укажите тип товара: ");
                    String type = scanner.next();
                    System.out.print("Укажите количество: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Укажите страну производства: ");
                    String countryOfManufacture = scanner.next();
                    System.out.print("Укажите минимальный возраст: ");
                    String minimumAge = scanner.next();
                    System.out.print("Укажите материал изготовления: ");
                    String material = scanner.next();
                    System.out.println("Укажите наполнитель: ");
                    String filler = scanner.next();
                    System.out.print("Укажите бренд: ");
                    String brand = scanner.next();

                    presenter.addNewToy(new SoftToys(id,type,quantity,countryOfManufacture,minimumAge,material,filler,
                            brand));
                }
                case 4 -> {
                    System.out.print("Укажите артикул: ");
                    int id = scanner.nextInt();
                    System.out.print("Укажите тип товара: ");
                    String type = scanner.next();
                    System.out.print("Укажите количество: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Укажите страну производства: ");
                    String countryOfManufacture = scanner.next();
                    System.out.print("Укажите минимальный возраст: ");
                    String minimumAge = scanner.next();
                    System.out.print("Укажите материал изготовления: ");
                    String material = scanner.next();
                    System.out.println("Укажите тип насольной игры: ");
                    String typeTableGames = scanner.next();
                    System.out.println("Укажите минимальное кол-во игроков: ");
                    int minNumberOfPlayers = scanner.nextInt();
                    System.out.println("Укажите максимальное кол-во игроков: ");
                    int maxNumberOfPlayers = scanner.nextInt();
                    System.out.print("Укажите бренд: ");
                    String brand = scanner.next();

                    presenter.addNewToy(new TableGames(id,type,quantity,countryOfManufacture,minimumAge,material,
                            typeTableGames,minNumberOfPlayers,maxNumberOfPlayers,brand));
                }
                case 5 -> flag = false;
            }
            if (!flag){
                break;
            }
        }
        start();
    }

}
