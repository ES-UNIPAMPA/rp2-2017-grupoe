package midias;

public class Midia {

    protected String codigo;
    protected String caminho;
    protected String titulo;
    protected String descricao;
    protected String genero;
    protected String autores;

    public Midia(String codigo, String caminho, String titulo, String descricao, String genero, String autores) {
        this.codigo = codigo;
        this.caminho = caminho;
        this.titulo = titulo;
        this.descricao = descricao;
        this.genero = genero;
        this.autores = autores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }
}
