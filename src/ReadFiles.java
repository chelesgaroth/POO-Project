import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {
    public static void main(String args[]){
       File futilizadores =  new File("Utlizadores.txt");
      int i=0;
      try {
        i=0;
        FileReader buf = new FileReader(futilizadores);
        BufferedReader lerBuf = new BufferedReader(buf);
        String linha = lerBuf.readLine();
        while (linha != null) {
            System.out.printf(linha);

            linha = lerBuf.readLine();
            i++;
        }

        buf.close();
    } catch (
    IOException e) {
        System.err.printf("Erro na abertura do arquivo : %s\n", e.getMessage());
    }
        System.out.println("\nFim de leitura do ficheiro " + futilizadores);


}}
