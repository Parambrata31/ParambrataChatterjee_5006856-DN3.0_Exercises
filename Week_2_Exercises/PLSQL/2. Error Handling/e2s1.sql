CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_from_balance NUMBER;
    v_to_balance NUMBER;
BEGIN

    BEGIN

        SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id;
        SELECT Balance INTO v_to_balance FROM Accounts WHERE AccountID = p_to_account_id;
        
        IF v_from_balance < p_amount THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for transfer.');
        END IF;
        
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account_id;
        
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account_id;
        
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');
        
    EXCEPTION
        WHEN OTHERS THEN

            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error during transfer: ' || SQLERRM);
    END;
END;
/
