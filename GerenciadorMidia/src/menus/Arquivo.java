package menus;

import java.io.*;
import java.util.List;
import midias.*;

public class Arquivo {

    public FileOutputStream gravar(List<Midia> midias) throws UnsupportedEncodingException, FileNotFoundException, IOException {

        FileOutputStream outFile;
        BufferedWriter buff;

        outFile = new FileOutputStream(new File("nomeArquivo"));
        buff = new BufferedWriter(new OutputStreamWriter(outFile, "UTF-8"));

        for (Midia midia : midias) {
            buff.write("Caminho do Arquivo: " + midia.getCaminho() + "\n");
            buff.write(midia.getCodigo() + "\n");
            buff.write(midia.getTitulo() + "\n");
            buff.write(midia.getDescricao() + "\n");

            if (midia instanceof Musica) {
                buff.write(((Musica) midia).getAno() + "\n");
                buff.write(((Musica) midia).getAutores() + "\n");
                buff.write(((Musica) midia).getDuracao() + "\n");
                buff.write(((Musica) midia).getGenero() + "\n");
                buff.write(((Musica) midia).getIdioma() + "\n");
                buff.write(((Musica) midia).getInterpretes() + "\n");
                buff.write("\n");
            } else if (midia instanceof Partitura) {
                buff.write(((Partitura) midia).getAno() + "\n");
                buff.write(((Partitura) midia).getAutores() + "\n");
                buff.write(((Partitura) midia).getGenero() + "\n");
                buff.write(((Partitura) midia).getInstrumentos()+ "\n");
                buff.write("\n");    
            } else if (midia instanceof Filme){
                buff.write(((Filme) midia).getAno() + "\n");
                buff.write(((Filme) midia).getGenero() + "\n");
                buff.write(((Filme) midia).getDiretor() + "\n");
                buff.write(((Filme) midia).getAtores() + "\n");
                buff.write(((Filme) midia).getDuracao() + "\n");
                buff.write(((Filme) midia).getIdioma() + "\n");
                buff.write("\n");
            }
        }
        buff.close();
        outFile.close();
        return outFile;
    }
    
    public void ler(String nomeArquivo) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        FileInputStream inFile;
        BufferedReader buff;
        String linha;
        Midia midia;
        int numeroDeMidias, numero;
        String caminho, codigo, titulo, descricao;
        
        inFile = new FileInputStream(new File(nomeArquivo));
        buff = new BufferedReader(new InputStreamReader(inFile, "UTF-8"));
        
        linha = buff.readLine();
        numeroDeMidias = Integer.parseInt(linha);
        
        for(int i = 0; i < numeroDeMidias; i++){
            linha = buff.readLine();
            numero = Integer.parseInt(linha);
            
            caminho = buff.readLine();
            codigo = buff.readLine();
            titulo = buff.readLine();
            descricao = buff.readLine();
            
            
        }
    }

}
