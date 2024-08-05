DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY c.CustomerID, t.TransactionDate;

    v_customer_id Customers.CustomerID%TYPE;
    v_customer_name Customers.Name%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transaction_type Transactions.TransactionType%TYPE;

    v_current_customer_id Customers.CustomerID%TYPE := NULL;

BEGIN
    OPEN GenerateMonthlyStatements;
    LOOP
        FETCH GenerateMonthlyStatements INTO v_customer_id, v_customer_name, v_transaction_date, v_amount, v_transaction_type;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        IF v_current_customer_id IS NULL OR v_current_customer_id != v_customer_id THEN
            IF v_current_customer_id IS NOT NULL THEN
                DBMS_OUTPUT.PUT_LINE('-----------------------------------------');
            END IF;

            v_current_customer_id := v_customer_id;

            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id);
            DBMS_OUTPUT.PUT_LINE('Customer Name: ' || v_customer_name);
            DBMS_OUTPUT.PUT_LINE('Transactions for the month:');
            DBMS_OUTPUT.PUT_LINE('-----------------------------------------');
            DBMS_OUTPUT.PUT_LINE('Date        | Amount  | Type');
            DBMS_OUTPUT.PUT_LINE('-----------------------------------------');
        END IF;

        DBMS_OUTPUT.PUT_LINE(TO_CHAR(v_transaction_date, 'YYYY-MM-DD') || ' | ' || 
                             TO_CHAR(v_amount, '99999.99') || ' | ' || 
                             v_transaction_type);
    END LOOP;

    IF v_current_customer_id IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('-----------------------------------------');
    END IF;

    CLOSE GenerateMonthlyStatements;
END;
/
