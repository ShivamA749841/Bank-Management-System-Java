import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;
class Book{
   private String bookName;
   private int bookId;
   private String author;
   private String category;
   private boolean available=true;
   private LocalDate issueDate;
   private LocalTime issueTime;
   private LocalDate returnDate;
   private LocalTime returnTime;



    Book(String bookName,int bookId,String author,String category)
    {
        this.bookName=bookName;
        this.bookId=bookId;
        this.author=author;
        this.category=category;
      

       
    }
    String getBookName(){
      return bookName;
    }
    void setBookName(String bookName){
        if(bookName==null){
        System.out.println("invalid name");
        return;
      }
      if(bookName.trim().isEmpty()){
        System.out.println("Book Name cannot empty");
        return;
      }
      this.bookName=bookName;
    }
    int getBookId(){
      return bookId;
    }
    void setBookId(int bookId){
      this.bookId=bookId;
    }
     String getBookauthor(){
      return author;
    }
    void setBookauthor(String author){
      this.author=author;
    }
     String getBookcategory(){
      return category;
    }
    void setBookcategory(String category){
      this.category=category;
    }
    
    public void setAvailable(boolean available){
      this.available=available;
    }
    public void setIssueDate(LocalDate issueDate){
      this.issueDate=issueDate;
    }
    public void setIssueTime(LocalTime issueTime){
      this.issueTime=issueTime;
    }
    public void setReturnDate(LocalDate returDate){
      this.returnDate=returDate;
    }
    public void setReturnTime(LocalTime returnTime){
      this.returnTime=returnTime;

    }
    public boolean isAvailable(){
      return available;
    }
    public LocalDate getIssueDate(){
      return issueDate;
    }
    public LocalTime getIssueTime(){
      return issueTime;
    }
    public LocalDate getReturnDate(){
      return returnDate;
    }
    public LocalTime getReturnTime(){
      return returnTime;
    }
    void display(){
      System.out.println("Book Id:"+bookId);
        System.out.println("Book Name:"+bookName);
        System.out.println("Author:"+author);
        System.out.println("Category:"+category);
        System.out.println("Status:"+(available ? "Available" : "Issued"));
        System.out.println("Issue Date:"+issueDate);
        System.out.println(" Issues Time:"+issueTime);
        System.out.println("Return Date:"+returnDate);
        System.out.println("Return Time:"+returnTime);

    }
}
class Library{
    Scanner sc;
    Library(Scanner sc){
        this.sc=sc;
    }
    Book[] books=new Book[1000];
    int  bookCount=0;
    void addBook(){
      System.out.println("Enter Book Name:");
      String name=sc.nextLine();
      System.out.println("Enter Book ID:");
      int id=sc.nextInt();
      sc.nextLine();
      // System.out.println("Enter Book Name:");
      // String name =sc.nextLine();
      System.out.println("Enter Author:");
      String author=sc.nextLine();
      System.out.println("Enter Category:");
      String  category=sc.nextLine();
        if(bookCount==books.length){
                  System.out.println("Library Full");
                  return;
                }
                if(id<=0){
                  System.out.println("invalid book id");
                  return;
                }
                boolean dublicate=false;
                for(int i=0; i<bookCount; i++){
                  if(books[i]!=null && books[i].getBookId()==id){
                    System.out.println("Book ID Already Available");
                    dublicate=true;
                    break;
                  }
                }
                if(!dublicate){
                books[bookCount]=new Book(name,id,author,category);
                System.out.println("Book Added Successfully");
                  bookCount++;}
                  System.out.println("Book Count After Add = " + bookCount);
    }
    void searchBook(){
         System.out.println("Enter Book id:");
               int id=sc.nextInt();
                boolean found=false;
                for(int i=0; i<bookCount; i++){
              if(books[i]!=null && books[i].getBookId()==id){
                 if (!books[i].isAvailable()) {
                System.out.println("Cannot search. book not availble in Library");
                return;
            }
                books[i].display();
                found=true;
            break;
              }}
              if(!found){
                System.out.println("Book not present");
              }
    }
    void removeBook(){
        System.out.println("Enter book id:");
                int id=sc.nextInt();
                boolean removed=false;
                for(int i=0; i<bookCount; i++){
                if(books[i]!=null && books[i].getBookId()==id){
                   if (!books[i].isAvailable()) {
                System.out.println("Cannot Remove. Book Is Issued.");
                return;
            }
                  for(int j=i; j<bookCount-1; j++){
                    books[j]=books[j+1];
                  }
                    books[bookCount-1]=null;
                    bookCount--;
                    System.out.println("Book Removed Sucessfully.");
                    removed=true;
                    break;
                }}
                if(!removed){
                  System.out.println("Book Not  Found:");
                }
                
    }
    void countBook() {

    int availableCount = 0;
    int issuedCount = 0;

    for (int i = 0; i < bookCount; i++) {

        if (books[i] != null) {

            if (books[i].isAvailable()) {
                availableCount++;
            } else {
                issuedCount++;
            }
        }
    }

    System.out.println("Total Books      : " + bookCount);
    System.out.println("Available Books  : " + availableCount);
    System.out.println("Issued Books     : " + issuedCount);
}
    void showAllBooks(){
         for(int i=0; i<bookCount; i++){
                     if(books[i]!=null){                    
                     System.out.println((i+1)+".");
                    books[i].display();
                    }}
                    if(bookCount==0){
                      System.out.println("Book Not Available");
                    }
                    
    }
    void issuseBook(){
 System.out.println("Enter your BookID:");
 int id=sc.nextInt();
 sc.nextLine();
 boolean found=false;
 for(int i=0; i<bookCount; i++){
  if(books[i]!=null && books[i].getBookId()==id){
    found=true;
    if(books[i].isAvailable()){
      books[i].setAvailable(false);
      books[i].setIssueDate(LocalDate.now());
      books[i].setIssueTime(LocalTime.now());
      System.out.println("Book Issued Successfully.");
      System.out.println("Issue Date : " + books[i].getIssueDate());
      System.out.println("Issue Time : " + books[i].getIssueTime());
    }
  
 else{
   System.out.println("Book Already Issued.");
 }
 break;}}
 if(!found){
  System.out.println("Book ID Not Found."); 
 }
    }
    void returnBook(){
  System.out.println("Enter your id:");
  int Id=sc.nextInt();
  sc.nextLine();
  boolean Found =false;
  for(int i=0; i<bookCount;i++){
    if(books[i]!=null && books[i].getBookId()==Id){
   Found=true;
    if(!books[i].isAvailable()){
      books[i].setAvailable(true);
      books[i].setReturnDate(LocalDate.now());
      books[i].setReturnTime(LocalTime.now());
      System.out.println("Book Return Successfully.");
      System.out.println("Retrun Date: "+books[i].getReturnDate());
      System.out.println("Return Time:"+books[i].getReturnTime());

    }
   else {
   System.out.println("Book Already Available.");
   }
 
    break;}}
    if(!Found){
  System.out.println("Book ID Not Found."); 
 }}
   
    void saveBook(){
      try{
        BufferedWriter bw=
          new BufferedWriter(
            new FileWriter("data.txt"));
            System.out.println("Book Count = " + bookCount);
            for(int i=0;i<bookCount;i++){
              bw.write(
                 books[i].getBookId() + "," +
                  books[i].getBookName() + "," +
                  books[i].getBookauthor() + "," +
                  books[i].getBookcategory() + "," +
                   books[i].isAvailable() + "," +
                  books[i].getIssueDate() + "," +
                         books[i].getIssueTime() + "," +
                 books[i].getReturnDate() + "," +
                 books[i].getReturnTime());
              bw.newLine();
            }
            bw.close();
            System.out.println("Books Saved Successfully");
        }
      
      catch(IOException e){
        System.out.println("Error Saving Fil.");
      }
    } 
    void load(){
      try{
      BufferedReader br =new BufferedReader(new FileReader("data.txt"));
      String line;
      while((line=br.readLine())!=null){
        String [] data=line.split(",");
        Book book=new Book(
          data[1],
          Integer.parseInt(data[0]),
         data[2],
         data[3]
      );
      book.setAvailable(Boolean.parseBoolean(data[4]));
       if (!data[5].equals("null")) {
      book.setIssueDate(LocalDate.parse(data[5]));}
      if (!data[6].equals("null")) {
      book.setIssueTime(LocalTime.parse(data[6]));}
      if (!data[7].equals("null")) {
      book.setReturnDate(LocalDate.parse(data[7]));}
      if (!data[8].equals("null")) {
      book.setReturnTime(LocalTime.parse(data[8]));
            }
             books[bookCount] = book;
            bookCount++;}
            br.close();
            System.out.println("Book Load Successfully:");
      }
      catch(FileNotFoundException e){
        System.out.println("NO previous Data Found.");
      }
      catch(IOException e){
        System.out.println("Error Loding file.");
    }}
    void exitLibrary(){
         System.out.println("Thank You fOr Visiting Library:");
         return;
    }}


public class Librarypro {
    public static void main(String[] args) {
      
        Scanner sc =new Scanner(System.in);
        Library library=new Library(sc);
        library.load();
        while(true){
          try{
          System.out.println("Welcome To Library:");
            System.out.println("1.Add Book");
            System.out.println("2.Search Book");
            System.out.println("3.Remove Book");
            System.out.println("4.Count Book");
            System.out.println("5.Show All Book");
            System.out.println("6.Issue Book");
            System.out.println("7.Return Book");
            System.out.println("8.Exit");
            System.out.println("Enter Your Choice:");
            int Choice =sc.nextInt();
            sc.nextLine();
            switch (Choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.searchBook();
                    break;
                case 3:
                    library.removeBook();
                    break;
                case 4:
                    library.countBook();
                    break;
                case 5:
                    library.showAllBooks();
                    break;
                case 6:
                  library.issuseBook();
                  break;
                case 7:
                  library.returnBook();
                  break;  
                case 8:
                  library.saveBook();
                    library.exitLibrary();
                    sc.close();
                    return;    
            
                default:
                    System.out.println("invalid choice");
                    break;
        }
      }
    
    catch(InputMismatchException e){
      System.out.println("Invalid Input ! Please Enter Numbers Only");
      sc.nextLine();
    }}}
}
