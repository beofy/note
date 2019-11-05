package cn.zmxblog.delegate;

public class Demo {

    static class RealPrinter {
        void print() {
            System.out.print("something");
        }
    }

    static class Printer {
        RealPrinter p = new RealPrinter(); // 委派
        void print() {
            p.print();
        }
    }


    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();
    }

}
