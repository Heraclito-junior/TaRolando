package framework.negocio;

import br.com.caelum.vraptor.model.Relatorio;

public interface IRelatorioNegocio<T extends Relatorio> {

    T gerarRelatorio(Long id);
}
