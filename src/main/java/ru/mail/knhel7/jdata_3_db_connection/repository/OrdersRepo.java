package ru.mail.knhel7.jdata_3_db_connection.repository;

import ru.mail.knhel7.jdata_3_db_connection.model.Product;

import java.util.List;

public interface OrdersRepo {
    List<Product> getProductName(String name);
}
