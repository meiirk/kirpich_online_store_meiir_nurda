package com.example.kirpich_online_store_meiir_nurda.users.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;
    private String image;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;

    public String getRolesName() {
        String roles_name = "";
        for (int i = 0; i < roles.size(); i++) {
            roles_name += roles.get(i).getRole() + ",";
        }
        return roles_name;
    }
}
