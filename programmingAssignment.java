/**

   By Humza Nawab
   2/20/2022
   IT 106-204
   Programming Assignment 1
   
   This program calculates the moving costs for a company.
   The company offers 3 components of their moving services: storage, insurace, travel
   The user must enter their name, then must enter the number of miles they will travel,
   rooms they have in the house they are moving, and the current plan or new insurance plan they want.
   
   There are 3 types of insurance options: BASIC, EXPANDED, NONE
   
   BASIC INSURANCE: $5 fee per room
   EXPANDED INSURANCE: $10 fee per room
   NONE: $0 fee per room
   
   Storage is $100 per month
   Travel costs are $1 per mile over 25 miles, as the first 25 miles are included in price
   The total cost will be cost of storage, travel, and insurance. 
   **/

//import java GUI pane
import javax.swing.JOptionPane;
//name of the program
public class programmingAssignment{
   //main method initialized for execution of code
   public static void main (String args[]){
   
   //initializing variables
   //customer name as string
   String customerName = "";
   //number of rooms as integer
   int numberOfRooms = 0;
   //travel miles as a decimal value
   double travelMiles = 0;
   //storage months as a decimal value
   double storageMonths = 0;
   //insurance plan stored as a string
   String insuranceOptions = "";
   //travel cost variable, will store resultant travel cost
   double travelCost = 0;
   //insurance cost variable, will store resultant insurance cost
   double insuranceCost = 0;
   //storage cost variable, will store resultant storage cost
   double storageCost = 0;
   //stores the total cost comprised of travel, insurace, and storage
   double totalCost = 0;
   
   //prompt for inputting customer name
   customerName =JOptionPane.showInputDialog("Please enter your name ");
   //prints out customer name with hello message
   JOptionPane.showMessageDialog(null, "Hello, " + customerName);
   //prompts user for nunber of rooms 
   numberOfRooms = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of rooms"));
   //prompts user for miles to travel
   travelMiles =Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the number of travel miles"));
   //prompts user for months of storage
   storageMonths = Double.parseDouble(JOptionPane.showInputDialog(null, "Pleae enter the number of storage months"));
   //prompts user for insurance options or current insurance 
   insuranceOptions = JOptionPane.showInputDialog("Please choose your insurance plan\nBASIC | EXPANDED | NONE");

   //calculates travel cost by subtracting miles traveled by included 25 included miles to get excess miles, multiplied by $1 fee per mile
   if(travelMiles>25){
   
      travelCost=(travelMiles-25)*1;
      
      }
   //if travel miles is 25 or less, cost is 0 as 25 base miles included in price
   else{
    
      travelCost = 0;

      }
   //checks if insurance entered is basic plan, then calculates insurance cost accordingly 
   if(insuranceOptions.equalsIgnoreCase ("basic")){
     //basic cost is $5 per room
     insuranceCost = numberOfRooms * 5;
     
     }
   //checks if insurance entered is expanded plan, then calculates insurance cost accordingly 
   else if(insuranceOptions.equalsIgnoreCase ("expanded")){
   
      //expanded cost is $10 per room
      insuranceCost = numberOfRooms * 10;
      
     }
   //if insurance plan entered is none or an invalid option, sets cost to 0
   else{
   
      insuranceCost = 0;
      
      }
   //calculates the storage cost, multiples months of storage by $100
   if(storageMonths > 0){
   
      storageCost = storageMonths * 100;
      
      }
   //if storage months 0, sets cost to 0
   else{
   
      storageCost = 0;
      
      }
   //calculates total cost by adding travel, insurance, and storage cost
   totalCost = travelCost + insuranceCost + storageCost;
   
   //outputs all the costs into the java pane as a receipt
   JOptionPane.showMessageDialog(null, "Receipt for " + customerName + "\ntravel cost--- $" + travelCost + "\ninsurance cost--- $" 
   + insuranceCost + "\nstorage cost--- $" + storageCost + "\ntotal cost--- $" + totalCost);





   }

}