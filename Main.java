import java.util.Scanner;

import Fretamento.Fretamento;
import Fretamento.ListaFretamento;
import Funcionario.Funcionario;
import Funcionario.ListaFuncionario;
import Funcionario.Motorista;
import Veiculo.ListaVeiculo;
import Veiculo.Veiculo;

public class Main {

    static Scanner in = new Scanner(System.in);
    static ListaFuncionario listaFuncionario = new ListaFuncionario();
    static ListaVeiculo listaVeiculo = new ListaVeiculo();
    static ListaFretamento listaFretamento = new ListaFretamento();

    public static void main(String[] args){
        int opcao;
        do{
        System.out.println("\n\n\nBem vindo ao TF Transportadora!\nDigite o numero da funcionalidade desejada:");
        System.out.println("Funcionários:\n1 - Cadastrar Funcionário\n2 - Listar funcionários em ordem alfabética\n3 - Buscar funcionário por CPF");
        System.out.println("Veículos:\n4 - Cadastrar veículo\n5 - Listar veículos em ordem de ano de fabricação\n6 - Buscar veículo por placa");
        System.out.println("Fretamentos:\n7 - Cadastrar fretamento de veículo\n8 - Listar motoristas livres\n9 - Listar veículos livres");
        System.out.println("10 - Listar histórico de fretamentos\n11 - Listar top 5 veículos mais lucrativos");
        System.out.println("99 - Para sair do programa.");
        opcao = Integer.parseInt(in.nextLine());

        switch(opcao){
            case 1: {
                cadastraFuncionario();
                break;
            }
            case 2: {
                listaFuncionarios();
                break;
            }
            case 3: {
                buscaFuncionario();
                break;
            }
            case 4: {
                cadastraVeiculo();
                break;
            }
            case 5: {
                listaVeiculos();
                break;
            }
            case 6: {
                buscaVeiculo();
                break;
            }
            case 7: {
                cadastraFretamento();
                break;
            }
            case 8: {
                listaMotoristasLivres();
                break;
            }
            case 9: {
                listaVeiculosLivres();
                break;
            }
            case 10: {
                listaHistoricoFretamento();
                break;
            }
            case 11: {
                listaFretamentosMaisLucrativos();
                break;
            }
            default:{
                opcao = 99;
                break;
            }

        }
    } while (opcao != 99);
        
        
    }

    // Métodos de Funcionário.

    public static void cadastraFuncionario(){
        System.out.println("Digite o tipo de funcionário de cadastro:");
        System.out.println("1 - Funcionário Administrativo.\n2 - Funcionário Manobrista\n3 - Funcionário Motorista");
        int tipoFuncionario = Integer.parseInt(in.nextLine());
        listaFuncionario.cadastraFuncionario(tipoFuncionario);

    }

    public static void listaFuncionarios(){
        for(Funcionario funcionario: listaFuncionario.getFuncionarios()){
            System.out.println(funcionario.toString());
        }
    }

    public static void buscaFuncionario(){
        System.out.println("Digite o CPF do funcionário desejado: (apenas numero)");
        String cpfFuncionario = in.nextLine();
        listaFuncionario.buscaFuncionario(cpfFuncionario.hashCode());

    }

    // Métodos de Veículo.

    public static void cadastraVeiculo(){
        System.out.println("Digite o tipo de veículo de cadastro:");
        System.out.println("1 - Passeio Utilitário.\n2 - Transporte de Passageiro\n3 - Transporte de Carga");
        int tipoVeiculo = Integer.parseInt(in.nextLine());
        listaVeiculo.cadastraVeiculo(tipoVeiculo);

    }

    public static void listaVeiculos(){
        for(Veiculo veiculo: listaVeiculo.getVeiculos()){
            System.out.println(veiculo.toString());
        }
    }

    public static void buscaVeiculo(){
        System.out.println("Digite a placa do veículo desejado:");
        String placaVeiculo = in.nextLine();
        listaVeiculo.buscaVeiculo(placaVeiculo.hashCode());

    }

    // Métodos de Fretamento.

    public static void cadastraFretamento(){
        System.out.println("Digite o tipo de fretamento de veiculo:");
        System.out.println("1 - Onibus/vans.\n2 - Utilitários/caminhões");
        int tipoFretamento = Integer.parseInt(in.nextLine());
        listaFretamento.cadastraFretamento(tipoFretamento, listaVeiculo, listaFuncionario);

    }

    public static void listaMotoristasLivres(){
        for(Motorista motorista: listaFretamento.getMotoristasLivres(listaFuncionario)){
            System.out.println(motorista.toString());
        }
    }

    public static void listaVeiculosLivres(){
        for(Veiculo veiculo: listaFretamento.getVeiculoLivres(listaVeiculo)){
            System.out.println(veiculo.toString());
        }
    }

    public static void listaHistoricoFretamento(){
        for(Fretamento fretamento: listaFretamento.getListaFretamento()){
            System.out.println(fretamento.toString());
        }
    }

    public static void listaFretamentosMaisLucrativos(){
        for(Fretamento fretamento: listaFretamento.getFretamentosMaisLucrativos()){
            System.out.println(fretamento.toString());
        }
    }

}
