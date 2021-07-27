package tech.pinheirolabs;

import java.util.Scanner;

import tech.pinheirolabs.util.Impressao;

/**
 * Indicador de a��o para processamento.
 * 
 * @author filipe.pinheiro
 *
 */
public enum Acao {

	CHAVE("chave", 1),

	CRYPTO("cripto", 2),

	DECRYPTO ("decripto", 3),
	
	AJUDA ("help", 0);

	private String acao;
	private int codigo;
	Acao(String acao, int codigo){
		this.acao = acao;
		this.codigo = codigo;
	}

	public String acao(){  return acao; };
	public int codigo(){  return codigo; };
	
	/** ********************************************************************************/
	public static boolean validarComando(int cmd){
		Acao[] acoes = Acao.values();
		for (Acao acao : acoes) {
			if(acao.codigo()  == cmd) return true;
		}
		return false;
	}
	
	public static String comando(int cmd){
		Acao[] acoes = Acao.values();
		for (Acao acao : acoes) {
			if(acao.codigo()  == cmd) return acao.acao();
		}
		return "";
	}
	
	/** ********************************************************************************/
	public static boolean validarComando(String cmd){
		Acao[] acoes = Acao.values();
		for (Acao acao : acoes) {
			if(acao.acao().equals(cmd)) return true;
		}
		return false;
	}
	
	/** ********************************************************************************/
	public static boolean isChave(int acao){
		return CHAVE.codigo() == acao;
	}
	/** ********************************************************************************/
	public static boolean isCripto(int acao){
		return CRYPTO.codigo() == acao;
	}
	/** ********************************************************************************/
	public static boolean isDecripto(int acao){
		return DECRYPTO.codigo() == acao;
	}
	/** ********************************************************************************/
	public static boolean isAjuda(int acao){
		return AJUDA.codigo() == acao;
	}
	/** ********************************************************************************/
	public static String comandos(){
		StringBuffer cmds = new StringBuffer();
		Acao[] acoes = Acao.values();
		for (Acao acao : acoes) {
			cmds.append(" | ");
			cmds.append(acao.acao());
		}
		cmds.append(" | ");
		return cmds.toString();
	}
	
	private static int lerAcao(Scanner scanner){
		Impressao.imprimirMenu();
		int acao=scanner.nextInt();
		return acao;
	}
	
	public static String[] ler(){
		String[] args = null;
		Scanner scanner = new Scanner(System.in);
		int acao = lerAcao(scanner);
        if(validarComando(acao)){
        	args = new String[3];
        	args[0] = comando(acao);
        	scanner.nextLine();
        	if(isChave(acao)){
        		System.out.print("\nEntre com a quantidade de Chaves (1 a 9): ");
        		int qtde=scanner.nextInt();
        		args[1] = Integer.toString(qtde);
        		scanner.nextLine();
        	} else 	if(isCripto(acao)){
        		System.out.print("\n1/2) Entre com a CHAVE criptografica: ");
        		String chave = scanner.nextLine();
        		System.out.print("\n2/2) Entre com o DADO a ser criptografado: ");
        		String dado = scanner.nextLine();
        		args[1] = chave;
        		args[2] = dado;
        	}else if(isDecripto(acao)){
        		System.out.print("\n1/2) Entre com a CHAVE criptografica: ");
        		String chave = scanner.nextLine();
        		System.out.print("\n2/2) Entre com o DADO *CriPtoGraDado*: ");
        		String dado = scanner.nextLine();
        		args[1] = chave;
        		args[2] = dado;
        	}
        	System.out.println("\n*******************************************************************************");
		} else{
			System.out.println("Opcao NAO encontrada! Tente novamente... Bye!  :(-");
			scanner.nextLine();
		}
        scanner.close();
        return args;
	}
	
}//END - By FP - 2021
