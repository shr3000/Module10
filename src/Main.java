import TelephoneValidator.ReadFromFile;
import TelephoneValidator.Validator;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ReadFromFile rff = new ReadFromFile("src/TelephoneValidator/file.txt");
        Queue<String> queue = rff.reading();
        for (String s: queue){
            Validator.validationPhone(s);
        }
    }
}