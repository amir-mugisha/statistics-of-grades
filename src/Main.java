import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = 0;
        boolean validInput = false;

        // Validate if the input is an integer and reject non integer inputs
        while(!validInput){
            System.out.print("Enter number of students: ");
            if(scanner.hasNextInt()){
                numberOfStudents = scanner.nextInt();
                validInput = true;
            }
            else{
                System.out.println("Invalid input, number of students must be an integer");
                scanner.next();
            }
        }


        int[] marks = new int[numberOfStudents];
        int[] stats = new int[5];
        int maximum = 0;
        int minimum;
        int sum = 0;

        System.out.print("Enter marks of " + numberOfStudents + " students: ");
        for(int i = 0; i < numberOfStudents; i++)
            marks[i] = scanner.nextInt();

        //set the minimum mark to the first element of the marks array
        minimum = marks[0];

        /*
        -loop through marks to record number of records in given ranges(0-20, 21-40,41-60,...).

        -check if current mark is greater than existing maximum to update the maximum
         and update minimum if current mark is less than existing minimum.
         
         -calculate the sum
        */

        for(int mark : marks){
            if(mark >= 0 && mark <= 20)
                stats[0]++;
            else if(mark > 20 && mark <= 40)
                stats[1]++;
            else if(mark > 40 && mark <= 60)
                stats[2]++;
            else if(mark > 60 && mark <= 80)
                stats[3]++;
            else
                stats[4]++;


            if(mark > maximum)
                maximum = mark;
            if(mark < minimum)
                minimum = mark;
            sum += mark;
        }

        double average = (double)sum/numberOfStudents;

        System.out.println("\nValues: \n");
        System.out.println("The maximum grade is " + maximum);
        System.out.println("The minimum grade is " + minimum);
        System.out.println("The average grade is " + average + "\n");

        System.out.println("Graph: \n");
        // iterate through stats to get the maximum number which will give us the height of our graph's Y-axis
        int max = 0;
        for(int st : stats)
            if(st > max)
                max = st;

        //here the for loop starts from the maximum record in our stats array to start the top of our y-axis
        for (int i = max; i > 0; i--) {
            //print the y-axis from the top
            System.out.print(i + " > ");
            /*
            loop into stats and if the record is greater or equal to the level of the y-axis print the "###"
            otherwise use tabs to have empty spaces
             */
            for (int stat : stats) {
                if (stat >= i) {
                    System.out.print("\t#######\t");
                } else {
                    System.out.print("\t\t\t");
                }
            }
            System.out.println();
        }

        // Print the x-axis
        System.out.print("\t+-----------+-----------+-----------+-----------+-----------+\n");
        System.out.print("\tI   0-20    I   21-40   I   41-60   I   61-80   I   81-100  I\n");

    }
}