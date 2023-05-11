package fahmi.ali.test.java.request;

import fahmi.ali.test.java.model.MoviesModel;

import java.util.Date;

public class MoviesRequest {
    private long id;

    private String title;
    private String description;
    private float rating;
    private String image;
    private Date created_at;
    private Date updated_at;

    public static MoviesRequest convertDataToDto(MoviesModel moviesRequest) {
        MoviesRequest model = new MoviesRequest();
        model.setId(moviesRequest.getId());
        model.setCreated_at(moviesRequest.getCreatedAt());
        model.setUpdated_at(moviesRequest.getUpdatedAt());
        model.setImage(moviesRequest.getImage());
        model.setDescription(moviesRequest.getDescription());
        model.setRating(moviesRequest.getRating());
        model.setTitle(moviesRequest.getTitle());
        return model;
    }

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
