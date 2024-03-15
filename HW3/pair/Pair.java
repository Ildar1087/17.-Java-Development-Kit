package HW3.pair;

public class Pair <T,U>{
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public U getSecond(){
        return second;
    }

    @Override
    public String toString() {
        return "(" +
                "first=" + first +
                ", second=" + second +
                ')';
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(21, "Hellouuu");
        Pair<Double, Boolean> pair2 = new Pair<>(12.22, true);

        System.out.println("pair1: " + pair1.toString());
        System.out.println("pair2:" + pair2.toString());
        System.out.println("first value of pair2: " + pair2.getFirst());
        System.out.println("second value of pair2: " + pair2.getSecond());
    }
}
