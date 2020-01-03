package t2company.com.uy.teamis.Model;

public class Comentario {
    String id;
    String Usuario;
    String comentario;

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    String key;
    public Comentario() {
    }

    public Comentario(String id, String usuario, String comentario) {
        this.id = id;
        Usuario = usuario;
        this.comentario = comentario;
    }

    public String getId() {
        return id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
