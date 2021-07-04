package Fretamento;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

import Funcionario.Funcionario;
import Funcionario.ListaFuncionario;
import Funcionario.Motorista;
import Veiculo.ListaVeiculo;
import Veiculo.Veiculo;
import jdk.jshell.execution.Util;

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

    public List<Fretamento> getFretamentos(){
        Collections.sort(listaFretamento);
        return listaFretamento;
    }

    public Fretamento buscaFretamento(int hashCodeCPF){
        for(Fretamento fretamento : listaFretamento){
            if(fretamento.hashCode() == hashCodeCPF){
                System.out.println(fretamento.toString());
                return fretamento;
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