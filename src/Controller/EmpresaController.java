package Controller;

import Model.Encomendas.Entrega;
import Model.Encomendas.IEntrega;
import Model.Encomendas.LinhaEncomenda;
import Model.ISistema;
import Model.Tipos.Empresa;
import Model.Tipos.ITipo;
import Model.Tipos.Loja;
import Model.Tipos.User;
import View.IAppView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;


public class EmpresaController implements IEmpresaController {
    private ISistema sistema;
    private IAppView view;
    private Empresa empresa;
    private IEntrega entregaFinal;
    private int opcao;

    public EmpresaController(){
        this.empresa = new Empresa();
        this.entregaFinal = new Entrega();
        this.opcao = 0;
    }

    public void setSistema(ISistema sistema){
        this.sistema = sistema;
    }
    public void setView(IAppView view) { this.view = view; }
    public void setEmpresa() {
        String id = sistema.getLogins().getCodigoID(sistema.getQuem().getEmail());
        this.empresa = (Empresa) sistema.getEmpresas().getTipo(id);
    }

    public void mode(){
        setEmpresa();
        Scanner ler = new Scanner(System.in);
        view.prepara(0);
        if(ler.nextLine().equals("Y")) empresa.setAceitaMedicamento(true);
        else empresa.setAceitaMedicamento(false);
        view.prepara(1);
        ler = new Scanner(System.in);
        if(ler.nextLine().equals("Y")) empresa.setChuva(true);
        else empresa.setChuva(false);
        view.prepara(2);
        ler = new Scanner(System.in);
        String n = ler.nextLine();
        empresa.setNEncs(Integer.parseInt(n));
        view.prepara(3);
        ler = new Scanner(System.in);
        String taxa = ler.nextLine();
        empresa.setTaxaAdicional(Double.parseDouble(taxa));
        do{
            view.modeEmpresa();
            ler = new Scanner(System.in);
            opcao = ler.nextInt();
            switch (opcao){
                case 1:{ //Encomendas por entregar
                    Set<IEntrega> res = sistema.getFilaEntregues().getEntregasFalse(empresa.getId());
                    if(res!=null)view.encomendasFila(res);
                    else view.printMensagem("Não há Encomendas por entregar");
                    break;
                }
                case 2: {//Entregar Encomenda ao Utilizador
                    view.printMensagem("Insira a Encomenda: ");
                    ler = new Scanner(System.in);
                    String codigoE = ler.nextLine();
                    if(!sistema.getFilaEntregues().containsEncFalse(codigoE)){
                        view.printMensagem("Código de encomenda inválido!");
                        break;
                    }
                    Set<IEntrega> med = sistema.getFilaEntregues().getMedicamentos(empresa.getId());
                    IEntrega entrega = sistema.getFilaEntregues().getEntrega(codigoE);

                    if((med.contains(entrega) && !empresa.getAceitaMedicamento())) {
                        sistema.getFilaEncomendas().addEncomenda(sistema.getFilaEntregues().getEntrega(codigoE).getEncomenda());
                        sistema.getFilaEntregues().removeEncomenda(sistema.getFilaEntregues().getEntrega(codigoE));
                        ((Empresa)sistema.getEmpresas().getTipo(empresa.getId())).setDisponibilidade(false);
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
                case 3:{ //Recusar pedidos de entrega


                }
            }
        }while (opcao!=0);
    }

    public void entregar(){
        User user = (User) sistema.getUsers().getTipo(entregaFinal.getEncomenda().getUserID());
        Loja loja = (Loja) sistema.getLojas().getTipo(entregaFinal.getEncomenda().getLojaID());
        ITipo transporte = entregaFinal.getTransporte();
        float dist = sistema.getGestao().distanciaPercorrida(user,transporte,loja);
        ArrayList<LinhaEncomenda> linhas = entregaFinal.getEncomenda().getProds();
        float preco = 0;
        for( LinhaEncomenda l : linhas){
            preco += l.getValor();
        }
        if(empresa.getChuva()) preco += empresa.getTaxaChuva(); //preco da chuva e transito (valor fixo)
        if(entregaFinal.getEncomenda().getCongelados()) preco += empresa.getTaxaAdicional(); //preco dos congelados +rapido
        preco += (empresa.getPreco()) * dist; //preco por km
        preco += (empresa.getPrecoPeso()) * (entregaFinal.getEncomenda().getPesoTotal());
        entregaFinal.setPrecoTotal(preco);
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
