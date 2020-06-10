package Model;

import Model.Encomendas.IEncomenda;
import Model.Encomendas.IEntrega;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

    public int removeEncomenda(IEncomenda encomenda) {
        return 0;
    }


    public Set<IEncomenda> getEncomendas(String codId) {
        return null;
    }


    public boolean containsEncTipo(String encId, String codId) {
        return false;
    }


    public IEncomenda getEncomendaTipo(String encId, String codId) {
        return null;
    }


    public IEncomenda existsEncomenda(String id) {
        return null;
    }

    public String toString() {
        return "Fila: " + fila;
    }
}
