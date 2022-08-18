//BY HUMZA NAWAB
import javax.swing.JOptionPane;

public class Lab7{

   public static void main (String args[] ){
   
      final int NUM_MIN_DEPENDENTS = 0;
      final int NUM_MAX_DEPENDENTS = 9;
      int financialAid = 0;
      int dependents = 0;
       
      //TASK 1      
      dependents = getDependents(0,9);
      //TASK 2
      financialAid = getAid(dependents);
     
      printFinancialAid(financialAid);
      
   }
 
   public static void printFinancialAid(double aid){
      JOptionPane.showMessageDialog(null, "The amount of financial aid your family is eligible for is: $" + String.format("%.2f", aid));
   
   
   }
   //TASK 3
   public static int getDependents(int NUM_MIN_DEPENDENTS, int NUM_MAX_DEPENDENTS){
      int dependents = 0;
       do{
         try{
            dependents = Integer.parseInt(JOptionPane.showInputDialog("enter dependents"));

            while(dependents < NUM_MIN_DEPENDENTS || dependents > NUM_MAX_DEPENDENTS){
               {
               
                  JOptionPane.showMessageDialog(null, "Not eligible for financial aid");
                  dependents = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter valid number of dependents" ));  
                  
               }
            
            }
            
            }
         catch(NumberFormatException e){
         
         JOptionPane.showMessageDialog(null, "Please enter valid years as digits");
         dependents = -1;
         }
      }
      while(dependents == -1);
      return dependents;
   }
   //TASK 4
   public static int getAid(int dependents){
      int aid = 0;
      
      if(dependents==2){
         
         aid = 1500 * 2;
      
      }
      else if(dependents == 3){
      
         aid = 2500 * 3;
      }
      else if(dependents == 4){
      
         aid = 3000 * 4;
      }
      else{
         
         aid = 0;
      
      }
      
      return aid;
   
   
   }

}