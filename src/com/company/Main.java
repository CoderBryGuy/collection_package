package com.company;

import com.company.collection_package.*;

public class Main {

    public static void main(String[] args) {

        IntArray x = new IntArray(10);
        //x.add(5);

        System.out.println(x.size());

        for (int i = 0; i <x.size() ; i++) {
         x.add(i);
            //System.out.println("adding "+ i);
        }
        System.out.println("x \n"+x);

        IntArray y = new IntArray(10);
        for (int i = 0; i <y.size() ; i++) {
            y.add(i+10);
            //System.out.println("adding "+ i);
        }
        System.out.println("y \n"+y);

        x.add(y);

        //System.out.println(x.size());
        //x.add(150,16);
        System.out.println("x after adding y \n" + x);

        y.clear();
        //System.out.println(y);
        System.out.println(".contains() "+x.contains(9));

        System.out.println(".get() "+x.get(10));

        System.out.println(".indexOf() "+x.indexOf(9));

        System.out.println(".lastIndexOf() "+x.lastIndexOf(9));

        x.remove(19);

        System.out.println(x);

    }
}
