#include "helpers.h"
#include <math.h>
#include <math.h>

// Convert image to grayscale
void grayscale(int height, int width, RGBTRIPLE image[height][width])
{
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            double avg = 0.0;
            int sum = (image[i][j].rgbtBlue + image[i][j].rgbtGreen + image[i][j].rgbtRed);
            avg = (sum + 0.0) / 3;
            avg = round(avg);

            image[i][j].rgbtBlue = avg;
            image[i][j].rgbtGreen = avg;
            image[i][j].rgbtRed = avg;
        }
    }
    return;
}

// Convert image to sepia
void sepia(int height, int width, RGBTRIPLE image[height][width])
{
    // Create a temporary copy of the image to avoid blurring pixels based on updated values from previous iterations.
    RGBTRIPLE temp_image[height][width];
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            temp_image[i][j] = image[i][j];
        }
    }

    // iterate pixels
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            BYTE originalBlue = temp_image[i][j].rgbtBlue;
            BYTE originalGreen = temp_image[i][j].rgbtGreen;
            BYTE originalRed = temp_image[i][j].rgbtRed;

            // Calculate sepia values using formula at filter-less site
            double sepiaRed = round(.393 * originalRed + .769 * originalGreen + .189 * originalBlue);
            double sepiaGreen = round(.349 * originalRed + .686 * originalGreen + .168 * originalBlue);
            double sepiaBlue = round(.272 * originalRed + .534 * originalGreen + .131 * originalBlue);

            // idd falues bigger than 255 set at 255
            if (sepiaRed > 255)
            {
                sepiaRed = 255;
            }
            if (sepiaGreen > 255)
            {
                sepiaGreen = 255;
            }
            if (sepiaBlue > 255)
            {
                sepiaBlue = 255;
            }

            // Set sepia values
            image[i][j].rgbtBlue = (BYTE) sepiaBlue;
            image[i][j].rgbtGreen = (BYTE) sepiaGreen;
            image[i][j].rgbtRed = (BYTE) sepiaRed;
        }
    }
    return;
}

// Reflect image horizontally
void reflect(int height, int width, RGBTRIPLE image[height][width])
{
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width / 2; j++)
        {
            // Swap RGB values
            RGBTRIPLE temp = image[i][j];
            image[i][j] = image[i][width - j - 1];
            image[i][width - j - 1] = temp;
        }
    }
    return;
}

// Blur image
void blur(int height, int width, RGBTRIPLE image[height][width])
{
    // Create a temporary copy of the image to avoid blurring pixels based on updated values from previous iterations.
    RGBTRIPLE temp_image[height][width];
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            temp_image[i][j] = image[i][j];
        }
    }

    // Loop through each pixel in the image.
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            // Initialize variables to store the sum and count of RGB values.
            double sum_red = 0.0;
            double sum_green = 0.0;
            double sum_blue = 0.0;
            int count = 0;

            // Loop through the surrounding pixels in a 3x3 box centered on the current pixel.
            for (int k = -1; k <= 1; k++)
            {
                for (int l = -1; l <= 1; l++)
                {
                    // Check if the surrounding pixel is within the bounds of the image.
                    if (i + k >= 0 && i + k < height && j + l >= 0 && j + l < width)
                    {
                        // Add the RGB values of the surrounding pixel to the corresponding sum variable.
                        sum_red += temp_image[i + k][j + l].rgbtRed;
                        sum_green += temp_image[i + k][j + l].rgbtGreen;
                        sum_blue += temp_image[i + k][j + l].rgbtBlue;

                        // Increment the count variable.
                        count++;
                    }
                }
            }

            // Calculate the average RGB values and set the current pixel to those values.
            image[i][j].rgbtRed = (BYTE) round(sum_red / count);
            image[i][j].rgbtGreen = (BYTE) round(sum_green / count);
            image[i][j].rgbtBlue = (BYTE) round(sum_blue / count);
        }
    }
    return;
}
