package es.iessoterohernandez.daw.endes.boletinJUnitBorja2;

import java.text.*;
/******************************************************************
* BadMoney program
* This program demonstrates the inaccuracies that can occur from
* using a floating point variable to represent money.
* NO user input of data is required.
* @author J. Dalbey   2/7/2000
* Assignment: Examine the code and write down your prediction of the output.
*    Then compile and execute the program to obtain the actual results.
*    If your prediction was incorrect, research the cause and write up a
*    detailed technical explanation for the observed results.
******************************************************************/

public class BadMoney
{

public static void main(String[] args)
{
    // Example 1
    float originalPrice = 400000.00f;
    // to make the price more attractive, we'll reduce it to $399999.95
    float reducedPrice = originalPrice - 0.05f;
    float discount = originalPrice - reducedPrice;
    // Display discount amount
    System.out.println("Discount is: " + discount);  

    // Example 2
    // The amount you have in the bank: $12,345,678.12
    float principal = 12345678.12f;
    int count;    // count number of iterations
    NumberFormat fmt = NumberFormat.getCurrencyInstance();  // for output formatting.

    // Display the original amount
    System.out.println( "The original principal is "
         + fmt.format(principal) + ".");

    // Add a dime to the principal a thousand times
    for (count = 1; count <= 1000; count = count + 1)
    {
    	principal = principal + .10f;
    }

    // The result should be 100 dollars larger.
    System.out.println( "The new principal is "
         + fmt.format(principal) + ".");  

    // Example 3 
    double FloatNumber = 4.35;
    int IntegerNumber = (int) (100 * FloatNumber);  
    System.out.println("Computation result is " + IntegerNumber);             

}
}