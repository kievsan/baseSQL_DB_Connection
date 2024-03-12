package ru.mail.knhel7.jdata_3_db_connection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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

    @OneToMany (mappedBy="customer", fetch=FetchType.EAGER)
    @ToString.Exclude
    private List<Order> orderList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getAge() == customer.getAge() &&
                Objects.equals(getId(), customer.getId()) &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getSurname(), customer.getSurname()) &&
                Objects.equals(getPhone(), customer.getPhone()) &&
                Objects.equals(getOrderList(), customer.getOrderList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
