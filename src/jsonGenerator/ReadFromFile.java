package jsonGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class ReadFromFile {
    private String path;
    private Queue<String> queue = new ArrayDeque<>();

    public ReadFromFile(String path) {
        this.path = path;
    }

    public Queue<String> reading(){
        if (path != null) {
            try(InputStream fileReader = new FileInputStream(path);
                Scanner scanner = new Scanner(fileReader)) {
                while (scanner.hasNext()) {
                    queue.add(scanner.nextLine());
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return queue;
    }

    @Override
    public String toString() {
        return "ReadFromFile{" +
                "queue=" + queue.toString() +
                '}';
    }
}
