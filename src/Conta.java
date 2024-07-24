public abstract class Conta<T extends Cliente> implements IConta {

  private static final int AGENCIA_PADRAO = 7;
  private static int SEQUENCIAL = 1;

  protected int agencia;
  protected int numero;
  protected double saldo;
  protected T cliente;

  public Conta(T cliente) {
    this.agencia = Conta.AGENCIA_PADRAO;
    this.numero = SEQUENCIAL++;
    this.cliente = cliente;
  }

  public int getAgencia() {
    return agencia;
  }

  public int getNumero() {
    return numero;
  }

  public double getSaldo() {
    return saldo;
  }

  @Override
  public void sacar(double valor) {
    saldo -= valor;
  }

  @Override
  public void depositar(double valor) {
    saldo += valor;
  }

  @Override
  public void transferir(double valor, Conta<?> contaDestino) {
    if (valor <= saldo) {
      this.sacar(valor);
      contaDestino.depositar(valor);
    } else {
      System.out.println("Saldo insuficiente para a transferência.");
    }
  }

  public void verificarSaldo() {
    System.out.println(String.format("Saldo atual da conta %d: %.2f", this.numero, this.saldo));
  }

  protected void imprimirInfosComuns() {
    System.out.println(String.format("Titular: %s", this.cliente.getNome()));
    System.out.println(String.format("Agencia: %d", this.agencia));
    System.out.println(String.format("Numero: %d", this.numero));
    System.out.println(String.format("Saldo: %.2f", this.saldo));
  }
}
