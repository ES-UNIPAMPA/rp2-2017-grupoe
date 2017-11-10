package menus;

import gerenciadores.GMusica;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import midias.Midia;
import midias.Musica;

/**
 *
 * @author Débora Siqueira
 */
public class MenuMusica implements IMenu {

    GMusica gerenciadorMusica = new GMusica();

    @Override
    public boolean adicionarMidia() {
        Random gerador = new Random();
        Scanner entrada = new Scanner(System.in);
        String titulo, genero, idioma, autores, ano, duracao, descricao, interpretes, caminho, codigo;
        System.out.println("Digite o título da música:");
        titulo = entrada.nextLine();
        System.out.println("Digite o genero da música:");
        genero = entrada.nextLine();
        System.out.println("Digite o idioma da música:");
        idioma = entrada.nextLine();
        System.out.println("Digite os autores da música:");
        autores = entrada.nextLine();
        System.out.println("Digite o ano da música:");
        ano = entrada.nextLine();
        System.out.println("Digite a duração da música:");
        duracao = entrada.nextLine();
        System.out.println("Digite a descrição da música:");
        descricao = entrada.nextLine();
        System.out.println("Digite os interpretes da música:");
        interpretes = entrada.nextLine();
        int codigoNumero = gerador.nextInt(1000);
        codigo = "" + codigoNumero;
        System.out.println("Codigo da sua musica: " + codigo);
        caminho = new java.io.File(".").getAbsolutePath();
        Musica musica = new Musica(codigo, caminho, titulo, descricao, genero, autores, ano, duracao, interpretes, idioma);
        if (gerenciadorMusica.adicionar(musica)) {
            System.out.println("Música adicionada com sucesso!");
            return true;
        }
        return false;
    }

    @Override
    public boolean excluirMidia() {
        Scanner entrada = new Scanner(System.in);
        String excluir;
        System.out.println("Digite o codigo da música que deseja excluir:");
        excluir = entrada.nextLine();
        if (gerenciadorMusica.exclusao(excluir)) {
            System.out.println("Música excluida com sucesso!");
            return true;
        } else {
            System.out.println("Não foi possivel excluir a música!");
            return false;

        }

    }

    @Override
    public Midia consultarMidia() {
        Scanner entrada = new Scanner(System.in);
        String consulta;
        System.out.println("Digite o codigo da música que desejas consultar:");
        consulta = entrada.nextLine();
        Musica musica = (Musica) gerenciadorMusica.consulta(consulta);
        return musica;
    }

    @Override
    public boolean editarMidia() {
       Scanner e = new Scanner(System.in);
        String codigo, titulo, desc, genero, idioma, autores, interpretes, ano, duracao;
        System.out.println("\nDigite o codigo do filme que deseja excluir:");
        codigo = e.nextLine();
        Musica musica = (Musica) gerenciadorMusica.consulta(codigo);
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo titulo da Musica: ");
        titulo = e.nextLine();
        if (titulo.equals("")) {
        } else {
            musica.setTitulo(titulo);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Nova descricao da Musica: ");
        desc = e.nextLine();
        if (desc.equals("")) {
        } else {
            musica.setDescricao(desc);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo genero da Musica: ");
        genero = e.nextLine();
        if (genero.equals("")) {
        } else {
            musica.setGenero(genero);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo idioma da Musica: ");
        idioma = e.nextLine();
        if (idioma.equals("")) {
        } else {
            musica.setIdioma(idioma);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo nome dos autores da Musica: (separados por espaco)");
        autores = e.nextLine();
        if (autores.equals("")) {
        } else {
            musica.setAutores(autores);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novos nomes dos interpretes: (separados por espaco)");
        interpretes = e.nextLine();
        if (interpretes.equals("")) {
        } else {
            musica.setInterprete(interpretes);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo ano de lancamento: ");
        ano = e.nextLine();
        if (ano.equals("")) {
        } else {
            musica.setAno(ano);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Nova duracao do filme em minutos: ");
        duracao = e.nextLine();
        if (duracao.equals("")) {
        } else {
            musica.setDuracao(duracao);
        }
        System.out.println("\nMusica editada com sucesso!!\n");
        return false;
    }

}
