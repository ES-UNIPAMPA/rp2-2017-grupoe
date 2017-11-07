package gerenciadores;

import java.util.ArrayList;
import java.util.Scanner;
import midias.Midia;

public class GMidia implements gerPrincipal {

    public GMidia() {

    }

    @Override
    public boolean adicionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void classifica(ArrayList<Midia> midia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edicao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exclusao() {
        Scanner entrada = new Scanner(System.in);
        String codigo = entrada.next();
        Midia h = new Midia();
        Midia temp = h.getMidia(codigo);
        if (temp != null) {
            String deletado = h.delMidia(codigo);
        }
        return false;
    }

    @Override
    public Midia exibir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
