import java.io.*;
class Paradise1
{
  InputStreamReader ir=new      InputStreamReader(System.in);
 BufferedReader br= new BufferedReader(ir);
String nitem[]={"Chicken Soup", "Chicken 65", "Pepper Chicken", "Chicken Sticks", "Chilli Prawns", "Chicken Biryani", "Mutton Biryani", "Butter Chicken", "Mutton Masala", "Butter Naan"};
String vitem[]={"Veg Corn Soup", "Gobi Manchurian", "Spring Rolls", "Paneer 65", "Corn Manchurian", "Veg Biryani", "Veg Noodles", "Palak Paneer", "Malai Kofta", "Paneer Kulcha"};
String ditem[]={"Caramel Custard", "Gulab Jamun", "Choco Brownie", "Ice Cream", "Gajar  Ka Halwa"};
String bitem[]={"Cream Lassi", "Cold Coffee", "Fruit Juice", "Milk Shake", "Coca Cola", "Kinley Water"};
int nprice [] ={134, 309, 309, 309, 378, 244, 254, 288, 309, 59};
int vprice [] ={125, 221, 175, 229, 229, 200, 184, 210, 210, 75};
int dprice []={84,84,100,150,84};
int bprice []={84,84,84,84,42,40};
String n[]=new String[10];
int no[]=new int[10];
double p[]=new double[10];
double q[]=new double[10];
double t[]=new double[10];
String ch1,c1,c2;
int ch, ino, qty, pos=0,ch2;
double total=0,tax,netamt;
void view()throws IOException
{
   do
   {
    System.out.println("1: Non Veg");
    System.out.println("2: Veg");
    System.out.println("3: Desserts");
    System.out.println("4: Beverages");
    System.out.println("Enter choice for menu display:");
    ch=Integer.parseInt(br.readLine());
     switch(ch) 
      {
     case 1:
     System.out.println("***************************************");
     System.out.println("No.\tItem\t\t\tPrice");
     System.out.println("***************************************");
     for(int i=0;i<nitem.length;i++)
     System.out.println((i+1)+"\t"+nitem[i]+"\t\t"+nprice[i]); 
     System.out.println("***************************************");
     break;
     case 2:
     System.out.println("***************************************");
     System.out.println("No.\tItem\t\t\tPrice");
     System.out.println("**************************************");
     for(int i=0;i<vitem.length;i++)
     System.out.println((i+1)+"\t"+vitem[i]+"\t\t"+vprice[i]);
     System.out.println("***************************************");
     break;
     case 3:
     System.out.println("***************************************");
     System.out.println("No.\tItem\t\t\tPrice");
     System.out.println("***************************************");
     for(int i=0;i<ditem.length;i++)
     System.out.println((i+1)+"\t"+ditem[i]+"\t\t"+dprice[i]);
     System.out.println("***************************************");
     break;
     case 4:
     System.out.println("***************************************");
     System.out.println("No.\tItem\t\t\tPrice");
     System.out.println("***************************************");
     for(int i=0;i<bitem.length;i++)
     System.out.println((i+1)+"\t"+bitem[i]+"\t\t"+bprice[i]);
     System.out.println("***************************************"); 
     break;
     default:
     System.out.println("Wrong Choice Entered");
   } 
   System.out.println("Enter y For Continuing Menu Display:");
   ch1=br.readLine();
  }while(ch1.equalsIgnoreCase("y"));
}
void order()throws IOException
{
  do
  {
    System.out.println("Enter 'N' for Non Veg, 'V' for Veg, 'D' for Desserts or 'B' for Beverages :");
    c1=br.readLine();     
    if((c1.equals("N")||c1.equals("V")||c1.equals("D")||c1.equals("B"))==false)
    System.out.println("Error!! You Have To Enter 'N', 'V', 'D' or 'B'"); 
  }while((c1.equals("N")||c1.equals("V")|| c1.equals("D")||c1.equals("B"))==false);
  switch(c1)
  {
   case "N":
   System.out.println("************************************"); 
   System.out.println("No.\tItem\t\tPrice");                
   System.out.println("************************************");
   for(int i=0;i<nitem.length;i++)
   System.out.println((i+1)+"\t"+nitem[i]+"\t\t"+nprice[i]); 
   System.out.println("************************************");
   do
   {
      do
      {
        System.out.println("Enter Item Number:");                      
        ino=Integer.parseInt(br.readLine());
        if(ino<1||ino>nitem.length)
         System.out.println("Error In Item Number");
      }while(ino<1||ino>nitem.length);
     System.out.println("Price is:"+nprice[ino-1]);
     System.out.println("Enter Quantity:");      
     qty=Integer.parseInt(br.readLine());
     total=total+qty*nprice[ino-1];
     n[pos]=nitem[ino-1];
     no[pos]=ino;
     p[pos]=nprice[ino-1];
     q[pos]=qty;
     t[pos]=qty*p[pos];
     System.out.println("Enter y To Buy More:");
     c2=br.readLine();
     pos++;
    }while(c2.equalsIgnoreCase("y"));
   menu();
   break;
   case "V":               
   System.out.println("************************************"); 
   System.out.println("No.\tItem\t\tPrice");              
   System.out.println("***********************************");
   for(int i=0;i<vitem.length;i++)   
   System.out.println((i+1)+"\t"+vitem[i]+"\t\t"+vprice[i]);     
   System.out.println("************************************");
do
{
    do{
System.out.println("Enter Item Number:");                        ino=Integer.parseInt(br.readLine());
if(ino<1||ino>vitem.length)
System.out.println("Error In Item Number");
}while(ino<1||ino>vitem.length);
System.out.println("Price is:"+vprice[ino-1]);
System.out.println("Enter Quantity:");                    qty=Integer.parseInt(br.readLine());
total=total+qty*vprice[ino-1];
n[pos]=vitem[ino-1];
no[pos]=ino;
p[pos]=vprice[ino-1];
q[pos]=qty;
t[pos]=qty*p[pos];
System.out.println("Enter y To Buy More:");
c2=br.readLine();
pos++;
}while(c2.equalsIgnoreCase("y"));
menu();
break;
case "D":                System.out.println("************************************");                System.out.println("No.\tItem\t\tPrice");                System.out.println("************************************");
for(int i=0;i<ditem.length;i++)                System.out.println((i+1)+"\t"+ditem[i]+"\t\t"+dprice[i]);                System.out.println("************************************");
do
{
   do
   {
System.out.println("Enter Item Number:");                        ino=Integer.parseInt(br.readLine());
if(ino<1||ino>ditem.length)
System.out.println("Error In Item Number");
}while(ino<1||ino>ditem.length);
System.out.println("Price is:"+dprice[ino-1]);
System.out.println("Enter Quantity:");                   qty=Integer.parseInt(br.readLine());
total=total+qty*dprice[ino-1];                    n[pos]=ditem[ino-1];
no[pos]=ino;
p[pos]=dprice[ino-1];
q[pos]=qty;
t[pos]=qty*p[pos];
System.out.println("Enter y To Buy More:");
 c2=br.readLine();
 pos++;
 }while(c2.equalsIgnoreCase("y"));
 menu();
 break;
 case "B":               System.out.println("************************************");                System.out.println("No.\tItem\t\tPrice");                System.out.println("************************************");
for(int i=0;i<bitem.length;i++)                System.out.println((i+1)+"\t"+bitem[i]+"\t\t"+bprice[i]);                System.out.println("************************************");
do
{
    do
    {
System.out.println("Enter Item Number:");                        ino=Integer.parseInt(br.readLine());
if(ino<1||ino>bitem.length)
System.out.println("Error In Item Number");
}while(ino<1||ino>bitem.length);
System.out.println("Price is:"+bprice[ino-1]);
System.out.println("Enter Quantity:");                    qty=Integer.parseInt(br.readLine());
total=total+qty*bprice[ino-1];
n[pos]=bitem[ino-1];
no[pos]=ino;
p[pos]=bprice[ino-1];
q[pos]=qty;
t[pos]=qty*p[pos];
System.out.println("Enter y To Buy More:");
c2=br.readLine();
pos++;
}while(c2.equalsIgnoreCase("y"));
menu();
break;
   }
}
void menu()throws IOException
{
   do
   {
      System.out.println("1: View Details");
System.out.println("2: Place An Order");
System.out.println("3: View Bill And Exit");
System.out.println("Enter choice from 1-3:");
ch2=Integer.parseInt(br.readLine());
if(ch2<1||ch2>3)
System.out.println("Error   In  Choice.  It Should Be From 1-3 Only");
}while(ch2<1||ch2>3);
switch(ch2)
{
   case 1:
   view();
   menu();
   break;
   case 2:
order();
break;
case 3:
System.out.println("Total Items:"+pos);           
System.out.println("*******************************************************************************");            
System.out.println("S.no\tCode\tName\t\t\tPrice\t\tQuantity\tTotal");            
System.out.println("*******************************************************************************");
for(int k=0;k<pos; k++)           
 System.out.println((k+1)+"\t"+no[k]+"\t"+n[k]+"\t\t"+p[k]+"\t\t"+q[k]+"\t\t"+t[k]);            System.out.println("*******************************************************************************");
System.out.println("Bill Amount:"+total);
tax=0.15*total;
netamt=total+tax;
System.out.println("Tax:"+tax);
System.out.println("Net Amount:"+netamt);            System.out.println("*******************************************************************************");            System.out.println("Paradise Has Been Enriched By Your Visit");            System.out.println("Do Give Your Feedback At The Reception And Help Us To Enhance Our Work");
System.out.println("Thanks For Visiting Us And Come Back Soon!!");
break;
}    } }
