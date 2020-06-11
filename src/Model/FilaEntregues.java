package Model;

import Model.Encomendas.IEncomenda;
import Model.Encomendas.IEntrega;

import java.io.Serializable;
import java.util.*;

public class FilaEntregues implements IFilaEntregues, Serializable {
    private Map<String, Set<IEntrega>> fila;

    public FilaEntregues(){
        this.fila = new HashMap<>();
    }


    public void addEncomenda(IEntrega e) {
        String transpID = e.getTransporte().getId();
        if(this.fila.containsKey(transpID)){
            this.fila.get(transpID).add(e);
        }
        else {
            Set<IEntrega> value = new TreeSet<>(new CompareEntrega());
            value.add(e);
            this.fila.put(transpID, value);
        }
    }

    public int removeEncomenda(IEntrega e) {
        String transpID = e.getTransporte().getId();
        if(this.fila.containsKey(transpID)){
            this.fila.get(transpID).remove(e);
            return 0;
        }
        return -1;
    }


    public Set<IEntrega> getEntregas(String codId) {
        if(this.fila.containsKey(codId)) return this.fila.get(codId);
        else return null;
    }

    public Set<IEntrega> getEntregasFalse(String codId){
        Set<IEntrega> res = new HashSet<>();
        if(this.fila.containsKey(codId)){
            Set<IEntrega> value = this.fila.get(codId);
            for(IEntrega e : value){
                if(e.getEntregue()) res.add(e);
            }
        }
        return res;
    }

    public Set<IEntrega> getEntregasTrue(String codId){
        Set<IEntrega> res = new HashSet<>();
        if(this.fila.containsKey(codId)){
            Set<IEntrega> value = this.fila.get(codId);
            for(IEntrega e : value){
                if(!e.getEntregue()) res.add(e);
            }
        }
        return res;
    }

    public Set<IEntrega> getMedicamentos(String codId){
        Set<IEntrega> set = new HashSet<>();
        if(this.fila.containsKey(codId)) {
            Set<IEntrega> value = this.fila.get(codId);
            for(IEntrega e : value){
                if(e.getEncomenda().getMedicamentos()) set.add(e);
            }
        }
        return set;
    }

    public boolean containsEncFalse (String encId) {
        Set<String> set = this.fila.keySet();
        for(String aux : set){
            Set<IEntrega> value = this.fila.get(aux);
            for(IEntrega encomenda : value){
                if(encomenda.getEncomenda().getEncomendaID().equals(encId)){
                    return true;
                }
            }
        }
        return false;
    }


    public IEntrega getEntrega(String id) {
        Set<String> set = this.fila.keySet();
        for(String aux : set){
            Set<IEntrega> value = this.fila.get(aux);
            for(IEntrega encomenda : value){
                if(encomenda.getEncomenda().getEncomendaID().equals(id)){
                    return encomenda;
                }
            }
        }
        return  null;
    }

    public String toString() {
        return "Fila: " + fila;
    }
}
