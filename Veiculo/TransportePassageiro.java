package Veiculo;
public class TransportePassageiro extends Veiculo {

    private int maxPassageiro;

    public TransportePassageiro(String numeroPlaca, String modeloVeiculo, int anoFabricacao, double pesoVeiculo,
            int maxPassageiro) {
        super(numeroPlaca, modeloVeiculo, anoFabricacao, pesoVeiculo);
        this.maxPassageiro = maxPassageiro;
    }

    public int getMaxPassageiro() {
        return maxPassageiro;
    }

    public void setMaxPassageiro(int maxPassageiro) {
        this.maxPassageiro = maxPassageiro;
    }

    @Override
    public String toString() {
        return "TransportePassageiro [anoFabricacao=" + super.getAnoFabricacao() + ", modeloVeiculo=" + super.getModeloVeiculo() + ", numeroPlaca="
        + super.getNumeroPlaca() + ", pesoVeiculo=" + super.getPesoVeiculo() + "maxPassageiro=" + maxPassageiro + "]";
    }
    
}
