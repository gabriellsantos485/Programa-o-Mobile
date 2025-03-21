public class Entrevista {

    private  Admin usuario = new Admin("", "", "");
    private  Entrevistado entrevistado = new Entrevistado();



    public Entrevista(Admin usuario, Entrevistado entrevistado){
        this.usuario = usuario;
        this.entrevistado = entrevistado;
    }


}
