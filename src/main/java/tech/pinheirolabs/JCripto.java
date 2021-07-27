package tech.pinheirolabs;

import static tech.pinheirolabs.util.Impressao.*;
import static tech.pinheirolabs.util.Util.*;
import static tech.pinheirolabs.util.Valida.validarArgs;
import static tech.pinheirolabs.Acao.*;
import static tech.pinheirolabs.Decrypter.decriptar;
import static tech.pinheirolabs.Encripter.encriptar;
import static tech.pinheirolabs.GeraChave.gerarChave;

import java.security.KeyException;

/**
 * Permite processar uma a��o espefica pre-definida.
 * 
 * @author filipe.pinheiro
 *
 */
public class JCripto {

	public static void acao(String[] args){
		if(!validarArgs(args)){
			imprimirHelp(); return;
		} else {
			try {
				if(CHAVE.acao().equals(args[0])){
					String[] chaves;
					chaves = gerarChave(getQuantidade(args[1]));
					imprimirChaves(chaves);
					return;
				}
				byte[] key = formatar(args[1]);
				if(CRYPTO.acao().equals(args[0])){
					String cripto = encriptar(key, args[2]);
					imprimirCriptografia(cripto, args[2]);
					return;
				}
				if(DECRYPTO.acao().equals(args[0])){
					String decripto = decriptar(key, args[2]);
					imprimirCriptografia(args[2], decripto);
					return;
				}
			} catch (KeyException e) {
				System.out.println("Erro ao executar o <comando>" + "! \nMotivo:" + e.getMessage());
				imprimirHelp();
			}
		}
		
	}
	
}//END - By FP - 2021
