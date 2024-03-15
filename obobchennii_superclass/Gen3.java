package obobchennii_superclass;

public class Gen3<T, V, X> extends Gen2<T,V> {
    X ob3;

    public Gen3(T o, V o2, X o3) {
        super(o, o2);
        this.ob3 = o3;
    }

    public X getOb3() {
        return ob3;
    }
}
