package Fretamento;
import java.time.LocalDate;

import Funcionario.Motorista;
import Veiculo.Veiculo;

public class Fretamento implements Comparable<Fretamento>{

    private int idFretamento;
    private Veiculo veiculo;
    private Motorista condutor;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double distancia;
    private double valorCobrado;

    public Fretamento(int idFretamento, Veiculo veiculo, Motorista condutor, LocalDate dataInicio,
            LocalDate dataTermino, double distancia, double valorCobrado) {
        this.idFretamento = idFretamento;
        this.veiculo = veiculo;
        this.condutor = condutor;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.distancia = distancia;
        this.valorCobrado = valorCobrado;
    }

    public int getIdFretamento() {
        return idFretamento;
    }

    public void setIdFretamento(int idFretamento) {
        this.idFretamento = idFretamento;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getCondutor() {
        return condutor;
    }

    public void setCondutor(Motorista condutor) {
        this.condutor = condutor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    @Override
    public int compareTo(Fretamento outro) {
        if (this.valorCobrado > outro.getValorCobrado()) { 
            return -1; 
            } if (this.valorCobrado < outro.getValorCobrado()) { 
            return 1; 
            } 
            return 0;
    }

    @Override
    public String toString() {
        return "Fretamento [condutor=" + condutor + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino
                + ", distancia=" + distancia + ", idFretamento=" + idFretamento + ", valorCobrado=" + valorCobrado
                + ", veiculo=" + veiculo + "]";
    }

    
}
