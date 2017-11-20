package gerenciadores;

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
    public Midia consulta(String titulo, String codigo) {
        for (int i = 0; i < listMidia.size(); i++) {
            if (listMidia.get(i).equalsTitulo(titulo) && listMidia.get(i).equalsTitulo(codigo)) {
                return listMidia.get(i);
            } 
        }
        return null;
    }

    
    /**
     * Método para exibir uma midia
     *
     * @param nome recebedio para exibir todo tipo de midia com esse parametro
     * @return Caso contenha as midias ele retornara. Caso contrário retornara
     * null
     */
    @Override
    public Midia exibir(String nome) {
        for (int i = 0; i < listMidia.size(); i++) {
            if (listMidia.get(i).equalsTitulo(nome)) {
                return listMidia.get(i);
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
     * @return Vai retornar verdadeiro caso a remoção seja realizada com
     * sucesso. Caso contrário retornara false
     */
    @Override
    public boolean exclusao(String titulo, String codigo) {
        for (int i = 0; i < listMidia.size(); i++) {
            if (listMidia.get(i).equalsTitulo(titulo) && listMidia.get(i).equalsTitulo(codigo)) {
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
