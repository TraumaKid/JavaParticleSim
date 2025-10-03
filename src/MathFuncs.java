public class MathFuncs {
    public static int randomInt(int lowerBound, int higherBound) {
        return (int) (Math.round(Math.random() * higherBound) - lowerBound);
    }

    public static int randomInt(int higherBound) {
        return (int) Math.round(Math.random() * higherBound);
    }
}
