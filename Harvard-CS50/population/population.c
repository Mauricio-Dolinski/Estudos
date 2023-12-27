#include <cs50.h>
#include <stdio.h>

int startSize(void);
int endSize(int sSize);
int get_years(int s, int e);
void print(int years);

int main(void)
{
    // TODO: Prompt for start size
    int sSize = startSize();

    // TODO: Prompt for end size
    int eSize = endSize(sSize);

    // TODO: Calculate number of years until we reach threshold
    int n = get_years(sSize, eSize);

    // TODO: Print number of years
    print(n);
}

//Start size Function
int startSize(void)
{
    int startSize;
    do
    {
        startSize = get_int("Start size: ");
    }
    while (startSize < 9);
    return startSize;
}

//End size Function
int endSize(int sSize)
{
    int endSize;
    do
    {
        endSize = get_int("End size: ");
    }
    while (endSize < sSize);
    return endSize;
}

//Get years Function
int get_years(int s, int e)
{
    int n;
    for (n = 0; s < e; n++)
    {
        int temp = s;
        s += temp / 3;
        s -= temp / 4;
    }
    return n;
}

//Print Function
void print(int years)
{
    printf("Years: %i\n", years);
}