public class Number implements CheckedNumber {
    @Override
    public boolean isNumber(String a, String b) {
        try{
            if (RomeNumber.checkNumber(a) && RomeNumber.checkNumber(b)) {
                return false;
            } else if (Integer.parseInt(a) < 1 || Integer.parseInt(b) < 1 ||
                    Integer.parseInt(b) > 10 || Integer.parseInt(a) > 10) {
                throw new RuntimeException("Число не может быть больше 10 или меньше 1");
            } else return true;
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Неверно записаны числа");
        }
    }
}
