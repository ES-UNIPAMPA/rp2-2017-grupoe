package midias;

/**
 *
 * @author Rafael
 */
public class Filme extends Midia {

    private String genero;
    private String idioma;
    private String diretor;
    private String ano;
    private String duracao;
    private String atores;
    private String local;

    public Filme(String caminho, String titulo, String descricao, String codigo, String genero, String idioma, String diretor, String atores, String duracao, String ano, String local) {
        super(caminho, titulo, descricao, codigo);
        this.genero = genero;
        this.idioma = idioma;
        this.diretor = diretor;
        this.atores = atores;
        this.ano = ano;
        this.duracao = duracao;
        this.local = local;
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
                + "Titulo : %s \n"
                + "Descrição d: %s \n"
                + "Genero: %s \n"
                + "Idioma: %s \n"
                + "Diretor:  %s \n"
                + "Ano: %s \n "
                + "Duração: %s \n"
                + "Atores: %s \n",
                caminho, titulo, descricao, genero, idioma, diretor, ano, duracao, getAtores());
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    @Override
    public String toFile() {
        String dados;
        dados = caminho + "\n" + titulo + "\n" + descricao + "\n" + genero + "\n" + idioma + "\n" + diretor + "\n" + ano + "\n" + duracao + "\n" + this.atores + "\n" + this.local;
        return dados;
    }
}
