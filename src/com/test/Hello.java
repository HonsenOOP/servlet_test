package com.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by Honsen on 2016/9/20.
 * @author Honsen
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println(test());
    }
    private static int test(){
        int ret = 0;
        try{
            System.out.println("try");
            return ret;
        }
        catch(Exception e){
            ret = 1;
            System.out.println("catch");
            return ret;
        }
        finally{
            System.out.println("finally");
            ret = 2;
        }
    }
}
