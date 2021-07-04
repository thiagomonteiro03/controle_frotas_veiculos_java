import java.util.Scanner;
import Funcionario.ListaFuncionario;

public class Main {

    static Scanner in = new Scanner(System.in);
    static ListaFuncionario funcionariosLista = new ListaFuncionario();

    public static void main(String[] args){
        int opcao;
        do{
        System.out.println("Bem vindo ao TF Transportadora!\nDigite o numero da funcionalidade desejada:");
        System.out.println("Funcionários:\n1 - Cadastrar Funcionário\n2 - Listar funcionários em ordem alfabética\n3 - Buscar funcionário por CPF");
        System.out.println("Veículos:\n4 - Cadastrar veículo\n5 - Listar veículos em ordem de ano de fabricação\n6 - Buscar veículo por placa");
        System.out.println("Fretamentos:\n7 - Cadastrar fretamento de veículo\n8 - Listar motoristas livres\n9 - Listar veículos livres");
        System.out.println("10 - Listar histórico de fretamentos\n11 - Listar top 5 veículos mais lucrativos");
        System.out.println("99 - Para sair do programa.");
        opcao = in.nextInt();

        switch(opcao){
            case 1: {
                cadastraFuncionario();
                break;
            }
            case 2: {

            }
            case 3: {
                buscaFuncionario();
            }
            case 4: {}
            case 5: {}
            case 6: {}
            case 7: {}
            case 8: {}
            case 9: {}
            case 10: {}
            case 11: {}
            default:{
                opcao = 99;
                break;
            }

        }
    } while (opcao != 99);
        
        
    }

    public static void cadastraFuncionario(){
        System.out.println("Digite o tipo de funcionário de cadastro:");
        System.out.println("1 - Funcionário Administrativo.\n2 - Funcionário Manobrista\n3 - Funcionário Motorista");
        int tipoFuncionario = in.nextInt();
        funcionariosLista.cadastraFuncionario(tipoFuncionario);

    }

    public static void buscaFuncionario(){
        String lala = in.nextLine();
        System.out.println("Digite o CPF do funcionário desejado: (apenas numero)");
        String cpfFuncionario = in.nextLine();
        funcionariosLista.buscaFuncionario(cpfFuncionario.hashCode());

    }

}
