public class Converting implements ConvertingString{
    private final CheckedNumber number = new Number();
    private String line;
    private int a;
    private int b;
    private boolean isArab;
    @Override
    public boolean isArabic() {
        return isArab;
    }

    private String operation;

    public Converting(String line) {
        this.line = line;
    }
    public int getA() {
        return a;
    }
    @Override
    public String convertToRome(int number) {
        return RomeNumber.toRome(number);
    }

    public int getB() { return b; }
    public String getOperation() {return operation; }
    @Override
    public void convertToNumber() {
        operation = searchOperation();
        String[] buff = line.split(operation);
        if (number.isNumber(buff[0], buff[1])) {
            isArab = true;
            a = Integer.parseInt(buff[0]);
            b = Integer.parseInt(buff[1]);
        } else {
            isArab = false;
            a = RomeNumber.toArabic(buff[0]);
            b = RomeNumber.toArabic(buff[1]);
        }
    }
    private String searchOperation() {
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
}
