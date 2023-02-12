package tiendq.system.shipper_system.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiendq.system.shipper_system.model.enums.EStatusOrder;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "address")
    private String address;

    @Column(name = "total_price")
    private double price;

    @Column(name = "status")
    private EStatusOrder statusOrder;

    @Column(name = "time_order")
    private Date timeOrder;

    @Column(name = "estimate_time")
    private Date estimateTime;

    @ManyToMany()
    @JsonManagedReference
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @OneToOne(mappedBy = "order")
    private Vote vote;

}
