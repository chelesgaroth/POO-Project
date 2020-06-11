package View;

import Model.Catalogos.ICatalogoProds;
import Model.Encomendas.ILinhaEncomenda;

public class AppView implements IAppView {

    public void preInicio(){
        System.out.println();
        System.out.println("-----------Bem-Vindo!!-----------");
        System.out.println("1- Ler um ficheiro .txt");
        System.out.println("2- Carregar estado do programa");
        System.out.println("0- Sair do aplicativo");
    }

    public void inicio () {
        System.out.println();
        System.out.println("---------TRAZ AQUI!--------");
        System.out.println("Prima:");
        System.out.println("1- Fazer Registo"); //adiciona ao estado
        System.out.println("2- Fazer Login "); //retoma o estado do aplicativo
        System.out.println("3- Alterar a password");
        System.out.println("4- Guardar estado do programa");
        System.out.println("0- Sair do aplicativo");
    }

    public void registo (){
        System.out.println("---------TRAZ AQUI!--------");
        System.out.println("Fazer registo de:");
        System.out.println("1- Utilizador");
        System.out.println("2- Voluntário");
        System.out.println("3- Loja");
        System.out.println("4- Empresa");
        System.out.println("0- Voltar ao Menu Inicial");
    }

    /*public void mode(int x, String nome){
        System.out.println("---------TRAZ AQUI!--------");

        if(x==1){ //User
            System.out.println("1- Fazer uma encomenda");
            System.out.println("2- Histórico de compras");
            /*
        * solicitar a entrega de uma encomenda que foi pedida a uma loja;
        * aceitar, ou não, o serviço de entrega proposto por uma empresa transportadora (os
        serviços feitos por voluntários são automaticamente aceites pelo sistema);
        * aceder à informação das entregas efectuadas num determinado período e por voluntário
        ou transportador;
        * classificar o voluntário ou a empresa de transportes mediante o grau de satisfação com
        o serviço;

        }
        if(x==2){ //Loja
            System.out.println("1- Ver o nº de vendas realizadas");
        }
        if(x==3){ //Empresa
            System.out.println("1- Ver o nº de encomendas transportadas");
        }
        if(x==4){ //Voluntário
            System.out.println("1- Ver o nº de encomendas que foram entregues");
        }
    } */

    public void printMensagem(String s){
        System.out.printf("\n%s\n",s);
    }

    public void login(int x){
        if(x==0) System.out.println("-----------LOGIN!----------");
        if(x==1) System.out.println("Insira o seu email:");
        if(x==3) System.out.println("Password ou email incorreto. Tente novamente.");
        if(x==2) System.out.println("Insira a sua password:");
    }
}
