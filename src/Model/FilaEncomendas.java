package Model;

import Model.Encomendas.IEncomenda;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FilaEncomendas implements IFila, Serializable {
    private Map<String, Set<IEncomenda>> fila;

    public FilaEncomendas(){
        this.fila = new HashMap<>();
    }

    public void addEncomenda(IEncomenda encomenda) {
        String userId = encomenda.getUserID();
        if(this.fila.containsKey(userId)){
            this.fila.get(userId).add(encomenda);
        }
        else {
            Set<IEncomenda> value = new TreeSet<>(new CompareEncomenda());
            value.add(encomenda);
            this.fila.put(userId, value);
        }
    }

    public int removeEncomenda(IEncomenda encomenda) {
        String userId = encomenda.getUserID();
        if(this.fila.containsKey(userId)){
            this.fila.get(userId).remove(encomenda);
        }
        else{
            return -1;
        }
        return 0;
    }

    public Set<IEncomenda> getEncomendas(String codId) {
        if(this.fila.containsKey(codId)) return this.fila.get(codId);
        else return null;
    }

    public boolean containsEncTipo(String encId, String codId) {
        return false;
    }

    @Override
    public IEncomenda getEncomendaTipo(String encId, String codId) {
        return null;
    }

    @Override
    public IEncomenda existsEncomenda(String id) {
        return null;
    }

    @Override
    public String toString() {
        return "Fila: " + fila;
    }
}
