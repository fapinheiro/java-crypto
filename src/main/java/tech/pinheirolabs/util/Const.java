package tech.pinheirolabs.util;

public interface Const {
	String 	METODO_ENCRIPTACAO 	= "AES";
	String 	ALGORITIMO 			= "SHA1PRNG";
	int 	MININO_CRYPTO		= 4;
	int 	NUMERO_CHAVE		= 16;
	int 	QUANTIDADE 			= 20;
	int 	CHAVE_TAMANHO 		= 128; // 128, 192, 256
	String 	SEPARADOR			= ",";
	String 	CHAVE_PADRAO		= "60,122,-128,-40,-54,64,-72,-53,117,-45,-62,18,55,-124,124,-86";
	String 	CHAVE_AMBIENTE		= System.getProperties().getProperty("br.com.embracon.cripto");
	
	/** ********************************************************************************/
	//TODO: Atualizar o Java para permitir encripta��o maior que 128 bits.
	//int maxKeyLen = Cipher.getMaxAllowedKeyLength(METODO_ENCRIPTACAO);
	//http://docs.oracle.com/javase/6/docs/technotes/guides/security/crypto/CryptoSpec.html#AppB
	//http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
	//http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html
	//Unzip and replace the jars (local_policy.jar , US_export_policy.jar) here: Java\jdk1.X_X\jre\lib\security
}//END - By FP - 2021
