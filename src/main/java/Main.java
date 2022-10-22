import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banco bancoMV = new Banco("Banco MV");

        Scanner scan = new Scanner(System.in);

        String nomeCliente;
        String cpfCliente;
        Integer idadeCliente;

        boolean loop = true;

        int registerOrLogin;
        int operacaoDesejada;

        boolean logado = false;

        while(loop) {
            System.out.println(" === Ola! Crie sua conta: ===");
            //Área para fazer cadastro
            System.out.println("Digite seu nome: ");
            nomeCliente = scan.next();
            System.out.println("Digite seu CPF: ");
            cpfCliente = scan.next();
            System.out.println("Digite sua idade: ");
            idadeCliente = scan.nextInt();

            Cliente cliente = new Cliente(nomeCliente, cpfCliente, idadeCliente);
            Conta contaCliente = new Conta(cliente);
            bancoMV.contas.add(contaCliente);

            logado = true;

            while (logado) {

                System.out.println(" === Qual o digito da operacao que deseja realizar? === ");
                System.out.println(" 1 - Sacar \n 2 - Depositar \n 3 - Transferir \n 4 - Imprimir extrato \n 5 - Sair");
                operacaoDesejada = scan.nextInt();

                switch (operacaoDesejada) {
                    case 1:
                        try {
                            System.out.println("Digite o valor que deseja sacar: ");
                            double valorSacar = scan.nextInt();
                            contaCliente.sacar(valorSacar);
                        } catch (Exception e) {
                            System.out.println("Valor nao aceito. Consulte o saldo ou certifique a escrita do valor.");
                        }
                        break;

                    case 2:
                        try {
                            System.out.println("Digite o valor que deseja depositar: ");
                            double valorDepositar = scan.nextInt();
                            contaCliente.depositar(valorDepositar);
                        } catch (Exception e) {
                            System.out.println("Valor nao aceito. Certifique que esta digitando o valor corretamente.");
                        }
                        break;

                    case 3:
                        try {
                            System.out.println("Digite o numero da conta para onde ira transferir: ");

                            int numeroContaDestino = scan.nextInt();

                            //lógica inicial para transferência

                        /*for (Conta contaDestino : bancoMV.contas ) {
                            if(contaDestino.numero == numeroContaDestino) {
                               System.out.println("Digite o valor que deseja transferir: ");
                                double valorTransferir = scan.nextInt();
                                contaCliente.transferir(valorTransferir, contaDestino);
                            }
                            else System.out.println("Conta nao encontrada.");
                          }
                        */
                        } catch (Exception e) {
                            System.out.println("Valor nao aceito. Certifique que a conta destino existe e o valor que esta querendo enviar.");
                        }
                        break;

                    case 4:
                        contaCliente.imprimirExtrato();
                        break;

                    case 5:
                        logado = false;
                        break;
                }
            }
        }
    }
}
