package com.arc.reviewms.review;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_title")
    private String title;

    @Column(name = "review_description")
    private String description;

    @Column(name = "review_rating")
    private String rating;

    @Column(name = "review_admin_id")
    private Long adminId;
}
