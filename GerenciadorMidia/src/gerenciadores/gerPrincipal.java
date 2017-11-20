
package gerenciadores;

import java.util.*;
import midias.*;

/**
 * Classe abstrata com o métodos para os gerenciadores.
 */
public abstract class gerPrincipal {
    protected static List <Midia> listMidia;
    
    public abstract boolean adicionar(Midia midia);
    
    public abstract Midia consulta(String titulo);
    
    public abstract void classifica(ArrayList<Midia> midia);
    
    public abstract boolean edicao(String codigo, Midia midia);
    
    public abstract boolean exclusao(String titulo, String codigo);
    
    public abstract Midia exibir(String nome);
 
}
