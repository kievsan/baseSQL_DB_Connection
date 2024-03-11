select product_name
from db3.orders o
    inner join db3.customers c on c.id = o.customer_id
where lower(c.name) = lower(:name)
;
