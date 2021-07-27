package com.insureq.blazarevic.demo.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "accident_id"
    )
    private Long id;

    @Column(
            name = "created_at"
    )
    private LocalDateTime createdAt;

    @Column(
            name = "location",
            nullable = false
    )
    private String location;

    // @JsonManagedReference
    @OneToMany(mappedBy = "accident", cascade = CascadeType.ALL)
    private Set<Participated> accidentParticipated = new HashSet<>();
}
