package Funcionario;

import java.time.LocalDate;

public class Administrador extends Funcionario {

    public Administrador(String nome, LocalDate dataNascimento, String cpf) {
        super(nome, dataNascimento, cpf);
    }

    @Override
    public String toString() {
        return "Administrador [cpf=" + super.getCpf() + ", dataNascimento=" + super.getDataNascimento() + ", nome=" + super.getNome() + "]";
    }

}
