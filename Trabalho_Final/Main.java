// Classe Main
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaDoacoes sistema = new SistemaDoacoes();

        while (true) {
            System.out.println("\n1. Registrar doação");
            System.out.println("2. Calcular total de doações");
            System.out.println("3. Listar doações");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha e não pular o proximo nextLine()

            switch (opcao) {
                case 1:
                    limparTela();
                    System.out.println("REGISTRANDO DOAÇÃO");
                    System.out.print("Digite o tipo de doação (dinheiro | roupa | alimento): ");
                    String tipo = scanner.nextLine();

                    System.out.print("Digite a quantidade: ");
                    double quantidade = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha e não pular o proximo nextLine()
                    
                    System.out.print("Digite a data (dd/MM/yyyy): ");
                    String data = scanner.nextLine();

                    Doacao doacao = new Doacao(tipo, quantidade, data);
                    sistema.registrarDoacao(doacao);
                    System.out.println("Doação registrada com sucesso!");
                    break;
                
                case 2:
                    limparTela();
                    System.out.print("Qual o tipo de doação que deseja verificar o total (dinheiro | roupa | alimento): ");
                    String tipoTotal = scanner.nextLine();

                    sistema.calcularTotalDoacoes(tipoTotal);
                    break;
                
                case 3:
                    limparTela();
                    System.out.print("Qual o tipo de doação que deseja listar (dinheiro | roupa | alimento): ");
                    String tipoListaDoacao = scanner.nextLine();
                    sistema.listaDoacoes(tipoListaDoacao);
                    break;
                
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }    
}
