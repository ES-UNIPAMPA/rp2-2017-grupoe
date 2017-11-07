package midias;

import java.util.ArrayList;

public class Midia {

    protected char abreviatura;
    protected int codigo;
    protected String caminho;
    protected String titulo;
    protected String descricao;
    protected String genero;
    protected String autores;
    private ArrayList<Midia> todas = new ArrayList();

    public Midia() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public Midia getMidia(String c) {
        for (int i = 0; i < todas.size(); i++) {
            if (c.equals(todas.get(i).getCodigo())) {
                System.out.println(todas.get(i).toString());
                return todas.get(i);
            }
        }
        System.out.println("Foto não encontrada!!");
        return null;
    }

    public boolean adicionarMidia(Midia f) {
        if (f != null) {
            todas.add(f);
            return true;
        } else {
            System.out.println("Nenhuma midia adicionada!");
        }
        return false;
    }

    public String delMidia(String c) {
        for (int i = 0; i < todas.size(); i++) {
            if (c.equals(todas.get(i).getCodigo())) {
                String temp = todas.get(i).toString();
                todas.remove(i);
                return temp;
            }
        }
        System.out.println("Midia não encontrada!!");
        return null;
    }
}
