import java.math.BigInteger;

public class BigIntegerUtility {
    public BigInteger hexToBigInteger(String hex) {
        return new BigInteger(hex, 16);
    }
}
