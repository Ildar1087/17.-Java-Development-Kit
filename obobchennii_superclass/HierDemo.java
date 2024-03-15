package obobchennii_superclass;

public class HierDemo {
    public static void main(String[] args) {
        Gen3<String, Integer, String> x3 =
                new Gen3<String, Integer, String>("Znachenie = ", 990, " Вот такое решение!");
        System.out.print(x3.getOb());
        System.out.print(x3.getOb2());
        System.out.println(x3.getOb3());
    }
}
