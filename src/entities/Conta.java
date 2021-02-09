package entities;

public abstract class Conta {

	private Pessoa pessoa;
	private int numero;
	private int agencia;
	private boolean contemPix = false;
	private double saldoConta;
	private int quantidadeDeSaquesNoMes = 0;
	private int saqueLivreDeTaxasPorMes = 1;
	private double taxaPorSaqueExedente = 5.5;
	private double trasferencia;
	private double limiteDeSaqueDia = 500.00;
	private double somaValorDeCadaSaque = 0;
	private double limiteTransferenciaDia = 500.00;
	private double somarValorTrasferenciaDia = 0;

	public abstract void sacar(double valor);

	public abstract void exibirSaldo();

	public abstract void depositar(double valor);
	
	public abstract void transferencia(double valor, Conta conta);

	public void ativarPix() {
		if (contemPix == false) {
			this.contemPix = true;
			System.out.println("Pix ativado com sucesso");
		} else {
			System.err.println("pix ja está ativo");

		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public boolean isContemPix() {
		return contemPix;
	}

	public void setContemPix(boolean contemPix) {
		this.contemPix = contemPix;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}

	public int getQuantidadeDeSaquesNoMes() {
		return quantidadeDeSaquesNoMes;
	}

	public void setQuantidadeDeSaquesNoMes(int quantidadeDeSaquesNoMes) {
		this.quantidadeDeSaquesNoMes = quantidadeDeSaquesNoMes;
	}

	public int getSaqueLivreDeTaxasPorMes() {
		return saqueLivreDeTaxasPorMes;
	}

	public void setSaqueLivreDeTaxasPorMes(int saqueLivreDeTaxasPorMes) {
		this.saqueLivreDeTaxasPorMes = saqueLivreDeTaxasPorMes;
	}

	public double getTaxaPorSaqueExedente() {
		return taxaPorSaqueExedente;
	}

	public void setTaxaPorSaqueExedente(double taxaPorSaqueExedente) {
		this.taxaPorSaqueExedente = taxaPorSaqueExedente;
	}

	public double getTrasferencia() {
		return trasferencia;
	}

	public void setTrasferencia(double trasferencia) {
		this.trasferencia = trasferencia;
	}

	public double getLimiteDeSaqueDia() {
		return limiteDeSaqueDia;
	}

	public void setLimiteDeSaqueDia(double limiteDeSaqueDia) {
		this.limiteDeSaqueDia = limiteDeSaqueDia;
	}

	public double getSomaValorDeCadaSaque() {
		return somaValorDeCadaSaque;
	}

	public void setSomaValorDeCadaSaque(double somaValorDeCadaSaque) {
		this.somaValorDeCadaSaque = somaValorDeCadaSaque;
	}

	public double getLimiteTransferenciaDia() {
		return limiteTransferenciaDia;
	}

	public void setLimiteTransferenciaDia(double limiteTransferenciaDia) {
		this.limiteTransferenciaDia = limiteTransferenciaDia;
	}

	public double getSomarValorTrasferenciaDia() {
		return somarValorTrasferenciaDia;
	}

	public void setSomarValorTrasferenciaDia(double somarValorTrasferenciaDia) {
		this.somarValorTrasferenciaDia = somarValorTrasferenciaDia;
	}

	@Override
	public String toString() {
		return  pessoa + ", numero da conta = " + numero + ", agencia = " + agencia + ", contemPix = " + contemPix
				;
	}
	

}
