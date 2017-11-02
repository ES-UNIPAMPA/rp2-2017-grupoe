package listas;

import java.util.ArrayList;
import midias.Filme;
import midias.Midia;

public class Midias {

    private ArrayList<Midia> todas = new ArrayList();

    public Midias() {

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
}
