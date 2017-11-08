package midias;

import java.util.ArrayList;

public class Filme extends Midia {

    private String genero;
    private String idioma;
    private String diretor;
    private String atores;
    private String ano;
    private String duracao;

    public Filme(String codigo, String caminho, String titulo, String descricao, String genero, String idioma, String diretor, String atores, String duracao, String ano) {
        super(codigo, caminho, titulo, descricao);
        this.genero = genero;
        this.diretor = diretor;
        this.atores = atores;
        this.ano = ano;
        this.duracao = ano;
    }

    /**
     * @return the aumentaCodigo
     */
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



    @Override
    public String toString() {
        return "\nCodigo: " + codigo + " \nCaminho: " + caminho + " \ntitulo: " + titulo + " \nDescricao: " + descricao + " \nGenero:  " + getGenero() + " \nIdioma: " + idioma + " \nDiretor: " + diretor + " \nAtores: " + atores + " \nAno: " + ano + " \nDuracao: " + duracao + "\n";
    }

    public int compareTo(Filme outroFilme) {
        if (this.codigo == outroFilme.getCodigo()) {
            return -1;
        } else if (this.codigo != outroFilme.getCodigo()) {
            return +1;
        } else {
            return 0;
        }
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

}
