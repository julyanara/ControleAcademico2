package domain;

import java.util.List;

public class Historico {

    protected Integer Codigo;
    protected Float Nota;
    private List<Disciplina> disciplina;

    public Historico(Float nota) {
        Nota = nota;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }

    public List<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    public Float getNota() {
        return Nota;
    }
    public void setNota(Float nota) {
        Nota = nota;
    }

    
    
}
