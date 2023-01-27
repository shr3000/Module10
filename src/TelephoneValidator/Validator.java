package TelephoneValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void validationPhone(String numberPhone){
        Pattern pattern = Pattern.compile("^[(]?[0-9]{3}[)]?[ ]?[0-9]{3}[-]?[0-9]{4}$");
        Pattern pattern2 = Pattern.compile("^[0-9]{3}?[-]?[0-9]{3}[-]?[0-9]{4}$");
        Matcher matcher = pattern.matcher(numberPhone);
        Matcher matcher2 = pattern2.matcher(numberPhone);
        if (matcher.matches() || matcher2.matches()) System.out.println(numberPhone);

    }
}
