package com.siimannuk.querydsldemo.superhero;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "superhero")
public class Superhero {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "skin_color")
    private String skinColor;

    @Column(name = "eye_color")
    private String eyeColor;

    @Column(name = "hair_color")
    private String hairColor;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "weight", nullable = false)
    private double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alignment_id", nullable = false)
    private Alignment alignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "superhero_has_superpower",
        joinColumns = @JoinColumn(name = "superhero_id"),
        inverseJoinColumns = @JoinColumn(name = "superpower_id")
    )
    private Set<Superpower> superpowers = new HashSet<>();

    public SuperheroDto toDto() {
        return new SuperheroDto()
            .id(id())
            .name(name())
            .gender(gender())
            .skinColor(skinColor())
            .eyeColor(eyeColor())
            .hairColor(hairColor())
            .height(height())
            .weight(weight())
            .alignment(alignment().name())
            .race(race().name())
            .publisher(publisher().name())
            .superpowers(
                superpowers().stream()
                    .map(Superpower::name)
                    .collect(Collectors.toSet())
            );
    }
}
