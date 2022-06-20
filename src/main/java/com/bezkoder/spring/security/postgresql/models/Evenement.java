package com.bezkoder.spring.security.postgresql.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evenement")
public class Evenement {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id ;

    private String title ;

    private String content ;

    private Instant createdOn ;

    private Instant updatedOn ;

    private String username ;


    public void setUsername(String username) {
        this.username = username;
    }

}
