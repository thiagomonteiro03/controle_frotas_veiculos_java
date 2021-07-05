package Fretamento;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Funcionario.Funcionario;
import Funcionario.ListaFuncionario;
import Funcionario.Motorista;
import Veiculo.ListaVeiculo;
import Veiculo.TransporteCarga;
import Veiculo.TransportePassageiro;
import Veiculo.Veiculo;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
                boolean veiculoTransporteCarga = veiculo instanceof TransportePassageiro;
                if(!veiculoTransporteCarga) break;
                System.out.println("Digite o cpf do condutor:");
                String cpf = in.nextLine();
                Funcionario funcionario = listaFuncionario.buscaFuncionario(cpf.hashCode());
                Motorista motorista = null;
                if(funcionario instanceof Motorista){
                    motorista = (Motorista) funcionario;
                }else break;
                if(!motorista.temCursoTransportePassageiro()) break;
                condutor = motorista;
                System.out.println("Digite a quantidade de passageiros:");
                int numPassageiros = Integer.parseInt(in.nextLine());
                System.out.println("Digite a data de início:");
                dataInicio = dataFormatt(in.nextLine());
                System.out.println("Digite a data do término:");
                dataTermino = dataFormatt(in.nextLine());
                System.out.println("Digite a distancia em Km:(Ex: 22.7)");
                distancia = Double.parseDouble(in.nextLine());
                valorCobrado = getValorCobradoPassageiros(veiculo, dataInicio, dataTermino, distancia, numPassageiros);
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
                boolean veiculoTransporteCarga = veiculo instanceof TransporteCarga;
                if(!veiculoTransporteCarga) break;
                System.out.println("Digite o cpf do condutor:");
                String cpf = in.nextLine();
                Funcionario funcionario = listaFuncionario.buscaFuncionario(cpf.hashCode());
                Motorista motorista = null;
                if(funcionario instanceof Motorista){
                    motorista = (Motorista) funcionario;
                }else break;
                if(!motorista.temCursoCargaPerigosa()) break;
                condutor = motorista;
                System.out.println("Digite a data de início:");
                dataInicio = dataFormatt(in.nextLine());
                System.out.println("Digite a data do término:");
                dataTermino = dataFormatt(in.nextLine());
                System.out.println("Digite a distancia em Km:(Ex: 22.7)");
                distancia = Double.parseDouble(in.nextLine());
                System.out.println("Possui carga perigosa? \n1 - sim \n0 - não:");
                String resposta = in.nextLine();
                boolean possuiCargaPerigosa;
                if(resposta.equals("1")) possuiCargaPerigosa = true;
                    else if(resposta.equals("0")) possuiCargaPerigosa = false;
                            else break;
                cargaPerigosa = possuiCargaPerigosa;
                valorCobrado = getValorCobradoCarga(cargaPerigosa, distancia, veiculo);
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

    public double getValorCobradoPassageiros(Veiculo veiculo, LocalDate dataInicio, LocalDate dataTermino, double distancia, int numPassageiros){
        TransportePassageiro veiculoPassageiro = null;
        double valor = 0;
        double valorDiaria = 0;
        double valorKm = 0;
        double diasAlugados = ChronoUnit.DAYS.between(dataTermino, dataInicio);
        if(veiculo instanceof TransportePassageiro){
            veiculoPassageiro = (TransportePassageiro)veiculo;
        } else return 0;
        if(diasAlugados==0) diasAlugados = 1;
        if(diasAlugados<0) return 0;

        if(numPassageiros<=15){
            valorDiaria = 410;
            valorKm = 2.2;
            }else if(numPassageiros<=26){
                    valorDiaria = 490;
                    valorKm = 2.8;
                    }else if(numPassageiros>26){
                        valorDiaria = 560;
                        valorKm = 3;
                    }
        if(numPassageiros > veiculoPassageiro.getMaxPassageiro()) return 0;
        valor = (valorDiaria * diasAlugados) + (valorKm * distancia) ;
            
        return valor;
    }

    public double getValorCobradoCarga(boolean cargaPerigosa, double distancia, Veiculo veiculo){
        TransporteCarga veiculoCarga;
        double valor = 0;
        double valorKm = cargaPerigosa? 1.5: 1.2;
        if(veiculo instanceof TransporteCarga){
            veiculoCarga = (TransporteCarga)veiculo;
        } else return 0;
        int numeroEixo = veiculoCarga.getNumeroEixo();
        valor = valorKm * numeroEixo * distancia;
            
        return valor;
    }

    public LocalDate dataFormatt(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimentoCnh = LocalDate.parse(data,formatter);
        return dataVencimentoCnh;
    }
    
}