import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {
    //what is the best way to define the constant values.
    //We need a way to 1. convert a numeral to an int
    // and 2. Convert an int to a roman numeral.
    private final HashMap<Integer, String> integerToNumeralMap = new HashMap<>();
    private final HashMap<String, Integer> numeralToIntegerMap = new HashMap<>();
    public RomanNumeralConverter() {
        //make the intial map
        integerToNumeralMap.put(1, "I");
        integerToNumeralMap.put(5, "V");
        integerToNumeralMap.put(10, "X");
        integerToNumeralMap.put(50, "L");
        integerToNumeralMap.put(100, "C");
        integerToNumeralMap.put(1000, "M");

        //reverse the mapping
        for (Map.Entry<Integer, String> entry : integerToNumeralMap.entrySet()) {
            numeralToIntegerMap.put(entry.getValue(), entry.getKey());
        }
    }

    public int numeralToInteger(String numeral) {
        // I think it makes sense to divide the string into an array of a fixed length
        // Then maybe we create a second array of the same size where we will put in the numbers.
        // based on the rules we can negate the numbers for subtraction.
        //This is a number system but we have to build everything in terms of those fixed values.
        int[] numberList = new int[numeral.length()];

        for (int i = 0; i < numeral.length(); i++) {
            numberList[i] = numeralToIntegerMap.get(String.valueOf(numeral.charAt(i)));
            //System.out.println(numberList[i]);
        }

        this.processSubtraction(numberList);

        int total = 0;
        for (int i = 0; i < numberList.length; i++) {
            total += numberList[i];
        }
        return total;
    }

    private void processSubtraction(int[] numberList) {
        if (numberList.length < 2) {
            return;
            //return numberList; // If the numeral is less than two characters long we don't need to process it
        }
        //Starting at the end of the list,
        for (int i = numberList.length - 1; i > 0; i -= 2) {
            //Looking at pairing AB
            //If B > A
            //Negate A
            if (numberList[i] > numberList[i - 1]) {
                numberList[i - 1] = numberList[i - 1] * -1;
            }
        }
        //return numberList;
    }

    public String IntegerToNumeral(int number) {

        return null;
    }
}
