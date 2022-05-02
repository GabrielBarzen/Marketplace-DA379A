create or replace function f_getAllProducts()
    returns setof products as
    $$
    begin
    return query (select * from products);
    end;
    $$

language plpgsql;

create or replace function f_addproducts(f_price double precision, f_date date, f_type varchar, f_color varchar, f_condition varchar, f_status varchar, f_seller varchar, f_name varchar)
    returns int as
    $$
    declare ok int;
    begin
        insert into products(price, date, type, color, condition, status, seller, name)
        values (f_price, f_date, f_type, f_color, f_condition, f_status, f_seller, f_name);
        ok = 1;
        return ok;
    EXCEPTION when too_many_arguments then
        ok = -1;
        return ok;
    end;
    $$

language plpgsql;

CREATE OR REPLACE FUNCTION f_register_user(
    username VARCHAR,
    email VARCHAR,
    password VARCHAR,
    birth_date DATE,
    first_name VARCHAR,
    last_name VARCHAR)
    RETURNS BOOLEAN AS $$
    BEGIN
        INSERT INTO users VALUES (username, email, password, birth_date, first_name, last_name);
        RETURN true;
    EXCEPTION WHEN unique_violation THEN
        RETURN false;
    END;
    $$ LANGUAGE plpgsql;
	

CREATE OR REPLACE procedure p_delete_user(uname VARCHAR)
    AS $$
    BEGIN
        DELETE FROM users WHERE uname = users.username;
    END;
    $$ LANGUAGE plpgsql;
	

create or replace procedure p_removeproduct(f_id uuid)
    as
    $$
    begin
        delete from products where f_id = products.id;
    end;
    $$

language plpgsql;

create or replace function f_searchType(
    f_type varchar default null,
    f_condition varchar default null,
    f_pricemax double precision default 9999999,
    f_pricemin double precision default 0)
    returns setof products as
    $$
        begin
            if f_pricemax <= 9999999 and f_pricemin >= 0 and f_type is null and f_condition is null then
                return query (select * from products where f_pricemax >= products.price and f_pricemin <= products.price and status = 'Not sold');

            elsif f_type is null and f_condition is not null then
                return query (select * from products where f_condition = products.condition and f_pricemax >= products.price and f_pricemin <= products.price and status = 'Not sold');

            elsif f_condition is null and f_type is not null then
                return query (select * from products where f_type = products.type and f_pricemax >= products.price and f_pricemin <= products.price and status = 'Not sold');

            else
                return query (select * from products where f_type = products.type and f_condition = products.condition and f_pricemax >= products.price and f_pricemin <= products.price and status = 'Not sold');

            end if;
        end;
    $$

language plpgsql;