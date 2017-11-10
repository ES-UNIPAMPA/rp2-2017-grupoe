package midias;

public class Partitura extends Midia {

    private String instrumentos;
    private String ano;
    private String autores;
    private String genero;

    public Partitura(String codigo, String caminho, String titulo, String descricao, String instrumentos, String ano, String autores, String genero) {
        super(codigo, caminho, titulo, descricao);
        this.instrumentos = instrumentos;
        this.ano = ano;
        this.autores = autores;
        this.genero = genero;
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

    public String getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(String instrumentos) {
        this.instrumentos = instrumentos;
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
        return String.format("Titulo da partitura: %s \n"
                + "Descrição da Partitura: %s \n"
                + "Instrumento (os): %s \n"
                + "Autor da Partitura: %s \n"
                + "Ano de Crição da Partitura: %s \n"
                + "Gênero da Partitura: %s \n ", 
                titulo, descricao, instrumentos, autores, ano, genero);
    }

}
