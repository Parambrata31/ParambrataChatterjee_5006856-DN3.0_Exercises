BEGIN
    SafeTransferFunds(
        p_from_account_id => 1,  -- Example from account ID
        p_to_account_id => 2,    -- Example to account ID
        p_amount => 100          -- Example amount to transfer
    );
END;
/
