
package menus;

import gerenciadores.GMidia;
import java.util.Scanner;
import midias.Midia;

/**
 *
 * @author Rafael
 */
public class Exclui {
    /**
     * Método para excluir uma mídia.
     *
     * @param tipo
     * @param midia
     * @return Retorna true caso a musica seja excluida. Caso contrário retorna
     * false.
     */
    public boolean excluirMidia(String tipo, GMidia midia) {
        Scanner entrada = new Scanner(System.in);
        String excluir = null, codigo = null;
        int resposta = 0;
        boolean ficar=false;
        System.out.println("Digite o titulo da Midia que deseja excluir:");
        excluir = ValidarEntradaUsuario.nextLine(excluir);
        System.out.println("Digite o codigo da Midia que deseja excluir:");
        codigo = ValidarEntradaUsuario.nextInt(codigo);
        Midia resconsulta = midia.consultar(excluir, codigo);
        if (resconsulta != null) {
            System.out.println(resconsulta);
        } else {
            System.out.println("Midia não encontrada!!");
            return false;
        }
        do {
            System.out.println("\nTem certeza que deseja excluir a midia " + tipo
                    + "\n1- SIM"
                    + "\n2- NAO");
            resposta = ValidarEntradaUsuario.validarInteiro(resposta);
            switch (resposta) {
                case 1:
                    if (midia.exclusao(excluir, codigo)) {
                        System.out.println("\nMidia excluida com sucesso!");
                        return true;
                    } else {
                        System.out.println("\nNão foi possivel excluir a Midia!");
                        return false;
                    }
                case 2:
                    System.out.println("\n A midia não foi excluida!");
                    ficar = true;
                default:
                    System.out.println("Opção inválida!");
                    ficar = false;
            }
        } while (!ficar);
        return true;
    }
    
}
