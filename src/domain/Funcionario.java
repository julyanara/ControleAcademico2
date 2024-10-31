package domain;

public class Funcionario {

    protected Integer Código;
    protected String Nome;
    protected String Email;
    protected String Senha;
    protected SexoEnum sexo;
    protected String Área;


    public Funcionario(String nome, String email, String senha, SexoEnum sexo, String área) {
        Nome = nome;
        Email = email;
        Senha = senha;
        this.sexo = sexo;
        Área = área;
    }
    public String getÁrea() {
        return Área;
    }
    public void setÁrea(String área) {
        Área = área;
    }
    public Integer getCódigo() {
        return Código;
    }
    public void setCódigo(Integer código) {
        Código = código;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getSenha() {
        return Senha;
    }
    public void setSenha(String senha) {
        Senha = senha;
    }
    public SexoEnum getSexo() {
        return sexo;
    }
    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Funcionario [Código=" + Código + ", Nome=" + Nome + ", Email=" + Email + ", Senha=" + Senha + ", sexo="
                + sexo + ", Área=" + Área + "]";
    }
}

