import java.util.Arrays;

public class Pessoa {
    // Declara variáveis privadas
    private String nome;
    private TeleSena[] TeleSenas;
    private double premiacao;

    // Construtor
    public Pessoa(String nome, int numTeleSenas) {
        this.nome = nome;
        this.TeleSenas = new TeleSena[numTeleSenas];
        compraTeleSenas();
    }

    // Métodos de acesso
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TeleSena[] getTeleSenas() {
        return TeleSenas;
    }

    public void setTeleSenas(TeleSena[] teleSenas) {
        TeleSenas = teleSenas;
    }

    public double getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(double premiacao) {
        this.premiacao = premiacao;
    }

    // Compra as teleSenas da pessoa
    public void compraTeleSenas() {
        for(int i = 0; i < this.getTeleSenas().length; i++) {
            this.getTeleSenas()[i] = new TeleSena();
        }
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", TeleSenas=" + Arrays.toString(TeleSenas) +
                '}';
    }
}
