package SortWords;

/*
Напишите метод, который будет подсчитывать частоту каждого слова в файле words.txt.

Предпалагаем, что:
words.txt содержит только слова в нижнем регистре, разделенные пробелом
Каждое слово содержит только символы-буквы в нижнем регистре.
Слова разделены одим или несколькими пробелами, либо переносом строки.
Пример:
Для файла words.txt со следующим содержанием:

the day is sunny the the
the sunny is  is

Метод должен вернуть частоту:
the 4
is 3
sunny 2
day 1
Обратите внимание! Вывод на консоль должен быть отсортирован на частоте слов (от наибольшей к наименьшей)
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Sort {
    private String path;
    private Map<String, Integer> mapWords = new TreeMap<>();
    private List<String> allWords;
    public Sort(String path) {
        this.path = path;
        allWords = reading();
    }

    public void wordsCounter() {
        for (String word: allWords) {
            if (mapWords.containsKey(word)){
                mapWords.put(word, mapWords.get(word) + 1);
            } else {
                mapWords.put(word, 1);
            }
        }

        printSort();
    }

    private void printSort(){
        Integer[] integers = mapWords.values().toArray(new Integer[0]);
        Arrays.sort(integers);
        for (int i = integers.length - 1; i >= 0; i --) {
            for (Map.Entry<String, Integer> entry: mapWords.entrySet()) {
                if (entry.getValue() == integers[i]){
                    System.out.println(entry.getKey() + " " + entry.getValue());
                    mapWords.remove(entry.getKey());
                    break;
                }
            }
        }
    }


    private List<String> reading(){
        List<String> list = new ArrayList<>();
        if (path != null) {
            try(InputStream fileReader = new FileInputStream(path);
                Scanner scanner = new Scanner(fileReader)) {
                while (scanner.hasNext()) {
                    String[] temp = scanner.nextLine().split(" ");
                    for (String s: temp){
                        if (!s.trim().isEmpty()) list.add(s);
                    }
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
