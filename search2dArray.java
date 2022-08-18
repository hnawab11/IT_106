import javax.swing.JOptionPane;

public class search2dArray{

   public static void main(String[] args){
   
   String[][] answers = new String[2][3];
   answers[0][0] = "humza";
   answers[0][1] = "solaiman";
   answers[0][2] = "ibrahim";
   answers[1][0] = "smiley";
   answers[1][1] = "aziza";
   answers[1][2] = "amani";
  
   
   String searchPrompt = "";
   String searchItem = "";
 
   searchPrompt = JOptionPane.showInputDialog("Would you like to search for an item?\nType yes or exit");
         int counter = 0;
         while(searchPrompt.equalsIgnoreCase("yes")){
            searchItem = JOptionPane.showInputDialog("Enter item to search");
            for(int k = 0;k<2;k++){
               
               for(int j = 0;j<3;j++){
                  if(answers[k][j].equalsIgnoreCase(searchItem)){
                     JOptionPane.showMessageDialog(null, "answer found " + answers[k][j]);
                     //counter++;
                     counter = 1;
                     break;
                  }
                  else{
                     counter = -1;
                  }              
               }
               if(counter == 1){
                  break;
               }
            }
            
            if(counter == -1){
                  JOptionPane.showMessageDialog(null,"The item you are searching for, " + searchItem + " cannot be found");
            }
            searchPrompt = JOptionPane.showInputDialog("Continue searching? \nType anything to exit or yes to continue");
         }
   }
















}