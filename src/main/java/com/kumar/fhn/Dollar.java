package com.kumar.fhn;

// Dollar.java
public class Dollar {
    public static void main(String[] args) {
        try {
            AmountAdder.addAmounts(new Amount("RUPEE", 5), new Amount("DOLLAR", 5));
        } catch (CurrenciesDoNotMatchException e) {
            System.out.println("Handled CurrenciesDoNotMatchException");
        } catch (Exception e) {
            System.out.println("Handled Exception");
        }
    }
}

