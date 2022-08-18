import javax.swing.JOptionPane;
public class programmingAssignment8{

   public static void main (String args[]){
       int students = 2;
       String[] name = new String[students];
       String[] ID = new String[students];
       int[] grades = new int[students];  
       String answers[] = new String[students];
       int passed = 0;
       int failed = 0;
       int averageScore = 0;
       int scoreSum = 0;  
       execute(students, name, ID, grades);
       
   }
     public static void execute(int students, String name[], String ID[], int grades[]){
      int scoreSum = 0;
      int passed = 0;
      int failed = 0;
      for(int k = 0;k<students;k++){
         name[k] = getName();
         ID[k] = getID();
         grades[k] = calcGrade(takeQuiz());     
         scoreSum +=grades[k];
         if(grades[k] >=80){
            passed++;
         }
         else if(grades[k] < 80){
            failed++;
         }       
      } 
      int averageScore = 0;
      averageScore = avgScore(scoreSum, students);
      printResults(name, ID, grades, averageScore, passed, failed, students); 
   }
   
   public static int avgScore(int scoreSum, int students){
      int average = 0;
      if(students > 0){
         average = scoreSum / students;
      }
      else{
         JOptionPane.showMessageDialog(null, "No average calculated because there are no students");
      }
      return average;
   }
   public static String getName(){
      String name = JOptionPane.showInputDialog("enter name");
      return name;
   }
   public static String getID(){
      String ID = JOptionPane.showInputDialog("enter ID");
      return ID;
   }
   public static String[] takeQuiz(){
      String[] answers = new String[5];
      for(int x = 0;x<5;x++){
         answers[x] = JOptionPane.showInputDialog("What is your answer for question" + (x+1) + "\nchoose (A)(B)(C)(D)");
      }
      return answers;
   }
   public static int calcGrade(String[] answers){
      String[] correctAnswers = {"a","b","c","d","a"};
      int grade = 0;  
      int correctlyAnswered = 0;
      for(int x = 0;x<5;x++){
         if(answers[x].equalsIgnoreCase(correctAnswers[x])){
            grade += 20;
            correctlyAnswered++;
         } 
      }
      JOptionPane.showMessageDialog(null, "Score: " + grade + "%"); 
      JOptionPane.showMessageDialog(null, "Correctly Answered: " + correctlyAnswered);  
      JOptionPane.showMessageDialog(null, "Incorrectly Answered: " + (5-correctlyAnswered));
      JOptionPane.showMessageDialog(null, "Passing Status: " + passedQuiz(grade));
      return grade;
     } 
   public static boolean passedQuiz(int grade){
   boolean passedQuiz = false;
   if(grade >= 80){
         passedQuiz = true;
      }
   return passedQuiz;
   }
   public static void printResults(String name[], String ID[], int grades[], int averageScore, int passed, int failed, int students){
	   String str = "NAME   |    ID   | GRADE |\n";
	   for(int k =0;k<students;k++){
		   str+= name[k] + "   " + ID[k] + "    " + grades[k] + "%\n";
	   }
	 str+= "\nAverage Score: " + averageScore + "%";
    str+= "\n#Students who passed: " + passed + "\n#Students who failed: " + failed;
    JOptionPane.showMessageDialog(null, str);
   }
   
}