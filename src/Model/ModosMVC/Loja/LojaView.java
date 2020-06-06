package Model.ModosMVC.Loja;

public class LojaView implements ILojaView {

    public void modeLoja(){
        System.out.println("-----------LOJA MODE----------");
        System.out.println("1- Validar uma encomenda");
        System.out.println("2- Encomendas em fila de espera");
        System.out.println("3- Indicar que a encomenda está pronta");
        System.out.println("4- Ver o histórico de vendas realizadas");
        System.out.println("0- Sair da aplicação");
    }

    public void printMensagem(String s){
        System.out.printf("\n%s\n",s);
    }
}
