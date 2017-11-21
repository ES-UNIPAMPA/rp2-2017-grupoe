package midias;

public class Midia {

    protected String caminho;
    protected String titulo;
    protected String descricao;
    private String codigo;

    public Midia(String caminho, String titulo, String descricao, String codigo) {

        this.caminho = caminho;
        this.titulo = titulo;
        this.descricao = descricao;
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

    public boolean equalsTitulo(String nome) {
        return this.titulo.equalsIgnoreCase(nome);
    }

    public String toFile() {
        return "";
    }

    @Override
    public String toString() {
        return "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
