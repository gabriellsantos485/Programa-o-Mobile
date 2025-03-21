public abstract class  Usuario {

    private String email;
    private String senha ;
    private String username;

    public Usuario(String email, String senha, String username){
        this.email = email;
        this.senha = senha;
        this.username=username;
    }

    protected abstract void logarNaConta();

    protected abstract void deslogarConta();

    protected abstract void entrevistar();

    protected abstract void cadastrarUsuario( Usuario usuario);



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
