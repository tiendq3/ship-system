package tiendq.system.shipper_system.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tiendq.system.shipper_system.model.enums.EStatusOrder;
import tiendq.system.shipper_system.service.ShipperService;

@RestController
@Data
public class ShipperController {
    private final ShipperService shipperService;

    @PutMapping("/api/v1/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void shipperUpdateOrder(@PathVariable Long id,
                                   @RequestParam Long shipperId,
                                   @RequestParam EStatusOrder statusOrder) {
        shipperService.shipperUpdateOrder(id, shipperId, statusOrder);
    }
}
