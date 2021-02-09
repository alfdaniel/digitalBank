package entities;

public class ContaPoupanca extends Conta {

	@Override
	public void depositar(double valor) {
		if (valor == 0) {
			System.out.println("Depósito não efetuado!");
			System.out.println("Você precisa inserir um valor maior que zero!");
		} else {
			System.out.println("Depósito efetuado com sucesso! " + valor);
			setSaldoConta(this.getSaldoConta() + valor);
		}
	}

	/*
	 * Sacar valor mostrando algumas posibilidades como: Limite do valor diario de
	 * saque, limites de saques por mes cobrando taxas se exeder o limite.
	 */

	@Override
	public void sacar(double valor) { //
		if (this.getSomaValorDeCadaSaque() < this.getLimiteDeSaqueDia()
				&& this.getSomaValorDeCadaSaque() + valor <= this.getLimiteDeSaqueDia()) {// if que vê se existe limite
																							// disponivel de para saque
																							// diario
			if (this.getLimiteDeSaqueDia() >= valor) {
				if (this.getSaldoConta() >= valor) { // Esse if permite o saque se o saldo for maior ou igual ao valor
														// de saque
					System.out.println("Saque da CC foi realizado com sucesso no valor de: " + valor);
					this.setSaldoConta(this.getSaldoConta() - valor);
					this.setQuantidadeDeSaquesNoMes(this.getQuantidadeDeSaquesNoMes() + 1); // Conta a quatidade de
																							// saques
					this.setSomaValorDeCadaSaque(this.getSomaValorDeCadaSaque() + valor); // Acumula o valor de cada
																							// saque
					if (this.getQuantidadeDeSaquesNoMes() > this.getSaqueLivreDeTaxasPorMes()) { // esse bloco de if
																									// cobra uma taxa
						this.setSaldoConta(this.getSaldoConta() - this.getTaxaPorSaqueExedente());
						System.out.println("Você ultrapassou o limite de saques da CC livres de taxa do mês, "
								+ "foi cobrado uma taxa de R$" + this.getTaxaPorSaqueExedente());
					}
				} else {
					System.out.println("Você tentou sacar R$" + valor + " da CC");
					System.out.println("Saldo é insuficiente!");
				}

			}
		} else {
			System.out.println(
					"Saque não pode ser realizado, " + "Seu limite de saque diário é: " + this.getLimiteDeSaqueDia());
		}

	}

	@Override
	public void exibirSaldo() {
		if (this.getSaldoConta() < 0) {
			System.out.println("Essa Conta corrente está com Saldo Negativo: " + this.getSaldoConta());
		} else {
			System.out.println("Saldo da conta corrente: " + this.getSaldoConta());
		}

	}

	@Override
	public void transferencia(double valor, Conta conta) {
		if (valor <= this.getLimiteTransferenciaDia()) {
			if (this.getSaldoConta() >= valor) {
				conta.depositar(valor); // passandoo valor de traferência para conta passada como argumento //
										// atrves do metodo
				this.setSaldoConta(this.getSaldoConta() - valor);
				System.out.println("Voce realizou uma traferencia de " + valor);
				System.out.println("Trasferência realizada com sucesso para conta: " + conta);
				this.setSomarValorTrasferenciaDia(this.getSomarValorTrasferenciaDia() + valor);
			} else {
				System.out.println("Não foi possivel realizar sua Trasferência");
			}
		} else {
			System.out.println("Trasferência não realizada, " + "Seu limite de transferência diário é: "
					+ this.getLimiteTransferenciaDia());
		}
	}

}
