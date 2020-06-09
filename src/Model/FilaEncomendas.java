package Model;

import Model.Encomendas.IEncomenda;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FilaEncomendas implements IFila{
    private Map<String, Set<IEncomenda>> fila;

    public FilaEncomendas(){
        this.fila = new HashMap<>();
    }

    public void addEncomenda(IEncomenda encomenda) {
        String lojaId = encomenda.getLojaID();
        if(this.fila.containsKey(lojaId)){
            this.fila.get(lojaId).add(encomenda);
        }
        else {
            Set<IEncomenda> value = new TreeSet<>(new CompareEncomenda());
            value.add(encomenda);
            this.fila.put(lojaId, value);
        }
    }

    public int removeEncomenda(IEncomenda encomenda) {
        String lojaId = encomenda.getLojaID();
        if(this.fila.containsKey(lojaId)){
            this.fila.get(lojaId).remove(encomenda);
        }
        else{
            return -1;
        }
        return 0;
    }

    @Override
    public Set<IEncomenda> getEncomendas(String codId) {
        return null;
    }

    @Override
    public boolean containsEncTipo(String encId, String codId) {
        return false;
    }

    @Override
    public IEncomenda getEncomendaTipo(String encId, String codId) {
        return null;
    }

    @Override
    public String toString() {
        return "Fila: " + fila;
    }
}
