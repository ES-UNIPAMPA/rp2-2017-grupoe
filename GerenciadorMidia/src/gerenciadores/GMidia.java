package gerenciadores;

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
    private List<Midia> listMidias;

    /**
     * Construtor que inicializa a lista
     *
     * @param listaMidia recebe o tipo de lista desejada.
     * @param caminho
     */
    public GMidia(List listaMidia, String caminho) {
        this.listMidias = listaMidia;
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
        listMidias.add(midia);
        return salvar();
    }

    /**
     * Método para consultar uma midia
     *
     * @param titulo para identificar a midia.
     * @return retorna uma list com todas as midias contendo o titulo passado.
     */
    @Override
    public List consulta(String titulo) {
        ArrayList<Midia> listaR = new ArrayList<>();
        for (Midia midia : getListMidias()) {
            if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                listaR.add(midia);

            }
        }
        return listaR;
    }

    /**
     * Método para exibir uma midia
     *
     * @param nome recebedio para exibir todo tipo de midia com esse parametro
     * @return Caso contenha as midias ele retornara. Caso contrário retornara
     * null
     */
    @Override
    public Midia exibir(String nome) {
        for (Midia midia : getListMidias()) {
            if (midia.getTitulo().equalsIgnoreCase(nome)) {
                salvar();
                return midia;
            }
        }
        return null;
    }

    /**
     * Método para editar uma midia
     *
     * @param novaMidia é recebido para editar a midia existente
     * @return Caso a edição seja salva com sucesso, retornara true. Caso
     * contrário retornara false
     */
    @Override
    public boolean edicao(Midia novaMidia) {
        for (int i = 0; i < listMidias.size(); i++) {
            if (listMidias.get(i).equals(novaMidia)) {
                listMidias.set(i, novaMidia);
            }
        }
        return salvar();
    }

    /**
     * @return retorna uma list com todas as midias
     */
    public List<Midia> getListMidias() {
        return listMidias;
    }

    /**
     * Método para excluir uma midia
     *
     * @param midias recebido para excluir a midia informada
     * @return Vai retornar verdadeiro caso a remoção seja realizada com
     * sucesso. Caso contrário retornara false
     */
    @Override
    public boolean exclusao(Midia midias) {
        for (Midia midia : listMidias) {
            if (midia.equals(midias)) {
                listMidias.remove(midia);
                return salvar();
            }

        }
        return false;
    }

    @Override
    public void classifica(ArrayList<Midia> midia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método para salvar uma midia
     *
     * @return Retornara true caso a midia seja salva com sucesso. Caso
     * contrário retorna true.
     */

    public boolean salvar() {
        String novaLinha = System.getProperty("line.separator");
        try {
            FileWriter escreverNoArquivo = new FileWriter(new File(caminho));
            escreverNoArquivo.write(String.valueOf(getListMidias().size()));
            escreverNoArquivo.write(novaLinha + novaLinha);
            for (Midia midia : getListMidias()) {
                escreverNoArquivo.write(midia.toFile());
                escreverNoArquivo.write(novaLinha + " " + novaLinha);
            }
            escreverNoArquivo.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    /**
     * Método para carregar uma midia.
     *
     * @return Retorna verdadeiro caso o carregamento seja realizado com
     * sucesso. Caso contrário retornara falso.
     */
    public boolean carregar() {
        File arquivo;
        arquivo = new File(caminho);
        if (arquivo.exists()) {
            ArrayList<String> dados = new ArrayList();
            try {
                FileReader fileReader = new FileReader(arquivo);
                BufferedReader buffR = new BufferedReader(fileReader);
                String linhas;
                buffR.readLine();
                buffR.readLine();
                int cont = 0;
                while ((linhas = buffR.readLine()) != null) {
                    if (!linhas.equals(" ")) {
                        dados.add(linhas);
                        cont++;
                    } else {
                        montarMidia(dados, arquivo);
                        cont = 0;
                    }
                }
            } catch (FileNotFoundException ex) {
                return false;
            } catch (IOException ex) {
                return false;
            }
        }
        return true;
    }
/**
 * Método que identifica o nome da midia.
 * @param dados contendo os dados do arquivo txt.
 * @param arquivo contendo o nome do arquivo.
 */
    private void montarMidia(ArrayList<String> dados, File arquivo) {

        switch (arquivo.getName()) {
            case "filme.txt":
                montarFilme(dados);
                break;
            case "musica.txt":
                montarMusica(dados);
                break;
            case "partitura.txt":
                montarPartitura(dados);
                break;
            default:
                System.out.println("Nome de arquivo inválido!");
                break;
        }

    }
/**
 * Método que cria o objeto filme inserindo os dados do ArrayList dados.
 * @param dados ArrayList contendo as informações do arquivo txt.
 */
    private void montarFilme(ArrayList<String> dados) {
        Midia novo = new Filme(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8),
                dados.get(9),
                dados.get(10));
        listMidias.add(novo);
        dados.clear();

    }
/**
 * Método que cria o objeto música inserindo os dados do ArrayList dados.
 * @param dados ArrayList contendo as informações do arquivo txt.
 */
    private void montarMusica(ArrayList<String> dados) {
        Midia musica = new Musica(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8),
                dados.get(9));
        listMidias.add(musica);
        dados.clear();

    }
/**
 *Método que cria o objeto partitura inserindo os dados do ArrayList dados.
 *@param dados ArrayList contendo as informações do arquivo txt.
 */
    private void montarPartitura(ArrayList<String> dados) {
        Midia novo = new Partitura(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7));
        listMidias.add(novo);
        dados.clear();
    }
/**
 * Método de ordenação do Filme
 * @param filmes recebe uma list com as midias
 * @return 
 */
    public Filme ordenarFilmes(List filmes) {
        int tamanho = filmes.size();
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                Filme auxiliar = (Filme) filmes.get(j);
                Filme troca = (Filme) filmes.get(j + 1);
                if (auxiliar.compareTo(troca) > 0) {
                    Filme aux = (Filme) filmes.get(j);
                    filmes.set(i, filmes.get(j + 1));
                    filmes.set(i + 1, aux);
                }
            }
        }
        return null;
    }
/**
 * Método de ordenação da música
 * @param listaMusica recebe uma lista com as midias. 
 */
    public void ordenarMusica(List listaMusica) {
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 0; i < listaMusica.size() - 2; i++) {
                Musica musica = (Musica) listaMusica.get(i);
                Musica musica2 = (Musica) listaMusica.get(i + 1);
                if (musica.compareTo(musica2) > 0) {
                    Musica aux = (Musica) listaMusica.get(i);
                    listaMusica.set(i, listaMusica.get(i + 1));
                    listaMusica.set(i + 1, aux);
                    houveTroca = true;
                }
            }
            if (!houveTroca) {
                break;
            }
            for (int i = listaMusica.size() - 2; i >= 0; i--) {
                Musica musica = (Musica) listaMusica.get(i);
                Musica musica2 = (Musica) listaMusica.get(i + 1);
                if (musica.compareTo(musica2) > 0) {
                    Musica aux = (Musica) listaMusica.get(i);
                    listaMusica.set(i, listaMusica.get(i + 1));
                    listaMusica.set(i + 1, aux);
                    houveTroca = true;
                }
            }

        } while (houveTroca);
    }
/**
 * Método de ordenação da partitura.
 * @param partitura recebe uma list com as midias. 
 */
    public void ordenarPartitura(List<Midia> partitura) {

        boolean houveTroca;
        int contador = 1;
        Partitura temp;

        do {
            /* quando começamos a avaliar o vetor, não há trocas */
            houveTroca = false;

            for (int i = 0; i < partitura.size() - contador; i++) {

                /* se o elemento i e o próximo estão na ordem trocada */
                if (partitura.get(i).getTitulo().compareToIgnoreCase(partitura.get(i + 1).getTitulo()) >= 0) {
                    /* troca de lugar os conteúdos deles */

                    temp = (Partitura) partitura.get(i);
                    partitura.set(i, partitura.get(i + 1));
                    partitura.set(i + 1, temp);

                    /* marca que houve troca */
                    houveTroca = true;
                }
            }
            contador++;
        } while (houveTroca);

    }
}
