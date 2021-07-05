package Funcionario;

import java.time.LocalDate;

public class Manobrista extends Funcionario {

    public Manobrista(String nome, LocalDate dataNascimento, String cpf, String numeroCnh, String categoriaCnh,
            LocalDate dataVencimentoCnh) {
        super(nome, dataNascimento, cpf, numeroCnh, categoriaCnh, dataVencimentoCnh);
    }

    @Override
    public String toString() {
        return "Manobrista [categoriaCnh=" + super.getCategoriaCnh() + ", cpf=" + super.getCpf() + ", dataNascimento=" + super.getCpf()
        + ", dataVencimentoCnh=" + super.getDataVencimentoCnh() + ", nome=" + super.getNome() + ", numeroCnh=" + super.getNumeroCnh() + "]";
    }
}
