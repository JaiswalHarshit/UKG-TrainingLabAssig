package assg2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
	private String bookTitle;
	private String author;
	private String ISBN;
	private int numOfCopies;

	public Book(String bookTitle, String author, String iSBN, int numOfCopies) {
		this.bookTitle = bookTitle;
		this.author = author;
		ISBN = iSBN;
		this.numOfCopies = numOfCopies;
	}
	
	protected String getBookTitile()
	{
		return bookTitle;
	}
	
	protected String getiSBN()
	{
		return ISBN;
	}
	
	protected int getNoOfCopies() {
		return numOfCopies;
	}
	
	protected void setNoOfCopies(int noOfCopies) {
		this.numOfCopies=noOfCopies;
	}

	public void display() {
		System.out.print(bookTitle + " -- ");
		System.out.print(author + " -- ");
		System.out.print(ISBN + " -- ");
		System.out.print(numOfCopies);
		System.out.println();
	}

}

class BookStore {
	private List<Book> books;
	
	BookStore(List<Book> books){
		this.books=books;
	}

	public void sell(String bookTitle, int noOfCopies) {
		int f=0;
		for(Book b: books) {
			if(b.getBookTitile().equals(bookTitle)) {
				f=1;
				b.setNoOfCopies(b.getNoOfCopies()-noOfCopies);
				System.out.println("Books sold");
				b.display();
				break;
			}
		}
		if(f==0)
			System.out.println("No book with this name");		
	}

	public void order(String ISBN, int noOfCopies) {
		int f=0;
		for(Book b: books) {
			if(b.getiSBN().equals(ISBN)) {
				f=1;
				b.setNoOfCopies(b.getNoOfCopies()+noOfCopies);
				System.out.println("Books added");
				b.display();
				break;
			}
		}
		if(f==0) {
			System.out.println("Enter Title and Author");
			Scanner input = new Scanner(System.in);
			String title = input.next();
			String author = input.next();
			Book b=new Book(title,author,ISBN,noOfCopies);
			books.add(b);
			System.out.println("New Book Added");
			b.display();
		}
	}

	public void display() {
		for (Book b : books) {
			b.display();
		}
	}
}

public class BookStoreApp {

	public static void main(String[] args) {
		
		Book b1= new Book("Effective_Java","Xyz","Abc123",25);
		Book b2= new Book("Effective_C++","Pqr","ABB1234",52);
		Book b3= new Book("Effective_C","Abc","Xqt12",15);
		Book b4= new Book("Effective_Python","Rst","Tqp1234",5);
		List<Book> books = new ArrayList<Book>();
		
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		
		BookStore bs = new BookStore(books);
		

		System.out.println("Enter “1”, to display the Books: Title – Author – ISBN - Quantity");
		System.out.println("Enter “2”, to order new books");
		System.out.println("Enter “3”, to sell books");
		System.out.println("Enter “0”, to exit the system.");

		Scanner input = new Scanner(System.in);
		int ch = input.nextInt();

		switch (ch) {
		case 1:
			bs.display();
			break;
		case 2:
			System.out.println("Enter ISBN and no. of copies");
			String isbn=input.next();
			int nc=input.nextInt();
			bs.order(isbn,nc);
			break;
		case 3:
			System.out.println("Enter BookTitle and no. of copies");
			String bt=input.next();
			int no=input.nextInt();
			bs.sell(bt,no);
			break;
		case 0:
			System.out.println("You have exited...");
			break;
		default:
			System.out.println("Wrong Input.....");
		}

	}

}
