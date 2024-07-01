public class Algorithm {

    // Array de letras permitidas
    static char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    // Array de letras especiales no permitidas
    static char[] specialLetters = {'{','}','[',']','<','>','|','!','@','"','#','·','~','$','%','¬','&','/','(',')','=','?','\'','¿','¡','\\','º','ª','^','*','+','_','ç','Ç','-','.',';',',',':','€'};


    // Obtener el indice de una letra en el array 'letters'
    public static int index(char c) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == c) {
                return i;
            }
        }
        return -1; // Devuelve -1 si no se encuentra en el array
    }

    // Cifrar una cadena usando un desplazamiento k
    public static String encryption(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = index(c);
            if (index != -1 ) {
                int newIndex = (index + k) % letters.length;
                if (newIndex < 0) {
                    newIndex += letters.length;
                }
                result.append(letters[newIndex]);

            } else {
                result.append(c);
            }

        }
        return result.toString();
    }

    // Transposición de colummnas
    // Dado un número de columnas, organiza el texto en una matriz y luego lo lee fila por fila
    public static String transpositionColumns(String s, int columns) {
        int rows = (s.length() + columns - 1) / columns; //Calcula las filas
        char[][] matrix = new char[rows][columns];

        //Añade el texto a la matriz
        int index = 0;
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                if (index < s.length()) {
                    matrix[row][col] = s.charAt(index++);
                } else {
                    matrix[row][col] = ' '; // Rellena espacios vacios
                }
            }
        }

        // Lee la matriz fila por fila para aplicar la transposición
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                result.append(matrix[row][col]);
            }
        }
        return result.toString().trim();
    }

    // Inserta el texto cifrado con dos claves diferentes y realiza una transposición de columnas
    public static String insertEncryption(String text, int k1, int k2, int columns) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();

        // Dependiendo de la posición de la letra en la palabra, la cuenta como par o impar (empieza en 0)
        // Par usara key 1 y impar key 2
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                even.append(text.charAt(i));
            } else {
                odd.append(text.charAt(i));
            }
        }

        // Texto cifrado pero separado por las posiciones pares e impares con claves diferentes
        String encryptionEven = encryption(even.toString(), k1);
        String encryptionOdd = encryption(odd.toString(), k2);
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
        return transpositionColumns(encryptedText, columns);
    }

    // Descifrar el texto
    public static String decryption(String s, int columns, int k1, int k2) {

        // Primero realiza la transposición inversa
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
        String decryptedEven = encryption(even.toString(), -k1);
        String decryptedOdd = encryption(odd.toString(), -k2);
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

    @Override
    public String toString() {
        return "Algorithm{ }";
    }

    // Determina si el caracter es especial o no
    public static boolean isSpecialCharacter(char c) {
        for (char specialChar : specialLetters) {
            if (c == specialChar) {
                return true;
            }
        }
        return false;
    }
}
