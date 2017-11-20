package midias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class Filme extends Midia {

    /**
     * @return the atores
     */
    public List<String> getAtores() {
        return atores;
    }

    /**
     * @param atores the atores to set
     */
    public void setAtores(List<String> atores) {
        this.atores = atores;
    }

    private String genero;
    private String idioma;
    private String diretor;
    private String ano;
    private String duracao;
    private List<String> atores;
    public static List<String> menu = new ArrayList(Arrays.asList("Digite o idioma:", "Digite o nome do diretor: ", "Digite a duração: "));
    public static List<String> variaveis = new ArrayList();

    public Filme( String codigo, String caminho, String titulo, String descricao, String genero, String idioma, String diretor, List atores, String duracao, String ano) {
        super( codigo, caminho, titulo, descricao, genero, ano);
        this.idioma = idioma;
        this.diretor = diretor;
        this.atores = atores;
        this.duracao = duracao;       
    }

   
    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

  

    /**
     * @return the diretor
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
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
     * @return the duracao
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    
    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }


    /**
     * Método toString para representar organizado os dados
     *
     * @return retorna uma String com todas as informações em ordem
     */
    //TO STRING
   
   @Override
     public String toString() {
        return String.format("Caminho: %s \n"
                + "Titulo: %s \n"
                + "Descrição d: %s \n"
                + "Genero: %s \n"
                + "Idioma: %s \n"
                + "Diretor:  %s \n"
                + "Ano: %s \n"
                + "Duração: %s \n"
                + "Atores: %s \n",
                caminho, titulo, descricao, genero, idioma, diretor, ano, duracao, atores);
    }

    
    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

}
