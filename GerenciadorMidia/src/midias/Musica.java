package midias;

import java.util.Objects;

/**
 *
 * @author Débora Siqueira
 */
public class Musica extends Midia implements Comparable<Musica> {

    private String ano;
    private String duracao;
    private String interprete;
    private String idioma;
    private String autores;
    private String genero;

    public Musica(String codigo, String caminho, String titulo, String descricao, String genero, String autores, String ano, String duracao, String interprete, String idioma) {
        super(codigo, caminho, titulo, descricao);
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
     * Método toString para representar organizado os dados
     *
     * @return retorna uma String com todas as informações em ordem
     */
    //TO STRING
    @Override
    public String toString() {
        return String.format("CÓDIGO: %s \n"
                + "Caminho: %s \n"
                + "Titulo: %s \n"
                + "Autores: %s \n"
                + "Descrição: %s \n"
                + "Genero: %s \n"
                + "Idioma: %s \n"
                + "Iterprete:  %s \n"
                + "Ano: %s \n"
                + "Duração: %s \n",
                super.codigo, caminho, titulo, autores, descricao, genero, idioma, interprete, ano, duracao);
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

    @Override
    public String toFile() {
        String dados;
        dados = super.codigo + "\n" + this.caminho + "\n" + this.titulo + "\n" + this.descricao + "\n" + this.genero + "\n" + this.autores + "\n" + this.ano + "\n" + this.duracao + "\n" + this.interprete + "\n" + this.idioma;
        return dados;
    }

    @Override
    public int compareTo(Musica o) {
        if (Integer.parseInt(ano) > Integer.parseInt(o.ano)) {
            return -1;
        }
        if (Integer.parseInt(ano) < Integer.parseInt(o.ano)) {
            return 1;
        }
        return 0;
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
        final Musica other = (Musica) obj;
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.duracao, other.duracao)) {
            return false;
        }
        if (!Objects.equals(this.interprete, other.interprete)) {
            return false;
        }
        if (!Objects.equals(this.idioma, other.idioma)) {
            return false;
        }
        if (!Objects.equals(this.autores, other.autores)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        return true;
    }

}
