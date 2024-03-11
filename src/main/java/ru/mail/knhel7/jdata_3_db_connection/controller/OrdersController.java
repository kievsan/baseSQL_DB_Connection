package ru.mail.knhel7.jdata_3_db_connection.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.mail.knhel7.jdata_3_db_connection.model.Product;
import ru.mail.knhel7.jdata_3_db_connection.repository.OrdersRepo;

import java.util.List;

@RestController
@RequestMapping("/products/fetch-product")
public class OrdersController {

  private final OrdersRepo repo;

  public OrdersController(OrdersRepo repo) {
      this.repo = repo;
  }

  @GetMapping
  public ResponseEntity <List<Product>> selectProductNamesByCustomerName(@RequestParam("name") String username) {
    return ResponseEntity.ok(repo.getProductName(username));
  }

}
