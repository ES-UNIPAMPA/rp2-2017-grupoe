package menus;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validação dos campos de String, int e double.
 *
 * @author Débora Siqueira
 */
public class ValidarEntradaUsuario {

    public static String nextLine(String texto) {
        Scanner entrada = new Scanner(System.in);
        boolean ficar;
        do {
            ficar = false;
            texto = entrada.nextLine();
            if (texto == null || texto.equals("") || texto.equals(" ")) {
                ficar = true;
                System.out.println("Formato de texto incorreto. Por favor, digite novamente:");
            } else {
                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(texto);
                if (matcher.find()) {
                    ficar = true;
                    System.out.println("Formato de texto incorreto. Por favor, Digite novamente: ");
                }
            }
        } while (ficar);
        return texto;
    }

    public static String nextInt(String numero) {
        Scanner entrada = new Scanner(System.in);
        boolean ficar;
        do {
            try {
                numero = entrada.nextLine();
                Integer.parseInt(numero);
                return numero;
            } catch (NumberFormatException e5) {
                System.out.println("Formato incorreto. Por favor, Digite novamente:");
                ficar = true;
            }
        } while (ficar);
        return numero;
    }

    public static String nextDouble(String numero) {
        Scanner entrada = new Scanner(System.in);
        boolean ficar;
        do {
            try {
                numero = entrada.nextLine();
                Double.parseDouble(numero);
                return numero;
            } catch (NumberFormatException e6) {
                System.out.println("Formato incorreto. Por favor, Digite novamente:");
                ficar = true;
            }
        } while (ficar);
        return numero;
    }

    public static int validarInteiro(int numero) {
        Scanner entrada = new Scanner(System.in);
        boolean ficar;
        do {

            try {
                numero = entrada.nextInt();
                return numero;

            } catch (NumberFormatException e4) {
                System.out.println("Formato incorreto. Por favor, Digite novamente:");
                ficar = true;
            }

        } while (ficar);
        return numero;
    }

    public static String entradaEnterTexto(String texto) {
        boolean ficar;
        do {
            Scanner e = new Scanner(System.in);
            ficar = false;
            texto = e.nextLine();
            //texto = texto.trim();
            if (texto == null || texto.equals(" ")) {
                ficar = true;
                System.out.println("Formato incorreto.Por favor, Digite novamente: ");
            } else {
                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(texto);
                if (matcher.find()) {
                    ficar = true;
                    System.out.println("Formato incorreto.Por favor, Digite novamente: ");
                }
            }
        } while (ficar);
        return texto;

    }

    public static String entradaEnterNumero(String texto) {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        do {
            ficar = false;
            texto = e.nextLine();
            Pattern pattern = Pattern.compile("[a-z, A-Z]");
            Matcher matcher = pattern.matcher(texto);
            if (matcher.find() || texto.equals(" ")) {
                ficar = true;
                System.out.println("Formato incorreto. Por favor, Digite novamente: ");
            }
        } while (ficar);
        return texto;
    }
}
