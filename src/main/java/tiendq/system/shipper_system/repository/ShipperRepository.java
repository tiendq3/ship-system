package tiendq.system.shipper_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tiendq.system.shipper_system.model.entities.Shipper;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {
}
