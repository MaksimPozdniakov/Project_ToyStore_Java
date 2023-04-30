package program.model;

import java.io.FileNotFoundException;
import java.util.*;

public class Model implements Service {

    ArrayList<String> ourCatalog = new ArrayList<>();

    StringBuilder prize = new StringBuilder();
    protected ArrayList<String> namePosition;

    public void createHelpAL(){
        namePosition = new ArrayList<>();
        namePosition.add("Артикул: ");
        namePosition.add(", Тип игрушки: ");
        namePosition.add(", Количество на складе: ");
        namePosition.add(", Страна производства: ");
        namePosition.add(", Минимальный возраст: ");
        namePosition.add(", Материал изготовления: ");
        namePosition.add(", Бренд: ");
    }

    @Override
    public ArrayList<String> openDb() throws FileNotFoundException {
        ReadFile ourDb = new ReadFile("C:\\Users\\PMPav\\Desktop\\Projects\\Project_ToyStore_Java\\program\\" +
                "db\\Catalog.txt");
        ourDb.read(ourCatalog);
        return ourCatalog;
    }

    @Override
    public void getToy(ArrayList<String> ourToys) {
        ourCatalog.addAll(ourToys);
    }

    public void delToy(int index){
        ourCatalog.remove(index-1);
    }


    @Override
    public void showAll() {

        createHelpAL();
        StringBuilder stringBuilder = new StringBuilder();
        int num = 1;
        for (String s : ourCatalog) {
            ArrayList<String> new_list = new ArrayList<>(Arrays.asList(s.split(",")));
            stringBuilder.append(num);
            stringBuilder.append(") ");
            for (int j = 0; j < new_list.size()-1; j++) {
                stringBuilder.append(namePosition.get(j));
                stringBuilder.append(new_list.get(j));
            }
            stringBuilder.append("\n");
            num++;
        }
        System.out.println(stringBuilder);
    }

    @Override
    public void lottery(){
        Random rnd = new Random();
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        for (String el: ourCatalog) {
            ArrayList<String> new_el = new ArrayList<>(Arrays.asList(el.split(",")));
            list.add(new_el);
        }

        int totalPercentage = 0;
        for (ArrayList<String> toy: list) {
            totalPercentage += Integer.parseInt(toy.get(7));
        }

        int randomNumber = rnd.nextInt(totalPercentage);
        int currentPercentage = 0;
        for (ArrayList<String> toy: list) {
            currentPercentage += Integer.parseInt(toy.get(7));
            if (randomNumber < currentPercentage){
                System.out.println(toy);
                break;
            }
        }









//        // отнимаем подарок из общего количества
//        ArrayList<String> parts = new ArrayList<>(Arrays.asList(ourCatalog.get(random).split(",")));
//        int num = Integer.parseInt(parts.get(2));
//        num = num - 1;
//        String newNum = Integer.toString(num);
//        parts.set(2,newNum);
//        StringBuilder nn = new StringBuilder();
//        for (String el: parts) {
//            if (nn.length()>0) nn.append(",");
//            nn.append(el);
//        }
//        ourCatalog.set(random,nn.toString());
//
//
//        // вносим изменения в наш общий каталог
//        WriteFile ourDb = new WriteFile("C:\\Users\\PMPav\\Desktop\\Projects\\Project_ToyStore_Java\\program\\" +
//                "db\\Catalog.txt");
//        ourDb.write(ourCatalog);
//
//        // записываем в список подарков
//        WriteFile ourPrize = new WriteFile("C:\\Users\\PMPav\\Desktop\\Projects\\Project_ToyStore_Java\\" +
//                "program\\db\\WonToys.txt");
//
//        ArrayList<String> prizeList = new ArrayList<>();
//        prizeList.add(prize.toString());
//        ourPrize.write(prizeList);
    }




    @Override
    public void write(){
        WriteFile ourDb = new WriteFile("C:\\Users\\PMPav\\Desktop\\Projects\\Project_ToyStore_Java\\program\\" +
                "db\\Catalog.txt");
        ourDb.write(ourCatalog);
    }

}
