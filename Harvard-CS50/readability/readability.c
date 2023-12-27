#include <cs50.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

//Initialize global variables;
int letters = 0;
int sentences = 0;
int words = 0;
void count(string s);

int main(void)
{
    int index = 0;

    string str = get_string("Text: ");

    // count how many letters, sentences, and words.
    count(str);

    // MAKE index = 0.0588 * L - 0.296 * S - 15.8
    // L is the average number of letters per 100 words in the text,
    // and S is the average number of sentences per 100 words in the text.
    double L = (double) letters / (words) * 100;
    double S = (double) sentences / (words) * 100;
    index = round(0.0588 * L - 0.296 * S - 15.8);

    // Grade it!
    if (index >= 16)
    {
        printf("Grade 16+");
    }
    else if (index < 1)
    {
        printf("Before Grade 1");
    }
    else
    {
        printf("Grade %i", index);
    }
    printf("\n");
}


void count(string s)
{
    int lastLetter = -2;
    // Iterate through each letter and sum letters, sentences and words
    for (int i = 0, n = strlen(s); i < n; i++)
    {

        // Change all letters to uppercase
        s[i] = toupper(s[i]);

        // Check if letter
        if (s[i] >= 65 && s[i] <= 90)
        {
            letters++;
            lastLetter = i;
        }
        else
        {
            if (lastLetter >= 0 && lastLetter == i - 1 && s[i] != '\'' && s[i] != '-')
            {
                words++;
            }
            if (s[i] == '!' || s[i] == '.' || s[i] == '?')
            {
                sentences++;
            }
        }
    }
}