SET SERVEROUTPUT ON;

DECLARE
    CURSOR loan_cursor IS
        SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
    
    v_loan_id Loans.LoanID%TYPE;
    v_customer_id Loans.CustomerID%TYPE;
    v_customer_name Customers.Name%TYPE;
    v_end_date Loans.EndDate%TYPE;
BEGIN
    FOR loan_rec IN loan_cursor LOOP
        v_loan_id := loan_rec.LoanID;
        v_customer_id := loan_rec.CustomerID;
        v_customer_name := loan_rec.Name;
        v_end_date := loan_rec.EndDate;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || v_customer_name || ' (ID: ' || v_customer_id || ') has a loan (ID: ' || v_loan_id || ') due on ' || v_end_date || '.');
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Reminder process completed.');
END;
/
