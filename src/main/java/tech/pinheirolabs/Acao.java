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
   DECRYPTO("decripto", 3),
   CERTIFICADO_HTTPS("certificado_https", 4),
   AJUDA("help", 0);

   private String acao;
   private int codigo;

   private Acao(String acao, int codigo) {
      this.acao = acao;
      this.codigo = codigo;
   }

   public String acao() {
      return this.acao;
   }

   public int codigo() {
      return this.codigo;
   }

   public static boolean validarComando(int cmd) {
      Acao[] acoes = values();
      Acao[] var2 = acoes;
      int var3 = acoes.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Acao acao = var2[var4];
         if (acao.codigo() == cmd) {
            return true;
         }
      }

      return false;
   }

   public static String comando(int cmd) {
      Acao[] acoes = values();
      Acao[] var2 = acoes;
      int var3 = acoes.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Acao acao = var2[var4];
         if (acao.codigo() == cmd) {
            return acao.acao();
         }
      }

      return "";
   }

   public static boolean validarComando(String cmd) {
      Acao[] acoes = values();
      Acao[] var2 = acoes;
      int var3 = acoes.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Acao acao = var2[var4];
         if (acao.acao().equals(cmd)) {
            return true;
         }
      }

      return false;
   }

   public static boolean isChave(int acao) {
      return CHAVE.codigo() == acao;
   }

   public static boolean isCripto(int acao) {
      return CRYPTO.codigo() == acao;
   }

   public static boolean isDecripto(int acao) {
      return DECRYPTO.codigo() == acao;
   }

   public static boolean isCertificadoHttps(int acao) {
      return CERTIFICADO_HTTPS.codigo() == acao;
   }

   public static boolean isAjuda(int acao) {
      return AJUDA.codigo() == acao;
   }

   public static String comandos() {
      StringBuffer cmds = new StringBuffer();
      Acao[] acoes = values();
      Acao[] var2 = acoes;
      int var3 = acoes.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Acao acao = var2[var4];
         cmds.append(" | ");
         cmds.append(acao.acao());
      }

      cmds.append(" | ");
      return cmds.toString();
   }

   private static int lerAcao(Scanner scanner) {
      Impressao.imprimirMenu();
      int acao = scanner.nextInt();
      return acao;
   }

   public static String[] ler() {
      String[] args = null;
      Scanner scanner = new Scanner(System.in);
      int acao = lerAcao(scanner);
      if (validarComando(acao)) {
         args = new String[]{comando(acao), null, null};
         scanner.nextLine();
         if (isChave(acao)) {
            System.out.print("\nEntre com a quantidade de Chaves (1 a 9): ");
            int qtde = scanner.nextInt();
            args[1] = Integer.toString(qtde);
            scanner.nextLine();
         } else {
            String dado;
            String url;
            if (isCripto(acao)) {
               System.out.print("\n1/2) Entre com a CHAVE criptografica: ");
               url = scanner.nextLine();
               System.out.print("\n2/2) Entre com o DADO a ser criptografado: ");
               dado = scanner.nextLine();
               args[1] = url;
               args[2] = dado;
            } else if (isDecripto(acao)) {
               System.out.print("\n1/2) Entre com a CHAVE criptografica: ");
               url = scanner.nextLine();
               System.out.print("\n2/2) Entre com o DADO *CriPtoGraDado*: ");
               dado = scanner.nextLine();
               args[1] = url;
               args[2] = dado;
            } else if (isCertificadoHttps(acao)) {
               System.out.print("\n1/2) Entre com o endereco (URL) do site HTTPS: ");
               url = scanner.nextLine();
               args[1] = url;
            }
         }

         System.out.println("\n*******************************************************************************");
      } else {
         System.out.println("Opcao NAO encontrada! Tente novamente... Bye!  :(-");
         scanner.nextLine();
      }

      return args;
   }
	
}//END - By FP - 2021
