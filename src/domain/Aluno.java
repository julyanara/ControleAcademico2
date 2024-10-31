package domain;

import java.util.Date;
import java.util.List;

public class Aluno extends Matricula{

    private Integer Código;
    private String Nome;
    private String cpf;
    private String Email;
    private String Senha;
    private String rg;
    private SexoEnum sexo;
    private Date DataNasc;
    private List<Curso> curso;
    private List<Bolsista> bolsista;
    private Historico historico;

    public Aluno(Date dataMat, String nome, String cpf, String email, String senha, String rg, SexoEnum sexo,
            Date dataNasc) {
        super(dataMat);
        Nome = nome;
        this.cpf = cpf;
        Email = email;
        Senha = senha;
        this.rg = rg;
        this.sexo = sexo;
        DataNasc = dataNasc;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public SexoEnum getSexo() {
        return sexo;
    }
    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }
    public Date getDataNasc() {
        return DataNasc;
    }
    public void setDataNasc(Date dataNasc) {
        DataNasc = dataNasc;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }

    public List<Bolsista> getBolsista() {
        return bolsista;
    }

    public void setBolsista(List<Bolsista> bolsista) {
        this.bolsista = bolsista;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    

    
}
