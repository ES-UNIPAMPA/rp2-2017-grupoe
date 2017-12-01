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
        Partitura partitura = new Partitura(codigos, caminho, titulo, descricao, ano, autores, genero, instrumento);
        if (gerenciadorPartitura.adicionar(partitura)) {
            System.out.println("\nPartitura adicionada com sucesso! =D");
            return true;
        }
        return false;
    }

    @Override
    public boolean excluirMidia() {
        List<Midia> listTemp;
        Scanner entrada = new Scanner(System.in);
        boolean ficar;
        String titulo = null, codigo = null;
        System.out.println("\nDigite o titulo da Partitura que deseja excluir:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        listTemp = gerenciadorPartitura.consulta(titulo);
        for (Midia midia : listTemp) {
            System.out.println(midia.toString());
        }
        if (!listTemp.isEmpty()) {
            System.out.println("ESSAS SÃO AS PARTITURAS ENCONTRADAS COM O TÍTULO.");
            System.out.println("Informe o código da sua partitura: ");
            codigo = ValidarEntradaUsuario.nextInt(codigo);
            for (Midia midiaRemover : listTemp) {
                if (midiaRemover.getCodigo().equalsIgnoreCase(codigo)) {
                    do {
                        System.out.println("\nTem certeza que deseja excluir essa Partitura?"
                                + "\n1 - SIM"
                                + "\n2 - NÃO");
                        int res = entrada.nextInt();
                        switch (res) {
                            case 1:
                                if (gerenciadorPartitura.exclusao(midiaRemover)) {
                                    System.out.println("\nPartitura excluida com sucesso!");
                                    return true;
                                } else {
                                    System.out.println("\nNão foi possivel excluir a Partitura !");
                                    return false;
                                }
                            case 2:
                                System.out.println("\nPartitura não foi excluido!");
                                return false;
                            default:
                                System.out.println("Opção inválida!");
                                ficar = true;
                        }
                    } while (ficar);
                }
            }
        }
        return false;
    }

    @Override
    public void consultarMidia() {
        List<Partitura> listTemp;
        String consulta = null;
        System.out.println("\nDigite o titulo da Partitura que deseja consultar:");
        consulta = ValidarEntradaUsuario.nextLine(consulta);
        listTemp = gerenciadorPartitura.consulta(consulta);
        if (listTemp.isEmpty()) {
            System.out.println("Partitura inexistente.");
        }
        for (Midia midia : listTemp) {
            System.out.println(midia.toString());
        }
    }

    @Override
    public boolean editarMidia() {
        List<Partitura> listTemp;
        Scanner e = new Scanner(System.in);
        String titulo = null, descricao = null, ano = null, genero = null, instrumento = null, codigo = null, autores = null;
        System.out.println("\nDigite o titulo da Partitura que deseja Editar:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        listTemp = gerenciadorPartitura.consulta(titulo);
        if (!listTemp.isEmpty()) {
            for (Midia partitura : listTemp) {
                System.out.println(partitura.toString());
            }
            System.out.println("ESSAS SÃO AS PARTITURAS EXISTENTES COM O TÍTULO INFORMADO.");
            System.out.println("Informe o código da partitura que deseja editar: ");
            codigo = ValidarEntradaUsuario.nextInt(codigo);
            for (Partitura partitura : listTemp) {
                if (partitura.getCodigo().equalsIgnoreCase(codigo)) {
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
                    System.out.println("Digite ENTER caso não deseje editar este item:");
                    System.out.println("Novos autores da partitura: ");
                    autores = ValidarEntradaUsuario.entradaEnterTexto(autores);
                    if (autores.equals("")) {
                    } else {
                        partitura.setAutores(autores);
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
                    if (gerenciadorPartitura.edicao(partitura)) {
                        System.out.println("Editado com sucesso.");
                    } else {
                        System.out.println("Não foi possível editar.");
                        return false;
                    }
                }
            }
        } else {
            System.out.println("Musica inexistente.");
            return false;
        }
        return false;
    }
}
