package midias;

public class Partitura extends Midia {

    protected static int aumentaCodigo = 0;
    protected String instrumentos;
    protected int ano;

    public Partitura() {
        
        codigo = 0;
        caminho = "";
        titulo = "";
        descricao = "";
        genero = "";
        autores = "";
        instrumentos = "";
        ano = 0;

    }

    public String getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(String instrumentos) {
        this.instrumentos = instrumentos;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
