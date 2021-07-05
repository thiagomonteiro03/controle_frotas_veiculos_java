package Veiculo;
public class PasseioUtilitario extends Veiculo {

    public PasseioUtilitario(String numeroPlaca, String modeloVeiculo, int anoFabricacao, double pesoVeiculo) {
        super(numeroPlaca, modeloVeiculo, anoFabricacao, pesoVeiculo);
    }

    @Override
    public String toString() {
        return "PasseioUtilitario [anoFabricacao=" + super.getAnoFabricacao() + ", modeloVeiculo=" + super.getModeloVeiculo() + ", numeroPlaca="
        + super.getNumeroPlaca() + ", pesoVeiculo=" + super.getPesoVeiculo() + "]";
    }
    
}
