

#include <cs50.h>
#include <stdio.h>

int main(void)
{
    //Get name
    string name = get_string("What's your name? ");

    //Print name
    printf("hello, %s\n", name);
}