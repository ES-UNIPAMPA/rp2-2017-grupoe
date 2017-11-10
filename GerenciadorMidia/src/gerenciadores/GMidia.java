package gerenciadores;

import java.util.ArrayList;
import java.util.List;
import midias.*;

public class GMidia extends gerPrincipal {

    List<Midia> listaMidia;

    /**
     * Construtor que inicializa a lista
     */
    public GMidia() {
        listaMidia = new ArrayList<>();

    }

    /**
     * Método para adicionar uma midia
     *
     * @param midia
     * @return
     */
    @Override
    public boolean adicionar(Midia midia) {
        return listaMidia.add(midia);

    }

    /**
     * Método para consultar uma midia
     *
     * @param codigo para efetuar a busca de midia desejada
     * @return retorna a mdia desejada caso o codigo exista. Caso contrário
     * retorna null
     */
    @Override
    public Midia consulta(String codigo) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                return listaMidia.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param midia
     */
    @Override
    public void classifica(ArrayList<Midia> midia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(nome)) {
                return listaMidia.get(i);
            }
        }
        return null;
    }

    /**
     * Método para editar uma midia
     *
     * @param codigo para encontrar a midia desejada
     * @param novaMidia é recebido para editar a midia existente
     * @return Caso a edição seja realizado com sucesso, retornara true. Caso
     * contrário retornara false
     */
    @Override
    public boolean edicao(String codigo, Midia novaMidia) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaMidia.add(i, novaMidia);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para excluir uma midia
     *
     * @param codigo para encontrar a midia desejada
     * @return Vai retornar verdadeiro caso a remoção seja realizada com
     * sucesso. Caso contrário retornara false
     */
    @Override
    public boolean exclusao(String codigo) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaMidia.remove(i);
                return true;
            }

        }
        return false;
    }
}
