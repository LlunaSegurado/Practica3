public class Decrypt {

    public static String decryption(String s, int columns, int k1, int k2) {

        int rows = (s.length() + columns - 1) / columns;
        char[][] matrix = new char[rows][columns];

        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (index < s.length()) {
                    matrix[row][col] = s.charAt(index++);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        // Lee la matriz columna por columna para revertir la transposición
        StringBuilder transposedText = new StringBuilder();
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                transposedText.append(matrix[row][col]);
            }
        }
        String transposedResult = transposedText.toString().trim();

        // Luego realiza la descodificación por sustitución
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();

        for (int i = 0; i < transposedResult.length(); i++) {
            if (i % 2 == 0) {
                even.append(transposedResult.charAt(i));
            } else {
                odd.append(transposedResult.charAt(i));
            }
        }

        // Descifra las posiciones pares e impares con las claves negativas
        String decryptedEven = Algorithm.encryption(even.toString(), -k1);
        String decryptedOdd = Algorithm.encryption(odd.toString(), -k2);
        String decryptedText = "";

        int oddIndex = 0;
        int evenIndex = 0;

        // Combina los textos descifrados de las posiciones pares e impares
        for (int i = 0; i < transposedResult.length(); i++) {
            if (i % 2 == 0) {
                decryptedText += decryptedEven.charAt(evenIndex++);
            } else {
                decryptedText += decryptedOdd.charAt(oddIndex++);
            }
        }
        return decryptedText;
    }
}
