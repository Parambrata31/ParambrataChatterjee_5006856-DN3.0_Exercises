SET SERVEROUTPUT ON;

DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, TRUNC((SYSDATE - DOB) / 365.25) AS Age
        FROM Customers;
    
    v_customer_id Customers.CustomerID%TYPE;
    v_age NUMBER;
    v_updated_loans NUMBER := 0;
BEGIN
    FOR customer_rec IN customer_cursor LOOP
        v_customer_id := customer_rec.CustomerID;
        v_age := customer_rec.Age;
        
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate * 0.99
            WHERE CustomerID = v_customer_id;
            
            IF SQL%ROWCOUNT > 0 THEN
                v_updated_loans := v_updated_loans + SQL%ROWCOUNT;
                DBMS_OUTPUT.PUT_LINE('Updated Loan for Customer ID: ' || v_customer_id || ' with new interest rate.');
            END IF;
        END IF;
    END LOOP;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Total number of updated loans: ' || v_updated_loans);
END;
/
