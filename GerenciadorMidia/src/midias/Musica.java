
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

    public Musica(String codigo, String caminho, String titulo, String descricao, String genero, String autores, String ano, String duracao, String interprete, String idioma) {
        super(codigo, caminho, titulo, descricao);
        this.ano = ano;
        this.duracao = duracao;
        this.interprete = interprete;
        this.idioma = idioma;
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
 * @return retorna uma String com todas as informações
 */
    @Override
    public String toString() {
        String dados;
        dados = "Título da musica: " + this.titulo + "\n" + "Autores da musica: " + this.autores + "\n" + "Descrição da musica: " + this.descricao + "\n" + "Genero da musica: " + this.genero + "\n" + "Idioma da musica: " + this.idioma + "\n" + "Interprete: " + this.interprete + "\n" + "Duração da musica:" + this.duracao;
        return dados;
    }
}
