//imports the java GUI pane
import javax.swing.JOptionPane;
   
   public class Lab3{
      
      //main method
      public static void main (String args[]){
            
            //initializing the 2 string variables for genre and violence
            String genre = "";
            String violenceStatus = "";
            
             //prompt asking user for book genre as string
             genre = JOptionPane.showInputDialog("What is the book's genre? ");
             //checks if genre inputted is action
             if(genre.equalsIgnoreCase("action")){
               //prompts user asking if book is violent as a string
               violenceStatus = JOptionPane.showInputDialog("Does it contain violence? ");
                  //if statement for if book is violent
                  if(violenceStatus.equalsIgnoreCase("yes")){
                  //outputs the appropriate location for action book
                  JOptionPane.showMessageDialog(null, "This book should be stocked on 2nd Floor, Left Wing");

                  }
                  //if statement if book isn't violent
                  else if(violenceStatus.equalsIgnoreCase("no")){
                     //prints the appropriate location for the non-violent action book
                     JOptionPane.showMessageDialog(null, "This book should be stocked on 2nd Floor, Right Wing");
                  }
                  //error statement if violence string is not yes or no
                  else{
                     JOptionPane.showMessageDialog(null, "Error, please enter yes or no");
                     }

             }
             //else if statement if genre is mystery
             else if(genre.equalsIgnoreCase("mystery")){
               //prints location for mystery book
               JOptionPane.showMessageDialog(null, " This book should be stocked on 1st floor");
             
             }
             //else if statement if genre is horror
             else if(genre.equalsIgnoreCase("horror")){
               //prints location for horror books
               JOptionPane.showMessageDialog(null, " This book should be stocked on 3rd floor");
             }
             //else statement if genre entered isn't horror, mystery, or action
             else{
               //outputs that the genre selected is not available
               JOptionPane.showMessageDialog(null, "We're sorry. The program does not support that genre at this time.");
               }
             
             
            
   
   
   }
   
   
}