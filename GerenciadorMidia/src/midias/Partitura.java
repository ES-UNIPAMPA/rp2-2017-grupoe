package midias;

public class Partitura extends Midia {

    public ColecaoDeCoisas instrumento;
    private String ano;
    private ColecaoDeCoisas autores;
    private String genero;

    public Partitura(String codigo, String caminho, String titulo, String descricao, ColecaoDeCoisas instrumento, String ano, ColecaoDeCoisas autores, String genero) {
        super(codigo, caminho, titulo, descricao);
        this.instrumento = instrumento;
        this.ano = ano;
        this.autores = autores;
        this.genero = genero;
    }

    public ColecaoDeCoisas getAutores() {
        return autores;
    }

    public void setAutores(ColecaoDeCoisas autores) {
        this.autores = autores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ColecaoDeCoisas getInstrumentos() {
        return instrumento;
    }

    public void setInstrumentos(ColecaoDeCoisas instrumento) {
        this.instrumento = instrumento;
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
                titulo, descricao, instrumento, autores, ano, genero);
    }

}
