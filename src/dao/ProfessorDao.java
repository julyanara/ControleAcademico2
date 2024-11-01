package dao;

import java.util.List;

import domain.Disciplina;
import domain.Funcionario;
import domain.Projeto;
import domain.SexoEnum;

public class ProfessorDao extends Funcionario{

    protected Float Salario;
    private List<Projeto> projeto;
    private List<Disciplina> disciplina;


    public ProfessorDao(String nome, String email, String senha, SexoEnum sexo, String área, Float salario) {
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

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    

}
