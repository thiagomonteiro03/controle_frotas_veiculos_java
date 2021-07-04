package Fretamento;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Funcionario.Funcionario;
import Funcionario.ListaFuncionario;
import Funcionario.Motorista;
import Veiculo.ListaVeiculo;
import Veiculo.Veiculo;

import java.time.format.DateTimeFormatter;

public class ListaFretamento {
    Scanner in = new Scanner(System.in);
    private List<Fretamento> listaFretamento = new LinkedList<>();


    public void cadastraFretamento(int tipoFretamento, ListaVeiculo listaVeiculo, ListaFuncionario listaFuncionario){
        int idFretamento = 0;
        Veiculo veiculo;
        Motorista condutor;
        LocalDate dataInicio;
        LocalDate dataTermino;
        double distancia;
        double valorCobrado;
        boolean cargaPerigosa;
        
        switch(tipoFretamento){
            case 1: {
                System.out.println("Digite a placa do veículo do fretamento(sem hífen):");
                String placa = in.nextLine();
                veiculo = listaVeiculo.buscaVeiculo(placa.hashCode());
                System.out.println("Digite o cpf do condutor:");
                String cpf = in.nextLine();
                Funcionario funcionario = listaFuncionario.buscaFuncionario(cpf.hashCode());
                Motorista motorista = null;
                if(funcionario instanceof Motorista){
                    motorista = (Motorista) funcionario;
                }else break;
                condutor = motorista;
                System.out.println("Digite a data de início:");
                dataInicio = dataFormatt(in.nextLine());
                System.out.println("Digite a data do término:");
                dataTermino = dataFormatt(in.nextLine());
                System.out.println("Digite a distancia em Km:(Ex: 22.7)");
                distancia = Double.parseDouble(in.nextLine());
                System.out.println("Digite o valor cobrado:(Ex: 50.87)");
                valorCobrado = Double.parseDouble(in.nextLine());
                idFretamento++;
                Fretamento onibusVans = new OnibusVans(idFretamento, veiculo, condutor, dataInicio, dataTermino, distancia, valorCobrado);
                listaFretamento.add(onibusVans);
                System.out.println("Fretamento de Ônibus/Vans cadastrado com sucesso!");
                break;
            }
            case 2: {
                System.out.println("Digite a placa do veículo do fretamento(sem hífen):");
                String placa = in.nextLine();
                veiculo = listaVeiculo.buscaVeiculo(placa.hashCode());
                System.out.println("Digite o cpf do condutor:");
                String cpf = in.nextLine();
                Funcionario funcionario = listaFuncionario.buscaFuncionario(cpf.hashCode());
                Motorista motorista = null;
                if(funcionario instanceof Motorista){
                    motorista = (Motorista) funcionario;
                }else break;
                condutor = motorista;
                System.out.println("Digite a data de início:");
                dataInicio = dataFormatt(in.nextLine());
                System.out.println("Digite a data do término:");
                dataTermino = dataFormatt(in.nextLine());
                System.out.println("Digite a distancia em Km:(Ex: 22.7)");
                distancia = Double.parseDouble(in.nextLine());
                System.out.println("Digite o valor cobrado:(Ex: 50.87)");
                valorCobrado = Double.parseDouble(in.nextLine());
                System.out.println("Possui carga perigosa? \n1 - sim \n0 - não:");
                String resposta = in.nextLine();
                boolean possuiCargaPerigosa;
                if(resposta.equals("1")) possuiCargaPerigosa = true;
                    else if(resposta.equals("0")) possuiCargaPerigosa = false;
                            else break;
                cargaPerigosa = possuiCargaPerigosa;
                idFretamento++;
                Fretamento utilitarioCaminhoes = new UtilitariosCaminhoes(idFretamento, veiculo, condutor, dataInicio, dataTermino, distancia, valorCobrado, cargaPerigosa);
                listaFretamento.add(utilitarioCaminhoes);
                System.out.println("Fretamento de Utilitário/Caminhões cadastrado com sucesso!");
                break;
            }
            default: System.out.println("Opção inválida.");
        }
    }

    public List<Motorista> getMotoristasLivres(ListaFuncionario listaFuncionario){
        List<Motorista> lista = new LinkedList<>();
        for(Funcionario funcionario : listaFuncionario.getFuncionarios()){
            if(funcionario instanceof Motorista){
                Motorista motorista = (Motorista) funcionario;
                lista.add(motorista);
                if(getListaFretamento()!=null || getListaFretamento().isEmpty()){
                for(Fretamento fretamento : getListaFretamento()){
                    if( fretamento.getCondutor()==motorista) lista.remove(motorista);
                }
            }
            }
        }
        return lista;
    }

    public List<Veiculo> getVeiculoLivres(ListaVeiculo listaVeiculo){
        List<Veiculo> lista = new LinkedList<>();
        for(Veiculo veiculo : listaVeiculo.getVeiculos()){
            lista.add(veiculo);
                for(Fretamento fretamento: getListaFretamento()){
                    if(fretamento.getVeiculo().equals(veiculo)) lista.remove(veiculo);
                }
            }
        return lista;
    }

    public List<Fretamento> getListaFretamento() {
        return listaFretamento;
    }

    public List<Fretamento> getFretamentosMaisLucrativos (){
        List<Fretamento> maisLucrativos = new LinkedList<>();
        for(Fretamento fretamento : listaFretamento){
            maisLucrativos.add(fretamento);
            if(maisLucrativos.size()==5) return maisLucrativos;
        }
        return maisLucrativos;
    }

    public LocalDate dataFormatt(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimentoCnh = LocalDate.parse(data,formatter);
        return dataVencimentoCnh;
    }
    
}