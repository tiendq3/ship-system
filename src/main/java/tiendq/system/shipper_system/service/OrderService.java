package tiendq.system.shipper_system.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import tiendq.system.shipper_system.model.entities.Order;
import tiendq.system.shipper_system.model.enums.EStatusOrder;
import tiendq.system.shipper_system.repository.OrderRepository;

import java.util.Optional;

@Service
@Data
public class OrderService {
    private final OrderRepository orderRepository;

    public void completedDelivery(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        orderOptional.get().setStatusOrder(EStatusOrder.Delivered);
    }
}
