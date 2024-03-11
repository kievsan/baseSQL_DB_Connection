package ru.mail.knhel7.jdata_3_db_connection.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.mail.knhel7.jdata_3_db_connection.model.Product;
import ru.mail.knhel7.jdata_3_db_connection.util.SqlReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdersRepoImpl implements OrdersRepo {

    private final String sqlQuery = SqlReader.read("./sql_queries/namedQuery01_CustomerNameByProductName.sql");
    private final NamedParameterJdbcTemplate jdbc;

    // Внедрение bean, созданного Spring Boot для работы с сохраненными данными:
    public OrdersRepoImpl(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Product> getProductName(String name) {
        RowMapper<Product> productRowMapper = (resultSet, i) -> new Product(resultSet.getString("product_name"));
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return jdbc.query(sqlQuery, paramMap, productRowMapper);
    }

}
