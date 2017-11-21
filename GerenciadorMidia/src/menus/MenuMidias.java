package menus;

import gerenciadores.GMidia;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class MenuMidias {
    
    String caminho = "";
    GMidia gerenciadorMidia = new GMidia(new ArrayList(), caminho);

    GMidia menu(String tipo) {
        Scanner entrada = new Scanner(System.in);
        String opcao = null;
        do {
            System.out.println("\n1- Adicionar " + tipo);
            System.out.println("2- Editar " + tipo);
            System.out.println("3- consultar " + tipo);
            System.out.println("4- Excluir " + tipo);
            System.out.println("0- Voltar ao menu principal.");
            System.out.println("Digite a opção desejada:");          
            opcao = ValidarEntradaUsuario.nextInt(opcao);
            switch (opcao) {
                case "1":
                    Adiciona midi = new Adiciona();
                    midi.adicionarMidia(tipo, gerenciadorMidia);
                    break;
                case "2":
                    Edita mid = new Edita();
                    mid.editarMidia(tipo, gerenciadorMidia);
                    break;
                case "3":
                    Consulta midias = new Consulta();
                    midias.consultarMidia(gerenciadorMidia);
                    break;
                case "4":
                    Exclui midia = new Exclui();
                    midia.excluirMidia(tipo, gerenciadorMidia);
                    break;
                case "0":
                    return gerenciadorMidia;
                default:
                    System.out.println("\nA Opção inserida é inválida. Digite novamente, por favor:");
            }
        } while (!opcao.equalsIgnoreCase("0"));
        return null;
    }
}
