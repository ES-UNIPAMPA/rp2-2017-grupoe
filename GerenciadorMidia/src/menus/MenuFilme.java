package menus;

import gerenciadores.GMidia;
import java.util.*;
import midias.*;

/**
 *
 * @author Rafael
 */
public class MenuFilme implements IMenu {

    final String caminhoTXTFilme = "src/Arquivos/filme.txt";
    GMidia gerenciadorFilme = new GMidia(new ArrayList(), caminhoTXTFilme);

    public MenuFilme() {
        gerenciadorFilme.carregar();
    }

    /**
     * @param metodo inicial do primeiro menu de interação dos filmes
     */
    void filme() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n1- Adicionar novo filme.");
            System.out.println("2- Editar filme.");
            System.out.println("3- consultar filme.");
            System.out.println("4- Excluir filme.");
            System.out.println("0- Voltar ao menu principal.");
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
                    System.out.println("\nA Opção inserida é inválida. Digite novamente, por favor:");
            }
        } while (opcao != 0);
    }

    /**
     *
     * @return preeche todas as variáveis, cria um objeto do tipo filme e
     * adiciona na lista de Midias
     */
    @Override

    public boolean adicionarMidia() {
        Random gerador = new Random();
        Scanner entrada = new Scanner(System.in);
        int codigos;
        codigos = gerador.nextInt(10000);
        String codigo = "" + codigos;
        String caminho, titulo = null, descricao = null, genero = null, idioma = null, diretor = null, atores, local = null, duracao = null, ano = null;
        System.out.println("\nDigite o título do filme:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        System.out.println("Digite o genero do filme:");
        genero = ValidarEntradaUsuario.nextLine(genero);
        System.out.println("Digite o idioma do filme:");
        idioma = ValidarEntradaUsuario.nextLine(idioma);
        System.out.println("Digite o nome do diretor do filme:");
        diretor = ValidarEntradaUsuario.nextLine(diretor);
        System.out.println("Digite o ano do filme:");
        ano = ValidarEntradaUsuario.nextInt(ano);
        System.out.println("Digite a duração do filme:");
        duracao = ValidarEntradaUsuario.nextDouble(duracao);
        duracao = duracao.replaceAll("\\.", ":");
        System.out.println("Digite a descrição do filme:");
        descricao = ValidarEntradaUsuario.nextLine(descricao);
        System.out.println("Digite o nome dos atores principais: (separados por espaço)");
        atores = entrada.nextLine();
        System.out.println("Digite o local onde foi gravado o filme:");
        local = ValidarEntradaUsuario.nextInt(local);
        caminho = new java.io.File(".").getAbsolutePath();
        System.out.println("Codigo do seu filme: " + codigo);
        Filme filme = new Filme(caminho, titulo, descricao, genero, idioma, diretor, atores, duracao, ano, local);
        if (gerenciadorFilme.adicionar(filme)) {
            System.out.println("\nFilme adicionado com sucesso!");
            return true;
        }
        return false;
    }

    /**
     *
     * @return confere se o filme existe, se sim, envia ele para o metodo
     * exclusao
     */
    @Override
    public boolean excluirMidia() {
        Scanner entrada = new Scanner(System.in);
        String titulo = null, codigo = null;
        boolean ficar;
        System.out.println("\nDigite o codigo do filme que deseja excluir:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        //System.out.println("Digite o título do filme que deseja excluir: ");
        //codigo = ValidarEntradaUsuario.nextInt(codigo);
        System.out.println(gerenciadorFilme.consulta(titulo, codigo));
        do {
            System.out.println("\nTem certeza que deseja excluir esse filme?"
                    + "\n1- SIM"
                    + "\n2- NAO");
            int res = 0;
            res = ValidarEntradaUsuario.validarInteiro(res);
            switch (res) {
                case 1:
                    if (gerenciadorFilme.exclusao(titulo, codigo)) {
                        System.out.println("\nFilme excluido com sucesso!");
                        return true;
                    } else {
                        System.out.println("\nNão foi possivel excluir o !");
                        return false;
                    }
                case 2:
                    System.out.println("\nO filme não foi excluido!");
                    return false;
                default:
                    ficar = true;
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            return false;
        } while (ficar);
    }

    @Override
    public void consultarMidia() {
        Scanner entrada = new Scanner(System.in);
        String consulta = null, codigo = null;
        System.out.println("\nDigite o titulo do filme que deseja consultar:");
        consulta = ValidarEntradaUsuario.nextLine(consulta);
        //System.out.println("Digite o código do filme que deseja consultar: ");
        //codigo = ValidarEntradaUsuario.nextInt(codigo);
        Midia filme = gerenciadorFilme.consulta(consulta, codigo);
        if (filme == null) {
            System.out.println("Filme inexistente.");
        } else {
            System.out.println(filme.toString());
        }
    }

    /**
     *
     * @return cada etapa da um set nos campos preenchidos se for pressionado
     * ENTER ele pula a etapa e vai para a proxima edicao
     */
    @Override
    public boolean editarMidia() {
        Scanner e = new Scanner(System.in);
        String titulo = null, desc, genero, idioma, diretor, atores, ano, duracao, codigo = null;
        System.out.println("\nDigite o titulo do filme que deseja excluir:");
        //titulo = ValidarEntradaUsuario.nextLine(titulo);
        //System.out.println("Digite o codigo do filme que deseja excluir:");
        codigo = ValidarEntradaUsuario.nextInt(codigo);
        Filme filme = (Filme) gerenciadorFilme.consulta(titulo, codigo);
        System.out.println("pressione ENTER caso nao deseje editar este item.");
        System.out.println("Novo titulo do filme: ");
        titulo = e.nextLine();
        if (titulo.equals("")) {
        } else {
            filme.setTitulo(titulo);
        }
        System.out.println("Pressione ENTER caso nao deseje editar este item.");
        System.out.println("Nova descricao do filme: ");
        desc = e.nextLine();
        if (desc.equals("")) {
        } else {
            filme.setDescricao(desc);
        }
        System.out.println("Pressione ENTER caso nao deseje editar este item.");
        System.out.println("Novo genero do filme: ");
        genero = e.nextLine();
        if (genero.equals("")) {
        } else {
            filme.setGenero(genero);
        }
        System.out.println("Pressione ENTER caso nao deseje editar este item.");
        System.out.println("Novo idioma do filme: ");
        idioma = e.nextLine();
        if (idioma.equals("")) {
        } else {
            filme.setIdioma(idioma);
        }
        System.out.println("Pressione ENTER caso nao deseje editar este item.");
        System.out.println("Novo nome do diretor do filme: ");
        diretor = e.nextLine();
        if (diretor.equals("")) {
        } else {
            filme.setDiretor(diretor);
        }
        System.out.println("Pressione ENTER caso nao deseje editar este item.");
        System.out.println("Novos nomes dos atores principais (separados por espaco)");
        atores = e.nextLine();
        if (atores.equals("")) {
        } else {
            filme.setAtores(atores);
        }
        System.out.println("Pressione ENTER caso nao deseje editar este item.");
        System.out.println("Novo ano de lancamento: ");
        ano = e.nextLine();
        if (ano.equals("")) {
        } else {
            filme.setAno(ano);
        }
        System.out.println("Pressione ENTER caso nao deseje editar este item.");
        System.out.println("Nova duracao do filme em minutos: ");
        duracao = e.nextLine();
        if (duracao.equals("")) {
        } else {
            filme.setDuracao(duracao);
        }
        System.out.println("\nFilme editado com sucesso!!\n");
        return false;
    }

}
