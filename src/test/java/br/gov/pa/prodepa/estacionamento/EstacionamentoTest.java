package br.gov.pa.prodepa.estacionamento;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.gov.pa.prodepa.estacionamento.model.VagaEstacionamento;
import br.gov.pa.prodepa.estacionamento.model.Veiculo;

public class EstacionamentoTest {
	
	Veiculo vPasseio01;
	Veiculo vPasseio02;
	Veiculo vPasseio03;
	Veiculo vPasseio04;
	Veiculo vPasseio05;
	Veiculo vPasseio06;
	
	Veiculo vUtilitario01;
	Veiculo vUtilitario02;
	Veiculo vUtilitario03;
	Veiculo vUtilitario04;
	Veiculo vUtilitario05;
	Veiculo vUtilitario06;
	
	@Before
	public void init() {
		
		//TODO Atencao: Vc deve preencher os objetos abaixo!!!
		
		vPasseio01 = new Veiculo();
		vPasseio02 = new Veiculo();
		vPasseio03 = new Veiculo();
		vPasseio04 = new Veiculo();
		vPasseio05 = new Veiculo();
		vPasseio06 = new Veiculo();
		
		vUtilitario01 = new Veiculo();
		vUtilitario02 = new Veiculo();
		vUtilitario03 = new Veiculo();
		vUtilitario04 = new Veiculo();
		vUtilitario05 = new Veiculo();
		vUtilitario06 = new Veiculo();
		
	}
	
	@Test
	public void testMain() {
		
		Estacionamento estacionamento = new Estacionamento();
		
		//Estacionar Veilulos Passeio
		estacionamento.entradaVeiculo(vPasseio01);
		estacionamento.entradaVeiculo(vPasseio02);
		estacionamento.entradaVeiculo(vPasseio03);
		estacionamento.entradaVeiculo(vPasseio04);
		
		//Estacionar Veilulos Utilitario
		estacionamento.entradaVeiculo(vUtilitario01);
		estacionamento.entradaVeiculo(vUtilitario02);
		estacionamento.entradaVeiculo(vUtilitario03);
		
		//Veja no log se está tudo certo
		estacionamento.imprimirEstacionamento();
		
		Integer numeorVagasOcupadas = estacionamento.quantidadeVagasOcupadas();
		assertEquals(new Integer(7), numeorVagasOcupadas);
		
		List<VagaEstacionamento> vagasOcupadasPasseio = estacionamento.getVagasOcupadasPasseio();
		assertEquals(4, vagasOcupadasPasseio.size());
		
		List<VagaEstacionamento> vagasOcupadasUtilitario = estacionamento.getVagasOcupadasUtilitario();
		assertEquals(3, vagasOcupadasUtilitario.size());
		
		
		//Remover Veiculos
		estacionamento.retiradaVeiculo(vPasseio01);
		estacionamento.retiradaVeiculo(vPasseio02);
		
		estacionamento.retiradaVeiculo(vUtilitario01);
		
		numeorVagasOcupadas = estacionamento.quantidadeVagasOcupadas();
		assertEquals(new Integer(4), numeorVagasOcupadas);
		
		vagasOcupadasPasseio = estacionamento.getVagasOcupadasPasseio();
		assertEquals(2, vagasOcupadasPasseio.size());
		
		vagasOcupadasUtilitario = estacionamento.getVagasOcupadasUtilitario();
		assertEquals(2, vagasOcupadasUtilitario.size());
		
		//Veja no log se está tudo certo
		estacionamento.imprimirEstacionamento();
	}
	
	@Test
	public void testExcesoesOverBooking() {
		
		Estacionamento estacionamento = new Estacionamento();
		
		//Estacionar Veilulos Passeio
		estacionamento.entradaVeiculo(vPasseio01);
		estacionamento.entradaVeiculo(vPasseio02);
		estacionamento.entradaVeiculo(vPasseio03);
		estacionamento.entradaVeiculo(vPasseio04);
		
		estacionamento.entradaVeiculo(vUtilitario01);
		estacionamento.entradaVeiculo(vUtilitario02);
		estacionamento.entradaVeiculo(vUtilitario03);
		
		try {
			estacionamento.entradaVeiculo(vPasseio05);
			estacionamento.entradaVeiculo(vPasseio06);
			fail("Não há 6 vagas para carros de passeio !!!");
		} catch (Exception e) {
			//Deu tudo certo. :)
		}
		
		try {
			estacionamento.entradaVeiculo(vUtilitario04);
			estacionamento.entradaVeiculo(vUtilitario05);
			estacionamento.entradaVeiculo(vUtilitario06);
			fail("Não há 6 vagas para carros de passeio !!!");
		} catch (Exception e) {
			//Deu tudo certo. :)
		}
		
	}
	
	@Test
	public void testExcesoesDuplicidade() {
		
		Estacionamento estacionamento = new Estacionamento();
		
		try {
			estacionamento.entradaVeiculo(vPasseio01);
			estacionamento.entradaVeiculo(vPasseio01);
			fail("Ops!! O veiculo 01 foi duplicado!!!!!");
		} catch (Exception e) {
			//Deu tudo certo. :)
		}
		
	}
	
	@Test
	public void testExcesoesVeiculoPerdido() {
		
		Estacionamento estacionamento = new Estacionamento();
		
		try {
			estacionamento.retiradaVeiculo(vPasseio01);
			fail("Ops!! O veiculo 01 não estava em nosso estacionamento!!!!!");
		} catch (Exception e) {
			//Deu tudo certo. :)
		}
		
	}

}
