package domain;

import java.util.List;

public class Professor extends Funcionario{

    protected Float Salario;
    private List<Projeto> projeto;
    private List<Disciplina> disciplina;


    public Professor(String nome, String email, String senha, SexoEnum sexo, String área, Float salario) {
        super(nome, email, senha, sexo, área);
        Salario = salario;
    }

    public Float getSalario() {
        return Salario;
    }

    public void setSalario(Float salario) {
        Salario = salario;
    }

    public List<Projeto> getProjeto() {
        return projeto;
    }

    public void setProjeto(List<Projeto> projeto) {
        this.projeto = projeto;
    }

    public List<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    

}
