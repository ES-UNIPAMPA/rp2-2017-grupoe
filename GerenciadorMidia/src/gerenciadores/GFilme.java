package gerenciadores;

import java.util.ArrayList;
import java.util.Scanner;
import midias.Filme;
import midias.Midia;

public class GFilme implements gerPrincipal {

    public GFilme() {

    }

    @Override
    public boolean adicionar() {
        Scanner entrada = new Scanner(System.in);
        Filme a = new Filme();
        System.out.println("Digite o codigo do filme: ");
        a.setCodigo(entrada.next());
        System.out.println("Digite o caminho do arquivo: ");
        a.setCaminho(entrada.next());
        System.out.println("Digite o titulo do arquivo: ");
        a.setTitulo(entrada.next());
        System.out.println("Digite a descricao do arquivo: ");
        a.setDescricao(entrada.next());
        System.out.println("Digite o genero do arquivo: ");
        a.setGenero(entrada.next());
        System.out.println("Digite o idioma do filme: ");
        a.setIdioma(entrada.next());
        System.out.println("Digite o nome do diretor do filme: ");
        a.setDiretor(entrada.next());
        System.out.println("Digite o nome dos atores principais (separados por espaco)");
        a.setAtores(entrada.next());
        System.out.println("Qual foi seu ano de lancamento? ");
        a.setAno(entrada.nextInt());
        System.out.println("Qual foi é a duracao do filme em minutos: ");
        a.setDuracao(entrada.nextInt());
        Filme.setLista(a);
        Midia m = new Midia();
        m.adicionarMidia(a);
        System.out.println("\nFilme adicionado com Sucesso!!!\n");
        return true;
    }

    @Override
    public void classifica(ArrayList<Midia> midia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edicao() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o codigo do Filme que deseja editar: ");
        String codigo = entrada.next();
        Filme x = new Filme();
        Filme filme = x.getFilme(codigo);
        System.out.println("Digite o novo codigo do filme: ");
        filme.setCodigo(entrada.nextInt());
        System.out.println("Digite o novo caminho do arquivo: ");
        filme.setCaminho(entrada.next());
        System.out.println("Digite o novo titulo do arquivo: ");
        filme.setTitulo(entrada.next());
        System.out.println("Digite a nova descricao do arquivo: ");
        filme.setDescricao(entrada.next());
        System.out.println("Digite o novo genero do arquivo: ");
        filme.setGenero(entrada.next());
        System.out.println("Digite o novo idioma do filme: ");
        filme.setIdioma(entrada.next());
        System.out.println("Digite o novo nome do diretor do filme: ");
        filme.setDiretor(entrada.next());
        System.out.println("Digite o novo nome dos atores principais (separados por espaco)");
        filme.setAtores(entrada.next());
        System.out.println("Qual foi seu ano de lancamento? ");
        filme.setAno(entrada.nextInt());
        System.out.println("Qual foi é a duracao do filme em minutos: ");
        filme.setDuracao(entrada.nextInt());
        System.out.println("\nFilme editado com sucesso!!\n");
    }

    @Override
      public boolean exclusao() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o codigo do Filme que deseja excluir: ");
        String codigo = entrada.next();
        Filme h = new Filme();
        Midia m = new Midia();
        Filme temp = h.getFilme(codigo);
        m.getMidia(codigo);
        if (temp != null) {
            System.out.println("Deseja realmente excluir esse filme?\n"
                    + "1- SIM     2- NAO");
            int resp = entrada.nextInt();
            if (resp == 1) {
                String deletado = h.delFilme(codigo);
                m.delMidia(codigo);
                System.out.println("Filme deletado com sucesso!!");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public Midia exibir() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("1- Exibir todos os Filmes   2- Exibir somente um filme");
        int opcao = entrada.nextInt();
        if (opcao == 1) {
            Filme b = new Filme();
            b.getLista();
        } else {
            System.out.println("Digite o codigo do Filme: ");
            String codigo = entrada.next();
            Filme b = new Filme();
            b.getFilme(codigo);
        }
        return null;
    }
}
