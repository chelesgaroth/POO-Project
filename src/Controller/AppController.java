package Controller;

import Model.*;
import Model.Leitura.IRWEstado;
import Model.Leitura.IReadFile;
import Model.Leitura.RWEstado;
import Model.Leitura.ReadFile;
import Model.Logins.ILogin;
import Model.Logins.Login;
import Model.Tipos.*;
import View.*;

import java.io.IOException;
import java.util.*;

public class AppController implements IAppController {
    private ISistema sistema;
    private IAppView view;
    private INavegador nav;
    private IReadFile lerFiles;
    private String file;
    private int opcao;
    private IRWEstado rw;


    public AppController(){
        this.file = " ";
        this.nav = new Navegador();
        this.lerFiles = new ReadFile();
        this.opcao = -1;
        this.rw = new RWEstado();
    }

    public void setSistema(ISistema sistema){
        this.sistema = sistema;
    }

    public void setAppView(IAppView view) {
        this.view = view;
    }

    public ISistema runController() {
        Scanner ler = new Scanner(System.in);
        do{
            view.preInicio();
            opcao = ler.nextInt();
            switch (opcao){
                case 1:{
                    view.printMensagem("Insira um ficheiro de leitura: ");
                    ler = new Scanner(System.in);
                    file = ler.nextLine();
                    lerFiles.leitura(file,sistema);
                    opcao = 0;
                    break;
                }
                case 2: {
                    view.printMensagem("Insira o nome do ficheiro:");
                    ler = new Scanner(System.in);
                    String f = ler.nextLine();
                    rw.setFileIn(f);
                    try {
                        view.printMensagem("Loading ...");
                        setSistema(rw.loadData());
                    } catch (ClassNotFoundException | IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(sistema.toString());
                    opcao = 0;
                    break;
                }
            }
        }while(opcao!=0);
        return sistema;
    }

    /*Esta função faz login ou regista na aplicação.
     * Faz return do char correspondente ao modo.
     * Caso seja 'l' -> Loja;
     * Caso seja 'u' -> user;
     * Caso seja 't' -> empresa;
     * Caso seja 'v' -> voluntário.
     */
    public char signUp (){
        Scanner ler = new Scanner(System.in);
        String email,pass;
        char mode = '0';
        do {
            view.inicio();
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:{ //registo
                    Random rn = new Random(100);
                    int id1 = rn.nextInt(100);
                    String id = String.valueOf(id1);
                    view.registo();
                    ler = new Scanner(System.in);
                    String tipo = ler.nextLine();
                    if (!tipo.equals("0")){
                        if (tipo.equals("1")) {
                            id = "u" + id;
                            System.out.println("user");
                            ITipo user = new User();
                            view.reg(1);
                            ler = new Scanner(System.in);
                            String nome = ler.nextLine();
                            view.reg(2);
                            ler = new Scanner(System.in);
                            float x = ler.nextFloat();
                            view.reg(3);
                            ler = new Scanner(System.in);
                            float y = ler.nextFloat();
                            user.setNome(nome);
                            user.setX(x);
                            user.setY(y);
                            user.setId(id);
                            sistema.getUsers().addTipo(user);


                        }
                        if (tipo.equals("2")){
                            id = "v" + id;
                            System.out.println("voluntario" );
                            ITipo vol = new Voluntario();
                            view.reg(1);
                            ler = new Scanner(System.in);
                            String nome = ler.nextLine();
                            view.reg(2);
                            ler = new Scanner(System.in);
                            float x = ler.nextFloat();
                            view.reg(3);
                            ler = new Scanner(System.in);
                            float y = ler.nextFloat();
                            view.reg(4);
                            ler= new Scanner(System.in);
                            float raio = ler.nextFloat();
                            vol.setNome(nome);
                            vol.setX(x);
                            vol.setY(y);
                            vol.setId(id);
                            ((Voluntario)vol).setRadius_volunteer(raio);
                            sistema.getVoluntarios(). addTipo(vol);

                        }
                        if (tipo.equals("3")){
                            id = "l" + id;
                            ITipo loja = new Loja();
                            System.out.println("loja");
                            ler = new Scanner(System.in);
                            String nome = ler.nextLine();
                            view.reg(2);
                            ler = new Scanner(System.in);
                            float x = ler.nextFloat();
                            view.reg(3);
                            ler = new Scanner(System.in);
                            float y = ler.nextFloat();
                            loja.setY(y);
                            loja.setX(x);
                            loja.setId(id);
                            loja.setNome(nome);
                            sistema.getLojas().addTipo(loja);

                        }
                        if (tipo.equals("4")) {
                            id = "t" + id;
                            System.out.println("empresa");
                            ITipo emp = new Empresa();
                            view.reg(1);
                            ler = new Scanner(System.in);
                            String nome = ler.nextLine();
                            view.reg(2);
                            ler = new Scanner(System.in);
                            float x = ler.nextFloat();
                            view.reg(3);
                            ler = new Scanner(System.in);
                            float y = ler.nextFloat();
                            view.reg(4);
                            ler= new Scanner(System.in);
                            float raio = ler.nextFloat();
                            view.reg(5);
                            ler= new Scanner(System.in);
                            int nif = ler.nextInt();
                            view.reg(6);
                            ler= new Scanner(System.in);
                            float preco = ler.nextFloat();
                            ((Empresa)emp).setNif(nif);
                            emp.setNome(nome);
                            emp.setId(id);
                            emp.setX(x);
                            emp.setY(y);
                            ((Empresa)emp).setPreco(preco);
                            ((Empresa)emp).setRaio(raio);
                            sistema.getEmpresas().addTipo(emp);
                        }

                        System.out.println(sistema.toString());

                    }
                    break;
                }
                case 2:{ //login
                    view.login(0);
                    email = ler.nextLine(); //ver o que se passa aqui
                    view.login(1);
                    email = ler.nextLine();
                    view.login(2);
                    pass = ler.nextLine();
                    ILogin login = new Login();
                    login.setEmail(email);
                    login.setPassword(pass);
                    while(!sistema.getLogins().existsLogin(login)){
                        view.login(3);
                        view.login(1);
                        email = ler.nextLine();
                        view.login(2);
                        pass = ler.nextLine();
                        login.setEmail(email);
                        login.setPassword(pass);
                    }
                    mode = email.charAt(0);
                    sistema.setQuem(login);
                    view.printMensagem("Login concluído!!\n");
                    //System.out.println("Login : " + login.toString());
                    opcao = 0;
                    break;
                }
                case 3:{
                    view.printMensagem("Indique o seu email");
                    ler = new Scanner(System.in);
                    String email2 = ler.nextLine();
                    view.printMensagem("Indique a palavra passe antiga");
                    ler = new Scanner(System.in);
                    String pass2 = ler.nextLine();
                    ILogin login = new Login();
                    login.setEmail(email2);
                    login.setPassword(pass2);
                    if (sistema.getLogins().existsLogin(login)) {
                        view.printMensagem("Insira a password nova");
                        ler = new Scanner(System.in);
                        String pass3 = ler.nextLine();
                        String id = sistema.getLogins().getCodigoID(email2);
                        ILogin log = sistema.getLogins().getLog(id);
                        log.setPassword(pass3);
                    }
                    else view.printMensagem("Login inexistente");
                    System.out.println(sistema.toString());

                    break;
                }
                case 4:{
                    view.printMensagem("Insira um nome para o ficheiro .dat");
                    ler = new Scanner(System.in);
                    String f = ler.nextLine();
                    rw.setFileOut(f);
                    try {
                        view.printMensagem("Saving ...");
                        rw.saveData(this.sistema);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        } while(opcao!=0);
        //view.printMensagem("Adeus!!");
        return mode;
    }
}
