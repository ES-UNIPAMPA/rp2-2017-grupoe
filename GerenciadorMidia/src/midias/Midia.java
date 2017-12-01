package midias;

import java.util.Objects;

public class Midia {

    protected String caminho;
    protected String titulo;
    protected String descricao;
    protected String codigo;

    public Midia(String codigo, String caminho, String titulo, String descricao) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Midia other = (Midia) obj;
        if (!Objects.equals(this.caminho, other.caminho)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
}
