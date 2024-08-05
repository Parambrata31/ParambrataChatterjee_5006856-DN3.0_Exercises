SET SERVEROUTPUT ON;

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE OF InterestRate;

    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_new_interest_rate NUMBER;

BEGIN
    OPEN UpdateLoanInterestRates;
    LOOP
        FETCH UpdateLoanInterestRates INTO v_loan_id, v_interest_rate;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        v_new_interest_rate := v_interest_rate + 1;

        UPDATE Loans
        SET InterestRate = v_new_interest_rate
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ' - New Interest Rate: ' || v_new_interest_rate);
    END LOOP;

    CLOSE UpdateLoanInterestRates;
END;
/
