import javax.swing.JOptionPane;

public class inClassGradeArray{
   final static int NUM_STUDENTS = 1;
   final static int NUM_TEST = 3;

   public static void main (String[] args){
      String[] studentsName = new String[NUM_STUDENTS];
      double[][] grades = new double[NUM_STUDENTS][NUM_TEST];
      getInputs(studentsName, grades);
      findMax(grades);
      printGradeBook(studentsName, grades);
   }
   public static void findMax(double[][] grades){
      
      for(int i = 0;i < NUM_TEST; i++){
         double max = 0;
         for(int k =0;k<NUM_STUDENTS;k++){
            if(grades[k][i] > max){
               max = grades[k][i];
            }
            JOptionPane.showMessageDialog(null, "maximum of test" + (i+1) + " " + max);

         }
         
      }
       
   }
   public static void printGradeBook(String[] studentsName, double[][] grades){
      String str = "";
      for(int i = 0;i<NUM_STUDENTS;i++){
         str+= studentsName[i] + " ";
         double total = 0;
         for(int k =0;k<NUM_TEST;k++){
            str+= grades[i][k] + " ";
            total+= grades[i][k];
         } 
         total = total/NUM_TEST;
         str+=total + "\n ";
      }
      JOptionPane.showMessageDialog(null, str);
   }
   
   public static void getInputs(String[] studentsName, double[][] grades){     
      for(int i = 0;i<NUM_STUDENTS;i++){
         studentsName[i] = getName();
         for(int k = 0;k<NUM_TEST;k++){
            grades[i][k] = getScore(); 
         }   
      } 
   }
   public static String getName(){
      String name = JOptionPane.showInputDialog("enter name");
      return name;
   
   }
   public static double getScore(){
      double score = Double.parseDouble(JOptionPane.showInputDialog("enter score"));
      return score;
   }







   


}