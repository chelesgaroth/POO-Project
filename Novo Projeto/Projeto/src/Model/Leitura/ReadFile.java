package Model.Leitura;

import Model.*;
import Model.Tipos.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadFile implements IReadFile {
    IUser user;
    IVoluntario voluntario;
    IEmpresa empresa;
    ILoja loja ;
    IEncomenda enco;
    ILogin login;

    public ReadFile(){
        this.user = new User();
        this.voluntario = new Voluntario();
        this.empresa = new Empresa();
        this.loja = new Loja();
        this.enco = new Encomenda();
        this.login = new Login();
    }

    public void leitura(String f, ISistema sistema){
        List<String> linhas = new ArrayList<>();
        if (f!=null) {                  //Verificar que o input não é nulo
            linhas = read(f);           //ler ficheiro e colocar em list
        }
        String[] linhaPartida;
        int i;
        String aux;
        String id;
        int conta1=0,conta2=0,conta3=0,conta4=0,conta5=0,conta6=0;

        for (i = 0; i < linhas.size(); i++) {
            if (linhas.get(i)!=null) {
                linhaPartida = linhas.get(i).split(":", 2);
                if (linhaPartida[0]!=null) {

                    switch(linhaPartida[0]) {

                        case ("Utilizador"): {
                            //System.out.println("É um utilizador");
                            IUser user = new User();
                            ILogin login = new Login();
                            aux = linhaPartida[1];
                            user.criaUser(aux);
                            sistema.addUser(user);
                            id = user.getUserID();
                            login.setLogin(id);
                            sistema.addLogin(login,id);
                            conta2++;
                            break;
                        }

                        case ("Voluntario"): {
                            //System.out.println("É um voluntario");
                            IVoluntario voluntario = new Voluntario();
                            ILogin login = new Login();
                            aux = linhaPartida[1];
                            voluntario.criaVoluntario(aux);
                            sistema.addVoluntario(voluntario);
                            id = voluntario.getId_volunteer();
                            login.setLogin(id);
                            sistema.addLogin(login,id);
                            conta3++;
                            break;
                        }

                        case ("Transportadora"): {
                            //System.out.println("É uma transportadora");
                            IEmpresa empresa = new Empresa();
                            ILogin login = new Login();
                            aux = linhaPartida[1];
                            empresa.criaEmpresa(aux);
                            sistema.addEmpresa(empresa);
                            id = empresa.getIdEmpresa();
                            login.setLogin(id);
                            sistema.addLogin(login,id);
                            conta4++;
                            break;
                        }

                        case ("Loja"): {
                            //System.out.println("É uma loja");
                            ILoja loja = new Loja();
                            ILogin login = new Login();
                            aux = linhaPartida[1];
                            loja.criaLoja(aux);
                            sistema.addLoja(loja);
                            id = loja.getCodLoja();
                            login.setLogin(id);
                            sistema.addLogin(login,id);
                            conta5++;
                            break;
                        }

                        case ("Encomenda"): {
                            //System.out.println("É uma encomenda");
                            IEncomenda enco = new Encomenda();
                            aux = linhaPartida[1];
                            enco.criaEncomenda(aux);
                            conta6++;
                            break;
                        }

                        case ("Aceite"):{
                            aux = linhaPartida[1];
                            conta1++;
                        }

                        default: {
                            System.out.println("Não foi registado -> "+linhaPartida[0]);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sistema.toString());
        //menu.Historico(conta1,conta2,conta3,conta4,conta5,conta6,conta7, conta8);
        System.out.printf("\nNúmero de Encomendas aceites: %d\n",conta1);
        System.out.printf("Número de Utilizadores: %d\n",conta2);
        System.out.printf("Número de Voluntários: %d\n",conta3);
        System.out.printf("Número de Empresas Transportadoras: %d\n",conta4);
        System.out.printf("Número de Lojas: %d\n",conta5);
        System.out.printf("Número de Encomendas: %d\n",conta6);
    }
    public static List<String> read (String f){
        int i;
        List<String> res = new ArrayList<>();
        try {
            i = 0;
            FileReader buf = new FileReader(f);
            BufferedReader lerBuf = new BufferedReader(buf);
            String linha = lerBuf.readLine();
            while (linha != null) {

                linha = lerBuf.readLine();
                res.add(linha);
                i++;
            }
        } catch (IOException e) {
            System.err.print("Erro na abertura do arquivo : %s\n");
        }
        return res;
    }
}
