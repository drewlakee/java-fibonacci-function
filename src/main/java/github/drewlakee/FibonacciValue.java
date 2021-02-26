package github.drewlakee;

import java.math.BigInteger;
import java.util.Objects;

public class FibonacciValue {

    private final int value;
    private BigInteger result;

    public FibonacciValue(int valueToCompute) {
        this.value = valueToCompute;
    }

    public BigInteger compute() {
        if (value <= 0) return BigInteger.ZERO;
        if (value == 1 || value == 2) return BigInteger.ONE;
        if (result != null) return result;

        BigInteger[] arr = new BigInteger[value];
        arr[0] = BigInteger.ONE;
        arr[1] = BigInteger.ONE;
        for (int i = 2; i < value; i++) {
            arr[i] = arr[i - 2].add(arr[i - 1]);
        }
        result = arr[value - 1];

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FibonacciValue that = (FibonacciValue) o;
        return value == that.value && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, result);
    }

    @Override
    public String toString() {
        return "FibonacciValue{" +
                "value=" + value +
                ", result=" + result +
                '}';
    }
}
