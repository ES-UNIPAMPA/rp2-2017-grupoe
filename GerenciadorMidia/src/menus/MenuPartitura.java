package menus;

import gerenciadores.GMidia;
import java.util.*;
import midias.*;

public class MenuPartitura implements IMenu {

    GMidia gerenciadorPartitura = new GMidia(new ArrayList());

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
                    Midia partitura = consultarMidia();
                    if (partitura == null) {
                        System.out.println("\nPartitura inexistente.");
                    } else {
                        System.out.println(partitura.toString());
                    }
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
        Random gerador = new Random();
        Scanner entrada = new Scanner(System.in);
        char ola;
        char tchau;
        ola = 's';
        tchau = 's';
        String codigo, caminho, titulo, descricao, ano, genero, toc, tic;
        ColecaoDeCoisas autores = new ColecaoDeCoisas();
        ColecaoDeCoisas instrumento = new ColecaoDeCoisas();
        System.out.println("\nDigite o título da Partitura:");
        titulo = entrada.nextLine();
        System.out.println("Digite o genero da Partitura:");
        genero = entrada.nextLine();
        System.out.println("Digite a descrição da Partitura:");
        descricao = entrada.nextLine();
        System.out.println("Digite o ano da Partitura:");
        ano = entrada.nextLine();
        System.out.println("Digite o (os) instrumento (os) da Partitura:");
        //Não estou conseguindo inserir mais de um elemento
        while (ola == 's'){
            toc = entrada.nextLine();
            instrumento.addColecaoDeCoisas(toc);
            System.out.println("Caso queira adicionar mais instrumentos, digite 's'");
            ola = entrada.next().charAt(0);
        } 
        System.out.println("Digite o Autor da Partitura:");
        do {
            tic = entrada.nextLine();
            autores.addColecaoDeCoisas(tic);
            System.out.println("Caso queira adicionar mais autores, digite 's'");
            tchau = entrada.next().charAt(0);
        } while (tchau == 's');
        int codigoNumero = gerador.nextInt(1000);
        codigo = "" + codigoNumero;
        System.out.println("Codigo da sua Partitura: " + codigo);
        caminho = new java.io.File(".").getAbsolutePath();
        Partitura partitura = new Partitura(codigo, caminho, titulo, descricao, instrumento, ano, autores, genero);
        if (gerenciadorPartitura.adicionar(partitura)) {
            System.out.println("\nPartitura adicionada com sucesso! =D");
            return true;
        }
        return false;
    }

    @Override
    public boolean excluirMidia() {
        Scanner entrada = new Scanner(System.in);
        String codigo;
        System.out.println("\nDigite o codigo da Partitura que deseja excluir:");
        codigo = entrada.nextLine();
        System.out.println(gerenciadorPartitura.consulta(codigo));
        System.out.println("\nTem certeza que deseja excluir essa Partitura?"
                + "\n1 - SIM"
                + "\n2 - NÃO");
        int res = entrada.nextInt();
        switch (res) {
            case 1:
                if (gerenciadorPartitura.exclusao(codigo)) {
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
    public Midia consultarMidia() {
        Scanner entrada = new Scanner(System.in);
        String consulta;
        System.out.println("\nDigite o codigo da Partitura que deseja consultar:");
        consulta = entrada.nextLine();
        Partitura partitura = (Partitura) gerenciadorPartitura.consulta(consulta);
        return partitura;
    }

    @Override
    public boolean editarMidia() {
        Scanner e = new Scanner(System.in);
        String codigo, caminho, titulo, descricao, ano, genero;
        ColecaoDeCoisas instrumentos = new ColecaoDeCoisas();
        ColecaoDeCoisas autores = new ColecaoDeCoisas();
        System.out.println("\nDigite o codigo da Partitura que deseja Editar:");
        codigo = e.nextLine();
        Partitura partitura = (Partitura) gerenciadorPartitura.consulta(codigo);
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo titulo da Partitura: ");
        titulo = e.nextLine();
        if (titulo.equals("")) {
        } else {
            partitura.setTitulo(titulo);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Nova descricao da Partitura: ");
        descricao = e.nextLine();
        if (descricao.equals("")) {
        } else {
            partitura.setDescricao(descricao);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo genero da Partitura: ");
        genero = e.nextLine();
        if (genero.equals("")) {
        } else {
            partitura.setGenero(genero);
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo instrumento da Partitura: ");
        for (int i = 0; i < partitura.instrumento.getNroColecaoDeCoisas(); i++) {
            String toc = e.nextLine();
            instrumentos.addColecaoDeCoisas(toc);
            if (toc.equals("")) {
            } else {
                partitura.setInstrumentos(instrumentos);
            }
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo nome do autor da Partitura: ");
        for (int i = 0; i < partitura.instrumento.getNroColecaoDeCoisas(); i++) {
            String tic = e.nextLine();
            autores.addColecaoDeCoisas(tic);
            if (tic.equals("")) {
            } else {
                partitura.setAutores(autores);
            }
        }
        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo ano da Partitura: ");
        ano = e.nextLine();
        if (ano.equals("")) {
        } else {
            partitura.setAno(ano);
        }

        System.out.println("Digite ENTER caso nao deseje editar este item.");
        System.out.println("Novo caminho do Arquivo: ");
        caminho = e.nextLine();
        if (caminho.equals("")) {
        } else {
            partitura.setCaminho(caminho);
        }
        System.out.println("\nPartitura editada com sucesso!!\n");
        return false;
    }
}
