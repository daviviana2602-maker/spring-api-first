package br.com.davi.spring_boot_first.service;

import br.com.davi.spring_boot_first.entity.ProductEntity;
import br.com.davi.spring_boot_first.repository.ProductRepository;
import br.com.davi.spring_boot_first.dto.response.CreateProductResponse;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;


@Service
public class CreateProductService {

    private final ProductRepository productRepository;


    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional
    public CreateProductResponse createNewProduct(String name, BigDecimal price, int quantity) {

        if (name.isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }

        if (price.compareTo(BigDecimal.valueOf(5000)) > 0 || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }

        if (quantity <= 0 || quantity > 100) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST
            );
        }


        ProductEntity produto = new ProductEntity();

        produto.setName(name);
        produto.setPrice(price);
        produto.setQuantity(quantity);

        productRepository.save(produto);


        return new CreateProductResponse(
                produto.getId(),
                produto.getName(),
                produto.getPrice(),
                produto.getQuantity()
        );

    }

}
