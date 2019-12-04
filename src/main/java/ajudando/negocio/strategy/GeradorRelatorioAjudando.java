package ajudando.negocio.strategy;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import ajudando.dao.ConviteAjudandoDAO;
import ajudando.dao.EventoAjudandoDAO;
import ajudando.dao.EventoAjudandoJpaDao;
import br.com.caelum.vraptor.jasperreports.Report;
import br.com.caelum.vraptor.jasperreports.download.ReportDownload;
import br.com.caelum.vraptor.jasperreports.formats.ExportFormats;
import br.com.caelum.vraptor.observer.download.Download;
import framework.br.com.caelum.vraptor.model.*;
import framework.br.com.caelum.vraptor.strategy.GeradorRelatorio;
import framework.br.com.caelum.vraptor.util.EntidadeReport;

import java.util.ArrayList;
import java.util.List;

public class GeradorRelatorioAjudando  implements GeradorRelatorio{
	
	@Inject
	private EventoAjudandoDAO dao;

	@Inject
	ConviteAjudandoDAO conviteDao;

	private ServletContext context;

	private List<Convite> convites;

	public GeradorRelatorioAjudando() {

	}

	public Download GerarRelatorio(EventoAjudando evento) {
		System.out.println("2");
//		System.out.println(dao.buscarPorId((long) 1).getTitulo());

		Double totalDoacoesEfetivadas = 0.0;
		Double totalDoacoesNaoEfetivadas = 0.0;
		int totalVoluntariosPresentes = 0;
		int totalVoluntariosAusentes = 0;
		int totalVoluntariosConfirmados = 0;
		int totalVoluntariosNaoConfirmados = 0;

		Relatorio relatorio = new Relatorio();
		List<ConviteAjudando> convites = conviteDao.convitesPorEvento(evento.getId());

		for (ConviteAjudando c : convites) {
			if (c.getParticipou()) {
				totalDoacoesEfetivadas += c.getValor();
				totalVoluntariosPresentes++;
			} else {
				totalDoacoesNaoEfetivadas += c.getValor();
				totalVoluntariosAusentes++;
			}

			if (c.isAceito()) {
				totalVoluntariosConfirmados++;
			} else {
				totalVoluntariosNaoConfirmados++;
			}
		}

		relatorio.setTitulo(evento.getTitulo());
		relatorio.setDataFim(evento.getDataFim());
		relatorio.setDataInicio(evento.getDataInicio());
		relatorio.setDescricao(evento.getDescricao());
		relatorio.setHoraFim(evento.getHoraFim());
		relatorio.setHoraInicio(evento.getHoraInicio());
		relatorio.setValorEsperado(totalDoacoesEfetivadas + totalDoacoesNaoEfetivadas);
		relatorio.setValorArrecadado(totalDoacoesEfetivadas);
		relatorio.setNumParticipantesPresentes(totalVoluntariosPresentes);
		relatorio.setNumParticipantesConfirmados(totalVoluntariosConfirmados);
		relatorio.setNumTotalVolutarios(convites.size());

		return gerarPDF(relatorio);
	}

	private Download gerarPDF(Relatorio relatorio) {
		Report report;
		ReportDownload download;

		List<Relatorio> relatorios = new ArrayList<>();
		relatorios.add(relatorio);

		report = new EntidadeReport<Relatorio>(relatorios, "relatorioTaAjudando.jasper", context);
		download = new ReportDownload(report, ExportFormats.pdf(), false);
		return download;
	}
}
