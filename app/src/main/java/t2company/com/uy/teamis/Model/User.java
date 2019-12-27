package t2company.com.uy.teamis.Model;

public class User {
    private String id;
    private String carrera;
    private String email;
    private String username;
    private String imageUrl;
    private String status;

    public User(String id, String carrera, String email, String username, String imageUrl, String status) {
        this.id = id;
        this.carrera = carrera;
        this.email = email;
        this.username = username;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    public User() {

    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageUrl;
    }

    public void setImageURL(String imageURL) {
        this.imageUrl = imageURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
