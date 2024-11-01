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
    private java.sql.Date DataNasc;
    private List<Curso> curso;
    private List<Bolsista> bolsista;
    private Historico historico;


    public Aluno(Date dataMat2, String nome, String cpf, String email, String senha, String rg, SexoEnum sexo,
            java.sql.Date dataNasc, Historico historico) {
        super(dataMat2);
        Nome = nome;
        this.cpf = cpf;
        Email = email;
        Senha = senha;
        this.rg = rg;
        this.sexo = sexo;
        DataNasc = dataNasc;
        this.historico = historico;
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
    public void setSexo(SexoEnum string) {
        this.sexo = string;
    }
    public java.sql.Date getDataNasc() {
        return DataNasc;
    }
    public void setDataNasc(java.sql.Date dataNasc) {
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

    public void setBolsista(List<Bolsista> string) {
        this.bolsista = string;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public void setBolsista(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBolsista'");
    }

    public void setHistorico(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHistorico'");
    }

    public void setCurso(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurso'");
    }

    

    
}
