package com.book.author.book_author;

import java.util.*;

public class FibonaciSerires {

    static int func(int ss){
        int i = 0;
        if(ss==0){

           return 1
                   ;
        }else {


            return ss * func(ss - 1) ;
        }
       // System.out.println(i);
    }

    public static void main(String[] args) {

        System.out.println("enter number");
        Scanner s = new Scanner(System.in);
        int ss = s.nextInt();

        int fact = func( ss);

        System.out.println(fact);
        System.out.println("hello World");
//        ArrayList<Integer> arr = new ArrayList<>();
//        int temp ;
//        int i=0;
//        int j=1;
//        System.out.println(i);
//        System.out.println(j);
//            for ( int k =0; k <=ss; k++) {
//
//                    temp = i +j;
//                    System.out.println(temp);
//                    i=j;
//                    j=temp;
//
//                }
    }
}