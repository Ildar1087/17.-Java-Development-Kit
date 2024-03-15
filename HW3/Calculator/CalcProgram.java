package HW3.Calculator;

import java.text.NumberFormat;
import java.util.Locale;

public class CalcProgram {
    public static void main(String[] args) {
        printResults(getArrayOfCalcOperations());


    }
    public static double[] getArrayOfCalcOperations(){
        return new double[]{
                Calculator.sum(35, 12.2),
                Calculator.divide((short)5, 123L),
                Calculator.multiply((byte)8, 3.32f),
                Calculator.subtract((long) 21, (short) 11)
        };
    }
        // Вывод результатов
    public static void printResults(double[] results){
        NumberFormat nf = getNumberFormat();
        for(double result : results){
            System.out.println("result = " + nf.format(result) + ";");
        }
    }


    public static NumberFormat getNumberFormat(){
        NumberFormat nf = NumberFormat.getInstance(Locale.ROOT);
        // объявляем количество минимальных и
        // максимальных значений после запятой
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf;
    }
}
