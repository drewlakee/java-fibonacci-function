package github.drewlakee;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FibonacciValue {

    private final int value;
    private List<BigInteger> result;

    public FibonacciValue(int valueToCompute) {
        this.value = valueToCompute;
    }

    public List<BigInteger> compute() {
        if (value <= 0) return List.of(BigInteger.ZERO);
        if (value == 1 || value == 2) return List.of(BigInteger.ONE);
        if (result != null) return result;

        ArrayList<BigInteger> arr = new ArrayList<>(value);
        arr.add(0, BigInteger.ONE);
        arr.add(1, BigInteger.ONE);
        for (int i = 2; i < value; i++) {
            arr.add(i, arr.get(i - 2).add(arr.get(i - 1)));
        }
        result = arr;

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
