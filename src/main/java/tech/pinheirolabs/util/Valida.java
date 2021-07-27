package tech.pinheirolabs.util;

import tech.pinheirolabs.Acao;

public class Valida {

	public static boolean validarArgs(String[] args) {
		if (args != null && args.length > 1) {
			String comando = args[0];
			if (!Acao.validarComando(comando)) {
				System.out.println("Erro: Comando invalido! Deve ser: " + Acao.comandos());
				return false;
			} else if (Acao.AJUDA.acao().equals(comando)) {
				return false;
			} else {
				if (Acao.CHAVE.acao().equals(comando)) {
					int qtde = Util.getQuantidade(args[1]);
					if (qtde <= 0 || qtde > 9) {
						System.out.println(
								"Erro: <Quantidade> nao informada ou invalida! Deve ser um número entre 1 e 9.");
						return false;
					}
				}

				if (Acao.CRYPTO.acao().equals(comando) || Acao.DECRYPTO.acao().equals(comando)) {
					if (args.length < 2) {
						System.out.println("Erro: <comando> ou numero de parametros invalido!");
						return false;
					}

					if (args[1] == null || !validarChave(args[1])) {
						System.out.println(
								"Erro: Chave invalida! Deve ser exatamente o valor gerado pelo <comando>=chave");
						return false;
					}

					if (args[2] == null || args[2].length() < 4) {
						System.out.println(
								"Erro: Conteudo a ser criptografado invalido! Deve ter pelo menos 4 caracteres.");
						return false;
					}
				}

				return true;
			}
		} else {
			return false;
		}
	}

	private static boolean validarChave(String chave) {
		String[] dados = chave.split(",");
		if (chave != null && dados.length == 16) {
			String[] var2 = dados;
			int var3 = dados.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				String key = var2[var4];

				try {
					Integer.parseInt(key);
				} catch (NumberFormatException var7) {
					return false;
				}
			}

			return true;
		} else {
			return false;
		}
	}

}// END - By FP - 2021
