import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private String line;
    private String result;
    private ConvertingString converting;
    private ArithmeticOperations calculator;
    public App(String line) {
        this.line = line;
    }
    public String getResult(){return result; }

    public void calculation(){
        converting = new Converting(line);
        converting.convertToNumber();
        calculator = new Calculator();
        int resultBuff = 0;
        switch (converting.getOperation()){
            case "\\+":
                resultBuff = calculator.addition(converting.getA(), converting.getB());
                break;
            case "\\-":
                resultBuff = calculator.subtraction(converting.getA(), converting.getB());
                break;
            case "\\*":
                resultBuff = calculator.multiplication(converting.getA(), converting.getB());
                break;
            case "\\/":
                resultBuff = calculator.division(converting.getA(), converting.getB());
                break;
        }
        if (converting.isArabic()) {
            result = String.valueOf(resultBuff);
        } else result = converting.convertToRome(resultBuff);
    }
}
