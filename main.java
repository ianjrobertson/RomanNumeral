public class main {
    public static void main(String[] args) {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        for (int i = 1; i < 4000; i++) {
            String numeral = converter.IntegerToNumeral(i);
            System.out.println(i + ": " + numeral + " -> " + converter.numeralToInteger(numeral));
        }
    }
}
