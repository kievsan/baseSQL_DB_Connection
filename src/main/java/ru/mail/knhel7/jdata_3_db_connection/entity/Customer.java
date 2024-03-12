package ru.mail.knhel7.jdata_3_db_connection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 30)
    private String surname;
    @Column(nullable = false)
    private int age;

    @Column(name = "phone_number", length = 12, nullable = false)
    private String phone;

    @OneToMany (mappedBy="customers", fetch=FetchType.EAGER)
    @ToString.Exclude
    private List<Order> orderList;
}
