import java.util.HashMap;

public class RomanNumeralConverter {
    //what is the best way to define the constant values.
    //We need a way to 1. convert a numeral to an int
    // and 2. Convert an int to a roman numeral.
    private final HashMap<String, Integer> numeralToIntegerMap;
    public RomanNumeralConverter() {
        //initialize the hashmap and define the constant values
        numeralToIntegerMap = new HashMap<>();
        numeralToIntegerMap.put("I", 1);
        numeralToIntegerMap.put("V", 5 );
        numeralToIntegerMap.put("X", 10);
        numeralToIntegerMap.put("L", 50);
        numeralToIntegerMap.put("C", 100);
        numeralToIntegerMap.put("D", 500);
        numeralToIntegerMap.put("M", 1000);
    }

    /**
     * Takes a given String for a roman numeral and converts the string to its Decimal representation
     *
     * @param numeral
     * @return Decimal representation of Roman Numeral
     */
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

    /**
     * Process the subtraction rule for a given roman numeral being converted to decimal
     * @param numberList
     */
    private void processSubtraction(int[] numberList) {
        if (numberList.length < 2) {
            return;
        }

        //Starting at the beginning
        for (int i = 0; i + 1 < numberList.length; i++) {
            //looking at pairing AB
            // If A < B
            //Negate A
            if (numberList[i] < numberList[i + 1]) {
                numberList[i] = numberList[i] * -1;
            }
        }
    }

    /**
     * This method takes an integer as a parameter and breaks it into 1000s, 100s, 10s, 1s, place,
     * It then breaks each of those components down to find the roman numerals representing that place in the number
     *
     * @param number
     * @return String representing roman numeral
     */
    public String IntegerToNumeral(int number) {
        StringBuilder numeral = new StringBuilder();
        //we want to divide the number into chunks that will easily sum together.

        //Find if we can break it into 1000 chunks
        //Use all the 1000 chunks we can

        //Find if we can break it into
        // Extracting the thousands place
        int numChunks;
        int thousands = number / 1000 * 1000;
        if (thousands != 0) {
            //okay so now we have the number in the thousandths place.
            numChunks = thousands / 1000;
            numeral.append("M".repeat(Math.max(0, numChunks)));
        }

        // Extracting the hundreds place
        int hundreds = (number / 100) % 10 * 100;
        if (hundreds != 0) {
            if (hundreds >= 500) {
                if (hundreds == 900) {
                    numeral.append("CM");
                }
                else {
                    numeral.append("D");
                    hundreds = hundreds % 500;
                    //and then we need to append how many are left
                    numeral.append("C".repeat(Math.max(0, hundreds / 100)));
                }
            }
            else {
                if (hundreds == 400) {
                    numeral.append("CD");
                }
                else {
                    numeral.append("C".repeat(Math.max(0, hundreds / 100)));
                }
            }
        }

        // Extracting the tens place
        int tens = (number / 10) % 10 * 10;
        if (tens != 0) {
            if (tens >= 50) {
                if (tens == 90) {
                    numeral.append("XC");
                }
                else {
                    numeral.append("L");
                    tens = tens % 50;
                    //and then we need to append how many are left
                    numeral.append("X".repeat(Math.max(0, tens / 10)));
                }
            }
            else {
                if (tens == 40) {
                    numeral.append("XL");
                }
                else {
                    numeral.append("X".repeat(Math.max(0, tens / 10)));
                }
            }
        }

        // Extracting the ones place
        int ones = number % 10;
        if (ones != 0) {
            if (ones >= 5) {
                if (ones == 9) {
                    numeral.append("IX");
                }
                else {
                    numeral.append("V");
                    ones = ones - 5;
                    //and then we need to append how many are left
                    numeral.append("I".repeat(ones));
                }
            }
            else {
                if (ones == 4) {
                    numeral.append("IV");
                }
                else {
                    numeral.append("I".repeat(ones));
                }
            }
        }
        return numeral.toString();
    }
}
