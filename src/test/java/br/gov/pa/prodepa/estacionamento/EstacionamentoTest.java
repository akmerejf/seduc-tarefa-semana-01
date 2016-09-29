package br.gov.pa.prodepa.estacionamento;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.gov.pa.prodepa.estacionamento.model.VagaEstacionamento;
import br.gov.pa.prodepa.estacionamento.model.Veiculo;

public class EstacionamentoTest {

	@Test
	public void test() {
		
		Estacionamento estacionamento = null;
		
		estacionamento.entradaVeiculo(new Veiculo());
		estacionamento.entradaVeiculo(new Veiculo());
		estacionamento.entradaVeiculo(new Veiculo());
		estacionamento.entradaVeiculo(new Veiculo());
		
		estacionamento.entradaVeiculo(new Veiculo());
		estacionamento.entradaVeiculo(new Veiculo());
		estacionamento.entradaVeiculo(new Veiculo());
		
		Integer numeorVagasOcupadas = estacionamento.quantidadeVagasOcupadas();
		assertEquals(new Integer(7), numeorVagasOcupadas);
		
		List<VagaEstacionamento> vagasOcupadasPasseio = estacionamento.getVagasOcupadasPasseio();
		assertEquals(4, vagasOcupadasPasseio.size());
		
		List<VagaEstacionamento> vagasOcupadasUtilitario = estacionamento.getVagasOcupadasUtilitario();
		assertEquals(vagasOcupadasUtilitario, vagasOcupadasUtilitario.size());
	}

}
