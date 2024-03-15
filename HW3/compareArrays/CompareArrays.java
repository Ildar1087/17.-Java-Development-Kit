package HW3.compareArrays;

public class CompareArrays {

    public static <T> boolean isIn(T[] a, T[] b){
        if(a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i; j < b.length; j++) {
                    if (a[i] == b[j])
                        return true;

                }
            }
        } return false;
    }

    public static void main(String[] args) {
        Integer a [] = {1, 22, 33, 11, 22, 12, 51};
        Integer b [] = {1, 22, 33, 11, 22, 12, 51};
        boolean res = isIn(a, b);
        System.out.println("Массив а = b? "+ res);

        String st1 [] = {"a", "b", "c", "d", "t", "t"};
        String st2 [] = {"a", "b", "c", "d", "t", "t"};
        boolean stres = isIn(st1, st2);
        System.out.println("Массив st1 = st2? " + stres);

        boolean chepuha = isIn(a, st1);
        System.out.println("Массив а == st1? " + chepuha);


    }
}
