package com.insureq.blazarevic.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "driver_id"
    )
    private Long id;

    @Column(
            name = "driver_name"
    )
    private String name;

    @Column(
            name = "driver_address"
    )
    private String address;

    // @JsonManagedReference
    @OneToMany(
            mappedBy = "person",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Car> cars = new ArrayList<>();
}
