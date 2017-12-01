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
        String titulo = null, genero = null, idioma = null, autores = null, ano = null, duracao = null, descricao = null, codigos, interpretes, caminho;
        Random gerador = new Random();
        int codigo;
        codigo = gerador.nextInt(10000);
        codigos = "" + codigo;
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
        System.out.println("Codigo da sua música: " + codigos);
        Musica musica = new Musica(codigos, caminho, titulo, descricao, genero, autores, ano, duracao, interpretes, idioma);
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
        List<Midia> listTemp;
        String excluir = null, codigo = null;
        int resposta = 0;
        boolean ficar;
        System.out.println("Digite o titulo da Música que deseja excluir:");
        excluir = ValidarEntradaUsuario.nextLine(excluir);
        listTemp = gerenciadorMusica.consulta(excluir);
        for (Midia midia : listTemp) {
            System.out.println(midia.toString());
        }
        if (!listTemp.isEmpty()) {
            System.out.println("ESSAS SÃO AS MÚSICAS ENCONTRADAS COM O TITULO.");
            System.out.println("Informe o código da sua música: ");
            codigo = ValidarEntradaUsuario.nextInt(codigo);
            for (Midia midiaRemover : listTemp) {
                if (midiaRemover.getCodigo().equalsIgnoreCase(codigo)) {
                    do {
                        System.out.println("\nTem certeza que deseja excluir a Música?"
                                + "\n1- SIM"
                                + "\n2- NAO");
                        resposta = ValidarEntradaUsuario.validarInteiro(resposta);
                        switch (resposta) {
                            case 1:
                                if (gerenciadorMusica.exclusao(midiaRemover)) {
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
                }
            }
        } else {
            System.out.println("Música inexistente!");
        }
        return true;
    }

    /**
     * Método para consultar uma mídia
     *
     * @return Retorna uma mídia desejada.
     */
    @Override
    public void consultarMidia() {
        List<Midia> listTemp;
        String consulta = null;
        System.out.println("Digite o titulo da Música que desejas consultar:");
        consulta = ValidarEntradaUsuario.nextLine(consulta);
        listTemp = gerenciadorMusica.consulta(consulta);
        gerenciadorMusica.ordenarMusica(listTemp); 
        if (listTemp.isEmpty()) {
            System.out.println("Música inexistente!");
        }
        for (Midia midia : listTemp) {
            System.out.println(midia.toString());
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
        List<Musica> listTemp;
        double duracao1 = Integer.MIN_VALUE;
        String codigo = null, titulo = null, desc = null, genero = null, idioma = null, autores = null, interpretes = null, ano = null, duracao = null;
        System.out.println("\nDigite o titulo da Música que deseja editar:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        listTemp = gerenciadorMusica.consulta(titulo);
        if (listTemp.isEmpty()) {
            System.out.println("Música inexistente!");
        }
        for (Midia musica : listTemp) {
            System.out.println(musica.toString());
        }
        System.out.println("ESSAS SÃO AS MÚSICAS EXISTENTES COM O TITULO INFORMADO.");
        System.out.println("Informe o código da música que deseja editar: ");
        codigo = ValidarEntradaUsuario.nextInt(codigo);
        for (Musica musica : listTemp) {
            if (musica.getCodigo().equalsIgnoreCase(codigo)) {
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
                if (gerenciadorMusica.edicao(musica)) {
                    System.out.println("\nMúsica editada com sucesso!!\n");
                    return true;
                }
            } else {
                System.out.println("Código inválido. Tente novamente.");
            }
        }
        return false;
    }
}
