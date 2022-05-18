package com.alnicode.restapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Size(min = 2)
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonIgnore
    private Set<User> users = Collections.emptySet();
}
