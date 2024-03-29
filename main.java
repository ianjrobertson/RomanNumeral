import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        while (running) {
            System.out.println("Type \"quit\" to end, or \"list\" to see all Roman Numerals\nEnter a Roman Numeral:");
            try {
                String input = sc.nextLine();
                if (input.equals("quit")) {
                    running = false;
                }
                else if (input.equals("list")) {
                    for (int i = 1; i < 4000; i++) {
                        String numeral = converter.IntegerToNumeral(i);
                        System.out.println(i + ": " + numeral + " -> " + converter.numeralToInteger(numeral));
                    }
                }
                else {
                    int decimal = converter.numeralToInteger(input);
                    if (!converter.IntegerToNumeral(decimal).equals(input)) {
                        throw new Exception("");
                    }
                    System.out.println(input + " -> " + decimal + " -> " + converter.IntegerToNumeral(decimal));
                }

            }
            catch (Exception e) {
                System.out.println("Bad input, try again");
            }

        }

    }
}
