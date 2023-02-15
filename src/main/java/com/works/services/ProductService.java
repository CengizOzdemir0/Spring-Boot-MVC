package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public boolean save(Product product){
        try {
            productRepository.save(product);
            return true;
        }catch (Exception ex){
            return false;
        }
    }



    public boolean delete(String stpid){
        try {
            Long pid = Long.parseLong(stpid);
            productRepository.deleteById(pid);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public Page<Product> list(int pageCount) {
        Pageable pageable =  PageRequest.of(pageCount,5);
        Page<Product> page = (Page<Product>) productRepository.findAll(pageable);

        return  page;

    }

    }


