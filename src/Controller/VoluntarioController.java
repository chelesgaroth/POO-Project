package Controller;

import Model.Catalogos.IProduto;
import Model.CompareEntrega;
import Model.Encomendas.Encomenda;
import Model.Encomendas.Entrega;
import Model.Encomendas.IEncomenda;
import Model.Encomendas.IEntrega;
import Model.ISistema;
import Model.Tipos.*;
import View.INavegador;
import View.IUserView;
import View.IVoluntarioView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class VoluntarioController implements IVoluntarioController {
    private ISistema sistema;
    private IVoluntarioView view;
    private Voluntario voluntario;
    private IEntrega entregaFinal;
    private int opcao;

    public VoluntarioController(){
        this.opcao = -1;
        this.entregaFinal = new Entrega();
    }

    public void setSistema(ISistema sistema){
        this.sistema = sistema;
    }
    public void setAppView(IVoluntarioView view) {
        this.view = view;
    }
    public void setVoluntario(){
        String id = sistema.getLogins().getCodigoID(sistema.getQuem().getEmail());
        ITipo tipo = sistema.getVoluntarios().getTipo(id);
        if(tipo instanceof Voluntario) this.voluntario = (Voluntario) tipo;
    }

    public void VoluntarioMode(){
        setVoluntario();
        Scanner ler = new Scanner(System.in);
        view.prepara();
        String yn = ler.nextLine();
        if(yn.equals("Y")) this.voluntario.setMedicamentos(true);
        do {
            ler = new Scanner(System.in);
            view.mode();
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:{ //Encomendas em espera --- ver só as que são false
                    Set<IEntrega> res = sistema.getFilaEntregues().getEntregasFalse(voluntario.getId());
                    if(res!=null)view.encomendasFila(res);
                    else view.printMensagem("Não há Encomendas por entregar");
                    break;
                }
                case 2:{ //Entregar Encomenda ao Utilizador
                    view.printMensagem("Insira a Encomenda: ");
                    ler = new Scanner(System.in);
                    String codigoE = ler.nextLine();
                    if(!sistema.getFilaEntregues().containsEncFalse(codigoE)){
                        view.printMensagem("Código de encomenda inválido!");
                        break;
                    }
                    Set<IEntrega> med = sistema.getFilaEntregues().getMedicamentos(voluntario.getId());
                    IEntrega entrega = sistema.getFilaEntregues().getEntrega(codigoE);

                    if((med.contains(entrega) && !voluntario.getMedicamentos())) {
                        view.printMensagem("Avisando o Utilizador que a encomenda foi cancelada...");
                        opcao = 0;
                    }
                    else {
                        this.entregaFinal = entrega;
                        view.printMensagem("Transportando a Encomenda até à casa do utilizador...");
                        view.printMensagem("Pressione ENTER quando chegar ao destino");
                        Scanner scanner = new Scanner(System.in);
                        scanner.nextLine();
                        entregar();
                    }
                    break;
                }
                case 3: { //Histórico de entregas
                    Set<IEntrega> res = sistema.getFilaEntregues().getEntregasTrue(voluntario.getId());
                    IEntrega[] array = res.toArray(new IEntrega[res.size()]);
                    Arrays.sort(array,new CompareEntrega());
                }
                case 4:{ //Classificacoes

                }
            }
        }while(opcao!=0);
    }

    public void entregar(){
        User user = (User) sistema.getUsers().getTipo(entregaFinal.getEncomenda().getUserID());
        Loja loja = (Loja) sistema.getLojas().getTipo(entregaFinal.getEncomenda().getLojaID());
        ITipo transporte = entregaFinal.getTransporte();
        float dist = sistema.getGestao().distanciaPercorrida(user,transporte,loja);
        entregaFinal.setDistPercorrida(dist);
        entregaFinal.setHoraEntrega(LocalTime.now());
        entregaFinal.setEntregue(true);
        entregaFinal.setDataEntrega(LocalDate.now());
        user.getHistorico().add(entregaFinal);
        System.out.println(entregaFinal.toString());
        view.printMensagem("Encomenda Entregue!!");
        view.printMensagem("O Utilizador irá agora classificar o serviço...");
    }
}
