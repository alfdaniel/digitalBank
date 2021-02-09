package entities;

public class ContaPoupanca extends Conta {

	@Override
	public void depositar(double valor) {
		if (valor == 0) {
			System.out.println("Dep�sito n�o efetuado!");
			System.out.println("Voc� precisa inserir um valor maior que zero!");
		} else {
			System.out.println("Dep�sito efetuado com sucesso! " + valor);
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
				&& this.getSomaValorDeCadaSaque() + valor <= this.getLimiteDeSaqueDia()) {// if que v� se existe limite
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
						System.out.println("Voc� ultrapassou o limite de saques da CC livres de taxa do m�s, "
								+ "foi cobrado uma taxa de R$" + this.getTaxaPorSaqueExedente());
					}
				} else {
					System.out.println("Voc� tentou sacar R$" + valor + " da CC");
					System.out.println("Saldo � insuficiente!");
				}

			}
		} else {
			System.out.println(
					"Saque n�o pode ser realizado, " + "Seu limite de saque di�rio �: " + this.getLimiteDeSaqueDia());
		}

	}

	@Override
	public void exibirSaldo() {
		if (this.getSaldoConta() < 0) {
			System.out.println("Essa Conta corrente est� com Saldo Negativo: " + this.getSaldoConta());
		} else {
			System.out.println("Saldo da conta corrente: " + this.getSaldoConta());
		}

	}

	@Override
	public void transferencia(double valor, Conta conta) {
		if (valor <= this.getLimiteTransferenciaDia()) {
			if (this.getSaldoConta() >= valor) {
				conta.depositar(valor); // passandoo valor de trafer�ncia para conta passada como argumento //
										// atrves do metodo
				this.setSaldoConta(this.getSaldoConta() - valor);
				System.out.println("Voce realizou uma traferencia de " + valor);
				System.out.println("Trasfer�ncia realizada com sucesso para conta: " + conta);
				this.setSomarValorTrasferenciaDia(this.getSomarValorTrasferenciaDia() + valor);
			} else {
				System.out.println("N�o foi possivel realizar sua Trasfer�ncia");
			}
		} else {
			System.out.println("Trasfer�ncia n�o realizada, " + "Seu limite de transfer�ncia di�rio �: "
					+ this.getLimiteTransferenciaDia());
		}
	}

}
