CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount (
        p_AccountID IN NUMBER,
        p_CustomerID IN NUMBER,
        p_AccountType IN VARCHAR2,
        p_Balance IN NUMBER
    );

    PROCEDURE CloseAccount (
        p_AccountID IN NUMBER
    );

    FUNCTION GetTotalBalance (
        p_CustomerID IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount (
        p_AccountID IN NUMBER,
        p_CustomerID IN NUMBER,
        p_AccountType IN VARCHAR2,
        p_Balance IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, SYSDATE);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: AccountID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END OpenAccount;

    PROCEDURE CloseAccount (
        p_AccountID IN NUMBER
    ) IS
    BEGIN

        DELETE FROM Transactions
        WHERE AccountID = p_AccountID;
        
        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: AccountID not found.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END CloseAccount;

        FUNCTION GetTotalBalance (
        p_CustomerID IN NUMBER
    ) RETURN NUMBER IS
        v_TotalBalance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_TotalBalance
        FROM Accounts
        WHERE CustomerID = p_CustomerID;

        RETURN NVL(v_TotalBalance, 0);  
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN 0;
    END GetTotalBalance;

END AccountOperations;
/
BEGIN
    AccountOperations.OpenAccount(
        p_AccountID => 6,
        p_CustomerID => 2,
        p_AccountType => 'Savings',
        p_Balance => 45000
    );
END;
/
BEGIN
    AccountOperations.CloseAccount(p_AccountID => 2);
END;
/
DECLARE
    v_TotalBalance NUMBER;
BEGIN
    v_TotalBalance := AccountOperations.GetTotalBalance(p_CustomerID => 2);
    DBMS_OUTPUT.PUT_LINE('Total Balance: ' || v_TotalBalance);
END;
/
