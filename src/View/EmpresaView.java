package View;

import Model.Encomendas.IEntrega;

import java.util.Set;

public class EmpresaView implements IEmpresaView {

    public void prepara(int x){
        if(x==0){
            System.out.println("Aceita transportar medicamentos?");
            System.out.println("(Y) Yes                  (N) No ");
        }
        if(x==1){
            System.out.println("Está a chover ou está trânsito ?");
            System.out.println("(Y) Yes                  (N) No ");
        }
        if(x==2) System.out.println("Quantas encomendas consegue transportar?");
        if(x==3) System.out.println("Qual é a taxa adicional?");
    }

    public void menu(){
        System.out.println("-----------EMPRESA MODE----------");
        System.out.println("1- Encomendas à espera da validação");
        System.out.println("2- Entregar Encomenda ao Utilizador");
        System.out.println("3- Histórico de entregas");
        System.out.println("4- Classificações recebidas pelos Users");
        System.out.println("5- Total Faturado num período");
        System.out.println("0- Voltar ao Menu de Login");
    }

    public void encomendasFila(Set<IEntrega> res){
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("                ENCOMENDAS PARA TRANSPORTE");
        System.out.println("«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»«»");
        System.out.println("Código da Encomenda  Medicamento   Congelados   Hora Inicial");
        for(IEntrega enco : res){
            System.out.printf("%-20s",enco.getEncomenda().getEncomendaID());
            System.out.printf("%-20s",enco.getEncomenda().getMedicamentos());
            System.out.printf("%-20s",enco.getEncomenda().getCongelados());
            System.out.print(enco.getEncomenda().getHoraInicial());
            System.out.println();
        }
    }

    public void printMensagem(String s){
        System.out.printf("\n%s\n",s);
    }
}
