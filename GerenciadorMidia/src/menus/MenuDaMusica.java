package menus;

import gerenciadores.GMidia;
import java.util.*;
import midias.*;

/**
 *
 * @author Débora Siqueira
 */
public class MenuDaMusica implements IMenu {

    final String arquivoTXTMusica = "src/Arquivos/musica.txt";
    GMidia gerenciadorMusica = new GMidia(new ArrayList(), arquivoTXTMusica);

    public MenuDaMusica() {
        gerenciadorMusica.carregar();
    }

    public void menuMusica() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n1- Adicionar nova Música.");
            System.out.println("2- Editar Música.");
            System.out.println("3- consultar Música.");
            System.out.println("4- Excluir Música.");
            System.out.println("5- Voltar ao menu principal.");
            System.out.println("Digite a opção desejada:");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    adicionarMidia();
                    break;
                case 2:
                    editarMidia();
                    break;
                case 3:
                    consultarMidia();
                    break;
                case 4:
                    excluirMidia();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("A Opção inserida é inválida. Digite novamente, por favor:");
            }
        } while (opcao != 5);
    }

    /**
     * Método para adicionar uma nova midia
     *
     * @return retorna true caso a nova midia seja adicionada. Caso contrário
     * retorna false
     */
    @Override
    public boolean adicionarMidia() {
        Scanner entrada = new Scanner(System.in);
        String titulo = null, genero = null, idioma = null, autores = null, ano = null, duracao = null, descricao = null, interpretes, caminho;
        System.out.println("Digite o título da Música:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        System.out.println("Digite o genero da Música:");
        genero = ValidarEntradaUsuario.nextLine(genero);
        System.out.println("Digite o idioma da Música:");
        idioma = ValidarEntradaUsuario.nextLine(idioma);
        System.out.println("Digite os autores da Música:");
        autores = ValidarEntradaUsuario.nextLine(autores);
        System.out.println("Digite o ano da Música:");
        ano = ValidarEntradaUsuario.nextInt(ano);
        System.out.println("Digite a duração da Música:");
        duracao = ValidarEntradaUsuario.nextDouble(duracao);
        duracao = duracao.replaceAll("\\.", ":");
        System.out.println("Digite a descrição da Música:");
        descricao = ValidarEntradaUsuario.nextLine(descricao);
        System.out.println("Digite os interpretes da Música:");
        interpretes = entrada.nextLine();
        caminho = new java.io.File(".").getAbsolutePath();
        Musica musica = new Musica(caminho, titulo, descricao, genero, autores, ano, duracao, interpretes, idioma);
        if (gerenciadorMusica.adicionar(musica)) {
            System.out.println("Música adicionada com sucesso!");
            return true;
        }
        return false;
    }

    /**
     * Método para excluir uma mídia.
     *
     * @return Retorna true caso a musica seja excluida. Caso contrário retorna
     * false.
     */
    @Override
    public boolean excluirMidia() {
        Scanner entrada = new Scanner(System.in);
        String excluir;
        int resposta = 0;
        boolean ficar;
        System.out.println("Digite o titulo da Música que deseja excluir:");
        excluir = entrada.nextLine();
        System.out.println(gerenciadorMusica.consulta(excluir));
        do {

            System.out.println("\nTem certeza que deseja excluir a Música?"
                    + "\n1- SIM"
                    + "\n2- NAO");
            resposta = ValidarEntradaUsuario.validarInteiro(resposta);
            switch (resposta) {
                case 1:
                    if (gerenciadorMusica.exclusao(excluir)) {
                        System.out.println("\nMúsica excluida com sucesso!");
                        return true;
                    } else {
                        System.out.println("\nNão foi possivel excluir a Música!");
                        return false;
                    }
                case 2:
                    System.out.println("\n A música não foi excluida!");
                    return false;
                default:
                    System.out.println("Opção inválida!");
                    ficar = true;
            }
        } while (ficar);
        return true;
    }

    /**
     * Método para consultar uma mídia
     *
     * @return Retorna uma mídia desejada.
     */
    @Override
    public void consultarMidia() {

        Scanner entrada = new Scanner(System.in);
        String consulta;
        System.out.println("Digite o titulo da Música que desejas consultar:");
        consulta = entrada.nextLine();
        Midia musica = gerenciadorMusica.consulta(consulta);
        if (musica == null) {
            System.out.println("Musica inexistente.");
        } else {
            System.out.println(musica.toString());
        }
    }

    /**
     * Método para editar uma mídia
     *
     * @return Retorna true caso a mídia tenha sido editada com sucesso.
     */
    @Override
    public boolean editarMidia() {
        Scanner e = new Scanner(System.in);
        double duracao1 = Integer.MIN_VALUE;
        String codigo, titulo = null, desc = null, genero = null, idioma = null, autores = null, interpretes = null, ano = null, duracao = null;
        System.out.println("\nDigite o titulo da Música que deseja editar:");
        codigo = e.nextLine();
        Musica musica = (Musica) gerenciadorMusica.consulta(codigo);
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo titulo da Música: ");
        titulo = ValidarEntradaUsuario.entradaEnterTexto(titulo);
        if (titulo.equals("")) {
        } else {
            musica.setTitulo(titulo);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Nova descrição da Música: ");
        desc = ValidarEntradaUsuario.entradaEnterTexto(desc);
        if (desc.equals("")) {
        } else {
            musica.setDescricao(desc);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo genero da Música: ");
        genero = ValidarEntradaUsuario.entradaEnterTexto(genero);
        if (genero.equals("")) {
        } else {
            musica.setGenero(genero);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo idioma da Música: ");
        idioma = ValidarEntradaUsuario.entradaEnterTexto(idioma);
        if (idioma.equals("")) {
        } else {
            musica.setIdioma(idioma);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo nome dos autores da Música:");
        autores = ValidarEntradaUsuario.entradaEnterTexto(autores);
        if (autores.equals("")) {
        } else {
            musica.setAutores(autores);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novos nomes dos interpretes:");
        interpretes = ValidarEntradaUsuario.entradaEnterTexto(interpretes);
        if (interpretes.equals("")) {
        } else {
            musica.setInterprete(interpretes);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo ano de lançamento: ");
        ano = ValidarEntradaUsuario.entradaEnterNumero(ano);
        if (ano.equals("")) {
        } else {
            musica.setAno(ano);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Nova duração do filme em minutos: ");
        duracao = ValidarEntradaUsuario.entradaEnterNumero(duracao);
        if (duracao.equals("")) {
        } else {
            musica.setDuracao(duracao);
        }
        System.out.println("\nMúsica editada com sucesso!!\n");
        return true;
    }

}
