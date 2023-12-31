package com.hexagonal.architecture.app.infrastructure.api;

import com.hexagonal.architecture.app.adapters.mapper.product.ProductInputData;
import com.hexagonal.architecture.app.adapters.mapper.product.ProductOutputData;
import com.hexagonal.architecture.app.core.dtos.Paged;
import com.hexagonal.architecture.app.core.dtos.ProductDTO;
import com.hexagonal.architecture.app.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController extends RestResource {
    private final ProductService service;
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create(@RequestBody ProductInputData createUserInputData) {
        ProductDTO product = createUserInputData.toEntity();
        service.save(product);
        return created(getLocation(product.getId()));
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductOutputData findById(@PathVariable("id") Long id) {
        ProductDTO product = service.findProductById(id);
        return new ProductOutputData().fromEntity(product);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductOutputData>> findAllPaged(
            @RequestParam(value = "_page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "_limit", required = false, defaultValue = "0") Integer itemsPerPage) {
        Paged<ProductDTO> paged = service.findAllProductPaged(page, itemsPerPage);

        List<ProductOutputData> outputDataList = paged
                .getItems()
                .stream()
                .map(this::toOutputData)
                .collect(Collectors.toList());

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(paged.getTotalItems()));

        return new ResponseEntity<>(outputDataList, headers, HttpStatus.OK);
    }
    private ProductOutputData toOutputData(ProductDTO product) {
        return new ProductOutputData().fromEntity(product);
    }
}
