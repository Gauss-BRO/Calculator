import java.util.HashMap;
import java.util.TreeMap;

public class RomeNumber {

    private final static TreeMap<Integer, String> romeMap = new TreeMap<>();
    private final static HashMap<String, Integer> arabicNumerals = new HashMap<>();

    static {
        arabicNumerals.put("I",1);
        arabicNumerals.put("II",2);
        arabicNumerals.put("III",3);
        arabicNumerals.put("IV",4);
        arabicNumerals.put("V",5);
        arabicNumerals.put("VI",6);
        arabicNumerals.put("VII",7);
        arabicNumerals.put("VIII",8);
        arabicNumerals.put("IX",9);
        arabicNumerals.put("X",10);
        romeMap.put(100, "C");
        romeMap.put(90, "XC");
        romeMap.put(50, "L");
        romeMap.put(40, "XL");
        romeMap.put(10, "X");
        romeMap.put(9, "IX");
        romeMap.put(5, "V");
        romeMap.put(4, "IV");
        romeMap.put(1, "I");
    }
    public static boolean checkNumber(String number) {
        return arabicNumerals.containsKey(number.toUpperCase());
    }
    public static String toRome(int number) {
        int l =  romeMap.floorKey(number);
        if ( number == l ) {
            return romeMap.get(number);
        }
        return romeMap.get(l) + toRome(number-l);
    }
    public static Integer toArabic(String number) {
        return arabicNumerals.get(number.toUpperCase());
    }

}