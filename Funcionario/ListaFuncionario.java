package Funcionario;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class ListaFuncionario {
    Scanner in = new Scanner(System.in);
    private List<Funcionario> listaFuncionario = new LinkedList<>();


    public void cadastraFuncionario(int tipoFuncionario){
        String nome;
        LocalDate dataNascimento;
        String cpf;
        String numeroCnh;   
        String categoriaCnh;
        LocalDate dataVencimentoCnh;
        boolean cargaPerigosa;
        boolean transportePassageiro;
        
        switch(tipoFuncionario){
            case 1: {
                System.out.println("Digite o nome:");
                nome = in.nextLine();
                System.out.println("Digite a data de nascimento (ex: 04/04/2004):");
                dataNascimento = dataFormatt(in.nextLine());
                System.out.println("Digite o cpf(apenas números):");
                cpf = in.nextLine();
                Funcionario admFuncionario = new Administrador(nome, dataNascimento, cpf);
                listaFuncionario.add(admFuncionario);
                System.out.println("Funcionário Administrador cadastrado com sucesso!");
                break;
            }
            case 2: {
                System.out.println("Digite o nome:");
                nome = in.nextLine();
                System.out.println("Digite a data de nascimento:");
                dataNascimento = dataFormatt(in.nextLine());
                System.out.println("Digite o cpf(apenas números):");
                cpf = in.nextLine();
                System.out.println("Digite o número da CNH:");
                numeroCnh = in.nextLine();
                System.out.println("Digite a Categoria da CNH:");
                categoriaCnh = in.nextLine();
                System.out.println("Digite a data de vencimento da CNH:");
                dataVencimentoCnh = dataFormatt(in.nextLine());
                Funcionario manobristaFuncionario = new Manobrista(nome, dataNascimento, cpf, numeroCnh, categoriaCnh, dataVencimentoCnh);
                listaFuncionario.add(manobristaFuncionario);
                System.out.println("Funcionário Manobrista cadastrado com sucesso!");
                break;
            }
            case 3: {
                System.out.println("Digite o nome:");
                nome = in.nextLine();
                System.out.println("Digite a data de nascimento:");
                dataNascimento = dataFormatt(in.nextLine());
                System.out.println("Digite o cpf(apenas números):");
                cpf = in.nextLine();
                System.out.println("Digite o número da CNH:");
                numeroCnh = in.nextLine();
                System.out.println("Digite a Categoria da CNH:");
                categoriaCnh = in.nextLine();
                System.out.println("Digite a data de vencimento da CNH:");
                dataVencimentoCnh = dataFormatt(in.nextLine());
                System.out.println("Possui curso para cargas perigosas? \n1 - sim \n0 - não:");
                String escolhaCarga = in.nextLine();
                boolean isCargaPerigosa;
                if(escolhaCarga.equals("1")) isCargaPerigosa = true;
                    else if(escolhaCarga.equals("0")) isCargaPerigosa = false;
                            else break;
                cargaPerigosa = isCargaPerigosa;
                System.out.println("Possui curso para transporte de passageiro? \n1 - sim \n0 - não:");
                String escolhaPassageiro = in.nextLine();
                boolean transportaPassageiro;
                if(escolhaPassageiro.equals("1")) transportaPassageiro = true;
                    else if(escolhaPassageiro.equals("0")) transportaPassageiro = false;
                            else break;
                transportePassageiro = transportaPassageiro;
                Funcionario motoristaFuncionario = new Motorista(nome, dataNascimento, cpf, numeroCnh, categoriaCnh, dataVencimentoCnh, cargaPerigosa, transportaPassageiro);
                listaFuncionario.add(motoristaFuncionario);
                System.out.println("Funcionário Motorista cadastrado com sucesso!");
                break;
            }
            default: System.out.println("Opção inválida.");
        }
    }

    public List<Funcionario> getFuncionarios(){
        Collections.sort(listaFuncionario);
        return listaFuncionario;
    }

    public Funcionario buscaFuncionario(int hashCodeCPF){
        for(Funcionario funcionario : listaFuncionario){
            if(funcionario.hashCode() == hashCodeCPF){
                System.out.println(funcionario.toString());
                return funcionario;
            }
        }
        return null;
    }

    public LocalDate dataFormatt(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimentoCnh = LocalDate.parse(data,formatter);
        return dataVencimentoCnh;
    }
    
}