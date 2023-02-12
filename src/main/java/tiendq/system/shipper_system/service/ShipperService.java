package tiendq.system.shipper_system.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tiendq.system.shipper_system.model.entities.Order;
import tiendq.system.shipper_system.model.entities.Product;
import tiendq.system.shipper_system.model.entities.Shipper;
import tiendq.system.shipper_system.model.enums.EStatusOrder;
import tiendq.system.shipper_system.repository.OrderRepository;
import tiendq.system.shipper_system.repository.ShipperRepository;

import java.util.Optional;

@Service
@Data
public class ShipperService {
    private final ShipperRepository shipperRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public void shipperUpdateOrder(Long orderId, Long shipperId, EStatusOrder statusOrder) {
        Optional<Shipper> shipperOptional = shipperRepository.findById(shipperId);
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        Shipper shipper = shipperOptional.get();
        Order order = orderOptional.get();

        double orderWeight = order.getProducts().stream().mapToDouble(Product::getWeight).sum();

        // check order of shipper
        if (order.getShipper().equals(shipper)) {
            order.setStatusOrder(statusOrder);
            double salaryPerOrder = 0;
            if (orderWeight <= 10) {
                salaryPerOrder += 15;
            } else if (orderWeight <= 20) {
                salaryPerOrder += 20;
            } else salaryPerOrder += 30;

            if (statusOrder.equals(EStatusOrder.Delivered)) {
                if (order.getVote() != null) {
                    if (order.getVote().getRate() < 3) {
                        salaryPerOrder *= 1.05;
                    } else salaryPerOrder *= 1.1;
                }
            }
            shipper.getWallet().setBalance(shipper.getWallet().getBalance() + salaryPerOrder);
            shipperRepository.save(shipper);
            orderRepository.save(order);
        }
    }
}
