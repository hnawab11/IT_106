import javax.swing.JOptionPane;

public class programmingAssignmentFiveInClass{
   
   final static int MAX_ITEM = 100;
   final static String[] TYPE = {"textbook", "apparel", "gift"};
   static int count = 0;
   
   public static void main (String args[]){
      String[] itemName = new String[MAX_ITEM];
      String[] itemType = new String[MAX_ITEM];
      double[] itemPrice = new double[MAX_ITEM];
      
      int option;
      
      do{
         option = Integer.parseInt(JOptionPane.showInputDialog("Would you like to add item, search item, or print list? 1,2,3,Quit"));
         
         switch(option){
            case 1:
               addItem(itemName, itemType, itemPrice);
               break;
            case 2:
               searchItem(itemName, itemPrice);
               break;
            case 3:
               printList(itemName, itemType, itemPrice);
               break;
            default:
               break;
         }
      
        }while(option!=0);
        
     
   }
   public static void printList(String[] itemName, String[] itemType, double[] itemPrice){
      String output = "Item List \n";
      for(int i = 0; i < count; i++){
         output += itemName[i] + " " + itemType[i] + " " + itemPrice[i] + "\n";
         
      }
      JOptionPane.showMessageDialog(null, output);
   }
   public static void searchItem(String[] itemName, double[] itemPrice){
      String searchItem = JOptionPane.showInputDialog("Enter search item");
      boolean found = false;
      int searchIndex = -1;
      
      for(int i = 0;i<count;i++){
         if(itemName[i].equalsIgnoreCase(searchItem)){
            found = true;
            searchIndex = i;
            break;
         }                      
      } 
      
     if(found){
         JOptionPane.showMessageDialog(null, "Item found: " + itemName[searchIndex] + "\nitem price $" + itemPrice[searchIndex]); 
     }
     else{
         JOptionPane.showMessageDialog(null, "Item not found");
     }   
           
   
   
   }
   public static void addItem(String[] itemName, String[] itemType, double[] itemPrice){
      
      if(count<MAX_ITEM){
         itemName[count] = getItemName();
         itemType[count] = getItemType();
         double price = getItemPrice();
         itemPrice[count] = calculateSalesPrice(itemType[count], price);
         count++;
         
      }
   
   }
   
   public static double calculateSalesPrice(String itemType, double price){
      double discount = 0, salesPrice = 0;
      if(itemType.equalsIgnoreCase(TYPE[0])){
         discount = price * 3.0/100.0;
         salesPrice = price - discount;
      }
      else if(itemType.equalsIgnoreCase(TYPE[1])){ 
         discount = price * 5.0/100.0;
         salesPrice = price - discount;
      
      }
      else if(itemType.equalsIgnoreCase(TYPE[2])){ 
         discount = price * 10.0/100.0;
         salesPrice = price - discount;
      }
      
   return salesPrice;
   }
   
   public static String getItemName(){
   
      String name = "";
      name = JOptionPane.showInputDialog("Enter item name");
      while(name.equalsIgnoreCase(" ") || name.equalsIgnoreCase(null)){
      
         name = JOptionPane.showInputDialog("Enter valid item name");
      
      }
      return name;
   }
   public static String getItemType(){
      String type = JOptionPane.showInputDialog("Enter item type");
      while(!type.equalsIgnoreCase(TYPE[0]) && !type.equalsIgnoreCase(TYPE[1]) && !type.equalsIgnoreCase(TYPE[2])){
      
         type = JOptionPane.showInputDialog("Enter valid item type");
      
      }
   return type;
   
   }
   public static double getItemPrice(){
   
      double price = 0;
      boolean valid = false;
      
      while(!valid){
         try{
            price = Double.parseDouble(JOptionPane.showInputDialog("Enter item price"));
            if(price>0){
               valid = true;
               }
            }
            catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null,"Invalid number");
         
             }
         }
      return price;
   }
   
  
}