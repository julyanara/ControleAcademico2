package domain;

import java.util.Date;
import java.util.List;

public class Disciplina extends Matricula{

    private Integer Código;
    private String Nome;
    private String Situação;
    private String CargaHorária;
    private Professor professor;
    private Historico historico;
    private List<Disciplina> disciplina;
    private Aluno aluno;
    private List<Turma> turma;

    public Disciplina(Date dataMat, String nome, String situação, String cargaHorária, Professor professor) {
        super(dataMat);
        Nome = nome;
        Situação = situação;
        CargaHorária = cargaHorária;
        this.professor = professor;
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
    public String getSituação() {
        return Situação;
    }
    public void setSituação(String situação) {
        Situação = situação;
    }
    public String getCargaHorária() {
        return CargaHorária;
    }
    public void setCargaHorária(String cargaHorária) {
        CargaHorária = cargaHorária;
    }
    
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Historico getHistorico() {
        return historico;
    }
    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public List<Disciplina> getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public List<Turma> getTurma() {
        return turma;
    }
    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }
  

    @Override
    public String toString() {
        return "Disciplina [Código=" + Código + ", Nome=" + Nome + ", Situação=" + Situação + ", CargaHorária="
                + CargaHorária + "]";
    }
  
  

}

