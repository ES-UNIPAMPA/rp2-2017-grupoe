package gerenciadores;

import java.util.ArrayList;
import java.util.List;
import midias.Filme;
import midias.Midia;

public class GFilme extends gerPrincipal {

    List<Filme>listaFilmes;

    public GFilme() {
        listaFilmes = new ArrayList<>();

    }

    public boolean adiciona(Filme filme) {
        listaFilmes.add(filme);
        return true;     
    }

    @Override
    public void classifica(ArrayList<Midia> midia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exclusao(String codigo) {
                delFilme(codigo);
        return false;
    }

    @Override
    public Filme consulta(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edicao(String codigo, Midia midia) {
        return false;
    }

    @Override
    public Midia exibir(String codigo) {
        getFilme(codigo);
        return null;
        }
    

    public Filme getLista() {
        for (int i = 0; i < listaFilmes.size(); i++) {
            System.out.println(listaFilmes.get(i).toString());
        }
        return null;
    }

    public Filme getFilme(String c) {
        for (int i = 0; i < listaFilmes.size(); i++) {
            if (c.equals(listaFilmes.get(i).getCodigo())) {
                return listaFilmes.get(i);
            }
        }
        System.out.println("Filme não encontrado!!");
        return null;
    }
    public String delFilme(String c) {
        for (int i = 0; i < listaFilmes.size(); i++) {
            if (c.equals(listaFilmes.get(i).getCodigo())) {
                String temp = listaFilmes.get(i).toString();
                listaFilmes.remove(i);
                //System.out.println("O seguinte filme foi deletado com sucesso:\n"+temp);
                return temp;
            }
        }
        System.out.println("Filme não encontrado!!");
        return null;
    }

    @Override
    public boolean adicionar(Midia midia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
