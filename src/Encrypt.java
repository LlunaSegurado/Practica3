public class Encrypt {

    // Inserta el texto cifrado con dos claves diferentes y realiza una transposición de columnas
    // Dependiendo de la posición de la letra en la palabra, la cuenta como par o impar (empieza en 0)
    public static String insertEncryption(String text, int k1, int k2, int columns) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();


        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                even.append(text.charAt(i));
            } else {
                odd.append(text.charAt(i));
            }
        }

        // Texto cifrado pero separado por las posiciones pares e impares con claves diferentes
        String encryptionEven = Algorithm.encryption(even.toString(), k1);
        String encryptionOdd = Algorithm.encryption(odd.toString(), k2);
        String encryptedText = "";

        int oddIndex = 0;
        int evenIndex = 0;

        // Combina los textos cifrados de las posiciones pares e impares
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                encryptedText += encryptionEven.charAt(evenIndex++);
            } else {
                encryptedText += encryptionOdd.charAt(oddIndex++);
            }
        }
        return Algorithm.transpositionColumns(encryptedText, columns);
    }
}
