import java.util.Scanner;

public class Main {

    public static int k1;
    public static int k2;
    public static int n;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String menu = "\n"
                    + "|----------------- MENU ----------------|\n"
                    + "|                                       |\n"
                    + "|    [1] Algorithm Definition           |\n"
                    + "|    [2] Encrypt                        |\n"
                    + "|    [3] Decryption                     |\n"
                    + "|    [4] Tests                          |\n"
                    + "|    [5] Exit                           |\n"
                    + "|                                       |\n"
                    + "|---------------------------------------|\n";

            System.out.print(menu);
            System.out.print("Choose the option [1-5]:\n>: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("\nAlgorithm Definition:");
                    System.out.println("This algorithm encrypts and decrypts text using a combination of substitution and transposition.");
                    System.out.println("1. Substitution: Each letter is shifted by a given key value (key 1 for even positions, key 2 for odd positions).");
                    System.out.println("2. Transposition: The encrypted text is then arranged into a matrix with a specified number of columns. The text is read row by row to form the final encrypted message.");
                    System.out.println("3. Decryption: The process is reversed by first arranging the encrypted text back into the matrix, then reading it column by column to retrieve the original order, and finally applying the inverse substitution keys.");
                    System.out.println("Special characters are removed before encryption to ensure only valid letters are processed.");
                    break;
                case 2:
                    System.out.print("Enter a text to encrypt: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter a key 1: ");
                    k1 = scanner.nextInt();
                    System.out.print("Enter a key 2: ");
                    k2 = scanner.nextInt();
                    System.out.print("Enter a number: ");
                    n = scanner.nextInt();
                    String textClean = validation(text).toString();
                    String result = Algorithm.insertEncryption(textClean, k1, k2, n);
                    System.out.println("Encrypted text: " + result);
                    break;
                case 3:
                    System.out.print("Enter a text to decrypt: ");
                    String text2 = scanner.nextLine();
                    System.out.print("Enter a key 1: ");
                    k1 = scanner.nextInt();
                    System.out.print("Enter a key 2: ");
                    k2 = scanner.nextInt();
                    System.out.print("Enter a number: ");
                    n = scanner.nextInt();
                    String textClean2 = validation(text2).toString();
                    String result2 = Algorithm.decryption(textClean2, n,k1 ,k2);
                    System.out.println("Decrypted text: " + result2);
                    break;
                case 4:
                    k1 = 3;
                    k2 = 5;
                    n = 2;

                    String textTest1 = "HELLO";
                    System.out.println("----------------- TEST 1 ----------------");
                    System.out.println("Text to encrypt: " + textTest1);
                    System.out.println("Key 1: (" + k1 + "), Key 2: (" + + k2 + "), Number: (" + n + ")");
                    String textTestClean1 = validation(textTest1).toString();
                    String resultTest1 = Algorithm.insertEncryption(textTestClean1, k1, k2, n);
                    System.out.println("Encrypted text: " + resultTest1);

                    String textTest2 = resultTest1;
                    System.out.println("----------------- TEST 2 ----------------");
                    System.out.println("Text to decrypt: " + textTest2);
                    System.out.println("Key 1: (" + k1 + "), Key 2: (" + + k2 + "), Number: (" + n + ")");
                    String textTestClean2 = validation(textTest2).toString();
                    String resultTest2 = Algorithm.decryption(textTestClean2, n,k1 ,k2);
                    System.out.println("Decrypted text: " + resultTest2);

                    String textTest3 = "HEll?O I aM LLu%NA@";
                    System.out.println("----------------- TEST 3 ----------------");
                    System.out.println("Text to encrypt: " + textTest3);
                    System.out.println("Key 1: (" + k1 + "), Key 2: (" + + k2 + "), Number: (" + n + ")");
                    String textTestClean3 = validation(textTest3).toString();
                    String resultTest3 = Algorithm.insertEncryption(textTestClean3, k1, k2, n);
                    System.out.println("Encrypted text: " + resultTest3);

                    String textTest4 = resultTest3;
                    System.out.println("----------------- TEST 4 ----------------");
                    System.out.println("Text to decrypt: " + textTest4);
                    System.out.println("Key 1: (" + k1 + "), Key 2: (" + + k2 + "), Number: (" + n + ")");
                    String textTestClean4 = validation(textTest4).toString();
                    String resultTest4 = Algorithm.decryption(textTestClean4, n,k1 ,k2);
                    System.out.println("Decrypted text: " + resultTest4);
                    break;
                case 5:
                    System.out.println("Leaving...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Valida y limpia el texto
    public static StringBuilder validation(String word) {
        StringBuilder cleanInput = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toUpperCase(word.charAt(i)); // Convierte a mayúscula
            if (!Algorithm.isSpecialCharacter(c)) {
                cleanInput.append(c);
            }
        }
        return cleanInput;
    }

}