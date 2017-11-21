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
        String codigo = null, titulo = null, resp = null, titulog = null, desc = null, genero = null, idioma = null, atores = null, autores = null, interpretes = null, ano = null, duracao = null, diretor = null, instrumentos = null;
        System.out.println("\nDigite o titulo da Midia que deseja editar:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        System.out.println("\nDigite o codigo da Midia que deseja editar:");
        codigo = ValidarEntradaUsuario.nextInt(codigo);
        Midia musica = midia.consultar(titulog, codigo);
        System.out.println("\nA seguinte midia foi encontrada: ");
        System.out.println(musica.toString());
        System.out.println("Deseja continuar?  1- SIM   2- NAO");
        resp = ValidarEntradaUsuario.nextInt(resp);
        if (!resp.equalsIgnoreCase("1")) {
            return false;
        }

        //AQUI EDITA OS CAMPOS EM COMUM DE TODAS AS MIDIAS
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo titulo: ");
        titulo = ValidarEntradaUsuario.validacaoEditar(titulo);
        if (titulo.equals("")) {
        } else {
            musica.setTitulo(titulo);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Nova descrição: ");
        desc = ValidarEntradaUsuario.validacaoEditar(desc);
        if (desc.equals("")) {
        } else {
            musica.setDescricao(desc);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo genero: ");
        genero = ValidarEntradaUsuario.validacaoEditar(genero);
        if (genero.equals("")) {
        } else {
            musica.setGenero(genero);
        }
        System.out.println("Tecle ENTER caso não deseje editar este item.");
        System.out.println("Novo ano: ");
        ano = ValidarEntradaUsuario.editarInteiro(ano);
        if (ano.equals("")) {
        } else {
            musica.setAno(ano);
        }

        //EDITA SOMENTE OS ITENS DE MUSICA
        if (tipo.equalsIgnoreCase("musica")) {
            Musica mus = (Musica) midia.consultar(titulog, codigo);
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Novo idioma da Música: ");
            idioma = ValidarEntradaUsuario.validacaoEditar(idioma);
            if (idioma.equals("")) {
            } else {
                mus.setIdioma(idioma);
            }
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Novo nome do autor da Música:");
            autores = ValidarEntradaUsuario.validacaoEditar(autores);
            if (autores.equals("")) {
            } else {
                ArrayList autore = new ArrayList();
                autore.add(autores);
                System.out.println("Digite S caso queira adicionar outro Autor ou N para pular: ");
                resp = ValidarEntradaUsuario.validacaoEditar(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do Autor: ");
                    autores = ValidarEntradaUsuario.validacaoEditar(autores);
                    autore.add(autores);
                    System.out.println("Digite S caso queira adicionar outro Autor ou N para pular: ");
                    resp = ValidarEntradaUsuario.validacaoEditar(resp);
                }
                mus.setAutores(autore);
            }
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Novos nomes dos interpretes: ");
            interpretes = ValidarEntradaUsuario.validacaoEditar(interpretes);
            if (interpretes.equals("")) {
            } else {
                ArrayList interprete = new ArrayList();
                interprete.add(interpretes);
                System.out.println("Digite S caso queira adicionar outro Interprete ou N para pular:");
                resp = ValidarEntradaUsuario.validacaoEditar(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do interpretes: ");
                    interpretes = ValidarEntradaUsuario.validacaoEditar(interpretes);
                    interprete.add(interpretes);
                    System.out.println("Digite S caso queira adicionar outro Interprete ou N para pular:");
                    resp = ValidarEntradaUsuario.validacaoEditar(resp);
                }
                mus.setInterpretes(interprete);
            }
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Nova duração do filme em minutos: ");
            duracao = ValidarEntradaUsuario.editarInteiro(duracao);
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
            System.out.println("Tecle ENTER caso nao deseje editar este item.");
            System.out.println("Novo instrumento da Partitura: ");
            instrumentos = ValidarEntradaUsuario.validacaoEditar(interpretes);
            if (instrumentos.equals("")) {
            } else {
                ArrayList instrument = new ArrayList();
                instrument.add(instrumentos);
                System.out.println("Digite S caso queira adicionar outro Instrumento ou N para pular:");
                resp = ValidarEntradaUsuario.validacaoEditar(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do Instrumento: ");
                    instrumentos = ValidarEntradaUsuario.validacaoEditar(interpretes);
                    instrument.add(instrumentos);
                    System.out.println("Digite S caso queira adicionar outro Instrumento, ou N para pular:");
                    resp = ValidarEntradaUsuario.validacaoEditar(resp);
                }
                part.setInstrumentos(instrument);
            }
            System.out.println("Tecle ENTER caso não deseje editar este item.");
            System.out.println("Novo nome do autore da Partitura:");
            autores = ValidarEntradaUsuario.validacaoEditar(autores);
            if (autores.equals("")) {
            } else {
                ArrayList autore = new ArrayList();
                autore.add(autores);
                System.out.println("Digite S caso queira adicionar outro Autor ou N para pular: ");
                resp = ValidarEntradaUsuario.validacaoEditar(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do Autor: ");
                    autores = ValidarEntradaUsuario.validacaoEditar(autores);
                    autore.add(autores);
                    System.out.println("Digite S caso queira adicionar outro Autor ou N para pular: ");
                    resp = ValidarEntradaUsuario.validacaoEditar(resp);
                }
                part.setAutores(autore);
            }
            System.out.println("\nPartitura editada com Sucesso!! ");
        }

        //MENU QUE EDITA SOMENTE FILMES  
        if (tipo.equalsIgnoreCase("filme")) {
            Filme film = (Filme) midia.consultar(titulog, codigo);
            System.out.println("Tecle ENTER caso nao deseje editar este item.");
            System.out.println("Novo idioma do filme: ");
            idioma = ValidarEntradaUsuario.validacaoEditar(idioma);
            if (idioma.equals("")) {
            } else {
                film.setIdioma(idioma);
            }
            System.out.println("Tecle ENTER caso nao deseje editar este item.");
            System.out.println("Novo nome do diretor do filme: ");
            diretor = ValidarEntradaUsuario.validacaoEditar(diretor);
            if (diretor.equals("")) {
            } else {
                film.setDiretor(diretor);
            }
            System.out.println("Tecle ENTER caso nao deseje editar este item.");
            System.out.println("Novo nome do ator principal: ");
            atores = ValidarEntradaUsuario.validacaoEditar(atores);
            if (atores.equals("")) {
            } else {
                ArrayList atore = new ArrayList();
                atore.add(atores);
                System.out.println("Digite S caso queira adicionar outro Ator ou N para pular: ");
                resp = ValidarEntradaUsuario.validacaoEditar(resp);
                while (resp.equalsIgnoreCase("S")) {
                    System.out.println("Novo nome do Ator: ");
                    atores = ValidarEntradaUsuario.validacaoEditar(atores);
                    atore.add(atores);
                    System.out.println("Digite S caso queira adicionar outro Ator ou N para pular: ");
                    resp = ValidarEntradaUsuario.validacaoEditar(resp);
                }
                film.setAtores(atore);
            }
            System.out.println("Tecle ENTER caso nao deseje editar este item.");
            System.out.println("Nova duracao do filme: ");
            duracao = ValidarEntradaUsuario.editarInteiro(duracao);
            if (duracao.equals("")) {
            } else {
                film.setDuracao(duracao);
            }
            
            System.out.println("\nFilme editado com sucesso!!\n");
        }
        return false;
    }
    
}
