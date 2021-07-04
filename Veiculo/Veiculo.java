package Veiculo;
public class Veiculo
{
   private String numeroPlaca;
   private String modeloVeiculo;
   private int anoFabricacao;
   private double pesoVeiculo;

   public Veiculo(String numeroPlaca, String modeloVeiculo, 
   int anoFabricacao, double pesoVeiculo)
   {
       this.numeroPlaca = numeroPlaca;
       this.modeloVeiculo = modeloVeiculo;
       this.anoFabricacao = anoFabricacao;
       this.pesoVeiculo = pesoVeiculo;
   }

public String getNumeroPlaca() {
    return numeroPlaca;
}

public void setNumeroPlaca(String numeroPlaca) {
    this.numeroPlaca = numeroPlaca;
}

public String getModeloVeiculo() {
    return modeloVeiculo;
}

public void setModeloVeiculo(String modeloVeiculo) {
    this.modeloVeiculo = modeloVeiculo;
}

public int getAnoFabricacao() {
    return anoFabricacao;
}

public void setAnoFabricacao(int anoFabricacao) {
    this.anoFabricacao = anoFabricacao;
}

public double getPesoVeiculo() {
    return pesoVeiculo;
}

public void setPesoVeiculo(double pesoVeiculo) {
    this.pesoVeiculo = pesoVeiculo;
}

@Override
public String toString() {
    return "Veiculo [anoFabricacao=" + anoFabricacao + ", modeloVeiculo=" + modeloVeiculo + ", numeroPlaca="
            + numeroPlaca + ", pesoVeiculo=" + pesoVeiculo + "]";
}

   
}