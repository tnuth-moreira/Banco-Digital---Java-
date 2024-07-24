public class ContaPoupanca extends Conta<Cliente> {

  private static final double JUROS = 0.02; // Exemplo: 2% ao mês

  public ContaPoupanca(Cliente cliente) {
    super(cliente);
  }

  @Override
  public void depositar(double valor) {
    super.depositar(valor);
  }

  public void aplicarJuros() {
    double juros = saldo * JUROS;
    saldo += juros;
    System.out.println(String.format("Juros de %.2f aplicados. Novo saldo: %.2f", juros, saldo));
  }

  @Override
  public void imprimirExtrato() {
    System.err.println("=== Extrato Conta Poupança ===");
    super.imprimirInfosComuns();
  }
}
