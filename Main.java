import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner sc =new Scanner(System.in);
      
      while(true){
        System.out.println("1.addition:");
        System.out.println("2.subtraction");
        System.out.println("3.multication");
        System.out.println("4.division");
        System.out.println("5.exit");
        System.out.println("enter your choice:");
        int choice=sc.nextInt();
        if(choice==5){
          System.out.println("thank you");
          break;
        }
        System.out.println("enter  the number1");
      int num1=sc.nextInt();
      System.out.println("enter the number 2");
      int num2=sc.nextInt();
       
        switch (choice) {
          case  1:
          System.out.println("result"+(num1+num2));           
            break;
            case  2:
               System.out.println("result"+(num1-num2));          
            break;
              
            case 3:
              System.out.println("result"+(num1*num2));         
            break;
          
            case  4:
              if(num2!=0){
               System.out.println("result"+(num1/num2)); } 
              else{
                System.out.println("cannot divode");
              }          
            break;
          default:
            System.out.println("invalid");
            break;

        }
      }
      sc.close();
    }}