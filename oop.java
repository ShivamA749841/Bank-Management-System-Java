// import java.util.Arrays;
import java.util.Scanner;

public class oop{
    public static void main(String[] args) {
Scanner sc =new Scanner(System.in);
System.out.println("enter the sentace:");
String world1=sc.nextLine();
char arr[]=world1.toCharArray();
int count=1;
for(int i=1; i<arr.length; i++){
if(arr[i]==arr[i-1]){
   
    count++;

}
else{
    System.out.println(arr[i-1]+ " "+count);
count=1;
}
}
System.out.println(arr[arr.length-1]+""+count);
   sc.close(); }}