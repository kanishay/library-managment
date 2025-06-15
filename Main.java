import manager.LibraryManager;
import manager.LoginManager;
import model.User;
import model.Book;


import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LibraryManager library=new LibraryManager();
        LoginManager l =new LoginManager();
        User currentUser=null;
        while(currentUser==null){
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Exit");
            int choice=sc.nextInt();
            if(choice==1){
                System.out.println("Username:");
                String username=sc.next();
                System.out.println("Password:");
                String password=sc.next();
                currentUser=l.login(username,password,library.getAllusers());
                if(currentUser==null){
                    System.out.println("Invalid username or password,Try again to login");
                }
            }
            else if(choice==2){
                System.out.println("Name:");
                String name=sc.nextLine();
                System.out.println("Username:");
                String username=sc.next();
                System.out.println("Password:");
                String password= sc.next();
                int userId=1000+ new Random().nextInt(9000);
                User newUser=new User(userId,name,username,password,false);
                library.adduser(newUser);
                System.out.println("User registered successfully,Now you can login");

            }
            else if(choice==3){
                System.out.println("Goodbye!!,Have a nice day");
                return;
            }
            else{
                System.out.println("Invalid choice");
            }
        }
        System.out.println("Welcome "+currentUser.getName());
        int choice;
        do {
            System.out.println("=====Menu====");
            if (currentUser.getIsadmin()) {
                System.out.println("1.Add book");
                System.out.println("2.View book");
                System.out.println("3.View users");
                System.out.println("4.Log out");
                choice = sc.nextInt();
                ;
                if (choice == 1) {
                    System.out.println("Book title:");
                    String title = sc.nextLine();
                    System.out.println("Book Author:");
                    String author = sc.nextLine();
                    System.out.println("Book publisher:");
                    String publisher = sc.nextLine();
                    System.out.println("Year:");
                    int year = sc.nextInt();
                    System.out.println("Copies:");
                    int copies = sc.nextInt();
                    int bookId = 1000 + new Random().nextInt(9000);
                    Book newbook = new Book(bookId, title, author, publisher, year, copies);
                    library.addBook(newbook);
                    System.out.println("\nBook added successfully");
                } else if (choice == 2) {
                    System.out.println("====Booklist====");
                    library.viewAllBooks();
                } else if (choice == 3) {
                    System.out.println("====Userlist====");
                    ArrayList<User> users = library.getAllusers();
                    for (User u : users) {
                        String role;
                        if (u.getIsadmin()) {
                            role = "Admin";
                        } else {
                            role = "User";
                        }
                        System.out.println(u.getUserid() + ":" + u.getName() + "|Role:" + role);
                    }
                }
                else if (choice == 4) {
                    System.out.println("Logged out");
                    break;
                }
                else {
                    System.out.println("Invalid choice");
                }
            }
            else{
                System.out.println("1.View Book");
                System.out.println("2.Search Book");
                System.out.println("3.Borrow Book");
                System.out.println("4.Return Book");
                System.out.println("5.My borrowed Books");
                System.out.println("6.Logout ");
                choice=sc.nextInt();
                if(choice==1){
                    System.out.println("====BookList====");
                    library.viewAllBooks();
                }
                else if(choice==2){
                    System.out.println("Keyword:");
                    String keyword=sc.nextLine();
                    library.searchBookByTitle(keyword);
                }
                else if(choice==3){
                    System.out.println("Book id:");
                    int bid=sc.nextInt();
                    library.borrowBook(bid,currentUser.getUserid());
                }
                else if(choice==4){
                    System.out.println("Book id:");
                    int bid=sc.nextInt();
                    library.returnBook(bid,currentUser.getUserid());
                }
                else if(choice==5){
                    currentUser.showBorrowedBooks();
                }
                else if(choice==6){
                    System.out.println("Logged out");
                    break;
                }
                else{
                    System.out.println("Invalid choice");
                }
            }
        }while(true);
        sc.close();

    }
}
