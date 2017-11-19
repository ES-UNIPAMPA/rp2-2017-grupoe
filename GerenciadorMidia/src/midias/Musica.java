package midias;

/**
 * 
 * @author Débora Siqueira
 */
public class Musica extends Midia {

    private String ano;
    private String duracao;
    private String interprete;
    private String idioma;
    private String autores;
    private String genero;

    public Musica( String caminho, String titulo, String descricao, String genero, String autores, String ano, String duracao, String interprete, String idioma) {
        super( caminho, titulo, descricao);
        this.ano = ano;
        this.duracao = duracao;
        this.interprete = interprete;
        this.idioma = idioma;
        this.genero = genero;
        this.autores = autores;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Método toString para representar os atributos do objeto
     *
     * @return retorna uma String com todas as informações
     */
    @Override
    public String toString() {
        String dados;
        dados = "Caminho do Arquivo: " + this.caminho + "\n" + "Título da Música: " + this.titulo + "\n" + "Autores da Música: " + this.autores + "\n" + "Descrição da Música: " + this.descricao + "\n" + "Genero da Música: " + this.genero + "\n" + "Idioma da Música: " + this.idioma + "\n" + "Interprete: " + this.interprete + "\n" + "Duração da Música:" + this.duracao;
        return dados;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
