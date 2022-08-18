import javax.swing.JOptionPane;

public class Lab10{
   
   public static void main (String args[]){
   
      String[] gNum = new String[4];
      populateGNumber(gNum);
      double[] gpa = new double[4];
      String gNumber = "";
      populateGPA(gpa);
      gNumber = enterGNumber();
      
      search(gNumber, gNum, gpa);
      
   }
   
      
   
   
   public static double search(String gNumber, String[] gNum, double[] gpa){
       int counter = 0;
       double foundGPA = 0;
       double index = 0;
       
            for(int k = 0;k<gNum.length;k++){
               if(gNum[k].equalsIgnoreCase(gNumber)){
                  JOptionPane.showMessageDialog(null, "student found: " + gNum[k] + "\ngpa:" + gpa[k]);
                  foundGPA = gpa[k];
                  index = k;  
                    
                  counter++;
                  break;
               }
               else{
                  counter = -1;
                  
               }
            }
            if(counter == -1){      
                  JOptionPane.showMessageDialog(null,"The student you are searching for, " + gNumber + " cannot be found.");
            }
           //return foundGPA;
           return index;
           
   }  
   
   public static String enterGNumber(){
      String gNumber = "";
      gNumber = JOptionPane.showInputDialog("search for gnumber");
      return gNumber;
   }
 
   public static double[] populateGPA(double[] gpa){
      
      gpa[0] = 2.5;
      gpa[1] = 3.1;
      gpa[2] = 3.5;
      gpa[3] = 4.0;
      return gpa;
   
   }
   public static String[] populateGNumber(String[] gNum){
      for(int k =0;k<gNum.length;k++){
         gNum[k] = JOptionPane.showInputDialog("enter g number");
         while(gNum[k].equalsIgnoreCase(" ") || gNum[k].equalsIgnoreCase(null)){
            gNum[k] = JOptionPane.showInputDialog("g number cant be blank");
         
         }
      }
      
      return gNum;
   
   }
   
   










}