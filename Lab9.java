//BY HUMZA NAWAB
import javax.swing.JOptionPane;

public class Lab9{
   
   public static void main (String args[]){
   
      int numDeposits = 0;
      int numWithdrawals = 0;
      int initialBalance = getAccountBalance();
      int accountBalance = initialBalance;
      int transactionAmount =0;
      
      String transactionAction= ""; 
   
      do{
         transactionAction = getTransactionAction();
         if(transactionAction.equalsIgnoreCase("D")){
            transactionAmount = transactionAmount();
            numDeposits++;
         
         }
         else if(transactionAction.equalsIgnoreCase("W")){
            transactionAmount = transactionAmount();
            numWithdrawals++;
         
         }
         accountBalance = calculateAccountBalance(transactionAction, transactionAmount, accountBalance);
         printBalance(accountBalance);

         //transactionAction = getTransactionAction();

               
      }while(!transactionAction.equalsIgnoreCase("Q"));
      
      printTransactionSummary(initialBalance, accountBalance, numDeposits, numWithdrawals);
   
   }
   public static int getAccountBalance(){
   
      int balance = 0;
      //balance = Integer.parseInt(JOptionPane.showInputDialog("Enter account balance"));
      do{
         try{
               balance = Integer.parseInt(JOptionPane.showInputDialog("Enter account balance"));
               while(balance <0){
                  balance = Integer.parseInt(JOptionPane.showInputDialog("Please enter valid account balance.\nCannot be negative"));
               }
            }
            catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Enter account balance as a number");
               balance = -1;
            }
      }while(balance == -1);
      return balance;
   }
   public static String getTransactionAction(){
      String transaction = "";
      do{
      
         transaction = JOptionPane.showInputDialog("Enter transaction type");
         if(!transaction.equalsIgnoreCase("D") && !transaction.equalsIgnoreCase("W") && !transaction.equalsIgnoreCase("Q")){
            JOptionPane.showMessageDialog(null, "ERROR, Please enter D for deposit, W for withdrawal, or Q for quit");
         }
         
        }while(!transaction.equalsIgnoreCase("D") && !transaction.equalsIgnoreCase("W") && !transaction.equalsIgnoreCase("Q"));
   return transaction;
   }
   public static int transactionAmount(){
      int amount = 0;
      do{
         try{
               amount = Integer.parseInt(JOptionPane.showInputDialog("Enter transaction amount"));
               if(amount < 0){
                  amount = Integer.parseInt(JOptionPane.showInputDialog("Amount cannot be negative"));
               }
            }
            catch(NumberFormatException e)
            {
               JOptionPane.showMessageDialog(null, "Enter valid amount");
               amount = -1;    
            }
        }while(amount == -1);
   
      return amount;
   }
   public static int calculateAccountBalance(String transaction, int amount, int balance){   
      if(transaction.equalsIgnoreCase("D")){
         balance+= amount;
      }
      else if(transaction.equalsIgnoreCase("W")){
         balance-= amount;
      } 
   return balance;
   }
   public static void printBalance(int accountBalance){
      JOptionPane.showMessageDialog(null, "Account balance is $" + accountBalance); 
   }
   public static void printTransactionSummary(int initialBalance, int accountBalance, int numDeposits, int numWithdrawals){
      JOptionPane.showMessageDialog(null, "The initial balance in account was $" + initialBalance +
      "\nThe final balance in account is $" + accountBalance + "\nNumber of deposits " + numDeposits + "\nNumber of withdrawals " + numWithdrawals); 
   }
}















