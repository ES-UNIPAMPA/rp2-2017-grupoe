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
        getListMidias().add(midia);
        return salvar();
    }

    /**
     * Método para consultar uma midia
     *
     * @param titulo
     * @param codigo
     * @return retorna a mdia desejada caso o codigo exista. Caso contrário
     * retorna null
     */
    @Override
    public Midia consulta(String titulo, String codigo) {
        for (Midia midia : getListMidias()) {
            if (midia.getTitulo().equalsIgnoreCase(titulo) || midia.getCodigo().equalsIgnoreCase(codigo)) {
                salvar();
                return midia;
            }
        }
        return null;
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
     * @param titulo
     * @param novaMidia é recebido para editar a midia existente
     * @return Caso a edição seja realizado com sucesso, retornara true. Caso
     * contrário retornara false
     */
    @Override
    public boolean edicao(String titulo, Midia novaMidia) {
        for (int i = 0; i < getListMidias().size(); i++) {
            if (getListMidias().get(i).equalsTitulo(titulo)) {
                getListMidias().set(i, novaMidia);
                return true;
            }
        }
        return false;
    }
    
      /**
     * @return the listMidias
     */
    public List<Midia> getListMidias() {
        return listMidias;
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
        for (Midia midia : getListMidias()) {
            if (midia.getTitulo().equalsIgnoreCase(titulo) || midia.getCodigo().equalsIgnoreCase(codigo)) {
                getListMidias().remove(midia);
                salvar();
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
                dados.get(9));
        adicionar(novo);

    }

    private void montarMusica(ArrayList<String> dados) {
        Midia musica = new Musica(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8));
        adicionar(musica);

    }

    private void montarPartitura(ArrayList<String> dados) {
        Midia novo = new Partitura(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6));

        adicionar(novo);
    }

    public Filme ordenarFilmes(List filmes) {
        int tamanho = filmes.size();
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                Filme auxiliar = (Filme) filmes.get(j);
                Filme troca = (Filme) filmes.get(j+1);
                if(auxiliar.compareTo(troca)>0) {
                    auxiliar = (Filme) filmes.get(j);          
                    Filme alvo = (Filme)filmes.get(j);
                    troca = (Filme) filmes.get(j+1);
                    alvo = troca;
                    troca = auxiliar;                 
                }
            }
        }
        return null;
    }
}
