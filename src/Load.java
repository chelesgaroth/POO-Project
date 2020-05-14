import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Load {
    public static void leitura(File file){

        //lê o ficheiro e preenche as estruturas
        //retomando o estado do sistema
        try {
            FileReader buf = new FileReader(file);
            BufferedReader lerBuf = new BufferedReader(buf);
            String linha = lerBuf.readLine();
            while (linha != null) {
                linha = lerBuf.readLine();
            }
            buf.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo : %s\n", e.getMessage());
        }
        System.out.println("\nFim de leitura do ficheiro " + file);
    }
}
