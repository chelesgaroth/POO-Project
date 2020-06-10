package Model.Encomendas;


import Model.Tipos.ITipo;
import Model.Tipos.Voluntario;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Entrega extends Encomenda implements IEntrega, Serializable {
    private IEncomenda encomenda;
    private LocalTime horaEntrega;
    private ITipo transporte;

    public Entrega(){
        this.encomenda = new Encomenda();
        this.horaEntrega = LocalTime.now();
        this.transporte = new Voluntario(); // new Empresa();

    }

    public Entrega(IEncomenda encomenda , LocalTime horaEntrega,ITipo transporte){
        this.encomenda = encomenda;
        this.horaEntrega = horaEntrega;
        this.transporte = transporte;
    }

    public Entrega(Entrega e){
        this.encomenda = e.getEncomenda();
        this.horaEntrega = e.getHoraEntrega();
        this.transporte = e.getTransporte();
    }

    public IEncomenda getEncomenda() {
        return this.encomenda;
    }

    public void setEncomenda(IEncomenda encomenda) {
        this.encomenda = encomenda;
    }

    public LocalTime getHoraEntrega() {
        return this.horaEntrega;
    }

    public void setHoraEntrega(LocalTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public ITipo getTransporte() {
        return this.transporte;
    }

    public void setTransporte(ITipo transporte) {
        this.transporte = transporte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entrega)) return false;
        if (!super.equals(o)) return false;
        Entrega entrega = (Entrega) o;
        return Objects.equals(getHoraEntrega(), entrega.getHoraEntrega()) &&
                Objects.equals(getTransporte(), entrega.getTransporte());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHoraEntrega(), getTransporte());
    }

    @Override
    public String toString() {
        return "Entrega:\n" +
                "encomenda: " + encomenda.getEncomendaID() +
                "horaEntrega: " + horaEntrega +
                "transporte: " + transporte.getId();
    }
}
