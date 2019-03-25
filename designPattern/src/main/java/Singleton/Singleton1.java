package Singleton;
/*
*饿汉式（静态常量）
 */
public class Singleton1 {

    public final static Singleton1 instance = new Singleton1();

    private Singleton1(){};

    public Singleton1 getInstance(){
        return instance;
    }


}
