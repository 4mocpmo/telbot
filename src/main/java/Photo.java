import java.util.Date;
import java.util.Objects;

public class Photo {
    private int id;

    private String Title;

    private String description;

    private String privacy;

    private Date uploadDate;

    private Integer view;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getView() {
        return this.view;
    }

    public void setView(Integer view_) {
        this.view = view_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id == photo.id &&
                Objects.equals(Title, photo.Title) &&
                Objects.equals(description, photo.description) &&
                Objects.equals(privacy, photo.privacy) &&
                Objects.equals(uploadDate, photo.uploadDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Title, description, privacy, uploadDate, view);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", description='" + description + '\'' +
                ", privacy='" + privacy + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
