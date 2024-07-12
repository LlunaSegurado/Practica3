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

    // Determina si el caracter es especial o no
    public static boolean isSpecialCharacter(char c) {
        for (char specialChar : specialLetters) {
            if (c == specialChar) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Algorithm{ }";
    }
}
