package domain;

import java.util.List;

public class Curso {

    private Integer Código;
    private String Nome;
    private String CargaHorária;
    private List <Turma> turma;
    private List<Aluno> aluno;
   
    public Curso(String nome, String cargaHorária) {
        Nome = nome;
        CargaHorária = cargaHorária;
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
    public String getCargaHorária() {
        return CargaHorária;
    }

    public List<Turma> getTurma() {
        return turma;
    }
    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }
    
    public List<Aluno> getAluno() {
        return aluno;
    }
    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }

public void setCargaHorária(String cargaHorária) {
    CargaHorária = cargaHorária;
}
public Curso(Integer código, String nome, String cargaHorária) {
    Código = código;
    Nome = nome;
    CargaHorária = cargaHorária;
}
@Override
public String toString() {
    return "Curso [Código=" + Código + ", Nome=" + Nome + ", CargaHorária=" + CargaHorária + "]";
}


}
