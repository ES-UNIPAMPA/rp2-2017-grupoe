package midias;

public class Midia {

    protected String codigo;
    protected String caminho;
    protected String titulo;
    protected String descricao;

    public Midia(String codigo, String caminho, String titulo, String descricao) {
        this.codigo = codigo;
        this.caminho = caminho;
        this.titulo = titulo;
        this.descricao = descricao;
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
}
