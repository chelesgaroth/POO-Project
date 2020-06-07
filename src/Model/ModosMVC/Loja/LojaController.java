package Model.ModosMVC.Loja;

import Model.Encomendas.IEncomenda;
import Model.ISistema;
import Model.Logins.ILogin;
import Model.Tipos.ILoja;

import java.time.LocalTime;
import java.util.*;


public class LojaController implements ILojaController {
    private ISistema sistema;
    private ILojaView view;
    private IAppLoja model;
    private int opcao;

    public LojaController(){
        this.opcao = 0;
        this.view = new LojaView();
        this.model = new AppLoja();
    }

    public void setSistema(ISistema sistema){ this.sistema = sistema; }

    public void setView(ILojaView view){ this.view= view; }

    public void setModel(IAppLoja model) { this.model = model; }

    public void lojaMode() {
        view.infos();
        Scanner ler = new Scanner(System.in);
        String tempo = ler.nextLine();
        double time = Float.parseFloat(tempo);
        model.setTempoPessoa(time);
        do {
            ler = new Scanner(System.in);
            view.modeLoja();
            opcao = ler.nextInt();
            switch (opcao) {
                case 1: { //Validar a encomenda
                    //Estas duas linhas é só para testar as filas de espera
                    model.addEncomenda(sistema.getTotalEncs().iterator().next());
                    System.out.println(model.toString());
                    /*
                    PEDIR INPUTS PARA TER INFOS PARA CRIAR UMA ENCOMENDA
                    DEPOIS DISSO FAZER SET DA ENCOMENDA COM ESSAS INFORMAÇÕES
                    FAZER SET DA HORAINICIAL DA ENTREGA
                    ADICIONAR A ENCOMENDA À LISTA DE ESPERA DA APP
                    ADICIONAR AS ENCOMENDAS TOTAL NO SISTEMA
                     */
                    break;
                }
                case 2: { //Indicar que a encomenda está pronta
                    view.printMensagem("Qual a encomenda que está pronta?");
                    ler = new Scanner(System.in);
                    String encomenda = ler.nextLine();
                    if(model.existsEncomenda(encomenda)){
                        sistema.addAceite(encomenda);
                        System.out.println(sistema.getAceites());
                        model.removeEncomenda(encomenda);
                        System.out.println(model.toString());
                    }
                    break;
                }
                case 3: { // Encomendas em fila de espera

                    break;
                }
                case 4: { //Ver o histórico de vendas realizadas
                    break;
                }

                case 5 : {
                    HashMap<String, IEncomenda> encsTotais = sistema.getEncIntroduzidas();
                    HashSet<IEncomenda> encomendasProprias = new HashSet<>();
                    ILogin loja = sistema.getQuem();
                    String email = loja.getEmail();
                    String[] user = email.split("@");
                    for (String lojaid : encsTotais.keySet()) {
                        if (lojaid.equals(user[0])) {
                            IEncomenda enc = encsTotais.get(lojaid);
                            System.out.println(enc);
                            encomendasProprias.add(enc);
                        }
                    }
                    //encomendasProprias: estas sao as encomendas dos utilizadores para a loja
                    //para ficar completa falta a loja adicionar o peso da mesma e gerar codigo de encomenda
                }
                default:
                    break;
            }
        }while (opcao != 0) ;
        view.printMensagem("Obrigada!Volte Sempre!");
    }
}
