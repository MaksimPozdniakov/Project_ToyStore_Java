package program.model;

import java.io.FileNotFoundException;
import java.util.*;

public class Model implements Service {

    ArrayList<String> ourCatalog = new ArrayList<>();
    StringBuilder prize = new StringBuilder();

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
        ArrayList<String> namePosition = new ArrayList<>();
        namePosition.add("Артикул");
        namePosition.add("Тип игрушки");
        namePosition.add("Количество на складе");
        namePosition.add("Страна производства");
        namePosition.add("Минимальный возраст");
        namePosition.add("Материал изготовления");
        namePosition.add("Бренд");
        namePosition.add("То что нужно удалить");

        StringBuilder stringBuilder = new StringBuilder();
        int num = 1;
        for (String s : ourCatalog) {
            ArrayList<String> new_list = new ArrayList<>(Arrays.asList(s.split(",")));
            stringBuilder.append(num);
            stringBuilder.append(") ");
            for (int j = 0; j < new_list.size(); j++) {
                stringBuilder.append(namePosition.get(j));
                stringBuilder.append(": ");
                stringBuilder.append(new_list.get(j));
                stringBuilder.append(", ");
            }
            stringBuilder.append("\n");
            num++;
        }
        System.out.println(stringBuilder);
    }

    @Override
    public void lottery(){
        // рандомно выбираем приз
        Random rnd = new Random();
        int random = rnd.nextInt(0,ourCatalog.size() - 1);
        System.out.println(ourCatalog.size());
        ArrayList<String> al = new ArrayList<>(Arrays.asList(ourCatalog.get(random).split(",")));
        String newQ = "1";
        al.set(2,newQ);
        prize.append(al);
        System.out.printf("Ура! Вы выиграли: %s",prize);


        // отнимаем подарок из общего количества
        ArrayList<String> parts = new ArrayList<>(Arrays.asList(ourCatalog.get(random).split(",")));
        int num = Integer.parseInt(parts.get(2));
        num = num - 1;
        String newNum = Integer.toString(num);
        parts.set(2,newNum);
        StringBuilder nn = new StringBuilder();
        for (String el: parts) {
            if (nn.length()>0) nn.append(",");
            nn.append(el);
        }
        ourCatalog.set(random,nn.toString());

        // вносим изменения в наш общий каталог
        WriteFile ourDb = new WriteFile("C:\\Users\\PMPav\\Desktop\\Projects\\Project_ToyStore_Java\\program\\" +
                "db\\Catalog.txt");
        ourDb.write(ourCatalog);

        // записываем в список подарков
        WriteFile ourPrize = new WriteFile("C:\\Users\\PMPav\\Desktop\\Projects\\Project_ToyStore_Java\\" +
                "program\\db\\WonToys.txt");

        ArrayList<String> prizeList = new ArrayList<>();
        prizeList.add(prize.toString());
        ourPrize.write(prizeList);
    }


    @Override
    public void write(){
        WriteFile ourDb = new WriteFile("C:\\Users\\PMPav\\Desktop\\Projects\\Project_ToyStore_Java\\program\\" +
                "db\\Catalog.txt");
        ourDb.write(ourCatalog);
    }

}
