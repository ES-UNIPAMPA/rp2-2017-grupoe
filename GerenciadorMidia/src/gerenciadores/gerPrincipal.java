
package gerenciadores;

import java.util.*;
import midias.*;

/**
 * Classe abstrata com o métodos para os gerenciadores.
 */
public abstract class gerPrincipal {
    //protected static List <Midia> listMidia;
    
    public abstract boolean adicionar(Midia midia);
    
    public abstract List consulta( String nome);
    
    public abstract void classifica(ArrayList<Midia> midia);
    
    public abstract boolean edicao(Midia midia);
    
    public abstract boolean exclusao(Midia midias);
    
    public abstract Midia exibir(String nome);
 
}
