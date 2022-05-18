package com.alnicode.restapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "directions")
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direction_id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String country;

    @NotNull
    @Size(min = 3, max = 100)
    private String state;

    @NotNull
    @Size(min = 3, max = 100)
    private String locality;

    @NotNull
    @Size(min = 3, max = 120)
    @Column(unique = true)
    private String address;

    @OneToOne(mappedBy = "direction", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE })
    private Person person;
}
