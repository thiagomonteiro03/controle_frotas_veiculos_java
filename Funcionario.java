import java.io.IOException;
import java.time.LocalDate;

interface  Funcionario {

    private String nome;
    private LocalDate dataNascimento;
    private String numeroCnh;
    private LocalDate dataVencimentoCnh;

    public  Funcionario () throws IOException{
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroCnh = numeroCnh;
        this.dataVencimentoCnh = dataVencimentoCnh;
    }
    
}
