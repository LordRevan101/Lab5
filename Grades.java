import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
/**
 * This program will read a text file of scores, and calculate the number of A's, B's, C's, D's and F's. It will then
 * calculate the lowest score, highest score, and average score. It will then output a text file with the information.
 * @author Alan Doughman
 * @version v1.0
 * @since 3/22/25
 */
public class Grades{
    public static void main(String[] args) throws IOException{
        String inFile = getInFile();
        String outFile = getOutFile();
        
        processFile(inFile,outFile);
        System.exit(0);
    }
    
    /**
     * The getInFile method is to ask the user for an input, the name of a file. If it exists, it returns the file name. If 
     * the file does not exist, it will prompt the user to re-enter the information.
     * @return string inFileName, which is the name of the file inputted by the user.
     * @param no parameters
     */
    public static String getInFile() {
        String inFileName;
        File file;
        
        do {
            inFileName = JOptionPane.showInputDialog("Enter the file name.");
            file =  new File(inFileName);
            if (!(file.exists())){
                JOptionPane.showMessageDialog(null, inFileName + " is invalid. Please re-enter.");
            }
        } while(!(file.exists()));
        
        return inFileName;
    }
    
    /**
     * The getOutFile method is called in order to recieve user input for what they want the new file to be called, or 
     * replace a file with the same name. If the file cannot be created, it will re-promt the user.
     * @return string outFileName, which is the inputted file name.
     * @param no parameters
     */
    public static String getOutFile() {
        String outFileName;
        
        do {
            outFileName = JOptionPane.showInputDialog("Enter the name to create the text file.");
            try {
                PrintWriter fileOutput = new PrintWriter(outFileName);
                fileOutput.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, outFileName + " is invalid.");
                outFileName=null;
            }
        } while(outFileName==null);
        return outFileName;
    }
    
    /**
     * The processFile method is what process the inputted file from the user, reading it and calculating how many of each 
     * grade there is, along with the high, low, and average of each list. It then prints it out onto the user selected
     * new file and saves it. Once it is done it will close the files.
     * @return no return, void method
     * @param string inFile and outFile, which are files to read, and output into, respectively.
     */
    public static void processFile(String inFile, String outFile) throws IOException {
        Scanner fileChecker = new Scanner(new File(inFile));
        PrintWriter edit = new PrintWriter(outFile);
        
        int tracker=0;
        while ((fileChecker.hasNextLine())){
            int a=0,b=0,c=0,d=0,f=0, high=0, low=100, avgtrack=0;
            double avg=0;
            int check;
            while ((check = fileChecker.nextInt()) != -1){
                if (check>=90){
                    a++;
                } else if (check>=80){
                    b++;
                } else if (check>=70){
                    c++;
                } else if (check>=60){
                    d++;
                } else {
                    f++;
                }
                
                if(check>high){
                    high=check;
                }
                if(check<low){
                    low=check;
                }
                avg=avg+check;
                avgtrack++;
            }
            tracker++;
            avg=avg/avgtrack;
            if(avgtrack==0){
                edit.println("Set " + tracker + " of grades calculated");
                edit.println("No grades to average\n");
            } else {
                edit.println("Set " + tracker + " of grades calculated");
                edit.println("Number of A's: " + a);
                edit.println("Number of B's: " + b);
                edit.println("Number of C's: " + c);
                edit.println("Number of D's: " + d);
                edit.println("Number of F's: " + f);
                edit.println("The high score was: " + high);
                edit.println("The low score was: " + low);
                edit.println(String.format("The average score is: %.1f\n",avg));
            }
        }
        edit.close();
        fileChecker.close();
    }
}