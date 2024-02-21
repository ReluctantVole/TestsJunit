package es.iessoterohernandez.daw.endes.boletinJUnitBorja2;

import java.text.NumberFormat;

/**
 * Account is a bank account with basic services for deposit,
 * withdrawal, and interest.
 */
public class Account
{
    private NumberFormat fmt = NumberFormat.getCurrencyInstance();

    private final float kInterestRate = 0.045f;  // interest rate of 4.5%

    private long acctNumber;
    private float balance;
    public final String name;

    /**
     * Sets up the account by defining its owner, account number,
     * and initial balance.
     * @param owner name of account holder
     * @param account the account number, an identifier for the account
     * @param initial the initial amount of money in the account.
     */
    public Account(String owner, long account, float initial)
    {
        name = owner;
        acctNumber = account;
        balance = initial;
    }

    /**
     *  Deposit the specified amount into the account. 
     *  @param amount value to be added to the balance
     *  @return true if amount is non-negative, false if amount 
     *  is negative; indicates balance was not changed.
     */
    public boolean deposit(float amount)
    {
        boolean result = true;
        // is amount invalid?
        if (amount < 0)  
        {
            result = false;
        }
        else
        {
            balance = balance + amount;
        }

        return result;
    }

    /**
     *  Withdraw the specified amount from the account,
     *  unless amount is negative, fee is negative, or
     *  amount exceeds current balance. 
     *  @param amount value to be deducted from the balance
     *  @param fee the transaction fee debited from the account
     *  @return true if transaction was successful, false otherwise;
     */
    public boolean withdraw(float amount, float fee)
    {
        // validate parameters
        if (isValidWithdrawl(amount, fee))
        {
            amount += fee;
            balance = balance - amount;
        }
        return isValidWithdrawl(amount, fee);
    }

    /* Determine if withdrawal parameters are valid */
    private boolean isValidWithdrawl(float amount, float fee)
    {
        return amount >= 0 && fee >= 0 && amount <= balance;
    }

    /**
     *  Adds interest to the account.
     */
    public void addInterest()
    {
        balance += (balance * kInterestRate);
    }

    /**
     * Accessor to the current balance of the account.
     * @return the current balance of the account.
     */
    public float getBalance()
    {
        return balance;
    }

    /**
     *  Accessor to the account number.
     * @return the account number.
     */
    public long getAccountNumber()
    {
        return acctNumber;
    }

    /**
     *  Returns a one-line description of the account as a string.
     *  @return formatted account information
     */
    public String toString()
    {
        return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
    }
}