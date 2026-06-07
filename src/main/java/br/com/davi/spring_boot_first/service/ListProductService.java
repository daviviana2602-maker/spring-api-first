package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.entity.ProductEntity;
import br.com.davi.spring_boot_first.repository.ProductRepository;
import br.com.davi.spring_boot_first.dto.response.ListProductResponse;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ListProductService {

    private final ProductRepository productRepository;


    public ListProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<ListProductResponse> listProducts() {

        List<ProductEntity> products = productRepository.findAll();

        return products.stream()
            .map(produto -> new ListProductResponse(
                produto.getId(),
                produto.getName(),
                produto.getPrice(),
                produto.getQuantity()
            ))
            .toList();

        }

}
