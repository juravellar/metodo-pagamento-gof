package service.impl;

import service.MetodoPagamento;

public class DinheiroPagamento  implements MetodoPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via DINHEIRO: R$ " + valor);
    }
}
