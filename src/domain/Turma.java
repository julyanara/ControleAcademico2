package domain;

import java.util.Date;
import java.util.List;

public class Turma extends Matricula {

    private Integer Código;
    private String Nome;
    private String Situação;
    private String CargaHorária;
    private List<Disciplina> disciplina;
    private Curso curso;
    
    public Turma(Date localDate, String nome, String situação, String cargaHorária) {
        super(localDate);
        Nome = nome;
        Situação = situação;
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

    public List<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Turma [Código=" + Código + ", Nome=" + Nome + ", Situação=" + Situação + ", CargaHorária="
                + CargaHorária + "]";
    }

    

  


}

    
