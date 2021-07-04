package Funcionario;

import java.time.LocalDate;

public class Manobrista extends Funcionario {

    public Manobrista(String nome, LocalDate dataNascimento, String cpf, String numeroCnh, String categoriaCnh,
            LocalDate dataVencimentoCnh) {
        super(nome, dataNascimento, cpf, numeroCnh, categoriaCnh, dataVencimentoCnh);
    }
    
}
