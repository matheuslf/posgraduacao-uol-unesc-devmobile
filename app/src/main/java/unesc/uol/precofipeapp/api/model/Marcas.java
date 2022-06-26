package unesc.uol.precofipeapp.api.model;

import java.io.Serializable;

public class Marcas implements Serializable {

    private String nome;
    private int codigo;

    public Marcas() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
