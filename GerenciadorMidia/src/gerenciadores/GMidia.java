package gerenciadores;

import static gerenciadores.gerPrincipal.listMidia;
import java.util.*;
import midias.*;

public class GMidia extends gerPrincipal {

    /**
     * Construtor que inicializa a lista
     *
     * @param listaMidia recebe o tipo de lista desejada.
     */
    public GMidia(List listaMidia) {
        listMidia = listaMidia;

    }

  

    /**
     * Método para adicionar uma midia
     *
     * @param midia Recebe a midia que será adicionada
     * @return Retorna true caso a midia foi adicionada. Caso contrário retorna false.
     */
    @Override
    public boolean adicionar(Midia midia) {
        return listMidia.add(midia);

    }

    /**
     * Método para consultar uma midia
     *
     * @param titulo
     * @return retorna a mdia desejada caso o codigo exista. Caso contrário
     * retorna null
     */
    public Midia exibir(String dado) {
        for (int i = 0; i < listMidia.size(); i++) {
            Midia mostra = listMidia.get(i);
            //confere se o dado é igual ao titulo ou igual ao codigo
            if (mostra.getTitulo().equals(dado) || mostra.getCodigo().equals(dado)) {
                System.out.println(mostra);
            } 
        }
        return null;
    }

    
    /**
     * Método para consultar uma midia
     *
     * @param nome recebedio para exibir todo tipo de midia com esse parametro
     * @return Caso contenha as midias ele retornara. Caso contrário retornara
     * null
     */
    public Midia consultar(String titulo, String codigo) {
        for (int i = 0; i < listMidia.size(); i++) {
            Midia retorna = listMidia.get(i);
            if (retorna.getTitulo().equals(titulo) || retorna.getCodigo().equals(codigo)) {
                return retorna;
            }
        }
        return null;
    }

    /**
     * Método para editar uma midia
     *
     * @param titulo
     * @param novaMidia é recebido para editar a midia existente
     * @return Caso a edição seja realizado com sucesso, retornara true. Caso
     * contrário retornara false
     */
    @Override
    public boolean edicao(String titulo, Midia novaMidia) {
        for (int i = 0; i < listMidia.size(); i++) {
            if (listMidia.get(i).equalsTitulo(titulo)) {
                listMidia.add(i, novaMidia);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para excluir uma midia
     *
     * @param titulo é recebido para identificar a midia que ira ser excluida.
     * @param codigo
     * @return Vai retornar verdadeiro caso a remoção seja realizada com
     * sucesso. Caso contrário retornara false
     */
    @Override
    public boolean exclusao(String titulo, String codigo) {    
        for (int i = 0; i < listMidia.size(); i++) {
            Midia escolhida = listMidia.get(i);
            if (escolhida.getTitulo().equals(titulo) && escolhida.getCodigo().equals(codigo)) {
                listMidia.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void classifica(ArrayList<Midia> midia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
