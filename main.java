public class main {
    public static void main(String[] args) {
        RomanNumeralConverter converter = new RomanNumeralConverter();

        System.out.println(converter.numeralToInteger("CLXV"));
        System.out.println(converter.numeralToInteger("IV"));
        System.out.println(converter.numeralToInteger("XL"));
        System.out.println(converter.numeralToInteger("XC"));
        System.out.println(converter.numeralToInteger("XCIV"));
        System.out.print(converter.numeralToInteger("XIV"));
    }
}
