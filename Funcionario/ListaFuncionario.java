package Funcionario;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class ListaFuncionario {
    Scanner in = new Scanner(System.in);
    private List<Funcionario> funcionariosLista = new LinkedList<>();


    public void cadastraFuncionario(int tipoFuncionario){
        String nome;
        LocalDate dataNascimento;
        String cpf;
        String numeroCnh;   
        String categoriaCnh;
        LocalDate dataVencimentoCnh;
        
        switch(tipoFuncionario){
            case 1: {
                System.out.println("Digite o nome:");
                nome = in.nextLine();
                System.out.println("Digite a data de nascimento:");
                dataNascimento = dataFormatt(in.nextLine());
                System.out.println("Digite o cpf(apenas números):");
                cpf = in.nextLine();
                Funcionario admFuncionario = new Administrador(nome, dataNascimento, cpf);
                break;
            }
            case 2: {}
            case 3: {}
            default: System.out.println("Opção inválida.");
        }
        funcionariosLista.add(funcionario);
    }

    public LocalDate dataFormatt(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimentoCnh = LocalDate.parse(data,formatter);
        return dataVencimentoCnh;
    }
    
}