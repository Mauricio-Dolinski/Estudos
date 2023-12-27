#include <stdio.h>
#include <stdlib.h>

#define BLOCK_SIZE 512   // block size for reading data
#define FILENAME_SIZE 8  // size of the filename for each JPEG file

int main(int argc, char *argv[])
{
    // Check for correct number of command line arguments
    if (argc != 2)
    {
        fprintf(stderr, "Usage: recover image\n");
        return 1;
    }

    // Open input file
    FILE *input_file = fopen(argv[1], "r");
    if (input_file == NULL)
    {
        fprintf(stderr, "Could not open %s.\n", argv[1]);
        return 1;
    }

    // Initialize variables
    unsigned char block_buffer[BLOCK_SIZE];  // buffer for reading block data
    int file_counter = 0;  // count of the number of JPEG files recovered
    char filename[FILENAME_SIZE];  // buffer for storing the name of each JPEG file
    FILE *output_file = NULL;  // pointer to the output file for writing

    // Iterate through the input file until the end of the card
    while (fread(block_buffer, BLOCK_SIZE, 1, input_file) == 1)
    {
        // Check for start of new JPEG
        if (block_buffer[0] == 0xff && block_buffer[1] == 0xd8 && block_buffer[2] == 0xff && (block_buffer[3] & 0xf0) == 0xe0)
        {
            // Close previous file if one exists
            if (output_file != NULL)
            {
                fclose(output_file);
            }

            // Create new file
            sprintf(filename, "%03i.jpg", file_counter);  // create the filename
            output_file = fopen(filename, "w");  // open the output file
            if (output_file == NULL)
            {
                fclose(input_file);
                fprintf(stderr, "Could not create %s.\n", filename);
                return 1;
            }

            // Increment file counter
            file_counter++;
        }

        // Write to output file if it exists
        if (output_file != NULL)
        {
            fwrite(block_buffer, BLOCK_SIZE, 1, output_file);
        }
    }

    // Close input and output files
    fclose(input_file);
    if (output_file != NULL)
    {
        fclose(output_file);
    }

    // Success
    return 0;
}