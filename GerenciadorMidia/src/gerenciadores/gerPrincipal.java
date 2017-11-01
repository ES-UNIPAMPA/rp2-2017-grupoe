
package gerenciadores;

import java.util.ArrayList;
import midias.Midia;


public interface gerPrincipal {
    
    public abstract boolean adicionar(Midia midia);
    
    public abstract Midia consulta(int codigo);
    
    public abstract void classifica(ArrayList<Midia> midia);
    
    public abstract void edicao();
    
    public abstract boolean exclusao();
    
    public abstract Midia exibir();
 
    
}
