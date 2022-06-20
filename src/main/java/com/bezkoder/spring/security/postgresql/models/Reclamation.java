package com.bezkoder.spring.security.postgresql.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reclamation")
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String probleme ;
    private String site_web ;
    private String etablissement ;
    private String tel ;
    private String gouvernement ;
    private String gouvernorat ;
    private String message ;


}
