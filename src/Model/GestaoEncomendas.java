package Model;

import Model.Catalogos.ICatalogoTipo;
import Model.Catalogos.IProduto;
import Model.Catalogos.Produto;
import Model.Encomendas.*;
import Model.Logins.ILogin;
import Model.Tipos.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas implements IGestaoEncomendas, Serializable {


    public IEncomenda constroiEncomendaParaLoja (String loja , List<IProduto> prods, List<String> quantidades, ILogin user){

        ArrayList<LinhaEncomenda> encomendas = new ArrayList<>();
        IEncomenda encFinal = new Encomenda();
        String userId = (user.getPassword()).substring(0,3);

        int i=0;
        for(IProduto produto : prods){
            LinhaEncomenda linhaEncomenda = new LinhaEncomenda();
            linhaEncomenda.setProduto(produto);
            linhaEncomenda.setQuantidade(Float.parseFloat(quantidades.get(i)));
            linhaEncomenda.setValor((produto.getPreco()* Float.parseFloat(quantidades.get(i))));
            encomendas.add(linhaEncomenda);
        }
        Random random = new Random();
        int numero = random.nextInt(10000);
        String idEnc = "e" + numero;
        encFinal.setEncomendaID(idEnc);
        encFinal.setLojaID(loja);
        encFinal.setUserID(userId);
        encFinal.setProds(encomendas);
        encFinal.setHoraInicial(LocalTime.now());
        System.out.println("Detalhes da sua Encomenda:\nCódigo: " + encFinal.getEncomendaID()
            + "\nLoja: " + encFinal.getLojaID() + "\nProdutos:\n" + encFinal.getProds());
        return encFinal;
    }

    public boolean raioAcao(float x , float y , float raio , float xV , float yV){
        float resX = Math.abs(x-xV);
        float resY = Math.abs(y-yV);
        if((resX<=raio) && (resY<=raio)){
            return true;
        }
        else return false;
    }

    public boolean medicacao(IEncomenda encomenda , ITipo tipo ){
        if(encomenda.getMedicamentos()){
            if(tipo instanceof Voluntario){
                Voluntario vol = (Voluntario) tipo;
                if(vol.getMedicamentos()) return true;
                else return false;
            }
            if(tipo instanceof Empresa){
                Empresa emp = (Empresa) tipo;
                if (emp.getAceitaMedicamento()) return true;
                else return false;
            }
        }
        return true;

    }

    public HashSet<ITipo> verificarTransporte(ICatalogoTipo voluntarios, ICatalogoTipo empresas,IEncomenda encomenda, Loja loja){

        HashSet<ITipo> res = new HashSet<>();
        float xV , yV , rV;
        float xE, yE , rE;
        float x = loja.getX();
        float y = loja.getY();
        for(ITipo tipo1 : voluntarios.getCatalogo()){
            if(tipo1 instanceof Voluntario){
                Voluntario vol = (Voluntario) tipo1;
                 xV = vol.getX();
                 yV = vol.getY();
                 rV = vol.getRadius_volunteer();
                 if(raioAcao(x,y,rV,xV,yV)){
                     vol.setAvailability(true);
                 }
                 else vol.setAvailability(false);
                res.add(vol);
            }
        }
        for(ITipo tipo2 : empresas.getCatalogo()){
            if(tipo2 instanceof Empresa){
                Empresa emp = (Empresa) tipo2;
                xE = emp.getX();
                yE = emp.getY();
                rE = (float) emp.getRaio();
                if(raioAcao(x,y,rE,xE,yE)){
                    emp.setDisponibilidade(true);
                }
                else emp.setDisponibilidade(false);
                res.add(emp);
            }
        }
        return res;
    }
}
