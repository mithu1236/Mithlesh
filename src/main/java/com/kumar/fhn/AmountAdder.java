package com.kumar.fhn;

// AmountAdder.java
public class AmountAdder {
    public static Amount addAmounts(Amount a1, Amount a2) throws CurrenciesDoNotMatchException {
        if (!a1.getCurrency().equals(a2.getCurrency())) {
            throw new CurrenciesDoNotMatchException("Currencies do not match");
        }
        return new Amount(a1.getCurrency(), a1.getValue() + a2.getValue());
    }
}
