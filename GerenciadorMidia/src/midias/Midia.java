package midias;

public class Midia {

    
    protected String caminho;
    protected String titulo;
    protected String descricao;

    public Midia( String caminho, String titulo, String descricao) {
        
        this.caminho = caminho;
        this.titulo = titulo;
        this.descricao = descricao;
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
    
    
    public boolean equalsTitulo(String nome){
      return this.titulo.equalsIgnoreCase(nome);
    }
}
