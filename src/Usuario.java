import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Post> posts = new ArrayList<>();
    private List<Usuario> seguindo = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getSeguindo() {
        return seguindo;
    }

    public String getNome() {
        return nome;
    }

    public void lerPosts() {
        for (Post post: posts) {
            System.out.println(posts);
        }
    }

    public void adicionarSeguidor(Usuario seguidor) {
        seguindo.add(seguidor);
        for (Post post:posts) {
            seguidor.adicionarPost(post);
        }
    }

    public void adicionarPost(Post post) {
        this.posts.add(post);
        System.out.println("Postagem adicionada ao mural de " + nome);
    }

    public void lerMural() {
        lerPosts();
    }

    public void verSeguidores(){
        for (Usuario usuario: seguindo) {
            System.out.println("Seguindo " + usuario.getNome());
        }
    }

    @Override
    public String toString() {
        return "Usuário[" +
                "nome = " + nome + '\'' +
                ", postagens = " + posts +
                ", seguindo = " + seguindo +
                ']';
    }
}
