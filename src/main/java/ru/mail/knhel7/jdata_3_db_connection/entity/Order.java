package ru.mail.knhel7.jdata_3_db_connection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Customer customer_id;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }
}