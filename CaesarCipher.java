/* 
Summary of the program: The user is prompted to enter key values (pos or neg integers seperated by spaces) followed by a string to be encoded. 
The program relies on the helper methods read_key_values() and read_plain text() to scan and store the user input. The program then passes these inputs
as parameters to the encode method which returns the encoded string based on the key values shift. The program displays the encoded message and then
calls the decode method passing in the same key values and the new encrypted message. The program then displays the decoded message and lastly asks 
the user if they would like to run the program again. 

Author names: Rodolfo Lopez

Last modified: 2/13/21
*/

import java.util.*;

class CaesarCipher { 

    static final int POS_OF_FIRST_ASCII_CHAR = 33; 
    static final int POS_OF_LAST_ASCII_CHAR = 126; 
    static final int NUM_OF_ASCII_CHARS = POS_OF_LAST_ASCII_CHAR - POS_OF_FIRST_ASCII_CHAR; 

    public static int[] read_key_values(Scanner kb) {
        /*
         * Scans user key value input
         * @return key value as int array 
         */

        System.out.println("Enter the individual key values (positive or negative integers, one after another in the same line with a blank between two values):");            
        
        String[] key_values_string = kb.nextLine().split(" "); //tokenize string input into string array
        
        int[] key_values = new int[key_values_string.length]; //declare int array to store key values 

        //convert and initialize string array elements into int array elements
        for(int i =0 ; i < key_values_string.length; i++) {
            key_values[i] = Integer.parseInt(key_values_string[i]); //string to integer
        }

        return key_values;
    }

    public static String read_plain_text(Scanner kb) {
        /*
         * Scans user string input for plain text
         * @return string value to be encoded
         */

        System.out.println("Enter a string to be encoded:"); 

        String plain_text = kb.nextLine(); //reads entire string message
        
        return plain_text;
    }
 
    public static String encode(int[] key_values, String plain_text) { 
        /*
         * Builds an encoded string where each character is mapped to a shift value
         * @param int array of key values
         * @param string of plain_text
         * @return encoded string
         */
        
        int key_values_index = 0; //initialize index for key values
        int shift_value = 0; //initialize shift value
        StringBuilder encoded_text = new StringBuilder(); //instantiate StringBuilder for encoded text

        //iterates over plain text string
        for (int i=0; i < plain_text.length(); i++) { 
            //accessess appropriate key value for shift
            shift_value = key_values[key_values_index]; 

            //appends blank spaces to StringBuilder for encoded text
            if(plain_text.charAt(i) == ' ') {           
                encoded_text.append(plain_text.charAt(i));
            }

            //appends shifted character to StringBuilder for encoded text
            else {
                    //cast shifted integer value into associated ASCII character
                    char encoded_char = (char)((plain_text.charAt(i) + shift_value - POS_OF_FIRST_ASCII_CHAR) % NUM_OF_ASCII_CHARS + POS_OF_FIRST_ASCII_CHAR); 
                    encoded_text.append(encoded_char); 
            } 

            //checks if there is only one key value or if the current key value is the last index
            if ((key_values.length == 1)||(key_values_index == key_values.length-1)) {   
                key_values_index = 0; //loop back around to first key value
                continue; // continue encrypting        
            }

            //increment key value if key values is greater than length one and key values index is not the last element
            key_values_index++; 
        }
        return encoded_text.toString(); 
    } 

    public static String decode(int[] key_values, String encoded_text) {
        /*
         * Utilizes encode method with a modified key values parameter to decode message
         * @param int array of key values
         * @param string of encoded_text
         * @return decoded string
         */

        //iterates over key values int array
        for(int i=0; i < key_values.length; i++) {   
            key_values[i] = NUM_OF_ASCII_CHARS - key_values[i]; //adjusts key values for decoding
        }

        //passes in updated key values and encoded text for decoding 
        String decoded_text = encode(key_values, encoded_text); 

        return decoded_text;
    }

    public static boolean run_caesar_cipher(Scanner kb) {
        /* Scans user string input about the run condition
         * @returns true to keep the program running and false to terminante the program
         */

        System.out.println("Do you want to run the program again (y for yes and n for no)?:");
        String run = kb.nextLine();
        
        //if the user enters "n" terminate the program
        if(run.equalsIgnoreCase("n")) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) { 
        /* The driver method for the Caesar Cipher. Utilizes read_key_values() and read_plain_text() to scan and save user input
         * Displays the encoded message entered by the user and displays the decoded message entered by the user based on the key values
         * Utilizes run_caesar_cipher() to allow the user to run more than once
         * @param String[] args
         * @return void
         */

        Scanner kb = new Scanner(System.in);
        boolean run = true; //program is running
        while(run) {
            int[] key_values = read_key_values(kb); //read key values
            String plain_text = read_plain_text(kb); //read plain_text
            String encoded_text = encode(key_values, plain_text); //encode plain text based on key values
            System.out.println("The encoded message:\n" + encoded_text); //dispay encoded text
            String decoded_text = decode(key_values, encoded_text); //decode encoded_text based on key values
            System.out.println("The decoded message:\n" + decoded_text); //display encoded text
            run = run_caesar_cipher(kb); //check run condition for program 
        }    
        kb.close();
    } 
} 