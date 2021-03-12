package edu.miu.hashmap;

public class Test {
    public static void main(String[] args) {

    }
}

interface A {
    void addValue();
}
interface B extends A {}

abstract  class C implements B {
    public abstract void addValue();
}

class D implements A{

    @Override
    public void addValue() {
        System.out.println("DDDDD");
    }
}
