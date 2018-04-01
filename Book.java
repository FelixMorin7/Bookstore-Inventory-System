/**
*Name and ID: Felix Morin, 40063253
*Assignment 1
*Part 1: Book Class
*Due Date: January 31 2018
*
**The goal of this program is to allow the user to store information about books in a virtual bookstore, to change this information if needed, and to display
*information such as books by a requested author or all books under a certain price. 
 */

public class Book {

	/**
	 * instance variables declarations
	 * 
	 * @param title title of the book
	 * @param author author of the book
	 * @param ISBN ISBN of the book
	 * @param price price of the book
	 * @param counter total number of books created
	 * @param bookNum number of the book in an inventory
	 */
	private String title = "";
	private String author = "";
	private long ISBN = 0;
	private double price = 0.0;
	private static int counter = 0;
	private int bookNum = 0;
	
	
	/**
	 * default constructor
	 * 
	 * title initialized to "Unknown"
	 * author initialized to "Unknown"
	 * ISBN initialized to 0
	 * price initialized to 0
	 * counter incremented by 1
	 */
	public Book()
	{
		this.title = "Unknown";
		this.author = "Unknown";
		this.ISBN = 0;
		this.price = 0;
		bookNum = counter;
		counter++;
	}
	
	
	/**
	 * constructor with 4 parameters
	 * 
	 * title value from parameter of same name
	 * author value from parameter of same name
	 * ISBN value from parameter of same name
	 * price value from parameter of same name
	 * counter incremented by 1 
	 */
	public Book(String title, String author, long ISBN, double price)
	{
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
		bookNum = counter;
		counter++;
	}
	
	
	/**
	 * Mutator method for title 
	 * 
	 * title set to parameter value
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	
	/**
	 * Mutator method for author 
	 * 
	 * author set to parameter value
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	
	/**
	 * Mutator method for ISBN 
	 * 
	 * ISBN set to parameter value
	 */
	public void setISBN(long ISBN)
	{
		this.ISBN = ISBN;
	}
	
	
	/**
	 * Mutator method for price 
	 * 
	 * price set to parameter value
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	
	/**
	 *Getter method for title 
	 * 
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}
	
	
	/**
	 *Getter method for author 
	 * 
	 * @return author
	 */
	public String getAuthor()
	{
		return author;
	}
	
	
	/**
	 *Getter method for ISBN 
	 * 
	 * @return ISBN
	 */
	public long getISBN()
	{
		return ISBN;
	}
	
	
	/**
	 *Getter method for price 
	 * 
	 * @return price
	 */
	public double getPrice()
	{
		return price;
	}
	
	
	/**
	 *toString method 
	 * 
	 * @return title, author, ISBN, and price in a display format
	 */
	public String toString()
	{
		return ("Book #" + bookNum + "\nbook title: " + title + "\nauthor: " + author + "\nISBN: " + ISBN + "\nprice: " + price);
	}
	
	
	/**
	 *Getter method for the number of books created 
	 * 
	 * @return counter
	 */
	public static int findNumberOfBooks()
	{
		return counter;
	}
	
	/**
	 * equals method to verify if two books are equal
	 * 
	 * @param compare book to be compared with
	 * @return true if ISBN and price of the two books are equal, false otherwise
	 */
	public boolean equals(Object compare)
	{
		if(this.getClass()!=compare.getClass())
			return false;
		
		Book compare2 = (Book) compare;
		
		if(this.ISBN == compare2.getISBN() && this.price == compare2.getPrice())
			return true;
		else
			return false;
	}
	
	
}
