package Inheritance;

class A {
    public void process(){
        System.out.println("A");
    }
}

class B extends A {
    @Override
    public void process() {
        System.out.println("B");
    }
}

class C extends B {
    @Override
    public void process() {
        //super.process();
        System.out.println("C");
    }
}

public class Example {
    public static void main(String[] args) {
        C c = new C();
        c.process();
    }
}
