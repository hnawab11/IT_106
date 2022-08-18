//IT 106-204 LAB 2
//BY HUMZA NAWAB

//import the java pana classs
import javax.swing.JOptionPane;

public class Lab_2{
   //initializing the main method
   public static void main (String[] args){
   
      //initialize variable for minutes used, minute rate, base plan cost, and grand total
      double minuteRate = 0.15;
      double minutesUsed = 0;
      double basePlanCost = 20.00;
      double costMinutes = 0;
      double grandTotalCost = 0;
      
      //ask user to input the number of minutes used
      minutesUsed = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter number of minutes used"));
      
      //calculate the total cost of all minutes used by multiply minutesUsed by the minuteRate
      costMinutes = minutesUsed * minuteRate;
      
      //calculate the grand total by multiplying minutes used by the minute rate, and then adding that to the base plan cost
      grandTotalCost = costMinutes+basePlanCost;
      
      //outputting the resulting bill for the total cost
      JOptionPane.showMessageDialog(null, "**IST Wireless - Receipt **\n Base Plan Cost: $" + basePlanCost + 
      "\n Cost for Minutes Used: $" + costMinutes + "\n Grand Total: $" + grandTotalCost);
      }
    
}
