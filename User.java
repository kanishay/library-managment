package model;
import java.util.*;

public class User {
    private int userId;
    private String Name;
    private String username;
    private String password;
    private boolean isAdmin;
    private ArrayList<Integer> borrowedBooks=new ArrayList<>();
    public User(int userId,String Name,String username,String password,boolean isAdmin){
        this.userId=userId;
        this.username=username;
        this.Name=Name;
        this.password=password;
        this.isAdmin=isAdmin;
    }
    public int getUserid(){
        return userId;
    }
    public String getuserame(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return Name;
    }
    public boolean getIsadmin(){
        return isAdmin;
    }
    public ArrayList<Integer> getBorrowedBooks(){
        return borrowedBooks;
    }
    public void borrowBook(int id){
        borrowedBooks.add(id);
    }
    public void returnBook(int id){
        borrowedBooks.remove(id);
    }
    public void showBorrowedBooks(){
        if(borrowedBooks.isEmpty()){
            System.out.println("you have not borrowed any books:");
        }
        else{
            System.out.println("Borrowed Books:"+borrowedBooks);
        }
    }
}
