package ru.mail.knhel7.jdata_3_db_connection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @Column(length = 50)
    private String product_name;

    @Column
    private int amount;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="order_id")
    @ToString.Exclude
    private Customer customer_id;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getAmount() == order.getAmount() && Objects.equals(getId(),
                order.getId()) && Objects.equals(getDate(),
                order.getDate()) && Objects.equals(getProduct_name(),
                order.getProduct_name()) && Objects.equals(getCustomer_id(),
                order.getCustomer_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate());
    }
}
