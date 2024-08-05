CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        LogID,
        TransactionID,
        ActionDate,
        ActionType,
        Description
    )
    VALUES (
        AuditLog_seq.NEXTVAL,  -- Auto-increment LogID using the sequence
        :NEW.TransactionID,
        SYSDATE,
        'INSERT',
        'Transaction added with amount ' || :NEW.Amount
    );
END;
/
