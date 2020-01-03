package t2company.com.uy.teamis.Model;

public class Respuesta {
    private String id;
    private String usuario;
    private String comentario;

    public Respuesta() {
    }

    public Respuesta(String id, String usuario, String comentario) {
        this.id = id;
        this.usuario = usuario;
        this.comentario = comentario;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getComentario() {
        return comentario;
    }


}
