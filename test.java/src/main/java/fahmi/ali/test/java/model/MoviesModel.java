package fahmi.ali.test.java.model;



import fahmi.ali.test.java.request.MoviesRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="movies_tbl")
public class MoviesModel implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private float rating;

    @Column(name = "image")
    private String image;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public MoviesModel convertDtoToModel(MoviesRequest moviesRequest) {
        MoviesModel model = new MoviesModel();
        model.setId(moviesRequest.getId());
        model.setCreatedAt(moviesRequest.getCreated_at());
        model.setUpdatedAt(moviesRequest.getUpdated_at());
        model.setImage(moviesRequest.getImage());
        model.setDescription(moviesRequest.getDescription());
        model.setRating(moviesRequest.getRating());
        model.setTitle(moviesRequest.getTitle());
        return model;
    }
}
