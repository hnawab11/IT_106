import javax.swing.JOptionPane;

public class ATM{

   public static void main (String args[]){
      execute();     
   }
   public static boolean getPin(){
      int tries = 0;
      int savedPin = 1234;
      int pin = 0;
      boolean pinSuccess = false;
      while(tries < 3 && !pinSuccess){
      tries++;
      do{
         try{
            pin = Integer.parseInt(JOptionPane.showInputDialog("Please enter your pin"));
         }
         catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter valid PIN");
            pin = -1;
         }
       }while(pin == -1);
      
      if(pin == savedPin){
         pinSuccess = true;
         JOptionPane.showMessageDialog(null, "Welcome");
      }
      else{
         pinSuccess = false;
         JOptionPane.showMessageDialog(null, "Incorrect PIN \nAttempts Remaining: " + (3-tries));
      }
     }
      return pinSuccess;
   }
   public static String getTransactionType(){
      String transactionType = " ";
      transactionType = JOptionPane.showInputDialog("Deposit or withdraw?");
      while(!transactionType.equalsIgnoreCase("withdraw") && !transactionType.equalsIgnoreCase("w") 
     && !transactionType.equalsIgnoreCase("deposit") && !transactionType.equalsIgnoreCase("d")){

          transactionType = JOptionPane.showInputDialog("Please enter withdraw or deposit");   
      }
      return transactionType;
   }
   
   public static int transactionAmount(){
      
      int amount = 0;
      do{
      try{
         amount = Integer.parseInt(JOptionPane.showInputDialog("Enter amount"));
            while(amount < 0){
                amount = Integer.parseInt(JOptionPane.showInputDialog("Amount cannot be negative"));
            }
         }
         catch(NumberFormatException e){
         
            JOptionPane.showMessageDialog(null, "Amount must be entered as number");
            amount = -1;
         
         }
         }while(amount == -1);
      
      return amount;
   } 
   public static void execute(){
      boolean pinSuccess = getPin();  
      if(pinSuccess == true){
         executeBank();
      }
   }
   public static int executeBank(){
      
      int balance = 500;
      String prompt = " ";
      JOptionPane.showMessageDialog(null, "Current Balance is $" + balance);
      String str = "total transactions";
      
      do{
         String transaction = getTransactionType();
         int amount = transactionAmount();
         if(transaction.equalsIgnoreCase("deposit") || transaction.equalsIgnoreCase("d")){
     
           // amount = transactionAmount();
            balance += amount;
            JOptionPane.showMessageDialog(null, "New balance is $" + balance);
            str += "\ndeposited: $" + amount;
      
         }
         else if(transaction.equalsIgnoreCase("withdraw") || transaction.equalsIgnoreCase("w")){
            
            //amount = transactionAmount();
            while(amount > balance){
               JOptionPane.showMessageDialog(null, "cannot overdraw, enter valid number");
               amount = transactionAmount();
            }
            if(amount <= balance ){
               balance -= amount;
               JOptionPane.showMessageDialog(null, "New balance is $" + balance);
               str += "\nwithdrew: $" + amount;
            }
       
        }
            String output = output(transaction, balance); 
            JOptionPane.showMessageDialog(null, output + "\n" + str);
           // JOptionPane.showMessageDialog(null, str);
            prompt = JOptionPane.showInputDialog("Hit [ENTER] to continue or type exit");
      
        }while(!prompt.equalsIgnoreCase("exit"));
      
       return balance;
   
   }
   public static String output(String str, int balance){
   
      String output = "";
      output += "transaction type: " + str;
      output += "\nbalance $" + balance;
      return output;
   
   }   
}