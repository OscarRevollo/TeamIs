package t2company.com.uy.teamis.Model;

public class Comentario {
    String titulo;
    String autorOriginal;
    String emisorComentario;
    String comentario;

    public Comentario(String titulo, String autorOriginal, String emisorComentario, String comentario) {
        this.titulo = titulo;
        this.autorOriginal = autorOriginal;
        this.emisorComentario = emisorComentario;
        this.comentario = comentario;
    }

    public Comentario( ){
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutorOriginal(String autorOriginal) {
        this.autorOriginal = autorOriginal;
    }

    public void setEmisorComentario(String emisorComentario) {
        this.emisorComentario = emisorComentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutorOriginal() {
        return autorOriginal;
    }

    public String getEmisorComentario() {
        return emisorComentario;
    }

    public String getComentario() {
        return comentario;
    }
}
