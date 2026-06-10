package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.dto.response.OrderResponse;
import br.com.davi.spring_boot_first.entity.OrderEntity;
import br.com.davi.spring_boot_first.entity.UserEntity;
import br.com.davi.spring_boot_first.enums.OrderStatusEnum;
import br.com.davi.spring_boot_first.repository.OrderRepository;
import br.com.davi.spring_boot_first.repository.UserRepository;
import br.com.davi.spring_boot_first.security.OwnershipService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class CreateOrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OwnershipService ownershipService;


    public CreateOrderService(OrderRepository orderRepository,
                              UserRepository userRepository,
                              OwnershipService ownershipService)
    {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.ownershipService = ownershipService;
    }


    private UserEntity findId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }


    @Transactional
    public OrderResponse createOrder(Long userId){

        ownershipService.checkOwnership(userId);


        List<OrderEntity> orders = orderRepository.findByUserId(userId);


        for (OrderEntity o : orders){

            if (o.getStatus().equals(OrderStatusEnum.PENDING)) {

                throw new ResponseStatusException(
                        HttpStatus.CONFLICT
                );

            }
        }


        UserEntity user = findId(userId);

        OrderEntity order = new OrderEntity();


        order.setUserId(user.getId());
        order.setStatus(OrderStatusEnum.PENDING);

        orderRepository.save(order);

        return new OrderResponse(
            order.getId(),
            order.getUserId(),
            user.getName(),
            order.getStatus()
        );

    }

}
