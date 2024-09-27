import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Quel est le message que vous voulez chiffrer?");
        String currentChar = scan.nextLine();
        scan.close();

        String encryptedMessage = encrypt(currentChar);
        System.out.println("Message chiffré : " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Message déchiffré : " + decryptedMessage);
    }

    public static String encrypt(String plainText) {
        StringBuilder encrypted = new StringBuilder();
        int shift = 3;

        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);

            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                currentChar = (char) ((currentChar + shift - base) % 26 + base);
            }
            encrypted.append(currentChar);
        }

        return encrypted.toString();
    }

    public static String decrypt(String encryptedText) {
        StringBuilder decrypted = new StringBuilder();
        int shift = 3;

        for (int i = 0; i < encryptedText.length(); i++) {
            char currentChar = encryptedText.charAt(i);

            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                currentChar = (char) ((currentChar - shift - base + 26) % 26 + base);
            }
            decrypted.append(currentChar);
        }

        return decrypted.toString();
    }
}
