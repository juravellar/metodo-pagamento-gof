package builder;

import model.TipoPagamento;
import service.*;

import java.util.Map;
import java.util.function.Supplier;

public class TipoPagamentoFactory extends PagamentoFactory {
    private final Map<TipoPagamento, Supplier<MetodoPagamento>> registros;

    public TipoPagamentoFactory(Map<TipoPagamento, Supplier<MetodoPagamento>> registros) {
        this.registros = registros;
    }

    @Override
    public MetodoPagamento criarPagamento(TipoPagamento tipo) {
        Supplier<MetodoPagamento> supplier = registros.get(tipo);

        if (supplier == null) {
            throw new IllegalArgumentException("Tipo não suportado: " + tipo);
        }

        return supplier.get();
    }
}