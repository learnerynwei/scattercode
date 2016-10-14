package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    
    public static void main(String args[]) {
        String str = "flagname#11122111";
        String pattern = "flagname((#\\d{4,17})|(%\\d{8,17})|(\\d{0,17}))";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

}