package edu.miu.parallel.ThreadLocal;

public class Main {

    private static ThreadLocal<Transaction> local= new ThreadLocal<>();

    public static void main(String[] args) {

        local.set(new Transaction(34));

        check();


    }

    static void check(){

        System.out.println(local.get());

    }
}

class Transaction{
    private  int data;

    public Transaction(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "data=" + data +
                '}';
    }
}
