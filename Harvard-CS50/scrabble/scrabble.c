#include <ctype.h>
#include <cs50.h>
#include <stdio.h>
#include <string.h>

// Points assigned to each letter of the alphabet
int POINTS[] = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

int compute_score(string word);

int main(void)
{
    // Get input words from both players
    string word1 = get_string("Player 1: ");
    string word2 = get_string("Player 2: ");

    // Score both words
    int score1 = compute_score(word1);
    int score2 = compute_score(word2);
    int k = 0;

    // Print the winner
    if (score1 > score2)
    {
        k = 1;
    }
    else if (score1 < score2)
    {
        k = 2;
    }
    if (k == 0)
    {
        printf("Tie!\n");
        return 0;
    }
    printf("Player %i Wins!\n", k);

}

int compute_score(string word)
{
    // Compute and return score for string
    int sum = 0;

    // Iterate through each letter and sum points
    for (int i = 0, n = strlen(word); i < n; i++)
    {
        // Change all letters to uppercase
        int temp = toupper(word[i]);
        temp -= 65;

        // Check if letter
        if (temp >= 0 && temp <= 25)
        {
            sum += POINTS[temp];
        }
    }
    // return sum
    return sum;
}
