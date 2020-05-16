import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Load {
    public static void leitura(String f,Sistema sistema){
        List<String> linhas = new ArrayList<>();
        if (f!=null) {                  //Verificar que o input não é nulo
            linhas = read(f);           //ler ficheiro e colocar em list
        }
        String[] linhaPartida;
        int i;
        String aux;
        int conta1=0,conta2=0,conta3=0,conta4=0,conta5=0,conta6=0,conta7=0;

        for (i = 0; i < linhas.size(); i++) {
            //para cada linha do list
            if (linhas.get(i)!=null) {
                //System.out.println("LINHA"+linhas.get(i));
                linhaPartida = linhas.get(i).split(":", 2); //separar ate ao : em 2
                if (linhaPartida[0]!=null) {
                    //Em linhaPartida fica o tipo de entidade

                    switch(linhaPartida[0]) {

                        case ("Aceite"): {
                            Aceites c = new Aceites ();
                            //System.out.println("é um aceite");
                            //ENVIAR PARA AS ENCOMENDAS ACEITES
                            aux= linhaPartida[1];
                            Aceites.insereAceites(aux,c);
                            conta1++;
                            break;
                        }
                        case ("Utilizador"): {
                            //System.out.println("é um utilizador");
                            //ENVIAR PARA OS UTILIZADORES
                            aux = linhaPartida[1];
                            User.insereUser(aux,sistema);
                            conta2++;
                            break;
                        }

                        case ("Voluntario"): {
                            //System.out.println("é um voluntario");
                            //ENVIAR PARA VOLUNTARIO
                            aux = linhaPartida[1];
                            Volunteer.insereVolunteer(aux,sistema);
                            conta3++;
                            break;
                        }

                        case ("Transportadora"): {

                            //System.out.println("é uma transportadora");
                            //ENVIAR PARA TRANSPORTADORA
                            aux = linhaPartida[1];
                            Empresa.insereTransportadora(aux,sistema);
                            conta4++;
                            break;
                        }

                        case ("Loja"): {
                            //System.out.println("é uma loja");
                            //ENVIAR PARA LOJA
                            aux = linhaPartida[1];
                            Loja.insereLoja(aux,sistema);
                            conta5++;
                            break;
                        }

                        case ("Encomenda"): {
                            //System.out.println("é uma encomenda");
                            //ENVIAR PARA ENCOMENDA
                            aux = linhaPartida[1];
                            Encomenda.insereEncomenda(aux);
                            conta6++;
                            break;
                        }
                        case ("Login"): {
                            aux = linhaPartida[1];
                            Login.insereLogin(aux);
                            conta7++;
                            break;
                        }
                        default: {
                            System.out.println("erro");
                        }
                    }
                }
            }
        }
        Menu.Historico(conta1,conta2,conta3,conta4,conta5,conta6,conta7);
    }

    //Ler o ficheiro e passar para uma lista de String
    public static List<String> read (String f){
        int i=0;
        List<String> res = new ArrayList<>();
        try {
            i = 0;
            FileReader buf = new FileReader(f);
            BufferedReader lerBuf = new BufferedReader(buf);
            String linha = lerBuf.readLine();
            while (linha != null) {
                //      System.out.println(linha);
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
