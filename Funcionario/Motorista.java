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

    public boolean temCursoCargaPerigosa() {
        return cargaPerigosa;
    }

    public void setCargaPerigosa(boolean cargaPerigosa) {
        this.cargaPerigosa = cargaPerigosa;
    }

    public boolean temCursoTransportePassageiro() {
        return transportePassageiro;
    }

    public void setTransportePassageiro(boolean transportePassageiro) {
        this.transportePassageiro = transportePassageiro;
    }

    @Override
    public String toString() {
        return "Motorista [categoriaCnh=" + super.getCategoriaCnh() + ", cpf=" + super.getCpf() + ", dataNascimento=" + super.getCpf()
        + ", dataVencimentoCnh=" + super.getDataVencimentoCnh() + ", nome=" + super.getNome() + ", numeroCnh=" + super.getNumeroCnh() +
         "cargaPerigosa=" + cargaPerigosa + ", transportePassageiro=" + transportePassageiro + "]";
    }
    
}
