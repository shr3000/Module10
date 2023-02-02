import TelephoneValidator.ReadFromFile;
import TelephoneValidator.Validator;
import jsonGenerator.Generator;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ReadFromFile rff = new ReadFromFile("src/TelephoneValidator/file.txt");
        Queue<String> queue = rff.reading();
        for (String s: queue){
            Validator.validationPhone(s);
        }
        queue.clear();
        rff = new ReadFromFile("src/jsonGenerator/file.txt");
        queue = rff.reading();
        Generator.gsonGen((ArrayDeque<String>) queue);
    }
}