
package gerenciadores;

import java.util.*;
import midias.*;

/**
 * Classe abstrata com o métodos para os gerenciadores.
 */
public abstract class gerPrincipal {
    protected static List <Midia> listMidia;
    
    public abstract boolean adicionar(Midia midia);
    
    public abstract Midia consulta(String codigo);
    
    public abstract void classifica(ArrayList<Midia> midia);
    
    public abstract boolean edicao(String codigo, Midia midia);
    
    public abstract boolean exclusao(String nome);
    
    public abstract Midia exibir(String nome);
 
}
