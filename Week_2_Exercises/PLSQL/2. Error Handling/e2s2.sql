CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_current_salary NUMBER;
BEGIN

    BEGIN

        SELECT Salary INTO v_current_salary FROM Employees WHERE EmployeeID = p_employee_id;
        
        UPDATE Employees
        SET Salary = Salary * (1 + p_percentage / 100)
        WHERE EmployeeID = p_employee_id;
        
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Salary updated successfully for Employee ID: ' || p_employee_id);
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID does not exist.');
        WHEN OTHERS THEN

            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
    END;
END;
/
