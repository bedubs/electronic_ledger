
public class Account
{

    private double balance;

    public Account( double initialBalance )
    {
	if( initialBalance > 0 )
	{
	    this.balance = initialBalance;
	}
    }

    public double getBalance()
    {
	return this.balance;
    }

//    public double getTotal( Account checking, Account savings )
//    {
//	return checking.getBalance() + savings.getBalance();
//    }

    public void credit( double amount )
    {
	this.balance += amount;
    }

    public void withdraw( double amount )
    {
	if( this.balance > amount )
	{
	    this.balance -= amount;
	}
	else
	{
	    nsf();
	}
    }

    public void transfer( Account otherAccount, double amount )
    {
	if( this.balance > amount )
	{
	    this.balance -= amount;
	    otherAccount.balance += amount;
	}
	else
	{
	    nsf();
	}
    }

    public void nsf()
    {
	System.out.println( "Sorry, the account balance was not sufficient to complete this transaction." );
    }

   // public String toString()
    //{
//	return String.format( "Checking: " + %s + "\nSavings: " + %s + "\nTotal: " + %2d , 
  //  }
}
