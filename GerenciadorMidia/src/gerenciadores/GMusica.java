/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadores;

import java.util.ArrayList;
import midias.Musica;

/**
 *
 * @author Débora Siqueira
 */
public class GMusica {

    ArrayList<Musica> ListMusica;

    public GMusica(ArrayList ListMusica) {
        this.ListMusica = ListMusica;

    }

    public boolean adicionarMusica(Musica Musica) {
        return ListMusica.add(Musica);

    }

    public boolean removerMusica(String nome) {
        for (int i = 0; i < ListMusica.size(); i++) {
            if (ListMusica.get(i).getTitulo().equalsIgnoreCase(nome)) {
                ListMusica.remove(i);
                return true;
            }

        }
        return false;
    }

    public boolean editarMusica(String nome, Musica musica) {
        for (int i = 0; i < ListMusica.size(); i++) {
            if (ListMusica.get(i).getTitulo().equalsIgnoreCase(nome)) {
                ListMusica.add(i, musica);
                return true;
            }

        }
        return false;
    }
    public Musica consultarMusica(String nome){
        for (int i = 0; i < ListMusica.size(); i++) {
            if(ListMusica.get(i).getTitulo().equalsIgnoreCase(nome)){
                return ListMusica.get(i);
            }
            
        }
        return null;
    }
}

