public class InexistentUserException extends Exception {
    private String nome;

    public InexistentUserException(String msg) {
        super(msg);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
