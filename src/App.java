import java.sql.Date;

import dao.AlunoDao;
import domain.Aluno;

public class App {

    public static void main(String[] args) {
        try {

            Aluno aluno = new Aluno(null, null, null, null, null, null, null, null, null);
            aluno.setCodigo(1); 
            aluno.setNome("João Silva");
            aluno.setCpf("12345678901");
            aluno.setEmail("joao.silva@example.com");
            aluno.setSenha("senha123");
            aluno.setRg("MG1234567");
            aluno.setSexo("M");
            aluno.setDataNasc(Date.valueOf("2000-01-01"));
            aluno.setCurso("Engenharia");
            aluno.setBolsista("N");
            aluno.setHistorico("Nenhum");


            AlunoDao alunoDao = new AlunoDao();
            alunoDao.inserir(aluno);

            System.out.println("Aluno inserido com sucesso! Código gerado: " + aluno.getCodigo());

        } catch (Exception e) {
            System.err.println("Erro ao inserir aluno: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
