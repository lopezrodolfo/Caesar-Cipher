# Caesar Cipher Program

## Description

The Caesar Cipher program is a simple implementation of the Caesar cipher encryption technique. It allows users to encode and decode messages using a series of key values (positive or negative integers). The program prompts the user for input, processes the data, and displays the encoded and decoded messages.

## Author

Rodolfo Lopez

## Date

2/13/21

## Features

- User-friendly input prompts for key values and plain text.
- Encoding and decoding of messages based on user-defined key values.
- Ability to run the program multiple times without restarting.

## How It Works

1. **Input Key Values**: The user is prompted to enter a series of integers (key values) that determine the shift for encoding.
2. **Input Plain Text**: The user enters the string they wish to encode.
3. **Encoding**: The program shifts each character in the plain text according to the key values and generates the encoded message.
4. **Decoding**: The encoded message can be decoded back to the original plain text using the same key values.
5. **Repeat**: The user can choose to run the program again or exit.

## Usage

1. Compile the `CaesarCipher.java` file:
   ```bash
   javac CaesarCipher.java
   ```
2. Run the program:
   ```bash
   java CaesarCipher
   ```

## Example

Enter the individual key values (positive or negative integers, one after another in the same line with a blank between two values):
3 -1
Enter a string to be encoded:
Hello World
The encoded message:
Khoor Zruog
The decoded message:
Hello World
Do you want to run the program again (y for yes and n for no)?:
n
