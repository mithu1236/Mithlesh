package com.kumar.fhn;

public class DefaultTen {
    public static void main(String[] args) {
       int number = 10;
        switch (number) {
            default:
                System.out.println("Default");
                break;
            case 1:
                System.out.println(1);
                break;
            case 2:
               // Java Interview Questions and Answers – www.in28Minutes.com 51
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
        }
    }
}
