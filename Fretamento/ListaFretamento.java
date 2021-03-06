package Fretamento;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
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
                boolean veiculoTransportePassageiro = veiculo instanceof TransportePassageiro;
                if(!veiculoTransportePassageiro){
                    System.out.println("Veículo informado não é Transporte de Passageiro. \nFavor digitar qualquer numero para retornar ao menu inicial.");
                    in.nextLine();
                    break;
                }
                System.out.println("Digite o cpf do condutor:");
                String cpf = in.nextLine();
                Funcionario funcionario = listaFuncionario.buscaFuncionario(cpf.hashCode());
                Motorista motorista = null;
                if(funcionario instanceof Motorista){
                    motorista = (Motorista) funcionario;
                }else {
                    System.out.println("Funcionário informado não é Motorista. \nFavor digitar qualquer numero para retornar ao menu inicial.");
                    in.nextLine();
                    break;
                }
                if(!motorista.temCursoTransportePassageiro()){
                    System.out.println("Motorista não possui curso para transporte de passageiro. \nFavor digitar qualquer numero para retornar ao menu inicial.");
                    in.nextLine();
                    break;
                } 
                condutor = motorista;
                System.out.println("Digite a quantidade de passageiros:");
                int numPassageiros = Integer.parseInt(in.nextLine());
                System.out.println("Digite a data de início:(ex: DD/MM/AAAA)");
                dataInicio = dataFormatt(in.nextLine());
                System.out.println("Digite a data do término:(ex: DD/MM/AAAA)");
                dataTermino = dataFormatt(in.nextLine());
                System.out.println("Digite a distancia em Km:(Ex: 22.7)");
                distancia = Double.parseDouble(in.nextLine());
                valorCobrado = getValorCobradoPassageiros(veiculo, dataInicio, dataTermino, distancia, numPassageiros);
                if(!validaCnhPassageiros(veiculo, numPassageiros, motorista)){
                    System.out.println("CNH não é válida para a operação. \nFavor digitar qualquer numero para retornar ao menu inicial.");
                    in.nextLine();
                    break;
                }
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
                if(!veiculoTransporteCarga){
                    System.out.println("Veiculo não é Transporte de Carga. \nFavor digitar qualquer numero para retornar ao menu inicial.");
                    in.nextLine();
                    break;
                } 
                System.out.println("Digite o cpf do condutor:");
                String cpf = in.nextLine();
                Funcionario funcionario = listaFuncionario.buscaFuncionario(cpf.hashCode());
                Motorista motorista = null;
                if(funcionario instanceof Motorista){
                    motorista = (Motorista) funcionario;
                }else {
                    System.out.println("Funcionário não é motorista. \nFavor digitar qualquer numero para retornar ao menu inicial.");
                    in.nextLine();
                    break;
                }
                if(!motorista.temCursoCargaPerigosa()){
                    System.out.println("Motorista não possui curso para transporte de carga perigosa. \nFavor digitar qualquer numero para retornar ao menu inicial.");
                    in.nextLine();
                    break;
                }
                condutor = motorista;
                System.out.println("Digite a data de início:(ex: DD/MM/AAAA)");
                dataInicio = dataFormatt(in.nextLine());
                System.out.println("Digite a data do término:(ex: DD/MM/AAAA)");
                dataTermino = dataFormatt(in.nextLine());
                System.out.println("Digite a distancia em Km:(Ex: 22.7)");
                distancia = Double.parseDouble(in.nextLine());
                System.out.println("Possui carga perigosa? \n1 - sim \n0 - não:");
                String resposta = in.nextLine();
                boolean possuiCargaPerigosa;
                if(resposta.equals("1")) possuiCargaPerigosa = true;
                    else if(resposta.equals("0")) possuiCargaPerigosa = false;
                            else {
                                System.out.println("Opção inválida. \nFavor digitar qualquer numero para retornar ao menu inicial.");
                                in.nextLine();
                                break;
                            }
                cargaPerigosa = possuiCargaPerigosa;
                valorCobrado = getValorCobradoCarga(cargaPerigosa, distancia, veiculo);
                if(!validaCnhCarga(veiculo, motorista)){
                    System.out.println("CNH não é válida para a operação. \nFavor digitar qualquer numero para retornar ao menu inicial.");
                    in.nextLine();
                    break;
                }
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
        Collections.sort(listaFretamento);
        return listaFretamento;
    }

    public double getValorCobradoPassageiros(Veiculo veiculo, LocalDate dataInicio, LocalDate dataTermino, double distancia, int numPassageiros){
        TransportePassageiro veiculoPassageiro = null;
        double valor = 0;
        double valorDiaria = 0;
        double valorKm = 0;
        double diasAlugados = ChronoUnit.DAYS.between(dataInicio, dataTermino);
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

    public boolean validaCnhPassageiros(Veiculo veiculo, int numPassageiros, Motorista motorista){
        switch(motorista.getCategoriaCnh()){
            case "B": {
                if(numPassageiros<=8 && veiculo.getPesoVeiculo()<=3500) return true;
                break;
            }
            case "C": {
                if(numPassageiros<=8) return true;
                break;
            }

            case "D": return true;

            case "E": return true;
        
            default: return false;
        }
        return false;
    }

    public boolean validaCnhCarga(Veiculo veiculo, Motorista motorista){
        TransporteCarga veiculoCarga = (TransporteCarga)veiculo;
        switch(motorista.getCategoriaCnh()){
            case "C": {
                if(veiculo.getPesoVeiculo()<=6000 && !veiculoCarga.temUnidAcoplado()) return true;
                break;
            }
            case "E": {
                return true;
            }
            default: return false;
        }
        return false;
    }


    public LocalDate dataFormatt(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimentoCnh = LocalDate.parse(data,formatter);
        return dataVencimentoCnh;
    }
    
}