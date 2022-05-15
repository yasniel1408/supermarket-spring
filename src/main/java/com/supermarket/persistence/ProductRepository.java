package com.supermarket.persistence;


import com.supermarket.domain.dto.ProductDto;
import com.supermarket.domain.repository.IProductRepository;
import com.supermarket.persistence.crud.ICategoryCrudRepository;
import com.supermarket.persistence.crud.IProductCrudRepository;
import com.supermarket.persistence.entity.Category;
import com.supermarket.persistence.entity.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private IProductCrudRepository iProductCrudRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = iProductCrudRepository.findAll();
        List<ProductDto> productsResult = null;
        products.forEach(p -> {
            ProductDto productDto = modelMapper.map(p, ProductDto.class);
            productsResult.add(productDto);
        });
        System.out.println("productsResult " + productsResult);
        return productsResult;
    }

    @Override
    public Optional<List<ProductDto>> getAllProductsByCategory(Long categoryId) {
        List<Product> products = iProductCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(Arrays.asList(modelMapper.map(products, ProductDto[].class)));
    }

    @Override
    public Optional<List<ProductDto>> getActiveProductScarce(int cant) {
        Optional<List<Product>> products = iProductCrudRepository.findByCantStockLessThanAndState(cant, true);
        return Optional.of(Arrays.asList(modelMapper.map(products, ProductDto[].class)));
    }

    @Override
    public Optional<ProductDto> getOneProduct(Long productId) {
        Optional<Product> product = iProductCrudRepository.findById(productId);
        return product.map(pro -> modelMapper.map(pro, ProductDto.class));
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product newProduct = modelMapper.map(productDto, Product.class);

        try {

            newProduct.setCategoryId(productDto.getCategoryId());

            Product productDtoCreated = iProductCrudRepository.save(newProduct);
            return modelMapper.map(productDtoCreated, ProductDto.class);

        }catch (Exception exception){
            System.out.println(exception);
        }
        return productDto;
    }

    @Override
    public void deleteProduct(Long productId) {
        iProductCrudRepository.deleteById(productId);
    }
}