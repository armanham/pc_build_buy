package team.foura.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

/**
 * Base entity class for entities with common fields.
 *
 * <p>The {@code BaseEntity} class is an abstract class annotated with {@code @MappedSuperclass}.
 * It serves as a base class for entities that have common fields such as creation timestamp,
 * update timestamp, deletion timestamp, and deletion flag.
 *
 * <p>The class provides getters and setters for the common fields, allowing subclasses to access
 * and modify these fields. The common fields include:
 * <ul>
 *   <li>{@code createdOn}: the timestamp representing the creation date and time of the entity.</li>
 *   <li>{@code updatedOn}: the timestamp representing the last update date and time of the entity.</li>
 *   <li>{@code deletedOn}: the timestamp representing the deletion date and time of the entity.</li>
 *   <li>{@code isDeleted}: a flag indicating whether the entity is marked as deleted.</li>
 * </ul>
 *
 * <p>Subclasses of {@code BaseEntity} can extend this class to inherit the common fields and their
 * corresponding getters and setters. By utilizing this base class, entities can have consistent
 * tracking of creation, update, and deletion information.
 *
 * @author Arman Hambardzumyan
 */

@MappedSuperclass
public abstract class BaseEntity {

    @CreationTimestamp
    @Column(name = "created_on")
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "deleted_on")
    private Date deletedOn;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public BaseEntity() {
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Date getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Date deletedOn) {
        this.deletedOn = deletedOn;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}