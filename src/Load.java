import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Load {
    public static void leitura(String f){

        List<String> linhas = new ArrayList<>();
        if (f!=null) { //Verificar que o input não é nulo
            linhas = read(f); } //ler ficheiro e colocar em list
        String[] linhaPartida;
        int i=0;
        for (i = 0; i < linhas.size(); i++) { //para cada linha do list
            if (linhas.get(i)!=null) {
                //System.out.println("LINHA   " + linhas.get(i));
                linhaPartida = linhas.get(i).split(":", 2); //separar ate ao : em 2
                if (linhaPartida[0]!=null) {
                    //System.out.println(linhaPartida[0]);  //Em linhaPartida fica o tipo de entidade
                    switch(linhaPartida[0]) {
                        case ("Aceite"): {
                            System.out.println("é um aceite");
                            //ENVIAR PARA AS ENCOMENDAS ACEITES
                            break;
                        }
                        case ("Utilizador"): {
                            System.out.println("é um utilizador");
                            //ENVIAR PARA OS UTILIZADORES
                            break;
                        }

                        case ("Voluntario"): {
                            System.out.println("é um voluntario");
                            //ENVIAR PARA VOLUNTARIO
                            break;
                        }

                        case ("Transportadora"): {

                            System.out.println("é uma transportadora");
                            //ENVIAR PARA TRANSPORTADORA
                            break;
                        }

                        case ("Loja"): {
                            System.out.println("é uma loja");
                            //ENVIAR PARA LOJA
                            break;
                        }

                        case ("Encomenda"): {
                            System.out.println("é uma encomenda");
                            //ENVIAR PARA ENCOMENDA
                            break;
                        }
                        default: {
                            System.out.println("erro");
                        }
                    }
                }}}}

    //Ler o ficheiro
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
            System.err.printf("Erro na abertura do arquivo : %s\n");
        }
        return res;
    }
}
