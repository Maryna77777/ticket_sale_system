package com.example.tickets.service;


import com.example.tickets.entity.Sale;
import com.example.tickets.repository.CustomerRepository;
import com.example.tickets.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerRepository eventRepository;

    public List<Sale> getAllSalesByCustomerId(Long customerId) {
        return saleRepository.findByCustomerId(customerId);
    }

    public List<Sale> getAllSalesByEventId(Long eventId) {
        return saleRepository.findByEventId(eventId);
    }

//    public Sale createSale (Long customerId, Sale sale){
//        return saleRepository.findById(customerId).map(customer -> {
//            sale.setCustomer(customer);
//            return saleRepository.save(sale);
//        });
//    }


//    public List<Sale> getSalesByEventIdCustomerId (Long eventId,Long customerId){
//        return saleRepository.findByEventCustomerId(eventId, customerId);
//    }



//    public Sale createSale (Long customerId, Sale sale){
//        return saleRepository.findById(customerId).map(customer -> {
//            sale.setCustomer(customer);
//            return saleRepository.save(sale);
//        });
//    }

//    public Comment createComment(@PathVariable (value = "postId") Long postId,
//                                 @Valid @RequestBody Comment comment) {
//        return postRepository.findById(postId).map(post -> {
//            comment.setPost(post);
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }

}
