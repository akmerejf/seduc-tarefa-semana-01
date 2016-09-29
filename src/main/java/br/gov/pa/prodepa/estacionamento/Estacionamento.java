package br.gov.pa.prodepa.estacionamento;

import java.util.List;

import br.gov.pa.prodepa.estacionamento.model.VagaEstacionamento;
import br.gov.pa.prodepa.estacionamento.model.Veiculo;

public interface Estacionamento {

	public void entradaVeiculo(Veiculo veiculo);

	public Integer quantidadeVagasOcupadas();

	public List<VagaEstacionamento> getVagasOcupadasPasseio();
	
	public List<VagaEstacionamento> getVagasOcupadasUtilitario();

}
