package assg4b;

import java.math.BigDecimal;
import java.util.*;

class Book {
	private String name;
	private String author;
	private BigDecimal price;

	public Book(String name, String author, BigDecimal price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [name=");
		builder.append(name);
		builder.append(", author=");
		builder.append(author);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		return true;
	}

}

class BookCollection {
	private String owner;
	List<Book> books = new ArrayList<>();

	public BookCollection(String owner, List<Book> books) {
		super();
		this.owner = owner;
		this.books = books;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookCollection [owner=");
		builder.append(owner);
		builder.append(", books=");
		builder.append(books);
		builder.append("]");
		return builder.toString();
	}

	public boolean hasBook(Book b) {
		for (Book book : books) {
			if(book.equals(b)) {
				return true;
			}
		}
		return false;
	}
}

class BookCollectionTitleAndThenAuthorSorter implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		int val = o1.getName().compareTo(o2.getName());
		if (val == 0) {
			return o1.getAuthor().compareTo(o2.getAuthor());
		} else
			return val;
	}
	
}


public class BookCollectionMain {

	public static void main(String[] args) {
		Book b1 = new Book("effective java", "josh", new BigDecimal(400));
		Book b2 = new Book("java in depth", "josh", new BigDecimal(450));
		Book b3 = new Book("effective c++", "kim", new BigDecimal(370));
		Book b4 = new Book("effective c++", "jim", new BigDecimal(370));

		List<Book> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);

		BookCollection bc = new BookCollection("ram", books);
		
		Book b5 = new Book("java in depth", "josh", new BigDecimal(370));
		System.out.println("Has Book: " + bc.hasBook(b5));
		System.out.println("-------------------------");
		
		System.out.println("Before sorting------");
		System.out.println(bc);
		
		System.out.println("After sorting------");
		Collections.sort(books, new BookCollectionTitleAndThenAuthorSorter());
		System.out.println(bc);

		
		

	}

}
