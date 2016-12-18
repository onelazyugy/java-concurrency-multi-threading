package com.viet.le.livecoding2racecondition;

/**
 * Created by onelazyguy on 12/17/16.
 */
public class LongWrapper {
    private long l;
    public LongWrapper(long l){
        this.l = l;
    }
    public synchronized long getValue(){
        return l;
    }
    //remove 'synchronized' and run the main method and the result will be DIFFERENT all the time
    //add 'synchronized' and run the main method and the result will be SAME all the time
    public synchronized void incrementValue(){
        l = l + 1;
    }
}
