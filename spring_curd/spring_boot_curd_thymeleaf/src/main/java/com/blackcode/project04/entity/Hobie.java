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
public class Hobie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hobieId;
    private String hobieName;
}
