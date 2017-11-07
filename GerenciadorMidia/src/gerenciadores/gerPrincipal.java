
package gerenciadores;

import java.util.*;
import midias.Midia;


public abstract class gerPrincipal {
    protected List listMidia;
    
    public abstract boolean adicionar(Midia midia);
    
    public abstract Midia consulta(String codigo);
    
    public abstract void classifica(ArrayList<Midia> midia);
    
    public abstract boolean edicao(String titulo, Midia midia);
    
    public abstract boolean exclusao(String nome);
    
    public abstract Midia exibir(String nome);
 
}
