import java.util.ArrayList;
import java.util.List;

public class GrandePapagaio {
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario getUsuario(String nome) throws InexistentUserException {
        for (Usuario usuario: usuarios) {
            if(usuario.getNome().equals(nome.strip())){
                return usuario;
            }
        }
        throw  new InexistentUserException("O usuário não existe.");
    }

    public void listaDeUsuarios(){
        for (Usuario usuario: usuarios) {
            System.out.println("-> " + usuario.getNome());
        }
    }

    public boolean existeUsuario(String nomeDoUsuario){
        for (Usuario usuario: usuarios) {
            if (usuario.getNome().equals(nomeDoUsuario)){
                return true;
            }
        }
        return false;
    }

    public void postar(String nomeDoUsuario, String texto) {
        Post post = new Post(nomeDoUsuario, texto);
        if (!existeUsuario(nomeDoUsuario)) {
            Usuario usuario = new Usuario(nomeDoUsuario);
            usuario.adicionarPost(post);
            this.usuarios.add(usuario);
        } else {
            for (Usuario usuario: usuarios) {
                if (usuario.getNome().equals(nomeDoUsuario)){
                    usuario.adicionarPost(post);
                }
            }
        }
    }

    public void seguir(String seguidor, String seguido){
        if (!existeUsuario(seguido)){
            Usuario usuario = new Usuario(seguidor);
            this.usuarios.add(usuario);
        }
        if (existeUsuario(seguido)){
            for (Usuario usuario : usuarios){
                if (usuario.getNome().equals(seguido)){
                    for (Usuario user : usuarios) {
                        if (user.getNome().equals(seguidor)) {
                            usuario.adicionarSeguidor(user);
                        }
                    }
                }
            }
        }
    }

    public void mural(String nome){
        try {
            Usuario usuario = getUsuario(nome);
            usuario.lerMural();
        } catch (InexistentUserException e){
            System.out.println("Desculpe, o usuário " + nome + " não foi encontrado.");
        }
    }


}
