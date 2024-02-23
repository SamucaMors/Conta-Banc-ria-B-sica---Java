import java.util.Scanner;

public class Conta {
    public static void main(String[] args) {
        Scanner read = new Scanner (System.in);
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

        int operation = 0;
        double valorParaReceber;
        double valorParaEnviar;
        char mostrarDados;


        while (operation!=4){
            System.out.println("""
                Operações
                
                1 - Consultar saldo
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                """);
            System.out.print("Digite a opção desejada: ");
            operation = read.nextInt();

            switch (operation){
                case 1:
                    System.out.println();
                    System.out.println("Seu saldo é de %.2f".formatted(saldo));
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Informe o valor a receber: ");
                    valorParaReceber = read.nextDouble();
                    if (valorParaReceber > 0){
                        saldo += valorParaReceber;
                    }else if(valorParaReceber == 0){
                        System.out.println("Não é possível receber R$0,00");
                    }else {
                        System.out.println("Não é possível receber valores negativos");
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Informe o valor para envio: ");
                    valorParaEnviar = read.nextDouble();
                    if (valorParaEnviar > 0 && valorParaEnviar <= saldo){
                        saldo -= valorParaEnviar;
                    }else if(valorParaEnviar > saldo){
                        System.out.println("Não é possível enviar uma valor maior que o seu saldo!");
                    }else if(valorParaEnviar == 0){
                        System.out.println("Não é possível enviar R$0,00");
                    }
                    else{
                        System.out.println("Não é possível enviar um valor negativo");
                    }
                    break;
            }
        }


        System.out.println("Você quer ver dados atualizados?");
        System.out.println("'s' - para sim. 'n' para não.");
        mostrarDados = read.next().charAt(0);
        switch (mostrarDados){
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
        }

    }
}
