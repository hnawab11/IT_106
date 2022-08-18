import javax.swing.JOptionPane;

public class Lab_11{

   public static void main (String args[]){
   
      int[][] hoursWorked = new int[6][4];
      hoursWorked[0][0] = 5;
      hoursWorked[0][1] = 8;
      hoursWorked[0][2] = 6;
      hoursWorked[0][3] = 2;
      hoursWorked[1][0] = 2;
      hoursWorked[1][1] = 0;
      hoursWorked[1][2] = 8;
      hoursWorked[1][3] = 6;
      hoursWorked[2][0] = 6;
      hoursWorked[2][1] = 4;
      hoursWorked[2][2] = 9;
      hoursWorked[2][3] = 5;
      hoursWorked[3][0] = 7;
      hoursWorked[3][1] = 8;
      hoursWorked[3][2] = 8;
      hoursWorked[3][3] = 4;
      hoursWorked[4][0] = 3;
      hoursWorked[4][1] = 6;
      hoursWorked[4][2] = 2;
      hoursWorked[4][3] = 8;
      hoursWorked[5][0] = 9;
      hoursWorked[5][1] = 5;
      hoursWorked[5][2] = 1;
      hoursWorked[5][3] = 7;


      int totalHours = totalHoursWorked(hoursWorked);
      int employeeMostHours = mostHours(hoursWorked);
      int employeeLeastHours = leastHours(hoursWorked);
      JOptionPane.showMessageDialog(null, "total hours: " + totalHours + "\nemployee with most hours: " + employeeMostHours + " hours worked: " + findHoursWorked(hoursWorked, employeeMostHours) + 
     "\nemployee with least hours: " + employeeLeastHours + " hours worked: " + findHoursWorked(hoursWorked, employeeLeastHours) );
      

   
   }
   public static int totalHoursWorked(int[][] hoursWorked){
      int totalHours = 0;
      
      for(int k = 0;k<6;k++){
         for (int x = 0;x<4;x++){
             totalHours += hoursWorked[k][x];           
         } 
      }
      return totalHours;   
   }
   public static int findHoursWorked(int[][] hoursWorked, int employee){
      
      int hours = 0;
      
         for(int x = 0;x<4;x++){
            hours += hoursWorked[employee][x]; 
            
         
         }
      
      
      return hours;
   
   }
   public static int mostHours(int[][] hoursWorked){
      int tally =0;
      int maxEmployee = 0;
      for(int k = 0;k<6;k++){
         int sum = 0;
         for (int x = 0;x<4;x++){
            sum+= hoursWorked[k][x];
         }                
         if(sum > tally){   
            tally = sum;
            maxEmployee = k;
         } 
      }
     return maxEmployee;
   }
   public static int leastHours(int[][] hoursWorked){
      int tally = 1000;
      int minEmployee = 0;  
      for(int k = 0;k<6;k++){
         int sum = 0;
         for (int x = 0;x<4;x++){
            sum+= hoursWorked[k][x];  
         }  
         if(sum < tally){
            tally = sum;
            minEmployee = k;
         } 
      }
      return minEmployee;
   }
}