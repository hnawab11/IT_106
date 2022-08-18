import javax.swing.JOptionPane;

public class GradeCalculator{
   public static void main (String args[]){
   
      double score[] = new double[4];
      for(int k = 0;k<4;k++){
         score[k] = readScore();
      }
      double minScore = findLowestScore(score);
      JOptionPane.showMessageDialog(null, minScore);
      double avgScore = calculateAverage(score, minScore);
      String letterGrade = convertLetterGrade(avgScore);
      JOptionPane.showMessageDialog(null, letterGrade);
   
   }
   public static String convertLetterGrade(double score){
      String letter = " ";
      if(score >= 90 && score <=100){
         letter = "A";
         
      }
      else if(score>=80 && score <=89){
      
         letter = "B";
      }
      else if(score>=70&&score<=79){
      
         letter = "C";
      }
      else if(score>=60 && score<=69){
      
         letter = "D";
      }
      else{
         letter = "F";
         
         }
         return letter;
   }
   public static double calculateAverage(double[] score, double minScore){
      double sum = 0;
      for(int i =0;i<score.length;i++){
         sum+=score[i];
      
      }
    
      sum = sum - minScore;
      double avg = sum/3;
      return avg;
   }
   
   public static double readScore(){
      double testScore = 0;
      boolean flag = true;
      do{
         try{
            testScore = Double.parseDouble(JOptionPane.showInputDialog("Enter test score"));
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Invalid score. Try again");
         }
      }while(!flag);
      return testScore;
   }
   public static double findLowestScore(double[] score){
      double min = score[0];
      for(int i=1; i<score.length; i++){
         if(score[i]<min){
            min = score[i];
         
         }
      }
      return min;
   }

}