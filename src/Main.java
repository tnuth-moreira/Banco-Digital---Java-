public class Main {
  public static void main(String[] args) {
    Cliente thiago = new Cliente();
    thiago.setNome("Thiago");

    Banco banco = new Banco();
    Conta<Cliente> cc = new ContaCorrente(thiago);
    Conta<Cliente> poupanca = new ContaPoupanca(thiago);

    banco.adicionarConta(cc);
    banco.adicionarConta(poupanca);

    cc.depositar(100);
    poupanca.depositar(50);

    cc.transferir(30, poupanca);
    cc.verificarSaldo();
    poupanca.verificarSaldo();

    ((ContaPoupanca) poupanca).aplicarJuros();

    banco.listarContas();
    banco.atualizarCliente(thiago, "Thiago Moreira");
    banco.listarContas();
  }
}
