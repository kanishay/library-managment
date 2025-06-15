package manager;
import java.util.*;
import model.*;

public class LibraryManager {
   private ArrayList<Book> books=new ArrayList<>();
   private ArrayList<User> users=new ArrayList<>();
   public void addBook(Book book){
       books.add(book);
   }
   public void adduser(User user){
       users.add(user);
   }
   public Book getBookbyId(int id){
       for(Book b:books){
           if(b.getId()==id){
               return b;
           }
       }
       return null;
   }
    public User getUserbyId(int id){
        for(User u:users){
            if(u.getUserid()==id){
                return u;
            }
        }
        return null;
    }
    public void viewAllBooks(){
       if(books.isEmpty()){
System.out.println("No books in the library");
 }
       else{
           for(Book b:books){
               System.out.println(b.getTitle());
           }
       }
    }
    public ArrayList<User> getAllusers(){
       return users;
    }
    public void searchBookByTitle(String k){
       String Keyword =k.toLowerCase();
       boolean found=false;
       for(Book b:books){
           String bTitle=b.getTitle().toLowerCase();
           if(bTitle.contains(Keyword)){
               System.out.println(b);
               found=true;
           }
       }
       if(found==false){
           System.out.println("No matching book found");
       }
    }
public void borrowBook(int id,int userId ){
       Book b=getBookbyId(id);
       User u=getUserbyId(userId);
       if(u!=null && b!=null && b.getCopies()>0){
           b.decreasecopies();
           u.borrowBook(id);
           System.out.println("book borrowed successfully");
       }
       else{
           System.out.println("Book not found or user not found");
       }

    }
    public void returnBook(int id,int userId){
       Book b=getBookbyId(id);
       User u=getUserbyId(userId);
       if(b!=null && u!=null){
           b.increasecopies();
           u.returnBook(id);
           System.out.println("book returned successfully");
        }
       else{
            System.out.println("unable to return book");
        }
    }
}
