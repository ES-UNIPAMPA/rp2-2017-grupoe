package gerenciadores;

import java.util.ArrayList;
import java.util.Scanner;
import midias.Foto;
import midias.Midia;

public class GFoto implements gerPrincipal {

    public GFoto() {

    }

    @Override
    public boolean adicionar() {
        Scanner e = new Scanner(System.in);
        int resp;
        String resposta;
        Foto a = new Foto();
        Midia f = new Midia();
        System.out.println("Digite o codigo do filme: ");
        resposta = e.next();
        a.setCodigo(resposta);
        System.out.println("Digite o caminho do arquivo: ");
        a.setCaminho(e.next());
        System.out.println("Digite o titulo da foto: ");
        a.setTitulo(e.next());
        System.out.println("Digite a descricao do arquivo: ");
        a.setDescricao(e.next());
        System.out.println("Digite o nome do fotografo: ");
        a.setFotografo(e.next());
        System.out.println("Digite o nome das pessoas na foto:  (separado por espaco)");
        a.setPessoas(e.next());
        System.out.println("Digite o local onde foi tirada a foto: ");
        a.setLocal(e.next());
        System.out.println("Digite a hora que foi tirada a foto: (ex: 12:30");
        a.setHora(e.next());
        System.out.println("Digite a data que foi tirada a foto: (somente numeros ex:12032005)");
        a.setData(e.next());
        Foto.setLista(a);
        f.adicionarMidia(a);
        System.out.println("\nFoto adicionada com Sucesso!!!\n");
        return true;
    }

    @Override
    public void classifica(ArrayList<Midia> midia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edicao() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o codigo da Foto que deseja editar: ");
        String codigo = entrada.next();
        Foto x = new Foto();
        Foto foto = x.getFoto(codigo);
        System.out.println("Digite o novo codigo do filme: ");
        foto.setCodigo(entrada.nextInt());
        System.out.println("Digite o novo caminho do arquivo: ");
        foto.setCaminho(entrada.next());
        System.out.println("Digite o novo titulo do arquivo: ");
        foto.setTitulo(entrada.next());
        System.out.println("Digite a nova descricao do arquivo: ");
        foto.setDescricao(entrada.next());
        System.out.println("Digite o novo genero do arquivo: ");
        foto.setGenero(entrada.next());
        System.out.println("Digite o novo nome do fotografo: ");
        foto.setFotografo(entrada.next());
        System.out.println("Digite o novo nome das pessoas na foto:  (separados por espaco)");
        foto.setPessoas(entrada.next());
        System.out.println("Digite o novo local da foto: ");
        foto.setLocal(entrada.next());
        System.out.println("Atualize hora que foi tirada a foto: (ex: 12:30");
        foto.setHora(entrada.next());
        System.out.println("Atualize a data que foi tirada a foto: (somente numeros ex:12032005)");
        foto.setData(entrada.next());
        System.out.println("\nFoto editada com sucesso!!\n");
    }

    @Override
    public boolean exclusao() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o codigo da Foto que deseja excluir: ");
        String codigo = entrada.next();
        Foto h = new Foto();
        Midia m = new Midia();
        Foto temp = h.getFoto(codigo);
        String temporaria = h.getCaminho();
        if (temp != null) {
            System.out.println("Deseja realmente excluir essa foto?\n"
                    + "1- SIM     2- NAO");
            int resp = entrada.nextInt();
            if (resp == 1) {
                String deletado = h.delFoto(codigo);
                m.delMidia(temporaria);
                System.out.println("Foto deletada com sucesso!!");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public Midia exibir() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("1- Exibir todos as Fotos   2- Exibir somente uma Foto");
        int opcao = entrada.nextInt();
        if (opcao == 1) {
            Foto b = new Foto();
            b.getLista();
        } else {
            System.out.println("Digite o codigo da Foto: ");
            String codigo = entrada.next();
            Foto b = new Foto();
            b.getFoto(codigo);
        }
        return null;
    }
}
