public class Calculator {
    private final String line;
    public Calculator(String line){
        this.line = line.replaceAll("\\s", "");
    }
    public String computation() {
        String sign = operationCheck();
        String[] split = line.split(sign);
        String a = split[0];
        String b = split[1];
        int aEnd = 0;
        int bEnd = 0;
        int result = 0;
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
            if (result > 0) {
                return RomeNumber.toRome(result);
            } else {
                throw new RuntimeException("Неверно записаны числа");
            }
        } else {
            return String.valueOf(result);
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
<<<<<<< HEAD
            throw new RuntimeException("Неверно записаны числа");
=======
            throw new RuntimeException("Неверный формат чисел");
>>>>>>> 5cea11bf7e4b8109ae5aacc944702eb56e609d8b
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
    private int division (int a, int b){
        return a / b;
    }
}
