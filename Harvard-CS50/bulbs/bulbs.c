#include <cs50.h>
#include <stdio.h>
#include <string.h>

const int BITS_IN_BYTE = 8;

void print_bulb(int bit);
unsigned int_to_int(unsigned k);
bool byte[] = { 0, 0, 0, 0, 0, 0, 0, 0};

void int_to_byte(int value);

int main(void)
{
    // Get the message from user
    string s = get_string("Message: ");

    // Iterate each char of string;
    for (int i = 0, n = strlen(s); i < n; i++)
    {
        // Get int of char
        // Transform into a byte
        int_to_byte(s[i]);

        // Print each byte into a line and bit into a column
        for (int j = 0; j < 8; j++)
        {
            print_bulb(byte[j]);
        }
        printf("\n");
    }
}

void print_bulb(int bit)
{
    if (bit == 0)
    {
        // Dark emoji
        printf("\U000026AB");
    }
    else if (bit == 1)
    {
        // Light emoji
        printf("\U0001F7E1");
    }
}

void int_to_byte(int value)
{
    for (int i = 7; i >= 0; i--)
    {
        if (value == 1 || value == 0)
        {
            byte[i] = value;
            value = -1;
        }
        else if (value == -1)
        {
            byte[i] = false;
            break;
        }
        else
        {
            byte[i] = (value % 2);
            value = value / 2;
        }
    }
}