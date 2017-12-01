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

    public Filme(String codigo, String caminho, String titulo, String descricao, String genero, String idioma, String diretor, String atores, String duracao, String ano, String local) {
        super(codigo, caminho, titulo, descricao);
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
    public int getAno() {
        int anoint = Integer.parseInt(this.ano);
        return anoint;
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
        return String.format("CÓDIGO: %s \n"
                + "Caminho: %s \n"
                + "Titulo : %s \n"
                + "Descrição : %s \n"
                + "Genero: %s \n"
                + "Idioma: %s \n"
                + "Diretor:  %s \n"
                + "Ano: %s \n "
                + "Duração: %s \n"
                + "Atores: %s \n",
                super.codigo, caminho, titulo, descricao, genero, idioma, diretor, ano, duracao, atores);
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
        dados = super.codigo + "\n" + caminho + "\n" + titulo + "\n" + descricao + "\n" + genero + "\n" + idioma + "\n" + diretor + "\n" + ano + "\n" + duracao + "\n" + this.atores + "\n" + this.local;
        return dados;
    }

    public int compareTo(Filme outro) {
        if (getAno() < outro.getAno()) {
            return -1;
        } else if (getAno() > outro.getAno()) {
            return +1;
        } else {
            return 0;
        }
    }
}
