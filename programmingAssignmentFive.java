//BY HUMZA NAWAB
//import the java pane gui class
import javax.swing.JOptionPane;

//main class
public class programmingAssignmentFive{
   //main method
   public static void main (String[] args){
      //program variables
      String[] item = new String[100]; //string array to store items
      double[] price = new double[100];//double array to store price
      String[] itemType = new String[100];//string array to store item type
      double discount = 0;//double to store discount price for eligible items
      double priceSum = 0;//double to store sum of all prices of all items
      double avgPrice = 0; //double to store average price
      int itemCounter = 0; //counter that stores number of items entered, useful for traversing all 3 arrays
      int itemTypeGiftCounter = 0; //counter for gift
      int itemTypeTextbookCounter = 0;//counter for textbook
      int itemTypeApparelCounter = 0;//counter for apparel 
      int itemMiscCounter = 0; //counter for other items
      String str = " "; //string for outputting main program in one big window
      String searchItem = " ";//string for storing search item, 
     
      //string for program input prompt
      String programContinuationPrompt = " ";
      //string for proram search prompt
      String searchPrompt = " ";
         
         //do while loops that executes part of program responsible for prompting user for item, price, item type
         do{
            //prompt for item
            item[itemCounter] = JOptionPane.showInputDialog("please enter item");
            //input validation to ensure item isn't blank
            while(item[itemCounter].equals("") || item[itemCounter].equals(" ")){
               item[itemCounter] = JOptionPane.showInputDialog("Item name cannot be blank");
            }
            //nested do while that is part of prompting and validating price input
            do{
               //try statement attempts to get price
               try
               {  
                  //prompt for price
                  price[itemCounter] = Double.parseDouble(JOptionPane.showInputDialog("Please enter item price"));
                  //input validation to ensure price isn't negative 
                  while(price[itemCounter] < 0)
                  {
                     //re-prompts user for price and tells them their error
                     price[itemCounter] = Double.parseDouble(JOptionPane.showInputDialog("Please enter valid item price. Item price cannot be negative"));
                  }
               }
               //catch statement that prevents program crash if price isn't entered as number
               catch(NumberFormatException e)
               {
                  //re-prompts user for price, tells them price must be number
                  JOptionPane.showMessageDialog(null, "Please enter a valid price as numerical value");
                  //program sentinel set to -1, this allows do while loop to continually prompt user for price if invalid data is entered
                  price[itemCounter] = -1; 
               }
              //checks if sentinel is -1 for price,continues to execute until correct price entered
             }while(price[itemCounter] == -1);
         //prompts for item type
         itemType[itemCounter] = JOptionPane.showInputDialog("please enter item type");
         //input validation that ensures item type isn't bland
         while(itemType[itemCounter].equals("") || itemType[itemCounter].equals(" ")){
            //re-prompts for item type until valid input entered
            itemType[itemCounter] = JOptionPane.showInputDialog("item type cannot be empty\nPlease enter a valid item type");
         }
         //prompts to either continue entering items or stop
         programContinuationPrompt = JOptionPane.showInputDialog("Hit [Enter] to continue entering items or type exit"); 
         //program counter that increments after every run to allow all 3 arrays to be filled until user stops, also useful to keep track of entered items
         itemCounter++;
         
         //end of main do while statement for portion of code responsible to prompting, getting,and data validation
         }while(!programContinuationPrompt.equalsIgnoreCase ("exit"));
         
         //search feature of program that allows user to search by item
         //prompt for search 
         searchPrompt = JOptionPane.showInputDialog("Would you like to search for an item?\nType yes or exit");
         //counter that will be used to keep of item search success or failure
          int counter = 0;
         //while loops that runs while user keeps entering yes to search
         while(searchPrompt.equalsIgnoreCase("yes")){
            //prompt user for item to search for
            searchItem = JOptionPane.showInputDialog("Enter item to search");
            //for loop that will go through the filled portion of item array. Functionality is possible by itemCounter variable
            for(int k = 0;k<itemCounter;k++){
                 
               //checks if item name at certain index of array equals searchItem, not case sensitive
               if(item[k].equalsIgnoreCase(searchItem)){
                  //outputs to user that search was successful and item was found, outputs item name and price
                  JOptionPane.showMessageDialog(null, "item found: " + "|"+ item[k] + "|" + " |$" + price[k]+"|");
                  //increments the counter
                  counter++;
                  //breaks out of for loop if item found, this is required to stop search the array when item is found
                  break;
               }
               //else statement if item not found
               else{
                  //sets counter to -1, using it as a sentinel
                  counter = -1;
               }
                              
            } //end for loop 
            //check if sentinel counter = -1
            if(counter == -1){
                  //outputs to user that the item theyre searching four cannot be found. 
                  JOptionPane.showMessageDialog(null,"The item you are searching for, " + searchItem + " cannot be found. Not available in store");
            }
            //prompts user if they want to continue searching
            searchPrompt = JOptionPane.showInputDialog("Continue searching? \nType anything to exit or yes to continue");
         }//end while 
         
         //for loop for processing and outputting item data
         for(int k = 0;k<itemCounter;k++){
            //"item", k counter for item order, and string at item[k] added to output string
            str+= "\nitem " + k + ": " + item[k];
            //"item type", string at itemType[k] added to output string
            str+= " \nitem type: " + itemType[k];
          
          //processing the itemtypes to see if item is eligible for discount
            //if itemtype equals textbook
            if(itemType[k].equalsIgnoreCase("textbook")){
               //calculates discount by multiple price[k] by specified discount of 3%
               discount = price[k] * 3/100;
               //subtract discount from price to get new price 
               price[k]-=discount;
               //pricesum that adds the price of the item, this has to be done inside
               //the if loop because the pricesum must add the newly calculated discounted price, not the entered item price
               priceSum+= price[k];
               //counter that increments the number of items with type "textbook"
               itemTypeTextbookCounter++;
               //output string has "discount price" and price[k] added to it
               str+= " \ndiscount price: $" + price[k];
               //sets output string to next line
               str+= "\n";
            }
            //else if itemtype equals apparel
            else if(itemType[k].equalsIgnoreCase("apparel")){
               //calculates discount by multiple price[k] by specified discount of 3%
               discount = price[k] * 5/100;
              // salesPrice[k] = price[k] - discount;
               price[k]-= discount;
               //output string has "discount price :$" and price[k] added to it
               str+= " \ndiscount price: $" + price[k];
               //pricesum adds the price of item after discount calculated
               priceSum+=price[k];
               //incrememt the item type "apparel"
               itemTypeApparelCounter++;
               //sets output string to next line
               str+= "\n";
            }
            //else if itemtype equals gift
            else if(itemType[k].equalsIgnoreCase("gift")){
               //calculates discount by multiple price[k] by specified discount of 3%            
               discount = price[k] * 10/100;
               //salesPrice[k] = price[k] - discount;
               price[k]-= discount;
               //output string has text and the price added to it
               str+= " \ndiscount price: $" + price[k];
               //adds the calculated price with discount to price sum 
               priceSum+=price[k];
               //increment the item type "gift" 
               itemTypeGiftCounter++;
               //move to next line, formatting 
               str+= "\n";
            }
            //if itemtype is miscellaneous or anything else
            else{
               //adds text "price $" and price[k] to string for output
               str+= " \nprice: $" + price[k];
               //formatting
               str+="\n";
               //adds newly calculated price to price sum
               priceSum+=price[k];
            }
         }
         //calculates average price by dividing price sum by item counter
         avgPrice = priceSum / itemCounter;
         //output string formatting, prints average price, formats double string to round to 2 decimals, and print item counter
         str+= "\naverage price: $" + String.format("%.2f", avgPrice) + "\ntotal items: " + itemCounter;
         //calculates the items that aren't textbooks, apparel, or gifts by adding together all the gifts, apparel, and textbooks and subtracting them from the itemcounter
         itemMiscCounter= itemCounter - (itemTypeTextbookCounter + itemTypeApparelCounter + itemTypeGiftCounter);
         //adds the label "item category, textbook, apparel, gift, misc"  and counts of the itemtype counters to the output string
         str+= "\nitem category:                  |TEXTBOOK|  |APPAREL|  |GIFT|   |MISC|   " + "\n# of items per category        "  
         + itemTypeTextbookCounter + "                       " + itemTypeApparelCounter + "                 "  + itemTypeGiftCounter + "               " + itemMiscCounter;
         //prints the output string, which includes all data that was added to it  
         JOptionPane.showMessageDialog(null, str);
    
         
   }//end main method
 

}//end the main class