package Veiculo;
public class TransporteCarga extends Veiculo {

    private double capacidadeCarga;
    private int numeroEixo;
    private boolean unidAcoplado;
    
    public TransporteCarga(String numeroPlaca, String modeloVeiculo, int anoFabricacao, double pesoVeiculo,
            double capacidadeCarga, int numeroEixo, boolean unidAcoplado) {
        super(numeroPlaca, modeloVeiculo, anoFabricacao, pesoVeiculo);
        this.capacidadeCarga = capacidadeCarga;
        this.numeroEixo = numeroEixo;
        this.unidAcoplado = unidAcoplado;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getNumeroEixo() {
        return numeroEixo;
    }

    public void setNumeroEixo(int numeroEixo) {
        this.numeroEixo = numeroEixo;
    }

    public boolean temUnidAcoplado() {
        return unidAcoplado;
    }

    public void setUnidAcoplado(boolean unidAcoplado) {
        this.unidAcoplado = unidAcoplado;
    }

    @Override
    public String toString() {
        return super.toString() + "TransporteCarga [capacidadeCarga=" + capacidadeCarga + ", numeroEixo=" + numeroEixo + ", unidAcoplado="
                + unidAcoplado + "]";
    }

    
    
}
