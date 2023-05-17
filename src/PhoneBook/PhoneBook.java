/**2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий
 * и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять
 * записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под
 * одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе
 * такой фамилии должны выводиться все телефоны.
 * Желательно как можно меньше добавлять своего, чего нет в задании
 * (т.е. не надо в телефонную запись добавлять еще дополнительные поля
 * (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
 * Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main()
 * прописывая add() и get().*/


package PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, ArrayList<String>> phoneMap = new HashMap<>();
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();

        pb.add("Ivanov", "2-55-23");
        pb.add("Petrov", "2-54-86");
        pb.add("Sidorov", "2-45-67");
        pb.add("Kazakov", "2-45-65");
        pb.add("Bugrov", "2-65-87");
        pb.add("Evseev", "2-78-89");
        pb.add("Ivanov", "2-87-83");
       
    }
    public void add(String name, String phone) {
        ArrayList<String> string = phoneMap.get(name);
        System.out.println(string);
        if (string == null) {
            ArrayList<String> listPhone = new ArrayList<>();
            listPhone.add(phone);
            phoneMap.put(name, listPhone);
        } else {
            string.add(phone);
            phoneMap.put(name, string);
        }
    }

    public ArrayList<String> get(String name) {
        return phoneMap.get(name);

    }
}

