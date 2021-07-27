package tech.pinheirolabs;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.List;

import tech.pinheirolabs.cert.InstallCert;
import tech.pinheirolabs.util.Impressao;
import tech.pinheirolabs.util.Util;
import tech.pinheirolabs.util.Valida;


/**
 * Permite processar uma a��o espefica pre-definida.
 * 
 * @author filipe.pinheiro
 *
 */
public class JCripto {

	public static void acao(String[] args){
		if (!Valida.validarArgs(args)) {
			Impressao.imprimirHelp();
		 } else {
			try {
			   if (Acao.CHAVE.acao().equals(args[0])) {
				  String[] chaves = GeraChave.gerarChave(Util.getQuantidade(args[1]));
				  Impressao.imprimirChaves(chaves);
				  return;
			   }
   
			   if (Acao.CERTIFICADO_HTTPS.acao().equals(args[0])) {
				  List<String> argsInstallCert = new ArrayList<>();
   
				  for(int i = 1; i < args.length; ++i) {
					 if (args[i] != null) {
						argsInstallCert.add(args[i]);
					 }
				  }
   
				  InstallCert.mainMethod((String[])argsInstallCert.toArray(new String[argsInstallCert.size()]));
				  return;
			   }
   
			   byte[] key = Util.formatar(args[1]);
			   String decripto;
			   if (Acao.CRYPTO.acao().equals(args[0])) {
				  decripto = Encripter.encriptar(key, args[2]);
				  Impressao.imprimirCriptografia(decripto, args[2]);
				  return;
			   }
   
			   if (Acao.DECRYPTO.acao().equals(args[0])) {
				  decripto = Decrypter.decriptar(key, args[2]);
				  Impressao.imprimirCriptografia(args[2], decripto);
				  return;
			   }
			} catch (KeyException var3) {
			   System.out.println("Erro ao executar o <comando>! \nMotivo:" + var3.getMessage());
			   Impressao.imprimirHelp();
			} catch (Exception var4) {
			   System.out.println("Erro ao executar o <comando>! \nMotivo:" + var4.getMessage());
			   Impressao.imprimirHelp();
			}
   
		 }
		
	}
	
}//END - By FP - 2021
