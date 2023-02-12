package jsonGenerator;

/*
Дан текстовый файл file.txt, необходимо считать файл в список объектов User и создать новый файл user.json.
Предполагаем, что каждая строка содержит одинаковое количество "колонок", разделенный пробелом.
Пример:
Для файла file.txt со следующим содержанием:

name age
alice 21
ryan 30

Новый файл должен иметь следующий вид:

[
    {
        "name": "alice",
        "age":21
    },
    {
        "name": "ryan",
        "age":30
    }
]
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;

public class Generator {

    public static void gsonGen(ArrayDeque<String> queue) {
        String[] str = queue.poll().split(" ");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/jsonGenerator/user.json", true));) {
            writer.write("[\n");
            int count = 0;
            for (String s: queue){
                String[] tmp = s.split(" ");
                writer.write("    {\n        \"" + str[0] + "\": " + "\"" + tmp[0] + "\",\n");
                writer.write("        \"" + str[1] + "\":"+ tmp[1] + "\n");
                count++;
                if (count != queue.size()) writer.write("    },\n");
                else writer.write("    }\n");
                //writer.write("    },\n    {\n");
            }
            writer.write("]\n");
            writer.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
