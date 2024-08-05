ALTER TABLE Customers ADD (IsVIP VARCHAR2(3));

SET SERVEROUTPUT ON;

DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;
    
    v_customer_id Customers.CustomerID%TYPE;
    v_balance Customers.Balance%TYPE;
BEGIN
    FOR customer_rec IN customer_cursor LOOP
        v_customer_id := customer_rec.CustomerID;
        v_balance := customer_rec.Balance;
        
        IF v_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'YES'
            WHERE CustomerID = v_customer_id;
            
            IF SQL%ROWCOUNT > 0 THEN
                DBMS_OUTPUT.PUT_LINE('Promoted Customer ID: ' || v_customer_id || ' to VIP status.');
            END IF;
        END IF;
    END LOOP;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('VIP promotion process completed.');
END;
/
