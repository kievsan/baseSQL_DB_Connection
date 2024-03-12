package ru.mail.knhel7.jdata_3_db_connection.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import ru.mail.knhel7.jdata_3_db_connection.entity.Order;
import ru.mail.knhel7.jdata_3_db_connection.model.Product;

//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import ru.mail.knhel7.jdata_3_db_connection.util.SqlReader;
//import java.util.HashMap;
//import java.util.Map;

import java.util.List;

@Repository
public class OrdersRepoImpl implements OrdersRepo {

    @PersistenceContext
    private EntityManager manager;

//    private final String sqlQuery = SqlReader.read("./sql_queries/namedQuery01_CustomerNameByProductName.sql");
//    private final NamedParameterJdbcTemplate jdbc;
//
//    // Внедрение bean, созданного Spring Boot для работы с сохраненными данными:
//    public OrdersRepoImpl(NamedParameterJdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    @Override
//    public List<Product> getProductName(String name) {
//        RowMapper<Product> productRowMapper = (resultSet, i) -> new Product(resultSet.getString("product_name"));
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name", name);
//        return jdbc.query(sqlQuery, paramMap, productRowMapper);
//    }

    @Override
    public List<Product> getProductName(String name) {
        var query = manager.createQuery("SELECT orderList FROM Customer c WHERE lower(c.name) = lower(:name)");
        query.setParameter("name", name);
        List<Order> orders = query.getResultList();
        System.out.println(orders);
        return orders.stream()
                .map(order -> new Product(order.getProduct_name()))
                .toList();
    }

}
