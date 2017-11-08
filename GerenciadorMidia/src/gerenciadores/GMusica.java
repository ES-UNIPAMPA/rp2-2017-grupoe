package gerenciadores;

import java.util.ArrayList;
import java.util.List;
import midias.*;

/**
 *
 * @author Débora Siqueira
 */

public class GMusica extends gerPrincipal {

    List<Musica> listaMusica;
/**
 * Construtor que inicializa a lista
 */
    public GMusica() {
        listaMusica = new ArrayList<>();
        
    }
/**
 * Método para adicionar uma midia
 * @param musica do tipo midia para efetuar a converção para o tipo Musica e efetuar a inclusão
 * @return 
 */
    @Override
    public boolean adicionar(Midia musica) {
        return listaMusica.add((Musica) musica);

    }
/**
 * Método para consultar uma midia
 * @param codigo para efetuar a busca da musica desejada
 * @return  retorna a musica desejada caso o codigo exista. Caso contrário retorna null
 */
    @Override
    public Musica consulta(String codigo) {
        for (int i = 0; i < listaMusica.size(); i++) {
            if (listaMusica.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                return listaMusica.get(i);
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
 * @param nome recebedio para exibir todo tipo de musica com esse parametro
 * @return Caso contenha as musicas ele retornara. Caso contrário retornara null
 */
    @Override
    public Musica exibir(String nome) {
        for (int i = 0; i < listaMusica.size(); i++) {
            if (listaMusica.get(i).getTitulo().equalsIgnoreCase(nome)) {
                return listaMusica.get(i);
            }

        }
        return null;
    }
/**
 * Método para editar uma midia
 * @param codigo para encontrar a musica desejada
 * @param novaMusica é recebido para editar a musica existente
 * @return Caso a edição seja realizado com sucesso, retornara true. Caso contrário retornara false
 */
    @Override
    public boolean edicao(String codigo, Midia novaMusica) {
        for (int i = 0; i < listaMusica.size(); i++) {
            if (listaMusica.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaMusica.add(i, (Musica)novaMusica);
                return true;
            }

        }
        return false;
    }
/**
 * Método para excluir uma midia
 * @param codigo para encontrar a musica desejada
 * @return Vai retornar verdadeiro caso a remoção seja realizada com sucesso. Caso contrário retornara false
 */
    @Override
    public boolean exclusao(String codigo) {
        for (int i = 0; i < listaMusica.size(); i++) {
            if (listaMusica.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaMusica.remove(i);
                return true;
            }

        }
        return false;
    }
}
