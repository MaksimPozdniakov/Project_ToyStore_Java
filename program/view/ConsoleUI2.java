package program.view;



import program.model.baseClass.Toy;
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
        System.out.println("Изменения сохранены");
        presenter.save();
    }

    public void delToy(){
        showCatalog();
        System.out.print("Какую позицию необходимо удалить? ");
        int index = scanner.nextInt();
        System.out.println("Позиция удалена");
        presenter.delToy(index);
    }

    public void closeCatalog(){
        System.out.println("Каталог закрыт. Ждем вас снова!");
        System.exit(0);
    }

    public void newToy() throws FileNotFoundException {

        System.out.print("Укажите артикул: ");
        int id = scanner.nextInt();
        System.out.print("Укажите тип игрушки: ");
        String type = scanner.next();
        System.out.print("Укажите количество: ");
        int quantity = scanner.nextInt();
        System.out.print("Укажите страну производства: ");
        String countryOfManufacture = scanner.next();
        System.out.print("Укажите минимальный возраст: ");
        int minimumAge = scanner.nextInt();
        System.out.print("Укажите материал изготовления: ");
        String material = scanner.next();
        System.out.print("Укажите бренд: ");
        String brand = scanner.next();
        System.out.println("Укажите частоту выпадения игрушки (число от 1 до 100): ");
        int frequency = scanner.nextInt();

        presenter.addNewToy(new Toy(id, type, quantity, countryOfManufacture, minimumAge, material,
                brand, frequency));

        System.out.println("Новая игрушка добавлена");

//        start();
    }
}
