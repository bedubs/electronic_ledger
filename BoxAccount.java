import javax.swing.JOptionPane;

public class BoxAccount
{

    public static void main( String[] args )
    {

	String savingsBalanceString;
	String checkingBalanceString;
	double savingsBalance = 0;
	double checkingBalance =0;	
	int menuChoice = 0;
	int accountOpt = 0, transferOpt = 0;

	savingsBalanceString = JOptionPane.showInputDialog( "Savings", "Please enter your savings balance: " );
	savingsBalance = Double.parseDouble( savingsBalanceString );

	Account savings = new Account( savingsBalance );

	checkingBalanceString = JOptionPane.showInputDialog( "Checking", "Now enter your checking account balance: " );
	checkingBalance = Double.parseDouble( checkingBalanceString );

	Account checking = new Account( checkingBalance );

	JOptionPane.showMessageDialog( null, "Your savings account balance is: " + savings.getBalance() + "\nYour checking account balance is: " + checking.getBalance() + "\nTotal: " + total( savings.getBalance(), checking.getBalance() ), "Balance", JOptionPane.PLAIN_MESSAGE );

	menuChoice = menu();
	while( menuChoice != 5 )
	{
	    double howMuch = 0.0;  	  
	  
	    switch( menuChoice )
	    {

	    case 1: 
		do
	    	{
	    	String accountOptString = JOptionPane.showInputDialog( "Select an account: \n\t1. Savings\n\t2. Checking" );
	    	accountOpt = Integer.parseInt( accountOptString );
	    	}while( accountOpt < 1 || accountOpt > 2 );

	        String howMuchDeposit = JOptionPane.showInputDialog( "How much are you depositing?" );
		howMuch = Double.parseDouble( howMuchDeposit );
	
		if( accountOpt == 1 )
		{
		    savings.credit( howMuch );
		    JOptionPane.showMessageDialog( null, savings.getBalance() );
		}
		else
		{
		    checking.credit( howMuch );
		    JOptionPane.showMessageDialog( null, checking.getBalance() );
		}

		break;

	    case 2:
		do
	    	{
	    	String accountOptString = JOptionPane.showInputDialog( "Select an account: \n\t1. Savings\n\t2. Checking" );
	    	accountOpt = Integer.parseInt( accountOptString );
	    	}while( accountOpt < 1 || accountOpt > 2 );

		String howMuchWithdraw = JOptionPane.showInputDialog( "How much are you withdrawing?" );
		howMuch = Double.parseDouble( howMuchWithdraw );

		if( accountOpt == 1 )
		{
		    if( howMuch > savings.getBalance() )
		    {
		        JOptionPane.showMessageDialog( null, "Sorry, the account balance is not sufficient to complete this transaction." );
		    }
		    else
		    {
		        savings.withdraw( howMuch );
		        JOptionPane.showMessageDialog( null, savings.getBalance() );
		    }
		}				
		else
		{
		    if( howMuch > checking.getBalance() )
		    {
  	       	        JOptionPane.showMessageDialog( null, "Sorry, the account balance is not sufficient to complete this transaction." );
		    }
		    else
		    {
		        checking.withdraw( howMuch );
		        JOptionPane.showMessageDialog( null, checking.getBalance() );
		    }

	        }

		break;
	
	    case 3:
		do
		{
		    String transferOptString = JOptionPane.showInputDialog( "How would you like to transfer funds?\n\t1. From Checking to Savings\n\t2. From Savings to Checking" );
		    transferOpt = Integer.parseInt( transferOptString );
		}while( transferOpt < 1 || transferOpt > 2 );

		    String howMuchString = JOptionPane.showInputDialog( "How much would you like to transfer?" );
		    howMuch = Double.parseDouble( howMuchString );

		    if( transferOpt == 1 )
		    {
			if( howMuch > checking.getBalance() )
			{
			    JOptionPane.showMessageDialog( null, "Sorry, the account balance is not sufficient to complete this transaction." );
			}
			else
			{
			    checking.transfer( savings, howMuch );
			}
		    }
		    else
		    {
			if( howMuch > savings.getBalance() )
			{
			    JOptionPane.showMessageDialog( null, "Sorry, you do not have sufficient funds to complete this transaction." );
			}
			else
			{
		     	    savings.transfer( checking, howMuch );
			}
		    }



		break;

	    case 4:
		JOptionPane.showMessageDialog( null, "Savings: " + savings.getBalance() + "\nChecking: " + checking.getBalance() + "\nTotal: " + total( savings.getBalance(), checking.getBalance() ) );

		break;

	    }
		
	    
	    menuChoice = menu();
	}
    }

    public static int menu()
    {
	
	int choice = 0;
	
	do
	{
	    String menuOpt = JOptionPane.showInputDialog( "Choose what you would like to do: \n\t1. Make a deposit\n\t2. Make a withdrawal \n\t3. Transfer funds\n\t4. Get account balance\n\t5. Exit" );
	    choice = Integer.parseInt( menuOpt );
	}while( choice > 5 || choice < 1 );

	return choice;    
    }

    public static double total( double savings, double checking )
    {

	double totalIt = savings + checking;
	return totalIt;
    }
}
