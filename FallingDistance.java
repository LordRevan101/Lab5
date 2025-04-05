import java.util.Scanner;
/**
 * This program will ask the user for time of fall, and will output the distance the object falls every second.
 * @author Alan Doughman
 * @version v1.0
 * @since 3/18/25
 */
public class FallingDistance {
    public static final double ACCELERATION = 9.8;
    public static void main (String[] args) {
        int seconds;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter how much time the object will fall(positive whole number): ");
        seconds = input.nextInt();
        System.out.println("Time(secs)   Distance(m)\n==========   ===========");
        for (int i=1;i<=seconds;i++){
            System.out.printf("%-13d%.1f\n", i, getDistance(i));
        }
        
    }
    /**
    * The getDistance method is a method to calculate the distance an object fell using time, with a kinematic equation,
    * distance = (1/2)(g)t^2, where g is the acceleration of gravity, 9.8, and t is inputed time.
    * @param t is the inputted time
    * @return distance is the result of the equation
    */
    public static double getDistance(int t) {
        double distance;
        distance = 0.5 * ACCELERATION * t * t;
        return distance;
    }
}