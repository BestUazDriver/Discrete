public class BooleanFunction {

    public static void main(String[] args) {
        // Пример булевой функции: (A AND B) OR (NOT C)
        boolean A = true;
        boolean B = false;
        boolean C = true;

        boolean result = calculateBooleanFunction(A, B, C);
        System.out.println("Значение булевой функции: " + result);
    }

    public static boolean calculateBooleanFunction(boolean A, boolean B, boolean C) {
        boolean firstTerm = A && B;
        boolean secondTerm = !C;
        return firstTerm || secondTerm;
    }
}
