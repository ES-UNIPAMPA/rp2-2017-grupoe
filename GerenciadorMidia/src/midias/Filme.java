package midias;

import java.util.ArrayList;

public class Filme extends Midia {

    private String codigo;
    private String idioma;
    private String diretor;
    private String atores;
    private int ano;
    private int duracao;
    private static ArrayList<Filme> filmes = new ArrayList();

    public Filme() {
        this.codigo="";
        this.caminho = "";
        this.titulo = "";
        this.descricao = "";
        this.genero = "";
        this.idioma = "";
        this.diretor = "";
        this.atores = "";
        this.ano = 0;
        this.duracao = 0;
    }

    /**
     * @return the aumentaCodigo
     */
    public String getAumentaCodigo() {
        return codigo;
    }

    public boolean criaArray() {
        filmes = new ArrayList();
        return true;
    }

    public static Midia setLista(Filme f) {
        filmes.add(f);
        return null;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
 
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    /**
     * @return the diretor
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    /**
     * @return the atores
     */
    public String getAtores() {
        return atores;
    }

    /**
     * @param atores the atores to set
     */
    public void setAtores(String atores) {
        this.atores = atores;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the duracao
     */
    public double getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Midia getLista() {
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println(filmes.get(i).toString());
        }
        return null;
    }
    public Filme getFilme(String c){
        for(int i = 0; i<filmes.size();i++){
            if(c.equals(filmes.get(i).getAumentaCodigo())){
               System.out.println(filmes.get(i).toString()); 
               return filmes.get(i);
            }
        }
        System.out.println("Filme não encontrado!!");
        return null;
    }
    
       public String delFilme(String c){
        for(int i = 0; i<filmes.size();i++){
            if(c.equals(filmes.get(i).getAumentaCodigo())){
               String temp = filmes.get(i).toString();
               filmes.remove(i);
               //System.out.println("O seguinte filme foi deletado com sucesso:\n"+temp);
               return temp;
            }
        }
        System.out.println("Filme não encontrado!!");
        return null;
    }

    public String toString() {
        return "\nCodigo: " + codigo + " \nCaminho: " + caminho + " \ntitulo: " + titulo + " \nDescricao: " + descricao + " \nGenero:  " + genero + " \nIdioma: " + idioma + " \nDiretor: " + diretor + " \nAtores: " + atores + " \nAno: " + ano + " \nDuracao: " + duracao + "\n";
    }

    public  int compareTo(Filme outroFilme) {
        if (this.codigo == outroFilme.getAumentaCodigo()) {
            return -1;
        } else if (this.codigo != outroFilme.getAumentaCodigo()) {
            return +1;
        } else {
            return 0;
        }
    }

}
