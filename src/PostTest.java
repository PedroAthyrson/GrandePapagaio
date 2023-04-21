import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostTest {
    Post post;
    Usuario user;
    String usuario;
    GrandePapagaio papagaio;

    @BeforeEach
    public void init() {
        usuario = "Athyrson";
        post = new Post(usuario, "apenas um teste");
        papagaio = new GrandePapagaio();
    }

    @Test
    public void testPost() {
        Assertions.assertEquals("apenas um teste", post.getTexto());
        post.setTexto("maravilhoso papagaio");
        Assertions.assertEquals("maravilhoso papagaio", post.getTexto());
        Assertions.assertEquals(usuario, post.getNomeDoUsuario());
    }

    @Test
    public void testExisteUsuario() {
        String nome = "Pedro";
        papagaio.usuarios.add(new Usuario(nome));
        assertTrue(papagaio.existeUsuario(nome));
        assertFalse(papagaio.existeUsuario("Flamengo"));
    }


    @Test
    public void testToString() {
        String nomeUsuario = "Pedro";
        String texto = "Teste";
        Post post = new Post(nomeUsuario, texto);

        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String resultadoEsperado = nomeUsuario + " --> " + texto + " (" + dataAtual.format(formatter) + ")";

        Assertions.assertEquals(resultadoEsperado, post.toString());
    }
}
