package com;

import java.util.function.Supplier;

public class Lazily<T> implements Supplier<T> {
    private Supplier<T> supplier;

    public Lazily(Supplier<T> supplier) {
        this.supplier = supplier;
    }


    @Override
    public T get() {
        T val = supplier.get();
        supplier = () -> val;
        return val;
    }
}
