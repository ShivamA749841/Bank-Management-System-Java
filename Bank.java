
import java.util.*;


class Bank {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your name:");
        String Name=sc.nextLine();
        System.out.print("enter your accound num:");
        long Acc=sc.nextLong();
        System.out.print("enter your accound pin:");
        int  pin=sc.nextInt();
        

        System.out.print("enter your amount:");
      double amount=sc.nextDouble();
      String transaction="no transaction";
      while (true) {
        System.out.println("welcome to bank serives:");
        System.out.println("1.deposite");
        System.out.println("2.withdraw");
        System.out.println("3.cheakbalance");
        System.out.println("4.Account Details");
        System.out.println("5.transation");
        System.out.println("6.change pin");
        System.out.println("7.exit");
        System.out.println("enter your choice");
        int choice=sc.nextInt();
      
      switch (choice) {
        case 1: 
        System.out.println("enter pin");
        int enterpin=sc.nextInt();
          if(enterpin!=pin){
            System.out.println("wrong pin");
            break;
             }
            System.out.println("enter your deposit amount");
          double deposit=sc.nextDouble();
           
          if(deposit<=0){
            System.out.println("invalid amound");
         }else{
          amount+=deposit;
          System.out.println("deposit successfully");
        System.out.println("current balance:"+amount);
        transaction="deposited:"+deposit;
        }
          
          break;

          case 2:
          System.out.println("enter pin");
          int enterpin1=sc.nextInt(); 
          if(enterpin1!=pin){
          System.out.println("wrong pin");
          break;  }        
          System.out.println("enter the amount to withdraw");
          double withdraw=sc.nextDouble();
          
          if(withdraw<=amount){
          amount-=withdraw;
          System.out.println("withdraw successfully");
        System.out.println("current balance:"+amount);
        transaction="withdraw:"+withdraw;
        }
          else{
            System.out.println("insufficient balance");
          }
          break;

          case 3:
             System.out.println("enter pin");
          int enterpin2=sc.nextInt();
          if(enterpin2!=pin){
            System.out.println("wrong pin deposite not posible");
            break;          }
            System.out.println("current balace:"+amount);
            break;
            case 4:
               System.out.println("enter pin");
          int enterpin3=sc.nextInt();
          if(enterpin3!=pin){
            System.out.println("wrong pin deposite not posible");
            break;          }
            System.out.println("Name: " + Name);
            System.out.println("Account No: " + Acc);
            System.out.println("Balance: " + amount);
            break;
            case 5:
              System.out.println("enter pin");
          int enterpin5=sc.nextInt(); 
          if(enterpin5!=pin){
          System.out.println("wrong pin");
          break;          }
              System.out.println("transations:"+transaction);

              break;
              case 6:
                System.out.println("your current pin");
                int changepin=sc.nextInt();
                if(changepin==pin){
                  System.out.print("enter your new pin:");
                  int newpin=sc.nextInt();
                  pin=newpin;
                  System.out.println("pin change successfully");
                }
                else{
                  System.out.println("wrong current pin");
                  
                }
                      break;
            case 7:
              System.out.println("thank you for banking");
              sc.close();
          
          return;
      
        default:
          System.out.println("invalide choice"
          );
          
      }}

    }}








 