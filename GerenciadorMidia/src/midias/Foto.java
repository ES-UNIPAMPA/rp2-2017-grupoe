package midias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Foto extends Midia {

    private String codigo;
    private String fotografo;
    private String pessoas;
    private String local;
    private int hora;
    private String Data;
    private Date d;
    private static ArrayList<Foto> fotos = new ArrayList();

    public Foto() throws ParseException {
        this.codigo = "";
        this.caminho = "";
        this.titulo = "";
        this.descricao= "";
        this.fotografo = "";
        this.pessoas = "";
        this.local = "";
        this.hora = 0;
        this.Data = "00/00/0000";
        //configuracao da data
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.format(Data);
        try {
            d = sdf.parse(Data);
        } catch (ParseException erro) {
            System.out.println("Formato inválido!");
            erro.printStackTrace();
        }

    }
    //GETERS E SETTERS
    public static Midia setLista(Foto f) {
        fotos.add(f);
        return null;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the fotografo
     */
    public String getFotografo() {
        return fotografo;
    }

    /**
     * @param fotografo the fotografo to set
     */
    public void setFotografo(String fotografo) {
        this.fotografo = fotografo;
    }

    /**
     * @return the pessoas
     */
    public String getPessoas() {
        return pessoas;
    }

    /**
     * @param pessoas the pessoas to set
     */
    public void setPessoas(String pessoas) {
        this.pessoas = pessoas;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the Data
     */
    public String getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(String Data) {
        this.Data = Data;
    }
    
    /**
     * @return the aumentaCodigo
     */
    public String getAumentaCodigo() {
        return codigo;
    }
    

    
   //Metodos criados
    public boolean criaArray() {
        fotos = new ArrayList();
        return true;
    }

    public Midia getLista() {
        for (int i = 0; i < fotos.size(); i++) {
            System.out.println(fotos.get(i).toString());
        }
        return null;
    }

    public Foto getFilme(String c) {
        for (int i = 0; i < fotos.size(); i++) {
            if (c.equals(fotos.get(i).getAumentaCodigo())) {
                System.out.println(fotos.get(i).toString());
                return fotos.get(i);
            }
        }
        System.out.println("Foto não encontrada!!");
        return null;
    }

    public String delFoto(String c) {
        for (int i = 0; i < fotos.size(); i++) {
            if (c.equals(fotos.get(i).getAumentaCodigo())) {
                String temp = fotos.get(i).toString();
                fotos.remove(i);
                return temp;
            }
        }
        System.out.println("Fotos não encontrada!!");
        return null;
    }

    //imprime as informacoes
    public String toString() {
        return "\nCodigo: " + codigo + " \nCaminho: " + caminho + " \ntitulo: " + titulo + " \nDescricao: " + descricao + " \nGenero:  " + genero + " \nFotografo: " + fotografo + " \nPessoas: " + pessoas + " \nLocal: " + local + " \nData: " + d + " \nHora: " + hora + "\n";
    }

    public int compareTo(Foto outraFoto) {
        if (this.codigo == outraFoto.getAumentaCodigo()) {
            return -1;
        } else if (this.codigo != outraFoto.getAumentaCodigo()) {
            return +1;
        } else {
            return 0;
        }
    }

    

}
