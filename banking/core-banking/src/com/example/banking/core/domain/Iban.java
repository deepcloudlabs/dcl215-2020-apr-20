package com.example.banking.core.domain;

import java.util.Objects;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public final class Iban {
    private static final long MAX = 999999999;
    private static final long MODULUS = 97;

    private String value;

    private Iban(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Iban of(String value) {
        // validation
        if (validate(value))
            return new Iban(value);
        throw new IllegalArgumentException(String.format("%s is not a valid iban.", value));
    }

    public static boolean validate(String value) {
        if (value == null || value.length() < 5) {
            return false;
        }
        try {
            int modulusResult = calculateModulus(value);
            return (modulusResult == 1);
        } catch (Exception ex) {
            return false;
        }
    }

    private static int calculateModulus(String code) throws Exception {
        String reformattedCode = code.substring(4) + code.substring(0, 4);
        long total = 0;
        for (int i = 0; i < reformattedCode.length(); i++) {
            int charValue = Character
                    .getNumericValue(reformattedCode.charAt(i));
            if (charValue < 0 || charValue > 35) {
                throw new Exception("Invalid Character[" + i + "] = '"
                        + charValue + "'");
            }
            total = (charValue > 9 ? total * 100 : total * 10) + charValue;
            if (total > MAX) {
                total = (total % MODULUS);
            }
        }
        return (int) (total % MODULUS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Iban that = (Iban) o;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Iban{" +
                "value='" + value + '\'' +
                '}';
    }
}
