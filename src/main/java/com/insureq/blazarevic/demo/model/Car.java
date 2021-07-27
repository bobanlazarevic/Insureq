package com.insureq.blazarevic.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "car_licence"
    )
    private Long licence;

    @Column(
            name = "car_model"
    )
    private String model;

    @Column(
            name = "car_year"
    )
    private String year;

    // @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(
            name = "person_id",
            referencedColumnName = "driver_id",
            foreignKey = @ForeignKey(
                    name = "person_fk"
            )
    )
    private Person person;

    // @JsonManagedReference
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Participated> carParticipated = new HashSet<>();
}
