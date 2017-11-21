package menus;

import gerenciadores.GMidia;
import java.util.*;
import midias.*;

public class MenuPartitura implements IMenu {

    final String caminhoArquivoTXTPartitura = "src/Arquivos/partitura.txt";
    GMidia gerenciadorPartitura = new GMidia(new ArrayList(), caminhoArquivoTXTPartitura);

    public MenuPartitura() {
        gerenciadorPartitura.carregar();
    }

    void partitura() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n1- Adicionar nova Partitura.");
            System.out.println("2- Editar Partitura.");
            System.out.println("3- consultar Partitura.");
            System.out.println("4- Excluir Partitura.");
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
                    System.out.println("\nA Opção inserida é inválida. Digite novamente, por favor: ");
            }
        } while (opcao != 0);
    }

    @Override
    public boolean adicionarMidia() {
        String caminho, titulo = null, descricao = null, ano = null, genero = null, autores = null, instrumento = null, codigos;
        Random gerador = new Random();
        int codigo;
        codigo = gerador.nextInt(10000);
        codigos = "" + codigo;
        System.out.println("\nDigite o título da Partitura:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        System.out.println("Digite o genero da Partitura:");
        genero = ValidarEntradaUsuario.nextLine(genero);
        System.out.println("Digite a descrição da Partitura:");
        descricao = ValidarEntradaUsuario.nextLine(descricao);
        System.out.println("Digite o ano da Partitura:");
        ano = ValidarEntradaUsuario.nextInt(ano);
        System.out.println("Digite o (os) instrumento (os) da Partitura:");
        instrumento = ValidarEntradaUsuario.nextLine(instrumento);
        System.out.println("Digite os autores da Partitura: ");
        autores = ValidarEntradaUsuario.nextLine(autores);
        System.out.println("Código da partitura: " + codigos);
        caminho = new java.io.File(".").getAbsolutePath();
        //String caminho, String titulo, String descricao, String ano, String autores, String genero, String instrumentos
        Partitura partitura = new Partitura(caminho, titulo, descricao, codigos, ano, autores, genero, instrumento);
        if (gerenciadorPartitura.adicionar(partitura)) {
            System.out.println("\nPartitura adicionada com sucesso! =D");
            return true;
        }
        return false;
    }

    @Override
    public boolean excluirMidia() {
        Scanner entrada = new Scanner(System.in);
        String titulo = null, codigo = null;
        System.out.println("\nDigite o titulo da Partitura que deseja excluir:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        System.out.println("Digite o codigo da partitura: ");
        codigo = ValidarEntradaUsuario.nextInt(codigo);
        System.out.println(gerenciadorPartitura.consulta(titulo, codigo));
        System.out.println("\nTem certeza que deseja excluir essa Partitura?"
                + "\n1 - SIM"
                + "\n2 - NÃO");
        int res = entrada.nextInt();
        switch (res) {
            case 1:
                if (gerenciadorPartitura.exclusao(titulo)) {
                    System.out.println("\nPartitura excluida com sucesso!");
                    return true;
                } else {
                    System.out.println("\nNão foi possivel excluir a Partitura !");
                    return false;
                }
            case 2:
                System.out.println("\nPartitura não foi excluido!");
                return false;
        }
        return false;
    }

    @Override
    public void consultarMidia() {
        Scanner entrada = new Scanner(System.in);
        String consulta = null, codigo = null;
        System.out.println("\nDigite o titulo da Partitura que deseja consultar:");
        consulta = ValidarEntradaUsuario.nextLine(consulta);
        System.out.println("Digite o codigo da partitura: ");
        codigo = ValidarEntradaUsuario.nextInt(codigo);
        Midia partitura = gerenciadorPartitura.consulta(consulta, codigo);
        if (partitura == null) {
            System.out.println("Partitura inexistente.");
        } else {
            System.out.println(partitura.toString());
        }
    }

    @Override
    public boolean editarMidia() {
        Scanner e = new Scanner(System.in);
        String caminho, titulo = null, descricao = null, ano = null, genero = null, instrumento = null, codigo = null;
        System.out.println("\nDigite o titulo da Partitura que deseja Editar:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        System.out.println("Digite o codigo da partitura: ");
        codigo = ValidarEntradaUsuario.nextInt(codigo);
        Partitura partitura = (Partitura) gerenciadorPartitura.consulta(titulo, codigo);
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo titulo da Partitura: ");
        titulo = ValidarEntradaUsuario.entradaEnterTexto(titulo);
        if (titulo.equals("")) {
        } else {
            partitura.setTitulo(titulo);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Nova descricao da Partitura: ");
        descricao = ValidarEntradaUsuario.entradaEnterTexto(descricao);
        if (descricao.equals("")) {
        } else {
            partitura.setDescricao(descricao);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo genero da Partitura: ");
        genero = ValidarEntradaUsuario.entradaEnterTexto(genero);
        if (genero.equals("")) {
        } else {
            partitura.setGenero(genero);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo instrumento da Partitura: ");
        instrumento = ValidarEntradaUsuario.entradaEnterTexto(instrumento);
        if (instrumento.equals("")) {
            partitura.setInstrumentos(instrumento);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo ano da Partitura: ");
        ano = ValidarEntradaUsuario.entradaEnterNumero(ano);
        if (ano.equals("")) {
        } else {
            partitura.setAno(ano);
        }
        caminho = new java.io.File(".").getAbsolutePath();
        if (gerenciadorPartitura.edicao(titulo, partitura)) {
            System.out.println("Editado com sucesso.");
        } else {
            System.out.println("Não foi possível editar.");
        }
        return false;
    }
}
