package domain;

public class Coordenador extends Funcionario{

    private Float Salario;

   
    public Coordenador(String nome, String email, String senha, SexoEnum sexo, String área, Float salario) {
        super(nome, email, senha, sexo, área);
        Salario = salario;
    }

    public Float getSalario() {
        return Salario;
    }

    public void setSalario(Float salario) {
        Salario = salario;
    }

    
    
}
