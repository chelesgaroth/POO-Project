package Model.Leitura;

import Model.Encomenda;
import Model.IEncomenda;
import Model.ISistema;
import Model.Tipos.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile implements IReadFile {
    IUser user;
    IVoluntario voluntario;
    IEmpresa empresa;
    ILoja loja ;
    IEncomenda enco;

    public ReadFile(){
        this.user = new User();
        this.voluntario = new Voluntario();
        this.empresa = new Empresa();
        this.loja = new Loja();
        this.enco = new Encomenda();
    }

    public void leitura(String f, ISistema sistema){
        List<String> linhas = new ArrayList<>();
        if (f!=null) {                  //Verificar que o input não é nulo
            linhas = read(f);           //ler ficheiro e colocar em list
        }
        String[] linhaPartida;
        int i;
        String aux;
        int conta1=0,conta2=0,conta3=0,conta4=0,conta5=0,conta6=0,conta7=0, conta8=0;

        for (i = 0; i < linhas.size(); i++) {
            if (linhas.get(i)!=null) {
                linhaPartida = linhas.get(i).split(":", 2);
                if (linhaPartida[0]!=null) {

                    switch(linhaPartida[0]) {

                        case ("Utilizador"): {
                            //System.out.println("É um utilizador");
                            aux = linhaPartida[1];
                            user.criaUser(aux);
                            conta2++;
                            break;
                        }

                        case ("Voluntario"): {
                            //System.out.println("É um voluntario");
                            aux = linhaPartida[1];
                            voluntario.criaVoluntario(aux);
                            conta3++;
                            break;
                        }

                        case ("Transportadora"): {
                            //System.out.println("É uma transportadora");
                            aux = linhaPartida[1];
                            empresa.criaEmpresa(aux);
                            conta4++;
                            break;
                        }

                        case ("Loja"): {
                            //System.out.println("É uma loja");
                            aux = linhaPartida[1];
                            loja.criaLoja(aux);
                            conta5++;
                            break;
                        }

                        case ("Encomenda"): {
                            //System.out.println("É uma encomenda");
                            aux = linhaPartida[1];
                            enco.criaEncomenda(aux);
                            conta6++;
                            break;
                        }
                        default: {
                            System.out.println("Erro "+linhaPartida[0]);
                            break;
                        }
                    }
                }
            }
        }
        //menu.Historico(conta1,conta2,conta3,conta4,conta5,conta6,conta7, conta8);
        System.out.printf("\nNúmero de Encomendas aceites: %d\n",conta1);
        System.out.printf("Número de Utilizadores: %d\n",conta2);
        System.out.printf("Número de Voluntários: %d\n",conta3);
        System.out.printf("Número de Empresas Transportadoras: %d\n",conta4);
        System.out.printf("Número de Lojas: %d\n",conta5);
        System.out.printf("Número de Encomendas: %d\n",conta6);
        System.out.printf("Número de Logins (Contas feitas): %d\n",conta7);
        System.out.printf("Número de Produtos: %d\n\n",conta8);
    }
    public static List<String> read (String f){
        int i=0;
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
