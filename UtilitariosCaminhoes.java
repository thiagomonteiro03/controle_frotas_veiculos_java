import java.time.LocalDate;

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
    

    
}
