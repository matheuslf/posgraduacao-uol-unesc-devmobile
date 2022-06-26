package unesc.uol.precofipeapp.database.model;

public class UsuarioModel {

    public static final String
    TABELA_NOME = "tb_usuario";

    public static final String
    COLUNA_ID = "_id",
    COLUNA_NOME_USUARIO = "nome_usuario",
    COLUNA_EMAIL_USUARIO = "email_usuario",
    COLUNA_SENHA_USUARIO = "senha_usuario";

    public static final String
    CREATE_TABLE =
    "create table "+TABELA_NOME
            +" ( "
            + COLUNA_ID + " integer primary key autoincrement, "
            + COLUNA_NOME_USUARIO + " text not null, "
            + COLUNA_EMAIL_USUARIO + " text not null, "
            + COLUNA_SENHA_USUARIO + " text not null "
            +" );";

    public static final String
    DROP_TABLE =
    "drop table if exists "+TABELA_NOME;

    private long id;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }
}
