//BY Humza Nawab
import javax.swing.JOptionPane;
//main class
public class programmingAssignment7{
   //main method
   public static void main (String args[]){
       int students = 30; //variable for length of student array, grade array, name and id array
       String[] name = new String[students]; //array that stores all student names
       String[] ID = new String[students]; //array that stores all student IDs
       int[] grades = new int[students]; //array that stores all student calculated grades
       String[][] answers = new String[students][5]; //2D array that stores all quiz answers of all students for all questions
       execute(students, name, ID, grades, answers); //calls the execute method, passing the arrays so that they can be accessed
   }
   //execute method that executes all other methods
   public static void execute(int students, String name[], String ID[], int grades[], String[][] answers){
      //int scoreSum = 0; //stores the s
      int passed = 0; //number of students who passed
      int failed = 0; //number of students who failed 
      int counter = 0; //counter for first do while loop 
      String continuePrompt = "";
      String takeQuizPrompt = "";
      //first do while loop that prompts for name, ID
      do{
         name[counter] = getName();
         ID[counter] = getID();
         counter++;
         continuePrompt = JOptionPane.showInputDialog("Would you like to continue enter users? ");
      }while(!continuePrompt.equalsIgnoreCase("exit"));
      
      int counterTwo = 0; //counter for second do while loop
      //second do while loop that calls the takeQuiz, calcGrade, and passedQuiz methods
      do{
         takeQuiz(name, ID, answers, counterTwo); //calls methods that prints questions and lets student input their answers to questions
         calcGrade(name, ID, answers, grades, counterTwo); //calls method to calculate the grade of each student
         passed+=passedQuiz(grades, counterTwo); //calls method to calculate how many students passed the quiz
         //checks if counter is less than first counter minus 1, useful to ensure take quiz runs only the amount of times that students entered, not size of array
         if(counterTwo != (counter-1)){ 
            //prompts user if they want to continue taking quiz?
            takeQuizPrompt = JOptionPane.showInputDialog("Would you like to continue taking quiz? ");
         }
         //if second counter is equal to first counter stop taking the quiz
         else{
            JOptionPane.showMessageDialog(null, "No more students available to take quiz"); //informs users there are no more students available
            takeQuizPrompt = "no"; //if no more students are left to take quiz, enter prompt "no" for user
         }
         counterTwo++; //increments the second counter
      }while(!takeQuizPrompt.equalsIgnoreCase("no"));
      //calculates the average score by calling avgScore method
      int averageScore = avgScore(grades, counterTwo);
      //output results into a window by calling the printResults method
      printResults(name, ID, grades, averageScore, passed, failed, counterTwo, counter); 
   }
   //calcs the average exam score
   public static int avgScore(int[] grades, int students){
      int average = 0; //var to store avg
      int sum = 0; //var to store sum
      //checks to make sure students isn't 0 to prevent divide by zero
      if(students > 0){
         //for loops run the length of grade array
         for(int k = 0;k<students;k++){
            sum+=grades[k];
         }
         //calculates avg by dividing sum by students
         average = sum / students;
      }
      //if there aren't any entered users or array size is 0
      else{
         JOptionPane.showMessageDialog(null, "No average calculated because there are no students");
      }
      return average; //return average
   }
   //prompts for name
   public static String getName(){
      String name = JOptionPane.showInputDialog("Enter Name: ");
      //input validation to ensure no blanks entered
      while(name.equals("") || name.equals(null)){
         name = JOptionPane.showInputDialog("Enter valid name: ");
      }
      return name;
   }
   //prompts for student ID
   public static String getID(){
      String ID = JOptionPane.showInputDialog("enter ID: ");
      //input validation to ensure no blank IDs entered
      while(ID.equalsIgnoreCase("")){
         ID = JOptionPane.showInputDialog("enter valid ID: ");
      }
      return ID;
   }
   //prompts user for answers for questions, provides the test taking function
   public static void takeQuiz(String[] name, String[] ID, String[][] answers, int Students){
      //for loops that runs the length of questions, which is 5, and prints name, id to top of window while the user it taking the quiz
      for(int x = 0;x<5;x++){
         //sets index of 2d array answers to the answer of user
         answers[Students][x]=JOptionPane.showInputDialog("Student: " + name[Students] + "\nID: " + ID[Students] + "\nWhat is your answer for question" + (x+1) + "\nchoose (A)(B)(C)(D)");
      } 
    
   }
   //calcs the number grade of the user, checking against the "correct answers", prints a window showing # right ans, # wrong ans
   public static void calcGrade(String[] name, String[] ID, String[][] answers, int[] grades, int studentsTakenTest){
      String[] correctAnswers = {"d","b","c","a","b"}; //the correct answers
      boolean passedStatus = false; //boolean var to store if user has passed
      String str = ""; //output string
      int correctlyAnswered = 0; //var that stores number of correct answers
      //for loop that runs 5 times, for each question of the given user
      for(int x = 0;x<5;x++){
         //checks if student answer is equal to the correct answer
         if(answers[studentsTakenTest][x].equalsIgnoreCase(correctAnswers[x])){
            //increments index of grade array to 20 points if each question response is corret
            grades[studentsTakenTest] += 20;
            //increments counter to track number of correctly answered question
            correctlyAnswered++;       
         } 
      }
      //after student has answered all 5 questions
      //checks if grade of studnet greater than or equal to 80
      if(grades[studentsTakenTest] >= 80){
         //sets boolean passed var to true
         passedStatus = true;
      }
      //stores all the output and value of index of array into a string
      str+= "student: " + name[studentsTakenTest] + "\nID: " + ID[studentsTakenTest] + "\nscore: " + grades[studentsTakenTest] + "%" + "\ncorrect: " + correctlyAnswered + "\nincorrect: " + (5-correctlyAnswered) + "\npassed status: " + passedStatus;     
      //prints the output string    
      JOptionPane.showMessageDialog(null, str);
   } 
    //check the grades of all students and determines if their grade is a passed grade or failing grade
    public static int passedQuiz(int grades[], int studentsTakenTest){ 
      int passed = 0; //var to store number of passing students
      int failed = 0; //var to store number of failing students
      //if grade of student is greater than or equal to 80
      if(grades[studentsTakenTest] >= 80){
         //increment the passed var
         passed++;
      }
      return passed;
    }
    //prints the results into a window, showing the students, ID, quiz grades, average score, #students who've passed, failed, taken quiz, haven't taken quiz
    public static void printResults(String name[], String ID[], int grades[], int averageScore, int passed, int failed, int students, int studentsEntered){
	   String str = "NAME   |    ID   | GRADE |\n"; //var string for storing output
      //for loop that goes through name, id, grades array and stores data at those indices into str
	   for(int k =0;k<students;k++){
		   str+= name[k] + "   " + ID[k] + "    " + grades[k] + "%\n";
	   }
      //calcs students who failed by subtracting passed from students
      failed = students - passed;
      //sets the str var to averagescore, studentsentered, number of students, students passed, failed,  etc
	   str+= "Average Score: " + averageScore + "%" + "\nStudents entered: " + studentsEntered + "\nStudents who've taken test: " + students + "\nStudents who haven't taken test: " + (studentsEntered - students) + "\nStudents who passed: " + passed + "\nStudents who failed: " + failed;
      JOptionPane.showMessageDialog(null, str); //prints string
    }  
}