#include <cs50.h>
#include <stdio.h>
#include <math.h>

int main(void)
{
    // Prompt user for credit card number
    long card_number = get_long("Number: ");

    // Initialize variables for card type and number of digits
    int card_type = 0;
    int num_digits = 1;
    int first_digits = 0;

    // Get number of digits and card type
    long temp = card_number;
    while (temp > 0)
    {
        //get the last digit of the credit card number
        int digit = temp % 10;

        //if digits in the credit card number is even then multiplies digit by 2.
        if (num_digits % 2 == 0 && num_digits != 0)
        {
            digit *= 2;
            //If the result of the multiplication is greater than 9, it calculates the sum of the digits of the result and assigns it back to digit.
            if (digit > 9)
            {
                digit = ((digit / 10) + (digit % 10));
            }
        }
        card_type += digit;

        //count number of digits
        num_digits++;
        //
        temp /= 10;
    }
    num_digits--;

    // Check if card is valid All American Express numbers start with 34 or 37;
    //most MasterCard numbers start with 51, 52, 53, 54, or 55; and all Visa numbers start with 4.
    if (card_type % 10 == 0)
    {
        //get the first 2 numbers of card_number to test
        long test = card_number;
        int n = num_digits;
        while (n > 2)
        {
            test = test / 10;
            n--;
        }

        //Test company of card American Express uses 15-digit numbers. MasterCard uses 16-digit numbers, and Visa uses 13- and 16-digit numbers.
        if ((test == 34 || test == 37) && num_digits == 15)
        {
            printf("AMEX\n");
        }
        else if ((test == 51 || test == 52 || test == 53 || test == 54 || test == 55) && num_digits == 16)
        {
            printf("MASTERCARD\n");
        }
        else if (((test / 10) == 4) && (num_digits == 13 ||  num_digits == 16))
        {
            printf("VISA\n");
        }
        else
        {
            printf("INVALID\n");
        }
    }
    else
    {
        printf("INVALID\n");
    }
}