
/*
 * Class: CMSC203-32689
 * Instructor: Professor Grigoriy Grinberg
 * Description: A Cryptography Encode/Decode
 * Due: 03/16/2024
 * Platform/compiler:Java Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Min Hein Khant
*/


/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	public static boolean isStringInBounds(String plainText) {
	    for (int i = 0; i < plainText.length(); i++) {
	        char ch = plainText.charAt(i);
	        if (!(ch >= LOWER_RANGE && ch <= UPPER_RANGE)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	/**
	 * Encrypts a plaintext string using the Caesar Cipher. Each character in the plaintext
	 * is shifted forward by a number of places defined by the key. If the shifted character
	 * goes beyond the UPPER_RANGE, it wraps around starting from the LOWER_RANGE.
	 *
	 * @param plainText The uppercase string to be encrypted.
	 * @param key       The integer that specifies the offset for each character.
	 * @return The encrypted string, or an error message if the input string is out of bounds.
	 */
	
	public static String caesarEncryption(String plainText, int key) {
		if (!isStringInBounds(plainText)) {
	        return "The selected string is not in bounds, Try again.";
	    }
		String encryptedText = "";
	    for (int i = 0; i < plainText.length(); i++) {
	        char ch = plainText.charAt(i);
	        int shiftedValue = ((ch - LOWER_RANGE + key) % RANGE) + LOWER_RANGE;
	        encryptedText += (char) shiftedValue;
	    }
	    return encryptedText;

	}
	
	/**
	 * Encrypts a plaintext string using the Bellaso Cipher. Each character in the plaintext
	 * is shifted according to the ASCII value of the corresponding character in the keyword.
	 * The keyword is repeated or truncated to match the length of the plaintext.
	 *
	 * @param plainText The uppercase string to be encrypted.
	 * @param bellasoStr The keyword string that specifies the offset for each character.
	 * @return The encrypted string, or an error message if the input string is out of bounds.
	 */
	
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		if (!isStringInBounds(plainText)) {
	        return "The selected string is not in bounds, Try again.";
	    }
		
		String encryptedText = "";
	    for (int i = 0; i < plainText.length(); i++) {
	        char ch = plainText.charAt(i);
	        char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
	        int shiftedValue = ch + bellasoChar;
	        while (shiftedValue > UPPER_RANGE) {
	            shiftedValue -= RANGE;
	        }
	        encryptedText += (char) shiftedValue;
	    }
	    return encryptedText;
	}

	/**
	 * Decrypts an encrypted string using the Caesar Cipher. Each character in the encrypted
	 * text is shifted backward by the number of places defined by the key to restore the
	 * original plaintext.
	 *
	 * @param encryptedText The encrypted string to be decrypted.
	 * @param key           The integer that specifies the offset used during encryption.
	 * @return The decrypted plaintext string.
	 */
	
	public static String caesarDecryption(String encryptedText, int key) {
	    String decryptedText = "";
	    for (int i = 0; i < encryptedText.length(); i++) {
	        char ch = encryptedText.charAt(i);
	        int adjustedKey = key % RANGE;
	        int shiftedValue = ((ch - LOWER_RANGE - adjustedKey + RANGE) % RANGE) + LOWER_RANGE;
	        decryptedText += (char)shiftedValue;
	    }
	    return decryptedText;
	}

	/**
	 * Decrypts an encrypted string using the Bellaso Cipher. Each character in the encrypted
	 * text is shifted back according to the ASCII value of the corresponding character in
	 * the keyword used during encryption. The keyword is repeated or truncated to match the
	 * length of the encrypted text.
	 *
	 * @param encryptedText The encrypted string to be decrypted.
	 * @param bellasoStr    The keyword string used during encryption.
	 * @return The decrypted plaintext string.
	 */
	
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
	    String decryptedText = "";
	    for (int i = 0; i < encryptedText.length(); i++) {
	        char ch = encryptedText.charAt(i);
	        char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
	        int shiftedValue = ch - bellasoChar;
	        while (shiftedValue < LOWER_RANGE) {
	            shiftedValue += RANGE;
	        }
	        decryptedText += (char)shiftedValue;
	    }
	    return decryptedText;
	}
	
}

/*
System.out.println("Name: Min Hein Khant");
System.out.println("Due Date: 03/18/2024");
System.out.println("Professor: Professor Grigoriy Grinberg");
System.out.println("Class: CMSC203-32689");
*/

