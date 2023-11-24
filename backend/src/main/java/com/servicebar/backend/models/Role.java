package com.servicebar.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table
public class Role {
    @Id @Column("idRole")
    private Integer id;

    private ERole name;

    public Role() {}

    public Role(ERole name) {
        this.setName(name);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
