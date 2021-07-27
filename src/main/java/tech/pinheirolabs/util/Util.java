package tech.pinheirolabs.util;

import static tech.pinheirolabs.util.Const.SEPARADOR;

import java.security.KeyException;
import java.util.Properties;

public class Util {
	
	/*******************************************************************************************/
	public static String formatar(byte[] chave){
		StringBuffer sb = new StringBuffer();
		for (byte b : chave) {
			sb.append(b + ",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	/*******************************************************************************************/
	public static byte[] formatar(String chave) throws KeyException{
		String[] dados = chave.split(SEPARADOR);
		byte[] keys = new byte[dados.length];
		for (int i = 0; i < dados.length; i++) {
			try {
				keys[i] = Byte.parseByte(dados[i]);
			} catch (NumberFormatException e) {
				throw new KeyException("Erro ao formatar a chave informada.");
			}
		}
		return keys;
	}
	
	/*******************************************************************************************/
	public static int getQuantidade(String args){
		int qtde = 0;
		if(args!=null && args.length() > 0){
			try {
				qtde = Integer.parseInt(args);
				return qtde;
			} catch (NumberFormatException e) {
				//nothing...ok.
			}
		}
		return qtde;
	}
	
	/*******************************************************************************************/
	public static String getChave(String chave){
		Properties prop = System.getProperties();
		String valor = prop.getProperty(chave);
		return valor;
	}
	
	public static String encoding(String dado) {
		return dado.replaceAll("\\+", "%20").replaceAll("/", "//");
	}
	public static String decoding(String dado) {
		return dado.replaceAll("%20", "+").replaceAll(" ", "+").replaceAll("//", "/");
	}
}//END - By FP - 2021
