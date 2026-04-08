import java.util.InputMismatchException;
import java.util.Scanner;

public class FibonacciTest {
    
    public static void main(String[] args){
        long endTerm;
        long first = 0;
        long second = 1; 
        int choice = 0;
        
        //Ask user for choice of output
        Scanner input = new Scanner(System.in);
        System.out.println("Option 1: Help ");
        System.out.println("Option 2: Count ");
        System.out.println("Option 3: One-Line ");
        System.out.println("Option 4: Numbering ");
        System.out.println("Option 5: Numbering One-Line ");
        System.out.println("Option 6: Final Term ");
        System.out.println("Enter Your Choice As An Integer:");
        //Check for valid input
       try{
        choice = input.nextInt();
        if (choice < 1 || choice > 6 ){
            System.out.println("Invalid Choice. Must enter an Integer between 1 and 6.");
            input.close();
            return;
        }
       }
       catch(InputMismatchException exception){
            System.out.println("Invalid Input. Must enter an Integer.");
       }
       //Output based on user choice
        switch (choice) {
            //Help guide
            case 1: System.out.println("To use this program, Enter a number 1 through 6. This will decide what the program will output.");
                    System.out.println("Option 2 will output the sequence of numbers in the fibonacci sequence with each number on a new line.");
                    System.out.println("Option 3 will output the sequence of numbers in the fibonacci sequence with each number on the same line. ");
                    System.out.println("Option 4 will output the sequence of numbers in the fibonacci sequence with the term number in front of the fibonacci number.");
                    System.out.println("Option 5 will output the sequence of numbers in the fibonacci sequence with the term number in front of the fibonacci number (Outputted on Same Line).");
                    System.out.println("Option 6 will output the fibonacci number of the term you enter.");
                    System.out.println("After you choose an option, you will be asked to enter the last term number you want from the sequence.");
                    break;
           //Output the sequence of numbers in the fibonacci sequence with each number on a new line.
            case 2:
                System.out.println("Enter the end term: ");
                endTerm = input.nextInt();
                System.out.println("Here are the terms:");
                for (int i = 0;i <= endTerm; i++){
                    long next = first + second;
                    first = second;
                    second = next;
                    System.out.println(next);
                }
                    break;
            //Output the sequence of numbers in the fibonacci sequence with each number on the same line.      
            case 3:
                System.out.println("Enter the end term: ");
                endTerm = input.nextInt();
                System.out.println("Here are the terms:");
                for (int i = 0;i <= endTerm; i++){
                    long next = first + second;
                    first = second;
                    second = next;
                    System.out.print(next + " ");
                }

                    break;
            //Output the sequence of numbers in the fibonacci sequence with the term number in front of the fibonacci number.
            case 4:
                System.out.println("Enter the end term: ");
                endTerm = input.nextInt();
                System.out.println("Here are the terms:");
                for (int i = 0;i <= endTerm; i++){
                    long next = first + second;
                    first = second;
                    second = next;
                    System.out.println(i + ":" + next + " ");
                }
                    break;
            //Output the sequence of numbers in the fibonacci sequence with the term number in front of the fibonacci number (Outputted on Same Line).
            case 5:
                System.out.println("Enter the end term: ");
                endTerm = input.nextInt();
                System.out.println("Here are the terms:");
                for (int i = 0;i <= endTerm; i++){
                    long next = first + second;
                    first = second;
                    second = next;
                    System.out.print(i + ":" + next + " ");
                }
                    break;
            //Output the fibonacci number of the term you enter.        
            case 6:
                //find final term number
                    System.out.println("Enter the end term: ");
                    endTerm = input.nextInt();
                    long next = 0;
                    for (int i = 0; i <= endTerm; i++){
                        next = first + second;
                        first = second;
                        second = next;
                    }
                    System.out.println("The end term is: " + next);
                    break;
        }
        input.close();
    }
}
