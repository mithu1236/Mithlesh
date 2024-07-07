package com.kumar.fhn;

public class SwitchBrk {
    public static void main(String[] args) {
        int number = 2;
        switch (number) {
            case 1:
                System.out.println(1);
                break;
            case 2:
            case 3:
                System.out.println("Number is 2 or 3");
                break;
            default:
                System.out.println("Default");
                break;
        }
    }
}
