import java.util.Scanner;
/**
 * This program will ask the user for a positive whole numer input, and then it will check if it is prime. It will then output
 * the result, and then ask the user if they want to input another number.
 * @author Alan Doughman
 * @version v1.0
 * @since 3/20/25
 */
public class PrimeNums {
    public static void main(String[] args){
        int num;

        Scanner input = new Scanner(System.in);
        
        do {
            System.out.print("Please input a whole positive number to check if its prime: ");
            num = input.nextInt();
            if (testPrime(num)) {
                System.out.println(num + " is a prime");
            } else {
                System.out.println(num + " is not a prime");
            }
            System.out.print("Enter yes to retest for a prime. ");
        } while (input.next().equalsIgnoreCase("yes"));
    }
    
    /**
     * The testPrime method tests if the inputted number is a prime or not, by iterating through whole numbers until p's
     * square root.
     * @param p is the inputted number
     * @return boolean true or false if number is calculated to be prime or not
     */
    public static boolean testPrime(int p) {
        boolean check=true;
        for (int i=2;i<=Math.sqrt(p);i++){
            if (p%i==0){
                check=false;
                break;
            }
        }
        
        if (check){
            return true;
        } else {
            return false;
        }
    }
}