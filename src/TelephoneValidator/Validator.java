package TelephoneValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void validationPhone(String numberPhone){
        Pattern pattern = Pattern.compile("^((\\d{3}|\\d{3})[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(numberPhone);
        if (matcher.matches()) System.out.println(numberPhone);

    }
}
