package midias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class Filme extends Midia {

    private String genero;
    private String idioma;
    private String diretor;
    private String atores;
    private String ano;
    private String duracao;
    public static List<String> menu = new ArrayList(Arrays.asList("Digite o genero do filme: ", "Digite o nome do diretor do filme: ","Digite o nome dos atores principais: (separados por espaço): ", "Digite a duração do filme: "));
    public static List<String> variaveis = new ArrayList();

    public Filme(String codigo, String caminho, String titulo, String descricao, String genero, String idioma, String diretor, String atores, String duracao, String ano) {
        super(codigo, caminho, titulo, descricao);
        this.genero = genero;
        this.idioma = idioma;
        this.diretor = diretor;
        this.atores = atores;
        this.ano = ano;
        this.duracao = ano;       
    }

    /**
     * @return the aumentaCodigo
     */
    @Override
    public String getCodigo() {
        return codigo;
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

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the atores
     */
    public String getAtores() {
        return atores;
    }

    /**
     * @param atores the atores to set
     */
    public void setAtores(String atores) {
        this.atores = atores;
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
        return "\nCodigo: " + codigo + " \nCaminho: " + caminho + " \nTitulo: " + titulo + " \nDescricao: " + descricao + " \nGenero:  " + getGenero() + " \nIdioma: " + idioma + " \nDiretor: " + diretor + " \nAtores: " + atores + " \nAno: " + ano + " \nDuracao: " + duracao + "\n";
    }
    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

}
