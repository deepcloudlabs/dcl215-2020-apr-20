package com.example.banking.core.domain;

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
        throw new IllegalArgumentException("This is not a valid identity");
    }

    public static boolean validate(String value) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TcKimlikNo that = (TcKimlikNo) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
