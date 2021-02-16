package application;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Principal {

	public static void main(String[] args) {

	
	
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		 
	// Inserir dados no tabela PESSOA			
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			
			
//		st.executeQuery("INSERT INTO pessoa (id_pessoa, nome, sexo, nacionalidade, naturalidade)"
//									+ " VALUES (2, 'KAROL', 'F', 'BRASILEIRO', 'BELO_JARDIM')");
			
		
						
		} catch (Exception e) {
			
			throw new DbException(e.getMessage());
		}
		
	
		// buscar dados da tabela PESSOA	
		
		try {
			
			rs = st.executeQuery("select * from pessoa");
		
			while(rs.next()) {
			
				System.out.println(rs.getInt("id_pessoa" ) + ", " + rs.getString("nome"));
			}
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}
		
		
		
/*		
 * 
		ContaCorrente cc1 = new ContaCorrente();
		ContaCorrente cc2 = new ContaCorrente();
		ContaPoupanca cp1 = new ContaPoupanca();


		Pessoa p1 = new Pessoa();
		Pessoa p2 = new Pessoa();

		p1.setNome("Igor");
		p1.setCPF("12345678910");
		p1.setIdade(21);
		p1.setAltura(182.3);
		p1.setSexo("Masculino");

		cc1.setPessoa(p1);
		cc1.setAgencia(1010);
		cc1.setNumero(2020);
		cc1.setSaldoConta(1000);
		cc1.setContemPix(false);

		cc2.setPessoa(p2);
		cc2.setAgencia(1010);
		cc2.setNumero(2020);
		cc2.setSaldoConta(0);
		cc2.setContemPix(false);

		p2.setNome("Sophia");
		p2.setCPF("01987654321");
		p2.setIdade(19);
		p2.setAltura(165);
		p2.setSexo("Feminino");

		cp1.setPessoa(p2);
		cp1.setAgencia(1013);
		cp1.setNumero(2021);
		cp1.setSaldoContaPoupanca(321);
		cp1.setContemPix(true);

		System.out.println(cc1.toString());
		System.out.println(cp1.toString());
		System.out.println("________________________________________");
		cc1.ativarPix();
		cp1.ativarPix();
		System.out.println("________________________________________");
		cc1.exibirSaldo(); 
		cp1.exibirSaldo();
		System.out.println("________________________________________");
	  
	  
		
		cc1.exibirSaldo();
		cc1.depositar(500);
		cc1.exibirSaldo();
		System.out.println("________________________________________");
		cc1.depositar(0);
		cc1.exibirSaldo();
		System.out.println("________________________________________");
		
		
// Sacar valor mostrando algumas posibilidades como: Limite do valor diario de saque,
//limites de saques por mes cobrando taxas a mais

	cc1.sacar(400);
		cc1.exibirSaldo();
		System.out.println("________________________________________");
		cc1.sacar(100); 
		cc1.exibirSaldo();
		System.out.println("________________________________________");
		cc1.sacar(200); 
		cc1.exibirSaldo();
		System.out.println("________________________________________");
		cc1.sacar(44.5); 
		cc1.exibirSaldo();
		System.out.println("________________________________________");
 
		
//Fazer uma transferencia de uma conta para outra. 

	cc1.exibirSaldo();
		System.out.println("________________________________________");
		cc2.exibirSaldo();
		cc1.transferencia(300, cc2);
		cc1.exibirSaldo();
		System.out.println("________________________________________");
		cc2.exibirSaldo();
		System.out.println("________________________________________");
		
		cc1.exibirSaldo();
		cc1.transferencia(300, cc2);
		cc1.exibirSaldo();
		System.out.println("________________________________________");
		cc2.exibirSaldo();
*/
	
	}

}
