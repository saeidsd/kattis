package kattis.medium;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Saeid Samadi-Dana
 * @see <a href="https://open.kattis.com/problems/creditcard">https://open.kattis.com/problems/creditcard</a>
 */
public class CreditCard {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    

    public static void main(String[] args) {
        df.setRoundingMode(RoundingMode.UP);
        Scanner kb = new Scanner(System.in);
        int testCases = kb.nextInt();
        kb.nextLine();//remove enter key from buffer
        String[][] data = new String[testCases][3]; //create an array to store the test cases
        for (int i = 0; i < testCases; i++) {
            data[i] = kb.nextLine().split(" ");
        }

        //processing test cases
        for (int i = 0; i < testCases; i++) {
            double R = Double.parseDouble(data[i][0]);//monthly interest rate
            double B = Double.parseDouble(data[i][1]);//outstanding balance
            double M = Double.parseDouble(data[i][2]);//monthly payment

            int count = 0; //number of months to pay the credit card
            while (count <= 1200 && B > 0) {
                double monthlyInterest = Double.parseDouble(df.format( B * R / 100.0));
                B += monthlyInterest - M;
                count++;
            }

            if (count > 1200) {
                System.out.println("impossible");
            } else {
                System.out.println(count);
            }
        }
    }
}
