package builder;

import model.TipoPagamento;
import service.MetodoPagamento;

public abstract class PagamentoFactory {

    public abstract MetodoPagamento criarPagamento(TipoPagamento tipo);

    public void processarPagamento(TipoPagamento tipo, double valor) {
        MetodoPagamento pagamento = criarPagamento(tipo);
        pagamento.pagar(valor);
    }
}
