package menus;

import gerenciadores.GMidia;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class Consulta {

    /**
     * Método para consultar uma mídia
     *
     * @param midia
     * @return Retorna uma mídia desejada.
     */
    public boolean consultarMidia(GMidia midia) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o titulo ou o codigo da Midia que deseja exibir:");
        String titulo = entrada.nextLine(); 
            System.out.println("Foram encontrados os seguintes resultados: \n");
            midia.exibir(titulo);
            return true;
    }

}
