package casamento.negocio.strategy;

import br.com.caelum.vraptor.jasperreports.Report;
import br.com.caelum.vraptor.jasperreports.download.ReportDownload;
import br.com.caelum.vraptor.jasperreports.formats.ExportFormats;
import br.com.caelum.vraptor.observer.download.Download;
import casamento.dao.ConviteCasamentoDAO;
import casamento.dao.EventoCasamentoDAO;
import framework.br.com.caelum.vraptor.model.*;
import framework.br.com.caelum.vraptor.strategy.GeradorRelatorio;
import framework.br.com.caelum.vraptor.util.EntidadeReport;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

public class GeradorRelatorioCasamento implements GeradorRelatorio{
	
	@Inject
	private EventoCasamentoDAO dao;

	@Inject
	ConviteCasamentoDAO conviteDao;

	private ServletContext context;

	private List<Convite> convites;

	public GeradorRelatorioCasamento() {

	}

	public Download gerarRelatorio(Long id) {
		System.out.println("2");
//		System.out.println(dao.buscarPorId((long) 1).getTitulo());

		Double valorTotalPresentes = 0.0;
		Double valorArrecadadoPresentes = 0.0;
		int numPresentes = 0;
		int numTotalConvidados = 0;
		int numConvidadosConfirmados = 0;
		int numConvidadosNaoConfirmados = 0;
		int numConvidadosAusentes = 0;
		int numConvidadosParticipou = 0;
		int numPadrinhos = 0;

		EventoCasamento evento = dao.buscarPorId(id);
		RelatorioCasamento relatorio = new RelatorioCasamento();
		List<ConviteCasamento> convites = conviteDao.convitesPorEvento(evento.getId());

		for (ConviteCasamento c : convites) {
			if (c.getGrupo().equals("Padrinho")) {
				numPadrinhos++;
			}

			if (c.isCompareceu()) {
				valorArrecadadoPresentes += c.getPresente().getValor();
				numConvidadosParticipou++;
			} else {
				numConvidadosAusentes++;
			}

			if (c.isAceito()) {
				numConvidadosConfirmados++;
			} else {
				numConvidadosNaoConfirmados++;
			}
		}

		relatorio.setTitulo(evento.getTitulo());
		relatorio.setDescricao(evento.getDescricao());
		relatorio.setHoraFim(evento.getHoraFim());
		relatorio.setHoraInicio(evento.getHoraInicio());
		relatorio.setData(evento.getDataInicio());
		relatorio.setNumTotalConvidados(numTotalConvidados);
		relatorio.setNumConvidadosConfirmados(numConvidadosConfirmados);
		relatorio.setNumConvidadosNaoConfirmados(numConvidadosNaoConfirmados);
		relatorio.setNumConvidadosAusentes(numConvidadosAusentes);
		relatorio.setNumConvidadosParticipou(numConvidadosParticipou);
		relatorio.setNumPadrinhos(numPadrinhos);

		return gerarPDF(relatorio);
	}

	private Download gerarPDF(RelatorioCasamento relatorio) {
		Report report;
		ReportDownload download;

		List<RelatorioCasamento> relatorios = new ArrayList<>();
		relatorios.add(relatorio);

		report = new EntidadeReport<RelatorioCasamento>(relatorios, "relatorioTaCasando.jasper", context);
		download = new ReportDownload(report, ExportFormats.pdf(), false);
		return download;
	}
}
