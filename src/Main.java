import java.util.Scanner;
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GrandePapagaio papagaio = new GrandePapagaio();

        boolean sair = false;
        while (!sair) {
            System.out.println("""
                    \s
                    O GRANDIOSO PAPAGAIO\s
                      Digite um comando:\s""");
            String comando = sc.nextLine();
            String[] comandoDividido = comando.split(" ");

            if (comandoDividido.length == 2) {
                if (comandoDividido[0].equals("mural")) {
                    String nomeUsuario = comandoDividido[1];
                    papagaio.mural(nomeUsuario);
                }

            } 
            
            else if (comandoDividido.length >= 3) {
                if (comandoDividido[1].equals("segue")) {
                    String nomeSeguidor = comandoDividido[0];
                    String nomeSeguindo = comandoDividido[2];
                    papagaio.seguir(nomeSeguidor, nomeSeguindo);

                } 
                
                else if (comandoDividido[1].equals("->")) {
                    String usuario = comandoDividido[0];
                    String mensagem = " ";
                    for (int i = 2; i < comandoDividido.length; i++) {
                        String espaço = " ";
                        String parteMensagem = comandoDividido[i] + espaço;
                        mensagem = mensagem + parteMensagem;
                    }
                    papagaio.postar(usuario, mensagem);
                }


            } else {
                if (comando.equals("sair")) {
                    sair = true;
                    System.out.println("Até logo!");
                }

            }
        }
    }
}