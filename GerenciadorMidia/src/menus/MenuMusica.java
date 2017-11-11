package menus;


import gerenciadores.GMidia;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import midias.Midia;
import midias.Musica;

/**
 *
 * @author Débora Siqueira
 */
public class MenuMusica implements IMenu {

    GMidia gerenciadorMusica = new GMidia( new ArrayList());
    
    public void menuMusica(){
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
                    Musica musica = (Musica) consultarMidia();
                    if (musica == null) {
                        System.out.println("Música inexistente!");
                    } else {
                        System.out.println(musica.toString());
                    }
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
 * @return retorna true caso a nova midia seja adicionada. Caso contrário retorna false
 */
    @Override
    public boolean adicionarMidia() {
        Random gerador = new Random();
        Scanner entrada = new Scanner(System.in);
        String titulo, genero, idioma, autores, ano, duracao, descricao, interpretes, caminho, codigo;
        System.out.println("Digite o título da Música:");
        titulo = entrada.nextLine();
        System.out.println("Digite o genero da Música:");
        genero = entrada.nextLine();
        System.out.println("Digite o idioma da Música:");
        idioma = entrada.nextLine();
        System.out.println("Digite os autores da Música:");
        autores = entrada.nextLine();
        System.out.println("Digite o ano da Música:");
        ano = entrada.nextLine();
        System.out.println("Digite a duração da Música:");
        duracao = entrada.nextLine();
        System.out.println("Digite a descrição da Música:");
        descricao = entrada.nextLine();
        System.out.println("Digite os interpretes da Música:");
        interpretes = entrada.nextLine();
        int codigoNumero = gerador.nextInt(1000);
        codigo = "" + codigoNumero;
        System.out.println("(Codigo da sua Música): " + codigo);
        caminho = new java.io.File(".").getAbsolutePath();
        Musica musica = new Musica(codigo, caminho, titulo, descricao, genero, autores, ano, duracao, interpretes, idioma);
        if (gerenciadorMusica.adicionar(musica)) {
            System.out.println("Música adicionada com sucesso!");
            return true;
        }
        return false;
    }
/**
 * Método para excluir uma mídia.
 * @return Retorna true caso a musica seja excluida. Caso contrário retorna false.
 */
    @Override
    public boolean excluirMidia() {
        Scanner entrada = new Scanner(System.in);
        String excluir;
        int resposta;
        System.out.println("Digite o codigo da Música que deseja excluir:");
        excluir = entrada.nextLine();
        System.out.println(gerenciadorMusica.consulta(excluir));
        System.out.println("\nTem certeza que deseja excluir a Música?"
                + "\n1- SIM"
                + "\n2- NAO");
        resposta = entrada.nextInt();
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
        }
        return false;

    }
/**
 * Método para consultar uma mídia
 * @return Retorna uma mídia desejada.
 */
    @Override
    public Midia consultarMidia() {
        Scanner entrada = new Scanner(System.in);
        String consulta;
        System.out.println("Digite o codigo da música que desejas consultar:");
        consulta = entrada.nextLine();
        Musica musica = (Musica) gerenciadorMusica.consulta(consulta);
        return musica;
    }
/**
 * Método para editar uma mídia
 * @return Retorna true caso a mídia tenha sido editada com sucesso.
 */
    @Override
    public boolean editarMidia() {
       Scanner e = new Scanner(System.in);
        String codigo, titulo, desc, genero, idioma, autores, interpretes, ano, duracao;
        System.out.println("\nDigite o codigo do filme que deseja excluir:");
        codigo = e.nextLine();
        Musica musica = (Musica) gerenciadorMusica.consulta(codigo);
        System.out.println("Tecle ENTER caso nao deseje editar este item.");
        System.out.println("Novo titulo da Música: ");
        titulo = e.nextLine();
        if (titulo.equals("")) {
        } else {
            musica.setTitulo(titulo);
        }
        System.out.println("Tecle ENTER caso nao deseje editar este item.");
        System.out.println("Nova descrição da Música: ");
        desc = e.nextLine();
        if (desc.equals("")) {
        } else {
            musica.setDescricao(desc);
        }
        System.out.println("Tecle ENTER caso nao deseje editar este item.");
        System.out.println("Novo genero da Música: ");
        genero = e.nextLine();
        if (genero.equals("")) {
        } else {
            musica.setGenero(genero);
        }
        System.out.println("Tecle ENTER caso nao deseje editar este item.");
        System.out.println("Novo idioma da Música: ");
        idioma = e.nextLine();
        if (idioma.equals("")) {
        } else {
            musica.setIdioma(idioma);
        }
        System.out.println("Tecle ENTER caso nao deseje editar este item.");
        System.out.println("Novo nome dos autores da Música:");
        autores = e.nextLine();
        if (autores.equals("")) {
        } else {
            musica.setAutores(autores);
        }
        System.out.println("Tecle ENTER caso nao deseje editar este item.");
        System.out.println("Novos nomes dos interpretes:");
        interpretes = e.nextLine();
        if (interpretes.equals("")) {
        } else {
            musica.setInterprete(interpretes);
        }
        System.out.println("Tecle ENTER caso nao deseje editar este item.");
        System.out.println("Novo ano de lançamento: ");
        ano = e.nextLine();
        if (ano.equals("")) {
        } else {
            musica.setAno(ano);
        }
        System.out.println("Tecle ENTER caso nao deseje editar este item.");
        System.out.println("Nova duração do filme em minutos: ");
        duracao = e.nextLine();
        if (duracao.equals("")) {
        } else {
            musica.setDuracao(duracao);
        }
        System.out.println("\nMúsica editada com sucesso!!\n");
        return true;
    }

}
