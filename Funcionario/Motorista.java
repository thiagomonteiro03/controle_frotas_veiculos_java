package Funcionario;

import java.time.LocalDate;

public class Motorista extends Funcionario {

    private boolean cargaPerigosa;
    private boolean transportePassageiro;

    public Motorista(String nome, LocalDate dataNascimento, String cpf, String numeroCnh, String categoriaCnh,
            LocalDate dataVencimentoCnh, boolean cargaPerigosa, boolean transportePassageiro) {
        super(nome, dataNascimento, cpf, numeroCnh, categoriaCnh, dataVencimentoCnh);
        this.cargaPerigosa = cargaPerigosa;
        this.transportePassageiro = transportePassageiro;
    }

    public boolean isCargaPerigosa() {
        return cargaPerigosa;
    }

    public void setCargaPerigosa(boolean cargaPerigosa) {
        this.cargaPerigosa = cargaPerigosa;
    }

    public boolean isTransportePassageiro() {
        return transportePassageiro;
    }

    public void setTransportePassageiro(boolean transportePassageiro) {
        this.transportePassageiro = transportePassageiro;
    }

    @Override
    public String toString() {
        return "Motorista [cargaPerigosa=" + cargaPerigosa + ", transportePassageiro=" + transportePassageiro + "]";
    }
    
}
