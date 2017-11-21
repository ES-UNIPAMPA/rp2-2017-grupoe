package gerenciadores;

import static gerenciadores.gerPrincipal.listMidia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import midias.*;

public class GMidia extends gerPrincipal {
    
    String caminho;

    /**
     * Construtor que inicializa a lista
     *
     * @param listaMidia recebe o tipo de lista desejada.
     */
    public GMidia(List listaMidia, String caminho) {
        listMidia = listaMidia;
        this.caminho = caminho;

    }

    public GMidia() {

    }

    /**
     * Método para adicionar uma midia
     *
     * @param midia Recebe a midia que será adicionada
     * @return Retorna true caso a midia foi adicionada. Caso contrário retorna
     * false.
     */
    @Override
    public boolean adicionar(Midia midia) {
        return listMidia.add(midia);

    }

    /**
     * Método para consultar uma midia
     *
     * @param titulo
     * @return retorna a mdia desejada caso o codigo exista. Caso contrário
     * retorna null
     */
    @Override
    public Midia exibir(String dado) {
        for (int i = 0; i < listMidia.size(); i++) {
            Midia mostra = listMidia.get(i);
            //confere se o dado é igual ao titulo ou igual ao codigo
            if (mostra.getTitulo().equals(dado) || mostra.getCodigo().equals(dado)) {
                System.out.println(mostra);
                return mostra;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * Método para consultar uma midia
     *
     * @param nome recebedio para exibir todo tipo de midia com esse parametro
     * @return Caso contenha as midias ele retornara. Caso contrário retornara
     * null
     */
    public Midia consultar(String titulo, String codigo) {
        for (int i = 0; i < listMidia.size(); i++) {
            Midia retorna = listMidia.get(i);
            if (retorna.getTitulo().equals(titulo) || retorna.getCodigo().equals(codigo)) {
                return retorna;
            }
        }
        return null;
    }

    /**
     * Método para editar uma midia
     *
     * @param titulo
     * @param novaMidia é recebido para editar a midia existente
     * @return Caso a edição seja realizado com sucesso, retornara true. Caso
     * contrário retornara false
     */
    @Override
    public boolean edicao(String titulo, Midia novaMidia) {
        for (int i = 0; i < listMidia.size(); i++) {
            if (listMidia.get(i).equalsTitulo(titulo)) {
                listMidia.add(i, novaMidia);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para excluir uma midia
     *
     * @param titulo é recebido para identificar a midia que ira ser excluida.
     * @param codigo
     * @return Vai retornar verdadeiro caso a remoção seja realizada com
     * sucesso. Caso contrário retornara false
     */
    @Override
    public boolean exclusao(String titulo, String codigo) {
        for (int i = 0; i < listMidia.size(); i++) {
            Midia escolhida = listMidia.get(i);
            if (escolhida.getTitulo().equals(titulo) || escolhida.getCodigo().equals(codigo)) {
                listMidia.remove(escolhida);
                return true;
            }
        }
        return false;
    }

    @Override
    public void classifica(ArrayList<Midia> midia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public boolean salvar() {
        String novaLinha = "\n";
        try {
            try (FileWriter escritor = new FileWriter(new File(caminho))) {
                escritor.write(String.valueOf(listMidia.size()));
                escritor.write(novaLinha + novaLinha);
                for (Midia midia : listMidia) {
                    escritor.write(midia.toFile());
                    escritor.write(novaLinha + " " + novaLinha);
                }
            }
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
        return true;
    }

    public boolean carregar() throws FileNotFoundException, IOException {
        File arquivoTxT;
        arquivoTxT = new File(caminho);
        if (arquivoTxT.exists()) {
            ArrayList<String> dados = new ArrayList<>();
            FileReader file = new FileReader(arquivoTxT);
            BufferedReader buff = new BufferedReader(file);
            String linhas;
            buff.readLine();
            buff.readLine();
            int cont = 0;
            while ((linhas = buff.readLine()) != null) {
                if (!linhas.equals(" ")) {
                    dados.add(linhas);
                    cont++;
                } else {
                    montarMidia(dados, arquivoTxT);
                    cont = 0;
                }
            }
        }
        return true;
    }

    private void montarMidia(ArrayList<String> dados, File arquivo) {
        switch (arquivo.getName()) {
            case "musica.txt":
                montarMusica(dados);
                break;
            case "partitura.txt":
                montarPartitura(dados);
                break;
            case "filme.txt":
                montarFilme(dados);
                break;
            default:
                System.out.println("O Arquivo não foi encontrado D=");
        }
    }

    private void montarMusica(ArrayList<String> dados) {
        Midia novo = new Musica(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8),
                dados.get(9));
    }

    private void montarPartitura(ArrayList<String> dados) {
        Midia novo = new Partitura(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7));
    }

    private void montarFilme(ArrayList<String> dados) {
        Midia novo = new Musica(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8),
                dados.get(9));
    }

}
