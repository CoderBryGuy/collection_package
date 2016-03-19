package com.company;

import com.company.collection_package.*;

public class Main {

    public static void main(String[] args) {

        IntArray x = new IntArray(10);
        //x.add(5);

        System.out.println(x.size());

        for (int i = 0; i <15 ; i++) {
         x.add(i);
            //System.out.println("adding "+ i);
        }

        System.out.println(x.size());


        x.add(150,16);
        System.out.println(x);

    }
}
