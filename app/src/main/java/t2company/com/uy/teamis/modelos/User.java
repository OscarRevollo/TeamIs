package t2company.com.uy.teamis.modelos;

public class User {
    private String id;
    private String username;
    private String imageUrl;
    private String status;

    public User(String id, String imageUrl, String username, String status){
        this.id=id;
        this.username=username;
        this.imageUrl=imageUrl;
        this.status=status;
    }

    public User() {

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
