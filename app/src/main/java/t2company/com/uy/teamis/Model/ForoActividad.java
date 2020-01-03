package t2company.com.uy.teamis.Model;

public class ForoActividad {
    private String key;
    private String titulo;
    private String descripcion;
    private String categoria;
    private String fecha;
    private String autor;

    public ForoActividad(String titulo, String descripcion, String categoria, String fecha){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.categoria=categoria;
        this.fecha=fecha;
    }

    public ForoActividad() {
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
