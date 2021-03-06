package com.example.banking.core.domain;

import java.util.Objects;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// DDD : Value Class -> Immutable -> Validation
public final class TcKimlikNo {
    private final String value;

    private TcKimlikNo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TcKimlikNo of(String value) {
        // validation
        if (validate(value))
            return new TcKimlikNo(value);
        throw new IllegalArgumentException(String.format("%s is not a valid identity.", value));
    }

    public static boolean validate(String value) {
        if (value == null) return false;
        if (!value.matches("^\\d{11}$")) {
            return false;
        }
        int[] digits = new int[11];
        for (int i = 0; i < digits.length; ++i) {
            digits[i] = value.charAt(i) - '0';
        }
        int x = digits[0];
        int y = digits[1];
        for (int i = 1; i < 5; i++) {
            x += digits[2 * i];
        }
        for (int i = 2; i <= 4; i++) {
            y += digits[2 * i - 1];
        }
        int c1 = 7 * x - y;
        if (c1 % 10 != digits[9]) {
            return false;
        }
        int c2 = 0;
        for (int i = 0; i < 10; ++i) {
            c2 += digits[i];
        }
        if (c2 % 10 != digits[10]) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TcKimlikNo that = (TcKimlikNo) o;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TcKimlikNo{" +
                "value='" + value + '\'' +
                '}';
    }
}
