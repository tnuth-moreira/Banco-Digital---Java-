import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Banco {
  private String nome;
  private List<Conta<?>> contas = new ArrayList<>();

  public void adicionarConta(Conta<?> conta) {
    contas.add(conta);
  }

  public void removerConta(Conta<?> conta) {
    contas.remove(conta);
  }

  public Conta<?> buscarConta(int numero) {
    return contas.stream()
        .filter(conta -> conta.getNumero() == numero)
        .findFirst()
        .orElse(null);
  }

  public void listarContas() {
    for (Conta<?> conta : contas) {
      conta.imprimirInfosComuns();
      System.out.println("------------");
    }
  }

  public void atualizarCliente(Cliente cliente, String novoNome) {
    cliente.setNome(novoNome);
  }
}
