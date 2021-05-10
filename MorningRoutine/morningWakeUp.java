package MorningRoutine;

import java.util.Scanner;

public class morningWakeUp {
    public static void main(String[] args) {
        //Display message that the alarm clock is going off

        Scanner user_input = new Scanner(System.in);

        String firstName;
        String answer;
        String testString; // This line needs to be deleted

        

        System.out.println("What is your name?");
        firstName = user_input.next();

        System.out.println("Good Morning " + firstName + "!");
        System.out.println(firstName + " .Would you like to start your day?");  
        
        answer = user_input.nextLine();
        if (answer == "Yes") 
            System.out.println("Wonder" + firstName +"! What would you like to do first?");
        if (answer == "No") 
            System.out.println("Okay," + firstName +". I will try again later.");
        /* Lines 21-27 are not working,
        the next question isnt being asked,
        */
    }
}
