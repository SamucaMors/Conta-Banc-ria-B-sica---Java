import java.util.InputMismatchException;
import java.util.Scanner;

public class Conta {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int operation = 0;
        double valorParaReceber;
        double valorParaEnviar;
        char mostrarDados;
        String nome = "Wellington Moraes";
        String tipoDeConta = "Corrente";
        double saldo = 2500;

        System.out.println("""
                ****************************************************
                
                            Dados iniciais do cliente:
                            
                            Nome: %s
                            Tipo de conta: %s
                            Saldo inicial: %.2f
                            
                ****************************************************
                """.formatted(nome, tipoDeConta, saldo));

        while (operation != 4) {
            System.out.println("""
                            Operações
                            
                            1 - Consultar saldo
                            2 - Receber valor
                            3 - Transferir valor
                            4 - Sair
                            
                """);
            System.out.print("Digite a opção desejada: ");

            try {
                operation = read.nextInt(); // Lê a opção do usuário
                read.nextLine(); // Consumir nova linha

                switch (operation) {
                    case 1:
                        System.out.println("Seu saldo é de R$%.2f".formatted(saldo));
                        break;
                    case 2:
                        System.out.print("Informe o valor a receber: ");
                        valorParaReceber = read.nextDouble();
                        read.nextLine(); // Consumir nova linha

                        if (valorParaReceber > 0) {
                            saldo += valorParaReceber;
                            System.out.println("Valor recebido com sucesso!");
                        } else if (valorParaReceber == 0) {
                            System.out.println("Não é possível receber R$0,00");
                        } else {
                            System.out.println("Não é possível receber valores negativos");
                        }
                        break;
                    case 3:
                        System.out.print("Informe o valor para envio: ");
                        valorParaEnviar = read.nextDouble();
                        read.nextLine(); // Consumir nova linha

                        if (valorParaEnviar > 0 && valorParaEnviar <= saldo) {
                            saldo -= valorParaEnviar;
                            System.out.println("Valor transferido com sucesso!");
                        } else if (valorParaEnviar > saldo) {
                            System.out.println("Não é possível enviar um valor maior que o seu saldo!");
                        } else if (valorParaEnviar == 0) {
                            System.out.println("Não é possível enviar R$0,00");
                        } else {
                            System.out.println("Não é possível enviar um valor negativo");
                        }
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção do menu.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                read.nextLine(); // Limpa o buffer do scanner
            }
        }

        System.out.print("Você quer ver dados atualizados? ('s' para sim, 'n' para não): ");
        mostrarDados = read.next().charAt(0);

        switch (mostrarDados) {
            case 's':
                System.out.println("""
                ****************************************************
                
                            Dados atualizados do cliente:
                            
                            Nome: %s
                            Tipo de conta: %s
                            Saldo: %.2f
                            
                ****************************************************
                """.formatted(nome, tipoDeConta, saldo));
                break;
            case 'n':
                System.out.println("Ok. Tchau tchau!");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        read.close(); // Fecha o scanner ao final
    }
}
