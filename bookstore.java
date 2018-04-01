/**
*Name and ID: Felix Morin, 40063253
*Assignment 1
*Part 1: Book Class
*Due Date: January 31 2018
*
*The goal of this program is to allow the user to store information about books in a virtual bookstore, to change this information if needed, and to display
*information such as books by a requested author or all books under a certain price. 
 */

import java.util.Scanner;

public class bookstore {

	public static void main(String[] args) {
		
		Scanner keyIn = new Scanner(System.in);
		
		/**
		 * declaration of variables
		 * 
		 *@param maxBooks maximum number of books that can be created (input from user)
		 *@param choice indicates which action from the main menu to execute (input from user)
		 *@param password password that must be entered in order to access certain parts of the program
		 *@param attemptedPassword input from user that must be equal to the password 
		 *@param countTryPassword number of attempts to enter the password in a row (max 3)
		 *@param countOP1FailedAccess number of times the user is sent back to the main menu because of too many failed password attempts
		 *@param booksToCreate number of books to be created at once (input from user)    
		 *@param tempTitle variable to temporary store the title of a book in order to use it as a constructor parameter shortly after (input from user)
		 *@param tempAuthor variable to temporary store the author of a book in order to use it as a constructor parameter shortly after (input from user)    
		 *@param tempISBN variable to temporary store the ISBN of a book in order to use it as a constructor parameter shortly after (input from user)    
		 *@param tempPrice variable to temporary store the price of a book in order to use it as a constructor parameter shortly after (input from user)  
		 *@param choiceOP2 indicates which action from the menu within option 2 to execute (input from user)  
		 *@param bookUpdate number of the book to be modified within option 2   
		 */
		int maxBooks = 0;
		int choice = 0;
		final String password = "password";
		String attemptedPassword = "";
		int countTryPassword = 0;
		int countOP1FailedAccess = 0;
		int booksToCreate = 0;
		String tempTitle = "";
		String tempAuthor = "";
		long tempISBN = 0;
		double tempPrice = 0.0;
		int choiceOP2 = 0;
		int bookUpdate = 0;
		
		/**
		 * Welcome message
		 */
		System.out.println("Welcome to the bookstore software, which helps the owner to keep track of the books at the store.\n"); 
		
		/**
		 * Prompt user for maximum of books that can be created (maxBooks)
		 */
		System.out.println("Please enter the maximum number of books that the bookstore can contain: ");
		maxBooks = keyIn.nextInt();
		
		/**
		 * @param inventory array of Book objects with length equal to maxBooks
		 */
		Book inventory[] = new Book[maxBooks];
		
		/**
		 * Loop that keeps keeps coming back to the main menu until the user decides to quit the program (choice == 5)
		 */
		
		do {
		
			/**
			 * Reinitialize the number of attempts in a row to enter the password to 0
			 */
			countTryPassword = 0;
			
			/**
			 * Display the main menu
			 * Ask the user to choose an option and store his/her choice as an integer (1-5) in variable choice
			 */
			System.out.println("\nWhat do you want to do?\n\t1.\tEnter new books (password required)\n\t2.\tChange information of a book (password required)" +
					"\n\t3.\tDisplay all books by a specific author\n\t4.\tDisplay all books under a certain price\n\t5.\tQuit\nPlease enter your choice: ");
			choice = keyIn.nextInt();
		
			/**
			 * Make sure that the user's choice is from 1 to 5
			 * If it is not, ask for a new input until it is conform
			 */
			while(choice < 1 || choice > 5)
			{
				System.out.print("\nThe choice you entered is invalid. Please try again: ");
				choice = keyIn.nextInt();
			}
			
			/**
			 * If the user chooses option 1: 
			 */
			if(choice == 1)
			{
				/**
				 * Prompt user for password and store it in AttemptedPassword
				 * Increment the number of attempts by 1
				 */
				System.out.println("\nPlease enter your password: ");
				attemptedPassword = keyIn.next();
				countTryPassword++;
				
				/**
				 * If the password is not valid, ask the user to enter it again until it is either valid or 3 attempts have passed
				 */
				while(!attemptedPassword.equals(password) && countTryPassword<3)
				{
					System.out.println("The password you entered is invalid. Please retry: ");
					attemptedPassword = keyIn.next();
					countTryPassword++;
				}
				
				/**
				 * If the password is still not valid after 3 attempts, increment by 1 the number of times the user failed to access option 1
				 */
				if(!attemptedPassword.equals(password))
					countOP1FailedAccess++;
				
				/**
				 * If the number of times the user failed to access option 1 has reached 4, inform the user that the program will terminate and terminate it
				 */
				if(countOP1FailedAccess == 4)
				{
					System.out.print("Program detected suspicous activities and will terminate immediately!"); 
					System.exit(0);
				}
					
				/**
				 * If the user correctly entered the password:
				 */
				if(attemptedPassword.equals(password))
				{
					/**
					 * Ask the user for the number of books to create during this same access and store the number in booksToCreate
					 */
					System.out.println("Please enter the number of books you want to enter: ");
					booksToCreate = keyIn.nextInt(); 
					
					/**
					 * If the number entered above is less or equal than the maximum number of books left to create:
					 */
					if(booksToCreate<=maxBooks-Book.findNumberOfBooks())
					{
						/**
						 * One book at the time (for booksToCreate number of books), prompt the user for the title, author, ISBN, and price of the book to create,
						 *  and temporarily store the values in the respective variables. Then, create a new book within the inventory array.
						 */
						for(int i = 0; i<booksToCreate; i++)
						{
							System.out.println("Please enter the following information about book #" + (Book.findNumberOfBooks()) + ": ");
							System.out.println("Title: ");
							tempTitle = keyIn.nextLine();
							tempTitle = keyIn.nextLine();
							System.out.println("Author: ");
							tempAuthor = keyIn.nextLine();
							System.out.println("ISBN: ");
							tempISBN = keyIn.nextLong();
							System.out.println("Price: ");
							tempPrice = keyIn.nextDouble();
							
							inventory[Book.findNumberOfBooks()] = new Book(tempTitle, tempAuthor, tempISBN, tempPrice); 
						}
					}
					
					/**
					 * If the number of books to create is more than the maximum number of books left to create:
					 */
					else
					{
						/**
						 * Inform the user that only a maximum number of books can be created, and store this maximum in booksToCreate
						 */
						System.out.println("You cannot add that many books. You will only be able to add " + (maxBooks-Book.findNumberOfBooks()) + " books.");
						booksToCreate = (maxBooks-Book.findNumberOfBooks());
						
						/**
						 * One book at the time (for booksToCreate number of books), prompt the user for the title, author, ISBN, and price of the book to create,
						 *  and temporarily store the values in the respective variables. Then, create a new book within the inventory array.
						 */
						for(int i = 0; i<booksToCreate; i++)
						{
							System.out.println("Please enter the following information about book #" + (Book.findNumberOfBooks()) + ": ");
							System.out.println("Title: ");
							tempTitle = keyIn.nextLine();
							tempTitle = keyIn.nextLine();
							System.out.println("Author: ");
							tempAuthor = keyIn.nextLine();
							System.out.println("ISBN: ");
							tempISBN = keyIn.nextLong();
							System.out.println("Price: ");
							tempPrice = keyIn.nextDouble();
							
							inventory[Book.findNumberOfBooks()] = new Book(tempTitle, tempAuthor, tempISBN, tempPrice);
						}
					}
				}
			}
			
			/**
			 * If the user chooses option 2
			 */
			if(choice == 2)
			{
				/**
				 * Prompt user for password and store it in AttemptedPassword
				 * Increment the number of attempts by 1
				 */
				System.out.println("\nPlease enter your password: ");
				attemptedPassword = keyIn.next();
				countTryPassword++;
				
				/**
				 * If the password is not valid, ask the user to enter it again until it is either valid or 3 attempts have passed
				 */
				while(!attemptedPassword.equals(password) && countTryPassword<3)
				{
					System.out.println("The password you entered is invalid. Please retry: ");
					attemptedPassword = keyIn.next();
					countTryPassword++;
				}
				
				/**
				 * If the user correctly entered the password:
				 */
				if(attemptedPassword.equals(password))
				{
					/**
					 * Prompt the user for the number of the book (equal to its index in inventory array) he/she wants to modify, and store the value in bookUpdate
					 */
					System.out.println("Please enter the number of the book you want to update: ");
					bookUpdate = keyIn.nextInt();
					
					/**
					 * If the number entered does not correspond to the number of a book previously created, ask the user if he/she wants to go back to the main menu or to try another number (until it is valid) 
					 */
					while(bookUpdate<0 || bookUpdate > (Book.findNumberOfBooks()-1))
					{
						System.out.println("The number of the book you entered is invalid. Do you want want to re-enter another number? If not you will be brought back to the main menu.");
						if(keyIn.next().equalsIgnoreCase("yes"))
						{
							System.out.println("Please enter the number of the book you want to update: ");
							bookUpdate = keyIn.nextInt();
						}else
							break;	
					}
					
					/**
					 *If the number entered corresponds to the number of a book previously created:
					 */
					if(bookUpdate>=0 && bookUpdate<Book.findNumberOfBooks())
					{
						/**
						 * Loop that keeps keeps coming back to the option 2 menu until the user decides to quit this section (choiceOP2 == 5)
						 */
						
						do {
							/**
							 * Display the main menu for option 2
							 * Ask the user to choose an option and store his/her choice as an integer (1-5) in variable choiceOP2
							 */
							System.out.println("\n" + inventory[bookUpdate].toString());
							System.out.println("\nWhat information would you like to change?\n\t1.\tauthor\n\t2.\ttitle\n\t3.\tISBN\n\t4.\tprice\n\t5.\tQuit\nPlease enter your choice: ");
							choiceOP2 = keyIn.nextInt();
							
							/**
							 * Make sure that the user's choice is from 1 to 5
							 * If it is not, ask for a new input until it is conform
							 */
							while(choiceOP2 < 1 || choiceOP2 > 5)
							{
								System.out.print("The choice you entered is invalid. Please try again: ");
								choiceOP2 = keyIn.nextInt();
							}
							
							/**
							 * Depending on the user's choice, ask the user for a value to replace the old one, and complete the change using the corresponding mutator method from the Book class 
							 */
							switch(choiceOP2)
							{
							case 1:
								System.out.println("Enter the new author: ");
								tempAuthor = keyIn.nextLine();
								tempAuthor = keyIn.nextLine();
								inventory[bookUpdate].setAuthor(tempAuthor);
								break;
							case 2:
								System.out.println("Enter the new title: ");
								tempTitle = keyIn.nextLine();
								tempTitle = keyIn.nextLine();
								inventory[bookUpdate].setTitle(tempTitle);
								break;
							case 3:
								System.out.println("Enter the new ISBN: ");
								tempISBN = keyIn.nextLong();
								inventory[bookUpdate].setISBN(tempISBN);
								break;
							case 4:
								System.out.println("Enter the new price: ");
								tempPrice = keyIn.nextDouble();
								inventory[bookUpdate].setPrice(tempPrice);
								break;
							}
						
						}while(choiceOP2!=5);
					}
				}
			}
		
			/**
			 * If the user chooses option 3
			 */
			if(choice == 3)
			{
				/**
				 * Prompt the user for an author name and store it temporarily in tempAuthor 
				 */
				System.out.println("\nPlease enter the name of the author you are looking for: ");
				tempAuthor = keyIn.nextLine();
				tempAuthor = keyIn.nextLine();
				
				System.out.println();
				
				/**
				 * Display all books with the same other as entered above
				 */
				for(int i = 0; i<Book.findNumberOfBooks(); i++)
				{
					if(tempAuthor.equalsIgnoreCase(inventory[i].getAuthor()))
						System.out.println("\n" + inventory[i].toString());
				}
			}
			
			/**
			 * If the user chooses option 4
			 */
			if(choice == 4)
			{
				/**
				 * Prompt the user for a price and store it temporarily in tempPrice 
				 */
				System.out.println("\nPlease enter the maximum price you are looking for: ");
				tempPrice = keyIn.nextDouble();
				
				System.out.println();
				
				/**
				 * Display all books with a price lower or equal to the price entered above
				 */
				for(int i = 0; i<Book.findNumberOfBooks(); i++)
				{
					if(tempPrice>=inventory[i].getPrice())
						System.out.println("\n" + inventory[i].toString());
				}
			}
			
		}while(choice!=5);

		/**
		 * Once the user chooses option 5 (Quit the program):
		 * Closing message to show the user that the program is terminated
		 */
		
		System.out.print("\nThanks for using the bookstore software! Have a great day.");
		
		keyIn.close();
	}

}
