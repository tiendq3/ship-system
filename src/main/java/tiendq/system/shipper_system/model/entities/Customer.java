package tiendq.system.shipper_system.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(max = 255)
    private String name;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    @OneToMany(mappedBy = "customer")
    private Set<Vote> votes;
}
