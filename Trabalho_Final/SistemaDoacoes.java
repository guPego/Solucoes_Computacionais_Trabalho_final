import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SistemaDoacoes {
    private static final String ARQUIVO_ALIMENTO = "doacoesAlimento.txt";
    private static final String ARQUIVO_DINHEIRO = "doacoesDinheiro.txt";
    private static final String ARQUIVO_ROUPA = "doacoesRoupa.txt";

    public void registrarDoacao(Doacao doacao) {
        String arquivo = null;
            
        switch (doacao.getTipo().toLowerCase()) {
            case "alimento":
                arquivo = ARQUIVO_ALIMENTO;
                break;
            case "dinheiro":
                arquivo = ARQUIVO_DINHEIRO;
                break;
            case "roupa":
                arquivo = ARQUIVO_ROUPA;
                break;
            default:
                System.out.println("Doação inválida.");
                break;
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write(doacao.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calcularTotalDoacoes(String tipoTotal) {
        String arquivo = null;

        switch (tipoTotal.toLowerCase()) {
            case "alimento":
                arquivo = ARQUIVO_ALIMENTO;
                break;
            case "dinheiro":
                arquivo = ARQUIVO_DINHEIRO;
                break;
            case "roupa":
                arquivo = ARQUIVO_ROUPA;
                break;
            default:
        }

        double total = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 2) {
                    try {
                        total += Double.parseDouble(partes[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao converter o valor da doação: " + partes[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total de doações para " + tipoTotal + ": " + total);
    }

    public void listaDoacoes(String tipoListaDoacao) {
        String arquivo = null;

        switch (tipoListaDoacao.toLowerCase()) {
            case "alimento":
                arquivo = ARQUIVO_ALIMENTO;
                break;
            case "dinheiro":
                arquivo = ARQUIVO_DINHEIRO;
                break;
            case "roupa":
                arquivo = ARQUIVO_ROUPA;
                break;
            default:
                System.out.println("Tipo de doação inválido.");
                return;
        }
    
        System.out.println("Listando doações do tipo: " + tipoListaDoacao);
    
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}

