import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String nomeDoUsuario;
    private String texto;
    private LocalDateTime data;

    public Post(String nomeDoUsuario, String texto) {
        this.nomeDoUsuario = nomeDoUsuario;
        this.texto = texto;
        this.data = LocalDateTime.now();
    }
    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return getNomeDoUsuario() + " --> " + texto + " (" + data.format(formatter) + ")";
    }
}
