public class Tests {

    public static void runTests(int k1, int k2, int n) {
        String textTest1 = "HELLO";
        System.out.println("----------------- TEST 1 ----------------");
        System.out.println("Text to encrypt: " + textTest1);
        System.out.println("Key 1: (" + k1 + "), Key 2: (" + k2 + "), Number: (" + n + ")");
        String textTestClean1 = Main.validation(textTest1).toString();
        String resultTest1 = Encrypt.insertEncryption(textTestClean1, k1, k2, n);
        System.out.println("Encrypted text: " + resultTest1);

        String textTest2 = resultTest1;
        System.out.println("----------------- TEST 2 ----------------");
        System.out.println("Text to decrypt: " + textTest2);
        System.out.println("Key 1: (" + k1 + "), Key 2: (" + k2 + "), Number: (" + n + ")");
        String textTestClean2 = Main.validation(textTest2).toString();
        String resultTest2 = Decrypt.decryption(textTestClean2, n, k1, k2);
        System.out.println("Decrypted text: " + resultTest2);

        String textTest3 = "HEll?O I aM LLu%NA@";
        System.out.println("----------------- TEST 3 ----------------");
        System.out.println("Text to encrypt: " + textTest3);
        System.out.println("Key 1: (" + k1 + "), Key 2: (" + k2 + "), Number: (" + n + ")");
        String textTestClean3 = Main.validation(textTest3).toString();
        String resultTest3 = Encrypt.insertEncryption(textTestClean3, k1, k2, n);
        System.out.println("Encrypted text: " + resultTest3);

        String textTest4 = resultTest3;
        System.out.println("----------------- TEST 4 ----------------");
        System.out.println("Text to decrypt: " + textTest4);
        System.out.println("Key 1: (" + k1 + "), Key 2: (" + k2 + "), Number: (" + n + ")");
        String textTestClean4 = Main.validation(textTest4).toString();
        String resultTest4 = Decrypt.decryption(textTestClean4, n, k1, k2);
        System.out.println("Decrypted text: " + resultTest4);
    }
}
