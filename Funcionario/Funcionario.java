package Funcionario;
import java.time.LocalDate;

public abstract class  Funcionario implements Comparable<Funcionario> {

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String numeroCnh;   
    private String categoriaCnh;
    private LocalDate dataVencimentoCnh;

    public Funcionario(String nome, LocalDate dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Funcionario(String nome, LocalDate dataNascimento, String cpf, String numeroCnh, String categoriaCnh,
            LocalDate dataVencimentoCnh) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.numeroCnh = numeroCnh;
        this.categoriaCnh = categoriaCnh;
        this.dataVencimentoCnh = dataVencimentoCnh;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroCnh() {
        return numeroCnh;
    }

    public void setNumeroCnh(String numeroCnh) {
        this.numeroCnh = numeroCnh;
    }

    public String getCategoriaCnh() {
        return categoriaCnh;
    }

    public void setCategoriaCnh(String categoriaCnh) {
        this.categoriaCnh = categoriaCnh;
    }

    public LocalDate getDataVencimentoCnh() {
        return dataVencimentoCnh;
    }

    public void setDataVencimentoCnh(LocalDate dataVencimentoCnh) {
        this.dataVencimentoCnh = dataVencimentoCnh;
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }

    @Override
    public int compareTo(Funcionario outro){
        return nome.compareTo(outro.getNome());
    }

    @Override
    public String toString() {
        return "Funcionario [categoriaCnh=" + categoriaCnh + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
                + ", dataVencimentoCnh=" + dataVencimentoCnh + ", nome=" + nome + ", numeroCnh=" + numeroCnh + "]";
    }
}
