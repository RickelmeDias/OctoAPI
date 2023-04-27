package com.octopodius.OctoAPI.entities;

import com.octopodius.OctoAPI.enums.CategoryTypeEnum;
import com.octopodius.OctoAPI.enums.SubCategoryTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "publications")
@Entity(name = "Publication")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {

    @EmbeddedId
    private PublicationsId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_author_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryTypeEnum category;

    @Enumerated(EnumType.STRING)
    @Column(name = "sub_category", nullable = false)
    private SubCategoryTypeEnum subCategory;

    @Column
    @Size(max=3)
    private List<String> tags;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    protected void prePersist() {
        if (this.isActive == null) this.isActive = true;
        if (this.createdAt == null) createdAt = LocalDateTime.now();
        if (this.updatedAt == null) updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public void deletePost() {
        this.isActive = false;
    }

    @Getter
    @Embeddable
    static public class PublicationsId implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        @Column(name = "username_author")
        private String usernameAuthor;

        @Column(name = "slug")
        private String slug;

        public PublicationsId() {}

        public PublicationsId(String usernameAuthor, String slug) {
            this.usernameAuthor = usernameAuthor;
            this.slug = slug;
        }
    }
}