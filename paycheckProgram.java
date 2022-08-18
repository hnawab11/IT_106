import javax.swing.JOptionPane;

public class paycheckProgram{

        final static double HOURLY_PAY = 8.0;
        final static double HOURLY_PAY_EXPERIENCE = 10.0;
        final static double MAX_EMPLOYEE = 30;

   public static void main (String args[]){
   
        String[] employeeName = new String[30];
        double[] payCheck = new double[30];
        
        int i = 0;
        do{
            employeeName[i] = getName("test");
            //double experience = getExperience(1);
            double work = getWorkingHour(1);
            //payCheck[i] = calcPaycheck(work,experience);
            //displayCheckAmount(employeeName[i], payCheck[i]);
            i++;
        }
        while(!employeeName[i].equals("-1"));
        

      
      }
   public static void displayCheckAmount(String employeeName, double payCheck){
      JOptionPane.showMessageDialog(null, employeeName + "gets an amount of " + payCheck);
   }
      
   public static double calcPaycheck(double hour, double experience){
      double checkAmount = 0;
      if(hour > 40){
      double overTime = hour - 40;
         if(experience > 1){
         
            checkAmount = (40 * HOURLY_PAY_EXPERIENCE) + overTime * (HOURLY_PAY_EXPERIENCE/1.5);
         }
         else{
            checkAmount = 40 * HOURLY_PAY + (overTime * HOURLY_PAY * 1.5);
         }
      }
      else{
         if(experience > 1){
            checkAmount = hour * HOURLY_PAY_EXPERIENCE;
         }
         else{
            checkAmount = hour * HOURLY_PAY;
         }
      
      }
      return checkAmount;
   
   }
   
   public static String getName(String employeeName){
   
      String name = " ";
      name = JOptionPane.showInputDialog("Enter employee name");
      while(name.equals(" ") || name.equals("")){
            //re-prompts user for valid employee name
            name = JOptionPane.showInputDialog("Please enter valid employee name ");
      }

      return name;
   }
   
   public static double getExperience(double yearsWorked){
      double years = 0;
      do{
         try{
            years = Double.parseDouble(JOptionPane.showInputDialog("enter years worked"));

            while(years < 0){
               {
               //re-prompts user for sales until sales are 0 or greater
                  years = Integer.parseInt(JOptionPane.showInputDialog(null, "Error! Enter a valid employee years experience figure" ));  
               }
            
            }
            
            }
         catch(NumberFormatException e){
         
         JOptionPane.showMessageDialog(null, "Please enter valid years as digits");
         years = -1;
         
      }
      return years;
      }
      while(years == -1);
      
   }
   
   public static double getWorkingHour(double hoursWorked){
      double hours = 0;
      hours = Double.parseDouble(JOptionPane.showInputDialog("enter hours worked"));
      do{
         try{
            while(hours <= 0)
               {
               //re-prompts user for sales until sales are 0 or greater
                  hours = Integer.parseInt(JOptionPane.showInputDialog(null, "Error! Enter a valid employee years experience figure" ));  
               }
            
               hours = Double.parseDouble(JOptionPane.showInputDialog("enter hours worked"));
            }
      catch(NumberFormatException e){
         
         JOptionPane.showMessageDialog(null, "Please enter valid years as digits");
         hours = -1;
         
      }
      return hours;
      }
      while(hours == -1);

   
   }
   



}