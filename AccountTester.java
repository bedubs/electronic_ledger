import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Date;

public class AccountTester
{

    public static void main( String[] args ) throws Exception
    {

	String fileName = new Date() + ".txt";
	Date date = new Date();
	PrintWriter output = new PrintWriter( fileName );
	Scanner input = new Scanner( System.in );
	double savingsBalance = 0;
	double checkingBalance =0;
	int menuChoice = 0;
	int accountOpt = 0, transferOpt = 0;
	String test = "\t\tTest program for creating an account record";

	output.print( test );
	output.print( "\n\nThis file was created on: " );
	output.print(  date );

	System.out.println( "Please enter your savings balance: " );
	savingsBalance = input.nextDouble();

	Account savings = new Account( savingsBalance );

	System.out.println( "Now enter your checking account balance: " );
	checkingBalance = input.nextDouble();

	Account checking = new Account( checkingBalance );

	System.out.println( "Your savings account balance is: " + savings.getBalance() );
	System.out.println( "Your checking account balance is: " + checking.getBalance() );

	menuChoice = menu();
	while( menuChoice != 5 )
	{
	    double howMuch = 0.0;  	  
	  
	    switch( menuChoice )
	    {

	    case 1: 
		do
	    	{
	    	System.out.println( "Select an account: \n\t1. Savings\n\t2. Checking" );
	    	accountOpt = input.nextInt();
	    	}while( accountOpt < 1 || accountOpt > 2 );

	        System.out.println( "How much are you depositing?" );
		howMuch = input.nextDouble();
	
		if( accountOpt == 1 )
		{
		    savings.credit( howMuch );
		    System.out.println( savings.getBalance() );
		}
		else
		{
		    checking.credit( howMuch );
		    System.out.println( checking.getBalance() );
		}

		break;

	    case 2:
		do
	    	{
	    	System.out.println( "Select an account: \n\t1. Savings\n\t2. Checking" );
	    	accountOpt = input.nextInt();
	    	}while( accountOpt < 1 || accountOpt > 2 );

		System.out.println( "How much are you withdrawing?" );
		howMuch = input.nextDouble();

		if( accountOpt == 1 )
		{
		    savings.withdraw( howMuch );
		    System.out.println( savings.getBalance() );
		}				
		else
		{
		    checking.withdraw( howMuch );
		    System.out.println( checking.getBalance() );
	        }

		break;
	
	    case 3:
		System.out.println( "How would you like to transfer funds?\n\t1. From Checking to Savings\n\t2. From Savings to Checking" );
		transferOpt = input.nextInt();

		System.out.println( "How much would you like to transfer?" );
		howMuch = input.nextDouble();

		if( transferOpt == 1 ) checking.transfer( savings, howMuch );
		if( transferOpt == 2 ) savings.transfer( checking, howMuch );

		break;

	    case 4:
		System.out.println( "Savings: " + savings.getBalance() );
		System.out.println( "Checking: " + checking.getBalance() );

		break;

	    }
		
	    
	    menuChoice = menu();

	}

	output.print( "\n\n\tChecking: " + checking.getBalance() + "\n\tSavings: " + savings.getBalance() );
	output.close();

    }

    public static int menu()
    {
	
	Scanner input = new Scanner( System.in );
	int choice = 0;
	
	do
	{
	    System.out.println( "Choose what you would like to do: \n\t1. Make a deposit\n\t2. Make a withdrawal \n\t3. Transfer funds\n\t4. Get account balance\n\t5. Exit" );
	    choice = input.nextInt();
	}while( choice > 5 || choice < 1 );

	return choice;    
    }
}
