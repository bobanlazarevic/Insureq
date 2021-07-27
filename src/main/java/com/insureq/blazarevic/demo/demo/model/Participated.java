package com.insureq.blazarevic.demo.demo.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(
        name = "participated",
        uniqueConstraints = {
                @UniqueConstraint(name = "car_accident_unique", columnNames = {"car_licence", "accident_id"})
        }
)
public class Participated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_licence")
    private Car car;

    // @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accident_id")
    private Accident accident;

    @Column(
            name = "damage_amount"
    )
    private int damageAmount;
}
