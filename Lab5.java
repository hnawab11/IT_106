import javax.swing.JOptionPane;

public class Lab5
{
   
   //main method
   public static void main (String args[])
   {
      //initializing all variables
      double minKilowatt = 0.0;
      double maxKilowatt = 1000.0;
      double lowRateKilowattMin = 200.0;
      double lowRate = 0.08;
      double highRate = 0.11;
      double totalOwed = 0.0;
      double numCustomers = 0;
      double amountOwed = 0;
      double KilowattsUsed = -1;
      //initializing string variable that will be used for concatenating all outputs
      String str = "";
      //concatenating the headers
      str = str + "Monthly Billing Report\n";
      str = str + "Customer Number | Customer Name | Kilowats Used | Amount Owed \n";
      
      //prompting user for customer number
      String customerNumber = JOptionPane.showInputDialog("Enter customer number ");
      //while statement checking if sentinel is entered to exit program
       while(!customerNumber.equalsIgnoreCase("Quit"))
       {

         //prompts users for customer name
         String customerName = JOptionPane.showInputDialog("Enter customer name ");
       //do while statement that checks if kilowatts entered is a valid entry and is within range
        do{
           try
           {
            KilowattsUsed = Double.parseDouble(JOptionPane.showInputDialog("Enter kilowatts used"));
            while(KilowattsUsed < minKilowatt || KilowattsUsed > maxKilowatt)
            
                {
                  JOptionPane.showMessageDialog(null, "ERROR, please enter valid number of kilowatts");
                  KilowattsUsed = Double.parseDouble(JOptionPane.showInputDialog("Please enter a valid number of kilowatts"));
                } 
           }
            catch(Exception e )
              {
                  JOptionPane.showMessageDialog(null, "Please enter valid kilowatts used in numbers, not letters");
              }
            //Double KilowattsUsed = Double.parseDouble(JOptionPane.showInputDialog("Enter kilowats used "));
            
            }
              while(!(KilowattsUsed < maxKilowatt) || !(KilowattsUsed >= minKilowatt));
            //while(!(KilowattsUsed >= minKilowat || KilowattsUsed < maxKilowatt));
       
               if(KilowattsUsed < lowRateKilowattMin)
               {
                  amountOwed = KilowattsUsed * highRate;
               }
               else{
                  amountOwed = KilowattsUsed * lowRate;
               }
         //adding amounted owed from each run to total amount owed         
         totalOwed = totalOwed + amountOwed;
         numCustomers++;
         // concatenating the string variables
         str = str + customerNumber + " | " + customerName + " | " + KilowattsUsed + " | $" + amountOwed + "\n"; 
         //prompting user for customer number
         customerNumber = JOptionPane.showInputDialog("Enter customer number ");

               
      }
      
      ///checks to ensure that at least one customer is entered, otherwise will print no customers entered
      if(numCustomers > 0){
         str = str + "number of customers: " + numCustomers + " total owed $" + totalOwed;
      
      }
      else{
         str = str + "no customers entered ";
         
      }
      //outputs the entire string into one pane
      JOptionPane.showMessageDialog(null, str);

     
   
   }

}