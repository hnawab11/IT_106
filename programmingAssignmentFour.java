//By Humza Nawab
//import java pane gui class
import javax.swing.JOptionPane;

//name of main program or class, not the main method
public class programmingAssignmentFour
{
   //the main method of program, all execution happens within this block
   public static void main (String[] args){
   
      //declaring and instantiating all variables
      String employeeName = "";
      String employmentType = "";
      String employeeState = "";
      String programContinuationPrompt = "";
      int totalEligibleEmployees = 0;
      int employeeAnnualSales = 0;
      int totalEmployees = 0;
      int employeeAward = 0;
      int totalAmountAwarded = 0;
      int avgAmountAwarded = 0;

      
      //do while loop that executes the main part of the program, prompting user for name, state, employee type, and does the calculations
      do{
         //prompts user for employee name
         employeeName = JOptionPane.showInputDialog("Enter employee name ");
         //input validation, checking that user doesnt input a blank or an empty space for the name
         while(employeeName.equals(" ") || employeeName.equals("")){
            //re-prompts user for valid employee name
            employeeName = JOptionPane.showInputDialog("Please enter valid employee name ");
         }
         //prompts user for employement type
         employmentType = JOptionPane.showInputDialog("Is employee full-time or part-time? ");
         //input validation, checking that user inputs only "full-time" or "part-time"
         while(!employmentType.equalsIgnoreCase ("full-time") && (!employmentType.equalsIgnoreCase ("part-time"))){
            //re-prompts user
            employmentType = JOptionPane.showInputDialog("Error! Please re-enter employee employment status(part-time or full-time");
         }
         //prompts user for state of employee
         employeeState = JOptionPane.showInputDialog("Enter employee state of residence");
         //prompts user for yearly sales of an employee
         
         //do while for try-catch-input validation statements
         do{
            //try statement that attempts to acquire the sales entered
            try
            {  
               //prompts user for yearly sales of an employee
               employeeAnnualSales = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter employee yearly sales" ));
               //input validation, while statement that ensures that sales entered should be greater than 0
               while(employeeAnnualSales < 0)
               {
               //re-prompts user for sales until sales are 0 or greater
               employeeAnnualSales = Integer.parseInt(JOptionPane.showInputDialog(null, "Error! Enter a valid employee yearly sales figure" ));  
               }
            } //end try
            //catch statement that catces exception to prevent program crash
            catch(Exception e )
               { 
                  //re-prompts user for a valid sales figure, tells user that input must be a digit
                  JOptionPane.showMessageDialog(null, "Please enter valid annual sales figure as digits");
                  //program sentinel that sets employee sales to -1, which causes the while statement of do-while to repeat
                  //this allows the functionality that that re-prompting user for valid sales figure
                  employeeAnnualSales = -1;
               }
           //checks for sentinel value of -1 for annual sales, continues to execute do while until annual sales is a valid figure
          }while(employeeAnnualSales == -1);
         //counter that adds a tally of the total number of employees entered
         totalEmployees++;
         
         //if statement that checks for employees who are living in Virginia and are full-time
         //allows the user to enter either "virginia", "Virginia","va", or "VA". Caps doesn't matter
         if(employmentType.equalsIgnoreCase ("full-time") && (employeeState.equalsIgnoreCase("virginia") || (employeeState.equalsIgnoreCase("VA")))){
               
               //notifies user that the entered employee is eligible to PARTICIPATE in rewards program. 
               //DOES NOT neccessarily mean they will win an award 
               JOptionPane.showMessageDialog(null, "Employee "+ employeeName +" is eligible to participate in rewards program");   
            
            //if statement that checks and sets condition if annual sales are greater than or equal to 50000 and equal to or less than 100000
            if(employeeAnnualSales >= 50000 && employeeAnnualSales <= 100000){
               //counter that tallies the number of employees eligible to participate AND receive awards for their sales 
               totalEligibleEmployees ++;
               //calculates employee award amount as being 10% of the sales made
               employeeAward = employeeAnnualSales * 10/100;
               //counter that adds up total amount awarded to all employees
               totalAmountAwarded+=employeeAward;
               //notifies user that employee is eligible for award of certain figure
               JOptionPane.showMessageDialog(null,"Employee " + employeeName + " is eligible for an award of $" + employeeAward);
            }
            //else if that checks if sales are greater than or equal to 100,001 and less than or equal to 150000
            else if(employeeAnnualSales >= 100001 && employeeAnnualSales <= 150000){
               //counter that tallies the number of total eligible employees
               totalEligibleEmployees ++;
               //employee award amount, calculated as 12% of sales figure
               employeeAward = employeeAnnualSales * 12/100;
               //counter that adds employee award amount to total amount awarded figure
               totalAmountAwarded+=employeeAward;
               //notifies user that employee is eligible for award of certain figure
               JOptionPane.showMessageDialog(null,"Employee " + employeeName + " is eligible for an award of $" + employeeAward);
            }
            //else if that checks if sales are greater than or equal to 150,001 and less than or equal to 200,000
            else if(employeeAnnualSales >= 150001 && employeeAnnualSales <= 200000){
               //counter that tallies the number of total eligible employees
               totalEligibleEmployees ++;
               //award amount, calculated as 15% of sales 
               employeeAward = employeeAnnualSales * 15/100;
               //counter that tallies amound awarded to total amount awarded 
               totalAmountAwarded+=employeeAward;
               //notifies user that employee is eligible for award of certain figure
               JOptionPane.showMessageDialog(null,"Employee " + employeeName + " is eligible for an award of $" + employeeAward);
            }
            //else if checks if sales is greater than 200,000
            else if(employeeAnnualSales > 200000){
               //counter that tallies the number of total eligible employees
               totalEligibleEmployees ++;
               //award amount, calculated as 18% of sales
               employeeAward = employeeAnnualSales * 18/100;
               //counter that tallies amount awarded to total amount awarded
               totalAmountAwarded+=employeeAward;
               //notifies user that employee is eligible for award of certain figure
               JOptionPane.showMessageDialog(null, "Employee " + employeeName + " is eligible for an award of $" + employeeAward);
            }
            //else if checks if sales are less than 50,000
            else if(employeeAnnualSales < 50000){
            //notifies user that employee is not eligible to receive an award because their annual sales figure was too low
               JOptionPane.showMessageDialog(null, "Employee " + employeeName + " is not eligible to receive an award.\nTheir annual sales of $" 
               + employeeAnnualSales + " does not meet minimum target of $50,000 ");
            }
          } //end if statement that check is state = VA and employeement = full-time
          
           //else statement for all other employees who don't live in va, aren't working full-time, or aren't meeting both of these criteria
           else{
            //notifies user that employee is not eligible to participate in the rewards program 
            JOptionPane.showMessageDialog(null, "Employee " + employeeName + " is not eligible to participate in rewards program. They are either part-time or not living in state of Virginia");
         
         }
        
       //prompts user if they want to continue program. Hit the [ENTER] key or typing anything but exit will contine program while typing exit will exit program
       programContinuationPrompt = JOptionPane.showInputDialog("Continue? Hit [ENTER] to continue or type exit to end the program ");

   
      
      }while(!programContinuationPrompt.equalsIgnoreCase ("exit")); //while loop will continue until user enters exits when asked if they want to continue
      
      //if statement that checks if total eligible employees is greater than 0 before performing average amount awarded
      //without if statement, if total eligible employees is 0, the program will crash due to runtime error: DIVIDE BY 0
      if(totalEligibleEmployees > 0){
         //average amount awarded, calculated by dividied total amount awarded by total eligible employees
         avgAmountAwarded = totalAmountAwarded / totalEligibleEmployees;
      }
      
      //the final prompt before the program completely exits, prints the total number of employees, the number of eligible for an award, and the average award amount
      JOptionPane.showMessageDialog(null, "Total number of employees: " + totalEmployees + "\nEmployees eligible for award:" + totalEligibleEmployees + "\nAverage award amount: $" + avgAmountAwarded);
   
   
   }
}