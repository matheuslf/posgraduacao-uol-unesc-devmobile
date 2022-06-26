package unesc.uol.precofipeapp.api.model;

import java.io.Serializable;

public class Anos implements Serializable {

    private String nome;
    private String codigo;

    public Anos() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
