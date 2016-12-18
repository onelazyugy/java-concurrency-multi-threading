package com.viet.le;

/**
 * Created by onelazyguy on 12/17/16.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){}

    /**
     * only one thread can access this at a time
     * one object can get the key and run the code, then return the key back for the next object
     * if one object has the key, the other object need to wait until the object with the key is done
     * @return
     */
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
