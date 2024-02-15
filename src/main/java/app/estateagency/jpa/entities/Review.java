package app.estateagency.jpa.entities;

import app.estateagency.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "review", schema = "real_estate")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToOne
    @JoinColumn(name = "offer_id")
    private HistoryOffer historyOffer;

    private int rating;

    private String description;

    private LocalDateTime postDate;

    @PrePersist
    private void prePersist() {
        postDate = LocalDateTime.now();
    }
}
