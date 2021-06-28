import java.time.LocalDate;

public class OnibusVans extends Fretamento {

    public OnibusVans(int idFretamento, Veiculo veiculo, Motorista condutor, LocalDate dataInicio,
            LocalDate dataTermino, double distancia, double valorCobrado) {
        super(idFretamento, veiculo, condutor, dataInicio, dataTermino, distancia, valorCobrado);
    }

}
