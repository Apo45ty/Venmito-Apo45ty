package games.apolion.webInterfaceVenmito.webInterfaceVenmito.db.entities;

import games.apolion.webInterfaceVenmito.webInterfaceVenmito.utils.TimeZoneConverter;
import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    private String aboutMe;


    @OneToOne
    private User userID;

    @Column(nullable = false)
    private ZonedDateTime createDate;
    private ZonedDateTime deleteDate;

    private boolean isDeleted;

    public ZonedDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(ZonedDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }
    public ZonedDateTime getDeleteDate(String timeZone) {
        TimeZoneConverter converter = new TimeZoneConverter();
        ZonedDateTime localDateTime = converter.convertFromUTC(deleteDate,timeZone);
        return localDateTime;
    }
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    public ZonedDateTime getCreateDate() {
        return createDate;
    }
    public ZonedDateTime getCreateDate(String timeZone) {
        TimeZoneConverter converter = new TimeZoneConverter();
        ZonedDateTime localDateTime = converter.convertFromUTC(createDate,timeZone);
        return localDateTime;
    }
    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }
}
