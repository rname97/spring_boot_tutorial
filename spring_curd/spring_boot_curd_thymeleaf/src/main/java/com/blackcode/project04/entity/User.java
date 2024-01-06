package com.blackcode.project04.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String userAddress;

    @ManyToOne
    @JoinColumn(name = "hobieId")
    private Hobie hobie;

    @ManyToOne
    @JoinColumn(name = "professionId")
    private Profession profession;
}
