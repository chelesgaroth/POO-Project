package Model.Tipos;

import java.util.Objects;

public abstract class Tipo implements  ITipo{
    private String id;
    private String nome;
    private float x; //latitude
    private float y; //longitude

    public Tipo(){
        this.id = "n/a";
        this.nome = "n/a";
        this.x = 0;
        this.y = 0;
    }

    public Tipo(String id,String nome,float x , float y){
        this.id = id;
        this.nome = nome;
        this.x = x;
        this.y = y;
    }

    public Tipo(Tipo algo){
        this.id = algo.getId();
        this.nome = algo.getNome();
        this.x = algo.getX();
        this.y = algo.getY();
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tipo)) return false;
        Tipo tipo = (Tipo) o;
        return Float.compare(tipo.getX(), getX()) == 0 &&
                Float.compare(tipo.getY(), getY()) == 0 &&
                Objects.equals(getId(), tipo.getId()) &&
                Objects.equals(getNome(), tipo.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getX(), getY());
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public void criaTipo(String linha){
        String[] id= linha.split (",");
        this.id = (id[0]);

        float x= Float.parseFloat(id[2]);
        float y= Float.parseFloat(id[3]);

        this.x = x;
        this.y = y;

        String[] textoSeparado = id[1].split(" ");
        String nameAux = textoSeparado[0] + " " + textoSeparado[textoSeparado.length-1];
        this.nome = nameAux;
    }
}
