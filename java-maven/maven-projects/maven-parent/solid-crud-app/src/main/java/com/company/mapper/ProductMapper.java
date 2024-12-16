package com.company.mapper;

import com.company.dto.ProductDto;
import com.company.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Mapping methods
    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);
}
