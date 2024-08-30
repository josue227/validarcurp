import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String CURP_REGEX = "^[A-Z]{1}[AEIOUX]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[HM](AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$";

    public static void main(String[] args) {
        String archivo = "curp.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numeroLinea = 1;
            Pattern pattern = Pattern.compile(CURP_REGEX);

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                Matcher matcher = pattern.matcher(linea);
                if (!matcher.matches()) {
                    System.out.println("CURP inválida: " + linea + " en la línea: " + numeroLinea);
                }
                numeroLinea++;
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
