package tech.pinheirolabs.util;

import java.security.KeyException;
import java.util.Properties;

public class Util {
	
	public static String formatar(byte[] chave) {
		StringBuffer sb = new StringBuffer();
		byte[] var2 = chave;
		int var3 = chave.length;
  
		for(int var4 = 0; var4 < var3; ++var4) {
		   byte b = var2[var4];
		   sb.append(b + ",");
		}
  
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	 }
  
	 public static byte[] formatar(String chave) throws KeyException {
		String[] dados = chave.split(",");
		byte[] keys = new byte[dados.length];
  
		for(int i = 0; i < dados.length; ++i) {
		   try {
			  keys[i] = Byte.parseByte(dados[i]);
		   } catch (NumberFormatException var5) {
			  throw new KeyException("Erro ao formatar a chave informada.");
		   }
		}
  
		return keys;
	 }
  
	 public static int getQuantidade(String args) {
		int qtde = 0;
		if (args != null && args.length() > 0) {
		   try {
			  	qtde = Integer.parseInt(args);
			  return qtde;
		   } catch (NumberFormatException var3) {
		   }
		}
  
		return qtde;
	 }
  
	 public static String getChave(String chave) {
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
