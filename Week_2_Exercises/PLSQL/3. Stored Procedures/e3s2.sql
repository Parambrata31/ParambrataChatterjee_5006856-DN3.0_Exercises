CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN

    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100)
    WHERE Department = p_department;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Bonus updated for employees in department: ' || p_department);
END;
/

SET SERVEROUTPUT ON;

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/
