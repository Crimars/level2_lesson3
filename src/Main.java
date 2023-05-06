import java.lang.reflect.Array;
import java.util.*;

/**1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 *  Посчитать сколько раз встречается каждое слово.
  */
public class Main {
    public static void main(String[] args) {
        String[] cats = {"Ted", "Mad", "Lot", "Sam", "Ted", "Mot", "Ret", "Mad", "Sat", "Ted"};
        Set<String> unique = new HashSet<>(Arrays.asList(cats));
        System.out.println(unique);

        Map<String, Integer> map = new HashMap<>();
        for (String cat : cats){
            map.put(cat, map.getOrDefault(cat, 0) + 1);
            System.out.println(map);

        }
    }
}