package program.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Model implements Service {

    ArrayList<String> ourCatalog = new ArrayList<>();
    StringBuilder prize = new StringBuilder();

    @Override
    public ArrayList<String> openDb() throws FileNotFoundException {
        ReadFile ourDb = new ReadFile("C:\\Users\\PMPav\\Desktop\\Projects\\TheToyStoreProject\\" +
                "src\\db\\Catalog.txt");
        ourDb.read(ourCatalog);
        return ourCatalog;
    }

    @Override
    public void getToy(ArrayList<String> ourToys) {
        ourCatalog.addAll(ourToys);
    }

    @Override
    public void showAll() {
//        int num = 1;
//        for (String el: ourCatalog) {
//            System.out.printf("%d) %s \n", num, el);
//            num++;
//        }

        int num = 1;
        for (int i = 0; i < ourCatalog.size(); i++) {

            String[] ll2 = ourCatalog.get(i).split(",");
            StringBuilder ss = new StringBuilder();

            for (int j = 0; j < ll2.length; j++) {
                if (ss.length()>0) ss.append(", ");
                ss.append(ll2[j]);
            }
            System.out.printf("%d) %s\n", num, ss);
            num++;

        }


    }

    @Override
    public void lottery(){
        // рандомно выбираем приз
        Random rnd = new Random();
        int random = rnd.nextInt(0,ourCatalog.size() - 1);
        System.out.println(ourCatalog.size());
//        prize.append(ourCatalog.get(random));
//        System.out.printf("Ура! Вы выиграли: %s",prize);
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

        // сразу вносим изменения в наш общий каталог
        WriteFile ourDb = new WriteFile("C:\\Users\\PMPav\\Desktop\\Projects\\TheToyStoreProject\\src\\db\\" +
                "Catalog.txt");
        ourDb.write(ourCatalog);

        // записываем в список подарков
        WriteFile ourPrize = new WriteFile("C:\\Users\\PMPav\\Desktop\\Projects\\TheToyStoreProject\\src" +
                "\\db\\WonToys.txt");

        ArrayList<String> prizeList = new ArrayList<>();
        prizeList.add(prize.toString());
//        prizeList.add(al.toString());
        ourPrize.write(prizeList);
    }


    @Override
    public void write(){
        WriteFile ourDb = new WriteFile("C:\\Users\\PMPav\\Desktop\\Projects\\TheToyStoreProject\\" +
                "src\\db\\Catalog.txt");
        ourDb.write(ourCatalog);
    }

}
