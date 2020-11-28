public class Calculator {
    private final String line;
    private String sign;
    private String a;
    private String b;
    public Calculator(String line){
        this.line = line.replaceAll("\\s", "");
    }
    public String computation() {
        sign = operationCheck();
        String[] split = line.split(sign);
        a = split[0];
        b = split[1];
        int aEnd = 0;
        int bEnd = 0;
        double result = 0;
        if (numberCheck(a, b)) {
            aEnd = RomeNumber.toArabic(a);
            bEnd = RomeNumber.toArabic(b);
        } else {
            aEnd = Integer.parseInt(a);
            bEnd = Integer.parseInt(b);
        }
        switch (sign){
            case "\\+":
                result = addition(aEnd, bEnd);
                break;
            case "\\-":
                result = subtraction(aEnd, bEnd);
                break;
            case "\\*":
                result = multiplication(aEnd, bEnd);
                break;
            case "\\/":
                result = division(aEnd, bEnd);
                break;
        }
        if (numberCheck(a, b)){
            if (result % 1 == 0) {
                return RomeNumber.toRome((int)result);
            } else {
                return a + "/" + b + " дробных римских цифр нет";
            }
        } else {
            if (result % 1 == 0) {
                return String.format("%.0f", result);
            } else return String.format("%.3f",result);
        }
    }
    private boolean numberCheck(String a, String b) {
        try{
            if (RomeNumber.checkNumber(a) && RomeNumber.checkNumber(b)) {
                return true;
            } else if (Integer.parseInt(a) < 1 || Integer.parseInt(b) < 1 ||
                    Integer.parseInt(b) > 10 || Integer.parseInt(a) > 10) {
                throw new RuntimeException("Число не может быть больше 10 или меньше 1");
            } else return false;
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Неверно задано римское число");
        }
    }
    private String operationCheck() {
        String[] operation = new String[]{"+", "-", "*", "/"};
        String operationSymbol = "";
        int countOperation = 0;
        for (String s: operation) {
            if (line.contains(s)) {
                operationSymbol = s;
                countOperation++;
            }
        }
        if (countOperation == 1) {
            return "\\"+operationSymbol;
        } else {
            throw new RuntimeException("Неверная арифметическая операция");
        }
    }

    private int addition (int a, int b){
        return a + b;
    }
    private int subtraction (int a, int b){
        return a - b;
    }
    private int multiplication (int a, int b){
        return a * b;
    }
    private double division (int a, int b){
        return a / (double)b;
    }
}
