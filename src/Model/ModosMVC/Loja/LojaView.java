package Model.ModosMVC.Loja;

import Model.Encomendas.IEncomenda;

import java.util.ArrayList;

public class LojaView implements ILojaView {

    public void modeLoja(){
        System.out.println("-----------LOJA MODE----------");
        System.out.println("1- Validar uma encomenda");
        System.out.println("2- Indicar que a encomenda está pronta");
        System.out.println("3- Encomendas em fila de espera");
        System.out.println("4- Ver o histórico de vendas realizadas");
        System.out.println("5- Lista de encomendas por completar");
        System.out.println("0- Sair da aplicação");
    }

    public void printMensagem(String s){
        System.out.printf("\n%s\n",s);
    }

    public void infos(){
        System.out.println("-----------LOJA MODE----------");
        System.out.println("Quanto tempo demora, em média, em minutos, a atender uma pessoa?");
    }

    public void encomendasFila(ArrayList<IEncomenda> res){
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("                ENCOMENDAS NA FILA DE ESPERA");
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("Utilizador                               Código da Encomenda");
        for(int i=0; i<res.size();i++){
            System.out.printf("%-25s",res.get(i).getUserID());
            System.out.print(res.get(i).getEncomendaID());
            System.out.println();
        }
    }
}
