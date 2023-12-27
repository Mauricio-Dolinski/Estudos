#include <cs50.h>
#include <stdio.h>

void printHaches(int i);

int main(void)
{
    //TODO: Ask for user input for wall size
    int n;
    do
    {
        n = get_int("Size: ");
    }
    while (n < 1 || n > 8);

    //Print Mario Walls
    //new Line
    for (int i = 0; i < n; i++)
    {
        //print Spaces
        for (int k = 1; k < (n - i); k++)
        {
            printf(" ");
        }

        //print Haches
        printHaches(i);

        //print 2 Spaces
        printf("  ");

        //print Haches
        printHaches(i);

        //print new line
        printf("\n");
    }
}

//print Haches
void printHaches(int i)
{
    for (int l = 0; l < (i + 1); l++)
    {
        printf("#");
    }
}