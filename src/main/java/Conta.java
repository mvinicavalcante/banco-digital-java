public class Conta implements iConta {

    protected Banco banco;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected static int AGENCIA_PADRAO = 1;
    protected static int SEQUENCIAL = 1;
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;

        this.cliente = cliente;

    }


    @Override
    public void sacar(double valor) {
        if(this.saldo >= valor){
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        }
        else System.out.println("Nao foi possivel sacar R$" + valor);
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0){
            this.saldo += valor;
            System.out.println("Deposito de R$" + valor + " realizado com sucesso!");
        }
        else System.out.println("Nao foi possivel depositar R$" + valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(this.saldo >= valor && this != contaDestino){
            this.saldo -=valor;
            contaDestino.saldo += valor;
            System.out.println("Transferencia de R$" + valor + " para " + contaDestino.cliente.getNome() + " realizado com sucesso!");
        }
        else System.out.println("Nao foi possivel transferir R$" + valor + " para a conta " + contaDestino.numero);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(" === EXTRATO DA SUA CONTA === ");
        this.imprimirInfosComuns();
    }

}
