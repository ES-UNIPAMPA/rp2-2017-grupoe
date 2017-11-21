package midias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partitura extends Midia {

    private List<String> instrumentos;
    private List<String> autores;
    //public static List<String> menu = new ArrayList(Arrays.asList("Digite um instrumento: ", "Digite o nome do diretor do filme: ", "Digite a duração do filme: "));
    //public static List<String> variaveis = new ArrayList();


    public Partitura( String codigo, String caminho, String titulo, String descricao, List instrumentos, String ano, List autores, String genero) {
        super( codigo, caminho, titulo, descricao, genero, ano);
        this.instrumentos = instrumentos;
        this.autores = autores;
    }

        /**
     * @return the instrumentos
     */
    public List<String> getInstrumentos() {
        return instrumentos;
    }

    /**
     * @param instrumentos the instrumentos to set
     */
    public void setInstrumentos(List<String> instrumentos) {
        this.instrumentos = instrumentos;
    }

    /**
     * @return the autores
     */
    public List<String> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(List<String> autores) {
        this.autores = autores;
    }
    
        /**
     * Método toString para representar os atributos do objeto
     *
     * @return retorna uma String com todas as informações
     */
    @Override
    public String toString() {
        return String.format("Caminho: %s \n"
                + "Titulo da partitura: %s \n"
                + "Descrição da Partitura: %s \n"                  
                + "Ano de Crição da Partitura: %s \n"
                + "Gênero da Partitura: %s \n "
                + "Autores da Partitura: %s \n"
                + "Instrumentos: %s \n",
                caminho, titulo, descricao, ano, genero, autores, instrumentos);
    }
    
    public String toFile(){
                return String.format("Caminho: %s \n"
                + "Titulo da partitura: %s \n"
                + "Descrição da Partitura: %s \n"                  
                + "Ano de Crição da Partitura: %s \n"
                + "Gênero da Partitura: %s \n "
                + "Autores da Partitura: %s \n"
                + "Instrumentos: %s \n",
                caminho, titulo, descricao, ano, genero, autores, instrumentos);
    }

}
