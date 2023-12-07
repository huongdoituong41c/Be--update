package com.spring.security.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "hotel")
public class Hotel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToMany(mappedBy ="hotel",  cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    @Column (name = "NAME", nullable = false)
    private String name;

    @Column (name = "ADDRESS", nullable = false)
    private  String address;

    @Column (name = "DESCRIPTION", nullable = false)
    private String description;

    @Lob
    @Column (name = "IMG", nullable = false, columnDefinition = "BLOB")
    private byte[] img;

}
