BEGIN
    AddNewCustomer(
        p_customer_id => 1001,
        p_name => 'Alice Williams',
        p_dob => TO_DATE('1990-01-01', 'YYYY-MM-DD'),
        p_balance => 1500,
        p_last_modified => SYSDATE
    );
END;
/
