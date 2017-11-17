package midias;

import java.util.ArrayList;

public class ColecaoDeCoisas {

    protected ArrayList<String> novo;

    public ColecaoDeCoisas() {
        novo = new ArrayList<>();
    }

    public ArrayList<String> getInstrumento() {
        return novo;
    }

    public void setInstrumento(ArrayList<String> instrumento) {
        this.novo = instrumento;
    }


    public void addColecaoDeCoisas(String toc) {
        novo.add(toc);
    }

    public int getNroColecaoDeCoisas() {
        return novo.size();
    }
}
