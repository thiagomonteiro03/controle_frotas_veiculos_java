package Fretamento;
import java.time.LocalDate;

import Funcionario.Motorista;
import Veiculo.Veiculo;

public class UtilitariosCaminhoes extends Fretamento {

    private boolean cargaPerigosa;

    public UtilitariosCaminhoes(int idFretamento, Veiculo veiculo, Motorista condutor, LocalDate dataInicio,
            LocalDate dataTermino, double distancia, double valorCobrado, boolean cargaPerigosa) {
        super(idFretamento, veiculo, condutor, dataInicio, dataTermino, distancia, valorCobrado);
        this.cargaPerigosa = cargaPerigosa;
    }

    public boolean isCargaPerigosa() {
        return cargaPerigosa;
    }

    public void setCargaPerigosa(boolean cargaPerigosa) {
        this.cargaPerigosa = cargaPerigosa;
    }

    @Override
    public String toString() {
        return "UtilitariosCaminhoes [condutor=" + super.getCondutor() + ", dataInicio=" + super.getDataInicio() + ", dataTermino=" + super.getDataTermino()
        + ", distancia=" + super.getDistancia() + ", idFretamento=" + super.getIdFretamento() + ", valorCobrado=" + super.getValorCobrado()
        + ", veiculo=" + super.getVeiculo() + ", cargaPerigosa=" + cargaPerigosa + "]";
    }
    
}
