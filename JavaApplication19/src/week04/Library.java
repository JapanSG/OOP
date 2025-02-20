package week04;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
public class Library {
    public String libraryName;
    public Book book1;
    public Book book2;
    public Book book3;
    public void addBook(Book book, int slot){
        switch (slot){
            case 1:
                book1 = book;
                break;
            case 2:
                book2 = book;
                break;
            case 3:
                book3 = book;
                break;
            default:
                System.out.println("Slot not found");
        }
    }
    public void removeBook(int slot){
        switch (slot){
            case 1:
                book1 = null;
                break;
            case 2:
                book2 = null;
                break;
            case 3:
                book3 = null;
                break;
            default:
                System.out.println("Slot not found");
        }
    }
    public void printLibraryDetails(){
        System.out.println("Library: " + libraryName+"\n");
        printBookDetails(book1);
        System.out.println("");
        printBookDetails(book2);
        System.out.println("");
        printBookDetails(book3);
    }
    public void checkBookAvailability(int slot){
        Book selected;
        switch (slot) {
            case 1:
                selected = book1;
                break;
            case 2:
                selected = book2;
                break;
            default:
                selected = book3;
        }
        if (selected == null){
            System.out.println("Book in slot " + slot + " is not availble.");
        }
        else {
            System.out.println(selected.title + " is available.");
        }
        
    }
    public void updateBookPrice(int slot, double newPrice){
        Book selected;
        switch (slot) {
            case 1:
                selected = book1;
                break;
            case 2:
                selected = book2;
                break;
            default:
                selected = book3;
        }
        if (selected == null){
            System.out.println("No book in this slot.");
        }
        else {
            System.out.println("Updated price of " + selected.title + " to $" + newPrice + ".");
            selected.price = newPrice;
        }
    }
    public void printBookDetails(Book book){
        if (book == null){
            System.out.println("No book in this slot.");
        }
        else {
            book.printDetails();
        }
    }
}
