package com.example.banking.core.domain;

// Value class -> No identity -> immutable
public record Currency(double amount,CurrencyEnum currency){}
/* public final class Currency {
    private final double amount;
    private final CurrencyEnum currency;

    public Currency(double amount, CurrencyEnum currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency1 = (Currency) o;

        if (Double.compare(currency1.amount, amount) != 0) return false;
        return currency == currency1.currency;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
*/