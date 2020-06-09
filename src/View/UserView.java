package View;

public class UserView implements IUserView {

    public void userMode(){
        System.out.println("-----------USER MODE----------");
        System.out.println("1- Fazer uma encomenda");
        System.out.println("2- Histórico de compras");
        System.out.println("3- Classificar transporte");
        System.out.println("0- Voltar ao Menu de Login");
    }

    public void printMensagem(String s){
        System.out.printf("\n%s\n",s);
    }

}
