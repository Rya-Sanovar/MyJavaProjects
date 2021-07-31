import java.io.*;
class PARK_HYATT
{
    InputStreamReader ir=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(ir);
    /**All options under view menu*/
    String view[]={"BOOKINGS","MEETINGS AND EVENTS","DINING","THE SPA SALON"};
    /**Suites in Park Hyatt along with their prices*/
    String suite[]={"Park Suite King\t\t ","Park Executive Suite\t    ","Diplomat Suite\t\t ","Presidential Suite\t      "};
    int psuite[]={12740,18740,55740,110740};/**per night*/
    /**Rooms/Guest rooms in Park Hyatt along with their prices*/
    String room[]={"Park Twin\t\t       ","Park King\t\t       ","View King\t\t       ","View Twin\t\t       "};
    int proom[]={5740,5740,7240,7240};/**per night*/
    /**Names of rooms and prices for renting conference rooms in Park Hyatt related to meetings,events,wedding activites etc.*/
    String event[]={"The Meeting Manor\t       ","The Ballroom\t\t    ","Black Tie Global Conferences","Event Catering\t\t  "};
    int pevent[]={65630,80700,54257,71399};/**per day*/
    /**Restaurants in Park Hyatt along with the general price for each person for a day serve*/
    String dining[]={"The Dining Room\t\t ","Tre-Forni Restaurant & Bar","The Breakfast Club\t      ","Barbeque Nation\t\t "};
    int pdining[]={1400,1650,1400,1200};/**per person*/
    /**The Spa Salon prices for 80 minute treatment along with the names*/
    String spa[]={"Bamboo Fusion Massage\t   ","Fountain Of Youth Facial","Brazilian Gold Wax\t      ","Island Milk Bath\t"};
    int pspa[]={11203,7042,10243,9218};/**price for every 80 minutes*/
    
    /**creating temporary arrays so that all entities can be printed together in the bill later on*/
    String n[]=new String[10];/**array to store name of all entities purchased in the bill*/
    int no[]=new int[10];/**array to store number/code of the entity being booked*/
    int p[]=new int[10];/**array to store the price of the entity being booked*/
    int q[]=new int[10];/**array to store quantity of entity being booked*/
    int t[]=new int[10];/**array to store the total amount of the entity being booked*/
    int ino,qty;/**qty-stores quantity of item,ino-stores code of the item*/
    int total;/**total-calculate and store total price of the chosen entity*/
    int pos;/**contains total number of entities booked*/
    double tax;/**Holds the tax calculated on the bill amount*/
    double netamt;/**Holds final amount paid by user inclusive of tax*/
    
    /**function to display the main menu to the user**/
    void menu()throws IOException
    {
        int ch=0;
        /**This do-while loop asks user to keep giving his choice till the correct choice is encountered.*/
        do
        {
            System.out.println("***********************");
            System.out.println("  P A R K   H Y A T T ");
            System.out.println("***********************");
            System.out.println("1. VIEW MENU");
            System.out.println("2. PLACE AN ORDER");
            System.out.println("3. VIEW BILL AND EXIT");
            System.out.println("***********************");
            System.out.print("\n Enter a choice from 1 to 3 : ");
            ch=Integer.parseInt(br.readLine());
            if(ch<1||ch>3)
            System.out.println("\n ERROR! You choice should be from 1 to 3 only...");
        }while(ch<1||ch>3);
        
        /**Once we exit the do-while loop, ch stores the correct choice within the range of 1 to 3*/
        /**Now we proceed to execute according to user's choice using switch case.*/
        
        switch(ch)
        {
            case 1:
            view();/**call view() function to view the main menu*/
            break;
            
            case 2:
            order();/**call order() function to allow user to order from the menu*/
            break;
            
            case 3:
            bill_exit();/**call bill_exit() function to view final bill and exit*/
            break;
            
            
        }
    }
    /**This method helps us to view the menu*/
    void view()throws IOException
    {
        int ch=0,ch2=0;
        String s="",s2="";
        /**Allows the user to view the menu display as long as she wishes*/
        do
        {
            /**The inner do-while loop is used to get the correct choice as input*/
            do
            {
                /**for loop to print view menu*/
                System.out.println("*********************");
                for(int i=0;i<view.length;i++)
                System.out.println((i+1)+". "+view[i]);
                System.out.println("*********************");
                System.out.print("\n Enter choice for menu display : ");
                ch=Integer.parseInt(br.readLine());
                if(ch<1||ch>4)
                System.out.println(" ERROR! Please enter choice between 1 to 4 only...");
            }while(ch<1||ch>4);
            /**Once we recieve the correct choice in ch, we continue to display the suboptions to the user*/
            switch(ch)
            {
                case 1:/**To view Suites and Guest rooms for booking*/
                do
                {
                 do
                 {  
                    System.out.println("****************");
                    System.out.println("B O O K I N G ");
                    System.out.println("****************");
                    System.out.println("1. Suites");
                    System.out.println("2. Guest rooms");
                    System.out.println("****************");
                    System.out.print("\n Please enter your choice between 1-2 only : ");
                    ch2=Integer.parseInt(br.readLine());
                    if(ch2<1||ch2>2)
                    System.out.println(" ERROR!Please enter choice as 1 or 2 only...");
                 }while(ch2<1||ch2>2);
                 if(ch2==1)/**To view all suites and their prices*/
                 {   
                    System.out.println("\n S U I T E S (price estimated for a night only)");
                    System.out.println("***************************************************");
                    System.out.println("NO.\t   SUITE NAME\t\t\tPRICE");
                    System.out.println("***************************************************");
                    for(int i=0;i<suite.length;i++)
                    System.out.println((i+1)+".\t" +suite[i]+"\t"+psuite[i]);
                    System.out.println("***************************************************");
                 }
                 else if(ch2==2)/**To view all Guest rooms and their prices*/
                 {   
                    System.out.println("\n G U E S T  R O O M S (Price estimated for a night only)");
                    System.out.println("**********************************************************");
                    System.out.println("NO.\tROOM NAME\t\t\tPRICE");
                    System.out.println("**********************************************************");
                    for(int i=0;i<room.length;i++)
                    System.out.println((i+1)+".\t"+room[i]+"\t"+proom[i]);
                    System.out.println("**********************************************************");
                 }
                System.out.print(" Press 'y' if you want to continue viewing the 'BOOKING' menu : ");
                s2=br.readLine();
            }while(s2.equalsIgnoreCase("y"));
            break;
                
                case 2:/**To view all available conference rooms and prices*/
                System.out.println("\nM E E T I N G S  +  E V E N T S (Price estimated for a day only)");
                System.out.println("******************************************************************");
                System.out.println("NO.\tNAME OF ALLOTTED ROOM\t\t PRICE");
                System.out.println("******************************************************************");
                for(int i=0;i<event.length;i++)
                System.out.println((i+1)+".\t"+event[i]+"\t "+pevent[i]);
                System.out.println("******************************************************************");
                break;
                
                case 3:/**To view restaurants in Park Hyatt and their prices*/
                System.out.println("\nD I N I N G ( Price estimated for one person only)");
                System.out.println("****************************************************");
                System.out.println("NO.\tNAME OF RESTAURANT\t\tPRICE");
                System.out.println("****************************************************");
                for(int i=0;i<dining.length;i++)
                System.out.println((i+1)+".\t"+dining[i]+"\t"+pdining[i]);
                System.out.println("****************************************************");
                break;
                
                case 4:/**To view all spa treatments and their prices*/
                System.out.println("\n T H E   S P A   S A L O N (Price estimated for every 80 minutes only)");
                System.out.println("************************************************************************");
                System.out.println("NO.\t SPA TYPE NAME\t\t\tPRICE");
                System.out.println("************************************************************************");
                for(int i=0;i<spa.length;i++)
                System.out.println((i+1)+".\t"+spa[i]+"\t"+pspa[i]);
                System.out.println("************************************************************************");
                break;
            }
            System.out.print("\n Enter 'y' to continue menu display : ");
            s=br.readLine();
            
        }while(s.equalsIgnoreCase("y"));
        menu();/**To go back to main menu once you have viewed*/
    }
    /**This method enables the user to order/book*/
    void order()throws IOException
    {
        
        String s="",s2="";
        int ch=0,ch2=0;
        /** do-while loop takes care that only a valid choice is entered*/
       do
       {
          System.out.println("*********************");
          for(int i=0;i<view.length;i++)
          System.out.println((i+1)+". "+view[i]);
          System.out.println("*********************");
          System.out.print("\n Please enter your choice between 1 and 4 only : ");
          ch=Integer.parseInt(br.readLine());
          if(ch<1||ch>4)
          System.out.println(" ERROR!Please enter choice from 1 to 4 only!");
       }while(ch<1||ch>4);
       switch(ch)
       {
         case 1:/**To view Suites and Guest rooms for booking*/
        do
        {
            do
            {  
                    System.out.println("****************");
                    System.out.println("B O O K I N G ");
                    System.out.println("****************");
                    System.out.println("1. Suites");
                    System.out.println("2. Guest rooms");
                    System.out.println("****************");
                    System.out.print("\n Please enter your choice as 1 or 2 only : ");
                    ch2=Integer.parseInt(br.readLine());
                    if(ch2<1||ch2>2)
                    System.out.println(" ERROR!Please enter choice as 1 or 2 only...");
            }while(ch2<1||ch2>2);
            if(ch2==1)/**To view all suites and prices to book*/
            {   
                    /**VIEW THE SUITES MENU*/
                    System.out.println("\n S U I T E S (price estimated for a night only)");
                    System.out.println("***************************************************");
                    System.out.println("NO.\t   SUITE NAME\t\t\tPRICE");
                    System.out.println("***************************************************");
                    for(int i=0;i<suite.length;i++)
                    System.out.println((i+1)+".\t" +suite[i]+"\t"+psuite[i]);
                    System.out.println("***************************************************");
                    /**ALLOWS USER TO BOOK*/
                    do
                    {
                        /**CHECK IF ITEM NUMBER IS CORRECT*/
                        do
                        {
                            System.out.print(" Enter suite number : ");
                            ino=Integer.parseInt(br.readLine());
                            if(ino<1||ino>4)
                            System.out.println("\n ERROR! Suite number has to be from 1 to 4 only...");
                        }while(ino<1||ino>4);
                        System.out.println("\n The price of the chosen suite is : "+psuite[ino-1]);
                        System.out.print(" Please enter number of suites you'd like to book : ");
                        qty=Integer.parseInt(br.readLine());
                        total=total+qty*psuite[ino-1];
                        n[pos]=suite[ino-1];
                        no[pos]=ino;
                        p[pos]=psuite[ino-1];
                        q[pos]=qty;
                        t[pos]=qty*p[pos];
                        System.out.print("\n Please enter 'y' to book more : ");
                        s=br.readLine();
                        pos++;
                    }while(s.equalsIgnoreCase("y"));
            }           
            else if(ch2==2)/**To view all Guest rooms and prices to book*/
            {   
                    /**VIEW THE GUEST ROOM MENU*/
                    System.out.println("\n G U E S T  R O O M S (Price estimated for a night only)");
                    System.out.println("**********************************************************");
                    System.out.println("NO.\tROOM NAME\t\t\tPRICE");
                    System.out.println("**********************************************************");
                    for(int i=0;i<room.length;i++)
                    System.out.println((i+1)+".\t"+room[i]+"\t"+proom[i]);
                    System.out.println("**********************************************************");
                    /**ALLOWS USER TO BOOK*/
                    do
                    {
                        /**CHECK IF ITEM NUMBER IS CORRECT*/
                        do
                        {
                            System.out.print("\n Enter guest room number : ");
                            ino=Integer.parseInt(br.readLine());
                            if(ino<1||ino>4)
                            System.out.println("\n ERROR!Guest room number has to be from 1 to 4 only...");
                        }while(ino<1||ino>4);
                        System.out.println("\n The price of the chosen guest room is : "+proom[ino-1]);
                        System.out.print(" Please enter number of guest rooms you'd like to book : ");
                        qty=Integer.parseInt(br.readLine());
                        total=total+qty*proom[ino-1];
                        n[pos]=room[ino-1];
                        no[pos]=ino;
                        p[pos]=proom[ino-1];
                        q[pos]=qty;
                        t[pos]=qty*p[pos];
                        System.out.print("\n Please enter 'y' to book more : ");
                        s=br.readLine();
                        pos++;
                    }while(s.equalsIgnoreCase("y"));
                    
            }
            System.out.print(" Press 'y' to continue booking in the 'BOOKING' menu : ");
            s2=br.readLine();
        }while(s2.equalsIgnoreCase("y"));
        menu();/**calls the function to check what user's wish is after booking*/
        break;
                
        case 2:/**VIEW MEETINGS+EVENTS MENU*/
        System.out.println("\n M E E T I N G S  +  E V E N T S (Price estimated for a day only)");
        System.out.println("*******************************************************************");
        System.out.println("NO.\tNAME OF ALLOTTED ROOM\t\tPRICE");
        System.out.println("*******************************************************************");
        for(int i=0;i<event.length;i++)
        System.out.println((i+1)+".\t"+event[i]+"\t"+pevent[i]);
        System.out.println("*******************************************************************");
        /**ALLOWS USER TO BOOK*/
        do
        {
         /**CHECK IF ITEM NUMBER IS CORRECT*/
         do
         {
           System.out.print("\n Enter event number : ");
           ino=Integer.parseInt(br.readLine());
           if(ino<1||ino>4)
           System.out.println(" ERROR! Event room number has to be from 1 to 4 only...");
         }while(ino<1||ino>4);
         System.out.println("\n The price of the chosen event/conference room is : "+pevent[ino-1]);
         System.out.print(" Please enter number of event/conference rooms you'd like to book : ");
         qty=Integer.parseInt(br.readLine());
         total=total+qty*pevent[ino-1];
         n[pos]=event[ino-1];
         no[pos]=ino;
         p[pos]=pevent[ino-1];
         q[pos]=qty;
         t[pos]=qty*p[pos];
         System.out.print("\n Please enter 'y' to book more : ");
         s=br.readLine();
         pos++;
        }while(s.equalsIgnoreCase("y"));
        menu();/**calls the function to check what user's wish is after booking is done*/
        break;
            
                
        case 3:/**VIEW DINING MENU*/
        System.out.println("\n D I N I N G ( Price estimated for one person only)");
        System.out.println("*****************************************************");
        System.out.println("NO.\tNAME OF RESTAURANT\t\tPRICE");
        System.out.println("*****************************************************");
        for(int i=0;i<dining.length;i++)
        System.out.println((i+1)+".\t"+dining[i]+"\t"+pdining[i]);
        System.out.println("*****************************************************");
        /**ALLOWS USER TO BOOK*/
        do
        {
         /**CHECK IF ITEM NUMBER IS CORRECT*/
         do
         {
          System.out.print("\n Enter restaurant number : ");
          ino=Integer.parseInt(br.readLine());
          if(ino<1||ino>4)
          System.out.println(" ERROR! Restaurant number has to be from 1 to 4 only...");
         }while(ino<1||ino>4);
         System.out.println("\n The price for the reservation for a one-time meal in the chosen restaurant is : "+pdining[ino-1]);
         System.out.print(" Please enter number of one-time meals you would like to book : ");
         qty=Integer.parseInt(br.readLine());
         total=total+qty*pdining[ino-1];
         n[pos]=dining[ino-1];
         no[pos]=ino;
         p[pos]=pdining[ino-1];
         q[pos]=qty;
         t[pos]=qty*p[pos];
         System.out.print(" Please enter 'y' to book more : ");
         s=br.readLine();
         pos++;
        }while(s.equalsIgnoreCase("y"));
        menu();/**calls the function to check what user's wish is after booking*/
        break;        
                
                
        case 4:/**VIEW THE SPA SALON MENU*/
        System.out.println("\n T H E   S P A   S A L O N (Price estimated for every 80 minutes only)");
        System.out.println("************************************************************************");
        System.out.println("NO.\tTREATMENT NAME\t\t\tPRICE");
        System.out.println("************************************************************************");
        for(int i=0;i<spa.length;i++)
        System.out.println((i+1)+".\t"+spa[i]+"\t"+pspa[i]);
        System.out.println("************************************************************************");
        /**ALLOWS USER TO BOOK*/
        do
        {
         /**CHECK IF ITEM NUMBER IS CORRECT*/
         do
         {
          System.out.print("\n Enter spa treatment number : ");
          ino=Integer.parseInt(br.readLine());
          if(ino<1||ino>4)
          System.out.println(" ERROR! Spa treatment number has to be from 1 to 4 only...");
         }while(ino<1||ino>4);
         System.out.println("\n The price for salon treatment/80 min is : "+pspa[ino-1]);
         System.out.print(" Please enter number of the chosen spa treatments you would like to book : ");
         qty=Integer.parseInt(br.readLine());
         total=total+qty*pspa[ino-1];
         n[pos]=spa[ino-1];
         no[pos]=ino;
         p[pos]=pspa[ino-1];
         q[pos]=qty;
         t[pos]=qty*p[pos];
         System.out.print(" Please enter 'y' to book more : ");
         s=br.readLine();
         pos++;
        }while(s.equalsIgnoreCase("y"));
        menu();/**calls the function to check what user's wish is*/
        break;    
                
       }
    }
    /**This method prints the final bill i.e., enables the user to view his bill and exit*/
    void bill_exit()throws IOException
    {
      System.out.println("\t TOTAL BOOKINGS : "+pos);
      System.out.println("*************************************************************************************************");
      System.out.println("S.NO.\tCODE\t\tNAME\t\t\t\tPRICE\t     QUANTITY\t\tTOTAL");    
      System.out.println("*************************************************************************************************");
      for(int k=0;k<pos;k++)/**printing final bill*/
      System.out.println((k+1)+".\t"+no[k]+"\t"+n[k]+"\t"+"\t"+p[k]+"\t\t"+q[k]+"\t\t"+t[k]);
      System.out.println("*************************************************************************************************");
      System.out.println("\t Final Bill Amount : Rs. "+total);
      /**The tax allotted is 15%*/
      tax=0.15*total;/**calculate tax on the grand total*/
      netamt=total+tax;/**calculate final bill inclusive of tax*/
      System.out.println("\t Tax (15%) : Rs. "+tax);
      System.out.println("\t Net Amount : Rs. "+netamt);
      System.out.println("*************************************************************************************************");
      /**EXIT COMMENTS*/
      System.out.println("\n\t PARK HYATT has been enriched by your visit. ");
      System.out.println("\t Please leave your feedback at the reception and help us enhance our work!");
      System.out.println("\t Thanks for visiting us and we look forward to welcoming you again!");
    }
}