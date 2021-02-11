import java.util.ArrayList;
import java.util.Arrays;

public class ConvertDecimalMantissa {


/**
 * Main entry to our program.
 *
 */
    public static void main(String[] args) {

        String[] skipFirstElement = Arrays.copyOfRange(args, 1, args.length);

        prettyPrint(Convert(args, Integer.parseInt(args[0])), skipFirstElement, Integer.parseInt(args[0]));
    }

    /**
     *
     * Function converts Base 10 to Base X by taking the value passed, multiplying by the base.
     *
     * @param list - array of base 10 numbers.
     * @return - ArrayList of base x numbers
     */
    private static ArrayList<String> Convert(String[] list, int base){

        int fractionalLength =  8;
        ArrayList<String> data = new ArrayList<>();
        StringBuilder result = new StringBuilder("0.");
        double[] doubleArray = Arrays.stream(list).mapToDouble(Double::parseDouble).toArray(); //converting String Array to Double Array

        for (int i = 1; i < doubleArray.length; i++) {

            double currentDouble = doubleArray[i];

            while ( result.length() != fractionalLength ){

                currentDouble *= base;

                if (currentDouble < 1 ){
                    int test = (int) currentDouble;

                    result.append(test);
                } else if (currentDouble >= 1 ){

                    int test = (int) currentDouble;
                    result.append(test);

                    currentDouble -= test;
                }
            }
            data.add(result.toString());

            result = new StringBuilder("0.");
        }
        return data;
    }


    /**
     * Prints out the results displaying base 10 and base X side by side.
     *
     * @param baseTen - ArrayList of base ten
     * @param baseTwo - Array of base x
     */
    private static void prettyPrint(ArrayList<String> baseTen, String[] baseTwo, int base){

        System.out.println("|\tBase 10\t|\tBase "+ base +"\t|\n| :--------\t| :--------\t|");

        for (int i = 0; i < baseTen.size(); i++) {
            System.out.printf("|%20s\t|%n", baseTwo[i] + "\t| " + baseTen.get(i)  );
        }
    }

}
