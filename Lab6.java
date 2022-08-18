//BY HUMZA NAWAB
import javax.swing.JOptionPane;

public class Lab6{
   public static void main (String[] args){
      //step 1: setup any contants
      final int NUM_GRADES = 5;
      final double MINIMUM_GRADE = 0.0;
      final double MAXIMUM_GRADE = 100.0;
     
   
      
      //step 2: create an array that will hold the grades
      double grade[] = new double[NUM_GRADES];
    
     
      
      //step 3: get in all of the grades
      
         for(int k =0;k<NUM_GRADES;k++){
         do{
            try{
               grade[k] = Double.parseDouble(JOptionPane.showInputDialog("Please enter grades"));
               while(grade[k] < 0 || grade[k] > 100)
            
                {
                  //JOptionPane.showMessageDialog(null, "ERROR, please enter grade between 0-100");
                  grade[k] = Double.parseDouble(JOptionPane.showInputDialog("Please enter valid grade between 0-100"));
                } 

            }
            catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Please enter grade as numerical value");
               //sets grade at index to -1 to trigger re-prompting of grade until correct value entered
               grade[k] = -1;
            }
            
            }
            //repeats until valid grade is entered
            while(grade[k] == -1 );
            }
      
      //step 4: find the highest grade
   
     
      double highestGrade = 0;//grade[0];
      for(int i=0; i<grade.length; i++){
         if(grade[i]>highestGrade){
            highestGrade = grade[i];
         
         }
      }
      //step 5: output the highest grade
      
      JOptionPane.showMessageDialog(null, "the highest grade is" + highestGrade);
    
   }

}