import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.CharsetEncoder;
import java.util.Random;
import java.util.Scanner;

public class Register {
    public static void registoUser (String strfile,Sistema sistema) {

        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //UserID ->  gera um userID random para o utilizador
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int) ;
        id = "u" + id ;
        //UserName
        System.out.println("Insira o seu primeiro nome:");
        String nome1 = ler.nextLine();
        System.out.println("Insira o seu último nome:");
        String nome2 = ler.nextLine();
        String linha = id + "," + nome1 + " " + nome2;
        //Coordenadas GPS
        System.out.println("Insira as suas coordenadas de GPS:");
        System.out.println("x:");
        String x = ler.nextLine();
        System.out.println("y:");
        String y = ler.nextLine();

        linha = linha + "," + x + "," + y;
        User user = User.insereUser(linha,sistema);


        //Escrever no ficheiro
        try {
            FileWriter file = new FileWriter(strfile,true);
            file.write("\n");
            file.write(user.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        registarLogin (id,strfile,sistema);
    }
    public static void registoVoluntario (String strfile,Sistema sistema){

        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //VolunteerID ->  gera um userID random para o utilizador
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int);
        id = "v" + id;
        //Nome do voluntario
        System.out.println("Insira o seu primeiro nome:");
        String nome1 = ler.nextLine();
        System.out.println("Insira o seu último nome:");
        String nome2 = ler.nextLine();
        String linha = id + "," + nome1 + " " + nome2;
        //Coordenadas GPS
        System.out.println("Insira as suas coordenadas de GPS:");
        System.out.println("x:");
        String x = ler.nextLine();
        System.out.println("y:");
        String y = ler.nextLine();
        //Raio de ação
        System.out.println("Insira o seu raio de ação:");
        String r = ler.nextLine();
        linha = linha + "," + x + "," + y + "," + r;
        Volunteer vol = Volunteer.insereVolunteer(linha,sistema);

        //Escrever no ficheiro
        try {
            FileWriter file = new FileWriter(strfile,true);
            file.write("\n");
            file.write(vol.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        registarLogin (id,strfile,sistema);
    }
    public static void registoLoja (String strfile,Sistema sistema){
        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //LojaID
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int);
        id = "l" + id ;
        //LojaName
        System.out.println("Que tipo da loja?");
        System.out.println("1- Supermecado");
        System.out.println("2- Restaurante");
        System.out.println("3- Loja de roupa");
        System.out.println("4- Farmácia");
        int tipo =  Integer.parseInt(ler.nextLine());
        System.out.println("Insira o nome da sua loja:");
        String nome = ler.nextLine();
        String linha = id + "," + nome;
        Loja loja = Loja.insereLoja(linha,sistema);


        //Escrever no ficheiro
        try {
            FileWriter file = new FileWriter(strfile,true);
            file.write("\n");
            file.write(loja.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Chamar função que faz o registo da conta
        registarLogin (id,strfile,sistema);
    }
    public static void registoEmpresa (String strfile,Sistema sistema){
        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciando registo...");

        //EmpresaID
        Random rand = new Random();
        int rand_int = rand.nextInt(100);
        String id = String.valueOf(rand_int);
        id = "t" + id;
        //Nome da empresa
        System.out.println("Insira o nome da Empresa Transportadora:");
        String nome = ler.nextLine();
        String linha = id + "," + nome;
        //Coordenadas GPS
        System.out.println("Insira as suas coordenadas de GPS:");
        System.out.println("x:");
        String x = ler.nextLine();
        System.out.println("y:");
        String y = ler.nextLine();
        //NIF
        System.out.println("Insira o NIF da empresa:");
        String nif = ler.nextLine();
        //Raio de ação
        System.out.println("Insira o seu raio de ação:");
        String r = ler.nextLine();
        //Preço por Km
        System.out.println("Insira o preço por Km que a empresa cobra:");
        String preco = ler.nextLine();

        linha = linha + "," + x + "," + y + "," + nif + "," + r + "," + preco;
        Empresa emp = Empresa.insereTransportadora(linha,sistema);

        //Escrever no ficheiro
        try {
            FileWriter file = new FileWriter(strfile,true);
            file.write("\n");
            file.write(emp.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        registarLogin(id,strfile,sistema);
    }
   public static void registarLogin (String id,String strfile,Sistema sistema){
       int opcao=1;
       Scanner ler = new Scanner(System.in);
       Login conta = new Login();   //cria login
       System.out.printf("\nO seu ID é: %s\n", id);  //mostra o id
       System.out.println("Insira uma password:");    //pede password
       String pass = ler.nextLine();
       System.out.println("Confirme a sua password:");   //pede confirmação
       String pass2 = ler.nextLine();

       while(!pass.equals(pass2)){
           System.out.println("Por favor insira de novo.Password incorreta.");
           pass2 = ler.nextLine();
       }
        opcao = qualidadePass(pass);
       /** Caso o utilizador do programa pretende trocar de palavra passe recomeça a função */
       if (opcao == 0) {
           registarLogin(id,strfile,sistema);
       }
       /** Senão continua o que estava a fazer e atribui os valores que inseriu aos campos do login, escrevendo no ficheiro  */
       else{
       conta.setUserID(id);
       conta.setPassword(pass);
       Sistema.insereLogin(conta,sistema); // diz se a conta foi criada ou nao
       //Escrever no ficheiro
       try {
           FileWriter file = new FileWriter(strfile,true);
           file.write("\n");
           file.write(conta.toString());
           file.close();
       } catch (IOException e) {
           e.printStackTrace();
       }}

   }
    public static int qualidadePass (String password){
        int opcao = 1;
        Boolean digito = false;
        Boolean maiuscula = false;

        /**Ciclo que vai verificar se a palavra passe tem maiusculas e/ou números */
        for (int i=0; i<password.length(); i++) {
            char c = password.charAt(i);
            if(Character.isDigit(c)) digito = true;
            if (Character.isLetter(c)) {
                if(Character.isUpperCase(c)) maiuscula = true;
            } }

        /**ifs que consoante exista ou não números presentes na password avalia se a palavra passe é segura ou não e caso
        * esta seja fácil dá oportunidade ao utilizador do programa de alterar a mesma para incluir maiusculas ou numeros
         * tornando assim o seu acesso ao programa mais seguro */
        if (((digito==true) && (maiuscula==false))||((digito==false) && (maiuscula==true)))
            System.out.println((char)27 + "[33mPalavra Passe Média" + (char)27 + "[0m");
        if ((digito==true) && (maiuscula==true))  System.out.println((char)27 + "[32mPalavra Passe Dífícil" + (char)27 + "[0m");
        if  ((digito==false) && (maiuscula==false)){
            System.out.println((char)27 + "[31mPalavra Passe Fácil" + (char)27 + "[0m");
            System.out.println((char)27 +"[31mDIGITE 0 - se prentende melhorar a segurança do seu login"+ (char)27 + "[0m");
            Scanner ler = new Scanner(System.in);
            String resultado = ler.nextLine();

            if (resultado=="0"){
                System.out.println("Por favor insira uma palavra passe com dígitos ou letras maíusculas");
                opcao=0;
            }
            if (resultado.equals("")) {
            opcao =1;}
        /** Retorna a opção de trocar ou não de palavra passe para, desta forma, na função de registo ver se é necessaŕio recomeçar a
         * escolha de palavra passe */
        }
        return opcao;}
}

