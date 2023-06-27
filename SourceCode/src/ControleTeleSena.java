import java.text.DecimalFormat;

/*
 nome: Martin Gabriel Haas
 autor: https://github.com/MartinGHaas
 */

public class ControleTeleSena {
    public int quantidadePessoas = 20; // Declara a quantidade padrão de pessoas

    // Declara variáveis privadas
    private Pessoa[] compradores = new Pessoa[quantidadePessoas];
    private String[] ganhadores = new String[quantidadePessoas];
    private int[] numerosSorteados = new int[60];

    // Construtor
    public ControleTeleSena() {
        criaCompradores();
        sorteio();
    }

    // Métodos de Acesso
    public Pessoa[] getCompradores() {
        return compradores;
    }

    public void setCompradores(Pessoa[] compradores) {
        this.compradores = compradores;
    }

    public int[] getNumerosSorteados() {
        return numerosSorteados;
    }

    public void setNumerosSorteados(int[] numerosSorteados) {
        this.numerosSorteados = numerosSorteados;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public String[] getGanhadores() {
        return ganhadores;
    }

    public void setGanhadores(String[] ganhadores) {
        this.ganhadores = ganhadores;
    }

    // Cria os compradores para a TeleSena
    public void criaCompradores() {
        for (int i = 0; i < compradores.length; i++) {
            int num = (int) (Math.random() * 15 + 1);
            compradores[i] = new Pessoa("Comprador " + i, num);
        }
    }

    // Realiza o sorteio dos números
    public void sorteio() {

        for(int i = 0; i < 25; i++) {
            sorteiaNum(numerosSorteados, 60);
        }

        while(!temGanhador()) {
            sorteiaNum(numerosSorteados, 60);
        }
    }

    // Checa se há ganhadores na teleSena
    public boolean temGanhador() {
        boolean vencedor = false;

        for(int i = 0; i < compradores.length; i++) {
            for(int k = 0; k < compradores[i].getTeleSenas().length; k++) {
                int pontos1 = 0;
                int pontos2 = 0;

                for(int j = 0; j < numerosSorteados.length; j++){
                    if(ArrayHelp.taNaLista(compradores[i].getTeleSenas()[k].getCartela1(), numerosSorteados[j])) {
                        pontos1++;
                    }
                    if(ArrayHelp.taNaLista(compradores[i].getTeleSenas()[k].getCartela2(), numerosSorteados[j])) {
                        pontos2++;
                    }
                }
                if(pontos1 == 25 || pontos2 == 25 && !ArrayHelp.taNaLista(ganhadores, compradores[i].getNome())) {
                    vencedor = true;
                    ArrayHelp.preencheNoVazio(ganhadores, compradores[i].getNome());
                }
            }
        }

        return vencedor;
    }

    // Retorna o premio/ganhador
    public double premioGanhadores() {
        return valorPremio() / qtdGanhadores();
    }

    // Retorna a quantidade de TeleSenas vendidas
    public int totalTeleSenas() {
        int qtdTeleSenas = 0;
        for(int i = 0; i < compradores.length; i++) {
            qtdTeleSenas += compradores[i].getTeleSenas().length;
        }
        return qtdTeleSenas;
    }

    // Retorna o total
    public int totalArrecadado() {
        return totalTeleSenas() * TeleSena.preco;
    }

    // Retorna o premio
    public double valorPremio() {
        return totalArrecadado() * 0.8;
    }

    // Retorna o lucro
    public double valorLucro() {
        return totalArrecadado() * 0.2;
    }

    // Retorna a quantidade de ganhadores
    public int qtdGanhadores() {
        int qtdGanhadores = 0;
        for(int i = 0;i < ganhadores.length; i++) {
            if(ganhadores[i] != null) {
                qtdGanhadores++;
            }
        }
        return qtdGanhadores;
    }

    public String financeiro() {
        return "\t[SETOR FINANCEIRO]" + "\n" +
                "TeleSenas vendidas: " + totalTeleSenas() + "\n" +
                "Total Arrecadado: " + totalArrecadado() + "\n" +
                "Prêmio Total: " + valorPremio() + "\n" +
                "Premio por Ganhador: " + toFixed(premioGanhadores(), 1) + "\n" +
                "Lucro do Sílvio: " + valorLucro();

    }

    // sorteia os numeros
    public void sorteiaNum(int[] arr, int numMax) {
        int sorteado = (int) (Math.random() * numMax + 1);
        while(ArrayHelp.taNaLista(arr, sorteado)) {
            sorteado = (int) (Math.random() * numMax) + 1;
        }
        ArrayHelp.preencheNoVazio(arr, sorteado);
    }

    // Formata um double para as casas decimais desejadas
    public String toFixed(double num, int numeroDecimal) {
        String padrao = "0.";
        for(int i = 0; i < numeroDecimal; i++) {
            padrao += "0";
        }
        DecimalFormat formatacao = new DecimalFormat(padrao);
        String numFormatado = formatacao.format(num);
        numFormatado = numFormatado.replace(",", ".");

        return numFormatado;
    }

    // sim, dava pra simplificar :/
}
