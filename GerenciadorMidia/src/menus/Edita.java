package menus;

import gerenciadores.GMidia;
import java.util.ArrayList;
import java.util.Scanner;
import midias.Filme;
import midias.Musica;
import midias.Midia;
import midias.Partitura;

/**
 *
 * @author Rafael
 */
public class Edita {

    public boolean editarMidia(String tipo, GMidia midia) {
        Scanner e = new Scanner(System.in);
        String codigo = null, titulo = null, resp = null, titulog = null, desc, genero = null, idioma = null, atores=null, autores = null, interpretes = null, ano = null, duracao = null, diretor = null, instrumentos=null;
        System.out.println("\nDigite o titulo da Midia que deseja editar:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        System.out.println("\nDigite o codigo da Midia que deseja editar:");
        codigo = ValidarEntradaUsuario.nextInt(codigo);
        Midia musica = midia.consultar(titulog, codigo);
        System.out.println("A midia selecionada: ");
        System.out.println(musica.toString());
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo titulo: ");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        if (titulo.equals("")) {
        } else {
            musica.setTitulo(titulo);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Nova descrição: ");
        desc = e.nextLine();
        if (desc.equals("")) {
        } else {
            musica.setDescricao(desc);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo genero: ");
        genero = ValidarEntradaUsuario.nextLine(genero);
        if (genero.equals("")) {
        } else {
            musica.setGenero(genero);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo ano: ");
        ano = ValidarEntradaUsuario.nextLine(ano);
        if (genero.equals("")) {
        } else {
            musica.setAno(ano);
        }

        //EDITA SOMENTE OS ITENS DE MUSICA
        if (tipo.equalsIgnoreCase("musica")) {
            Musica mus = (Musica) midia.consultar(titulog, codigo);
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Novo idioma da Música: ");
            idioma = ValidarEntradaUsuario.nextLine(idioma);
            if (idioma.equals("")) {
            } else {
                mus.setIdioma(idioma);
            }
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Novo nome do autore da Música:");
            autores = ValidarEntradaUsuario.nextLine(autores);
            if (autores.equals("")) {
            } else {
                ArrayList autore = new ArrayList();
                autore.add(autores);
                System.out.println("Digite S caso queira adicionar outro Autor: ");
                resp = ValidarEntradaUsuario.nextLine(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do Autor: ");
                    autores = ValidarEntradaUsuario.nextLine(autores);
                    autore.add(autores);
                    System.out.println("Digite S caso queira adicionar outro Autor: ");
                    resp = ValidarEntradaUsuario.nextLine(resp);
                }
                mus.setAutores(autore);
            }
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Novos nomes dos interpretes: ");
            interpretes = ValidarEntradaUsuario.nextLine(interpretes);
            if (interpretes.equals("")) {
            } else {
                ArrayList interprete = new ArrayList();
                interprete.add(interpretes);
                System.out.println("Digite S caso queira adicionar outro Interprete");
                resp = ValidarEntradaUsuario.nextLine(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do interpretes: ");
                    interpretes = ValidarEntradaUsuario.nextLine(interpretes);
                    interprete.add(interpretes);
                    System.out.println("Digite S caso queira adicionar outro Interprete");
                    resp = ValidarEntradaUsuario.nextLine(resp);
                }
                mus.setInterpretes(interprete);
            }
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Nova duração do filme em minutos: ");
            duracao = ValidarEntradaUsuario.nextLine(duracao);
            if (duracao.equals("")) {
            } else {
                mus.setDuracao(duracao);
            }
            System.out.println("\nMúsica editada com sucesso!!\n");
            return true;
        }

        //MENU QUE EDITA SOMENTE PARTITURAS
        if (tipo.equalsIgnoreCase("partitura")) {
            Partitura part = (Partitura) midia.consultar(titulog, codigo);
            System.out.println("Digite ENTER caso nao deseje editar este item.");
            System.out.println("Novo instrumento da Partitura: ");
            instrumentos = ValidarEntradaUsuario.nextLine(interpretes);
            if (instrumentos.equals("")) {
            } else {
                ArrayList instrument = new ArrayList();
                instrument.add(instrumentos);
                System.out.println("Digite S caso queira adicionar outro Instrumento");
                resp = ValidarEntradaUsuario.nextLine(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do Instrumento: ");
                    instrumentos = ValidarEntradaUsuario.nextLine(interpretes);
                    instrument.add(instrumentos);
                    System.out.println("Digite S caso queira adicionar outro Instrumento");
                    resp = ValidarEntradaUsuario.nextLine(resp);
                }
                part.setInstrumentos(instrument);
            }
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Novo nome do autore da Partitura:");
            autores = ValidarEntradaUsuario.nextLine(autores);
            if (autores.equals("")) {
            } else {
                ArrayList autore = new ArrayList();
                autore.add(autores);
                System.out.println("Digite S caso queira adicionar outro Autor: ");
                resp = ValidarEntradaUsuario.nextLine(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do Autor: ");
                    autores = ValidarEntradaUsuario.nextLine(autores);
                    autore.add(autores);
                    System.out.println("Digite S caso queira adicionar outro Autor: ");
                    resp = ValidarEntradaUsuario.nextLine(resp);
                }
                part.setAutores(autore);
            }
            System.out.println("\nPartitura editada com Sucesso!! ");
        }
        
        //MENU QUE EDITA SOMENTE FILMES  
        if (tipo.equalsIgnoreCase("filme")) {
            Filme film = (Filme) midia.consultar(titulog, codigo);
            System.out.println("Pressione ENTER caso nao deseje editar este item.");
            System.out.println("Novo idioma do filme: ");
            idioma = ValidarEntradaUsuario.nextLine(idioma);
            if (idioma.equals("")) {
            } else {
                film.setIdioma(idioma);
            }
            System.out.println("Pressione ENTER caso nao deseje editar este item.");
            System.out.println("Novo nome do diretor do filme: ");
            diretor = ValidarEntradaUsuario.nextLine(diretor);
            if (diretor.equals("")) {
            } else {
                film.setDiretor(diretor);
            }
            System.out.println("Pressione ENTER caso nao deseje editar este item.");
            System.out.println("Novo nome do ator principal: ");
            atores = ValidarEntradaUsuario.nextLine(atores);
            if (atores.equals("")) {
            } else {
                ArrayList atore = new ArrayList();
                atore.add(atores);
                System.out.println("Digite S caso queira adicionar outro Ator: ");
                resp = ValidarEntradaUsuario.nextLine(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do Ator: ");
                    atores = ValidarEntradaUsuario.nextLine(atores);
                    atore.add(atores);
                    System.out.println("Digite S caso queira adicionar outro Ator: ");
                    resp = ValidarEntradaUsuario.nextLine(resp);
                }
                film.setAtores(atore);
            }
            System.out.println("Pressione ENTER caso nao deseje editar este item.");
            System.out.println("Nova duracao do filme: ");
            duracao = ValidarEntradaUsuario.nextLine(duracao);
            if (duracao.equals("")) {
            } else {
                film.setDuracao(duracao);
            }
            
            System.out.println("\nFilme editado com sucesso!!\n");
        }
        return false;
    }

}
