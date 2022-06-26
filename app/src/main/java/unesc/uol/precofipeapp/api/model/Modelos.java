package unesc.uol.precofipeapp.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Modelos implements Serializable {

    private List<Items> modelos;

    public List<Items> getModelos() {
        return modelos;
    }

    public class Items {

        private String nome;
        private int codigo;

        public Items() {

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


}
