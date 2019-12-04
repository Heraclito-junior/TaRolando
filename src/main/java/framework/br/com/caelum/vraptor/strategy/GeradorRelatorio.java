package framework.br.com.caelum.vraptor.strategy;

import br.com.caelum.vraptor.observer.download.Download;
import framework.br.com.caelum.vraptor.model.EventoAjudando;

public interface GeradorRelatorio {
	
	Download GerarRelatorio(EventoAjudando eventoAjudando);

}
