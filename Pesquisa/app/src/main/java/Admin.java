public class Admin extends Usuario {

    public  Admin(String email, String senha, String username){
        super(email, senha, username);
    }

    @Override
    protected void cadastrarUsuario(Usuario usuario) {
        System.out.println(usuario.getUsername());
    }

    @Override
    protected void entrevistar() {

    }

    @Override
    protected void deslogarConta() {

    }

    @Override
    protected void logarNaConta() {

    }

    private void vizualizarDadosdaPesquisa(){

    }

    private void cadastrarUsuarioComum(){

    }

    private void cadastrarCandidato(Candidato candidato){

    }
}
