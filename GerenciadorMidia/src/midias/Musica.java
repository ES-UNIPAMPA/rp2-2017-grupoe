package midias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Débora Siqueira
 */
public class Musica extends Midia {

    private String duracao;
    private String idioma;
    private List<String> interpretes;
    private List<String> autores;
    public static List<String> menu = new ArrayList(Arrays.asList("Digite o idioma da Música: ", "Digite a duração do filme: "));
    public static List<String> variaveis = new ArrayList();

    public Musica(String codigo, String caminho, String titulo, String descricao, String genero, List autores, String ano, String duracao, List interprete, String idioma) {
        super(codigo, caminho, titulo, descricao, genero, ano);
        this.duracao = duracao;
        this.interpretes = interprete;
        this.idioma = idioma;
        this.autores = autores;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the interpretes
     */
    public List<String> getInterpretes() {
        return interpretes;
    }

    /**
     * @param interpretes the interpretes to set
     */
    public void setInterpretes(List<String> interpretes) {
        this.interpretes = interpretes;
    }

    /**
     * @return the autores
     */
    public List<String> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    /**
     * Método toString para representar os atributos do objeto
     *
     * @return retorna uma String com todas as informações
     */
    @Override
    public String toString() {
        return String.format("Caminho: %s \n"
                + "Titulo: %s \n"
                + "Descrição: %s \n"
                + "Genero: %s \n"
                + "Idioma: %s \n"
                + "Ano: %s \n"
                + "Duração: %s \n"
                + "Autores: %s \n"
                + "Interpretes: %s \n",
                caminho, titulo, descricao, genero, idioma, ano, duracao, autores, interpretes);
    }

}
