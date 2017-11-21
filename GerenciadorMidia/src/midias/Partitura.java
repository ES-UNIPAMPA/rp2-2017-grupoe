package midias;

public class Partitura extends Midia {

    private String ano;
    private String autores;
    private String genero;
    private String instrumentos;

    public Partitura(String caminho, String titulo, String descricao, String ano, String autores, String genero, String instrumentos) {
        super(caminho, titulo, descricao);
        this.ano = ano;
        this.autores = autores;
        this.genero = genero;
        this.instrumentos = instrumentos;
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * Método toString para representar os atributos do objeto
     *
     * @return retorna uma String com todas as informações
     */
    @Override
    public String toString() {        
        return String.format("Caminho: %s \n"
                + "Titulo da partitura: %s \n"
                + "Descrição da Partitura: %s \n"
                + "Instrumento (os): %s \n"
                + "Autor da Partitura: %s \n"
                + "Ano de Crição da Partitura: %s \n"
                + "Gênero da Partitura: %s \n ",
                caminho, titulo, descricao, instrumentos, autores, ano, genero);
    }

    @Override
    public String toFile() {
        String dados;
        dados = this.caminho + "\n" + this.titulo + "\n" + this.descricao + "\n" + this.autores + "\n" + this.ano + "\n" + this.genero + "\n" + this.instrumentos;
        return dados;
    }

    public String getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(String instrumentos) {
        this.instrumentos = instrumentos;
    }

}
