package Veiculo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class ListaVeiculo {
    Scanner in = new Scanner(System.in);
    private List<Veiculo> listaVeiculo = new LinkedList<>();


    public void cadastraVeiculo(int tipoVeiculo){
        String numeroPlaca;
        String modeloVeiculo;
        int anoFabricacao;
        int numeroEixo;
        int maxPassageiro;
        double pesoVeiculo;
        double capacidadeCarga;
        boolean unidAcoplada;
        
        switch(tipoVeiculo){
            case 1: {
                System.out.println("Digite a placa(sem aspas):");
                numeroPlaca = in.nextLine();
                System.out.println("Digite o modelo do veículo:");
                modeloVeiculo = in.nextLine();
                System.out.println("Digite o ano de fabricação:");
                anoFabricacao = Integer.parseInt(in.nextLine());
                System.out.println("Digite o peso do veículo(apenas números):");
                pesoVeiculo = Double.parseDouble(in.nextLine());
                Veiculo passeioUtilitario = new PasseioUtilitario(numeroPlaca, modeloVeiculo, anoFabricacao, pesoVeiculo);
                listaVeiculo.add(passeioUtilitario);
                System.out.println("Veículo de Passeio Utilitário cadastrado com sucesso!");
                break;
            }
            case 2: {
                System.out.println("Digite a placa(sem aspas):");
                numeroPlaca = in.nextLine();
                System.out.println("Digite o modelo do veículo:");
                modeloVeiculo = in.nextLine();
                System.out.println("Digite o ano de fabricação:");
                anoFabricacao = Integer.parseInt(in.nextLine());
                System.out.println("Digite o peso do veículo(ex: 10.5):");
                pesoVeiculo = Double.parseDouble(in.nextLine());
                System.out.println("Digite o número máximo de passageiros:");
                maxPassageiro = Integer.parseInt(in.nextLine());
                Veiculo transportePassageiro = new TransportePassageiro(numeroPlaca, modeloVeiculo, anoFabricacao, pesoVeiculo, maxPassageiro);
                listaVeiculo.add(transportePassageiro);
                System.out.println("Veículo de Transporte de Passageiro cadastrado com sucesso!");
                break;
            }
            case 3: {
                System.out.println("Digite a placa(sem aspas):");
                numeroPlaca = in.nextLine();
                System.out.println("Digite o modelo do veículo:");
                modeloVeiculo = in.nextLine();
                System.out.println("Digite o ano de fabricação:");
                anoFabricacao = Integer.parseInt(in.nextLine());
                System.out.println("Digite o peso do veículo(ex: 10.5):");
                pesoVeiculo = Double.parseDouble(in.nextLine());
                System.out.println("Digite a capacidade de carga em kilos(ex: 100.5):");
                capacidadeCarga = Double.parseDouble(in.nextLine());
                System.out.println("Digite o numero de eixos:");
                numeroEixo = Integer.parseInt(in.nextLine());
                System.out.println("Possui unidade acoplada? \n1 - sim \n0 - não:");
                String resposta = in.nextLine();
                boolean possuiUnidadeAcoplada;
                if(resposta.equals("1")) possuiUnidadeAcoplada = true;
                    else if(resposta.equals("0")) possuiUnidadeAcoplada = false;
                            else break;
                unidAcoplada = possuiUnidadeAcoplada;
                Veiculo transporteCarga = new TransporteCarga(numeroPlaca, modeloVeiculo, anoFabricacao, pesoVeiculo, capacidadeCarga, numeroEixo, unidAcoplada);
                listaVeiculo.add(transporteCarga);
                System.out.println("Veículo de Transporte de Carga cadastrado com sucesso!");
                break;
            }
            default: System.out.println("Opção inválida.");
        }
    }

    public List<Veiculo> getVeiculos(){
        Collections.sort(listaVeiculo);
        return listaVeiculo;
    }

    public Veiculo buscaVeiculo(int hashCodeCPF){
        for(Veiculo veiculo : listaVeiculo){
            if(veiculo.hashCode() == hashCodeCPF){
                System.out.println(veiculo.toString());
                return veiculo;
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