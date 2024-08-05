SET SERVEROUTPUT ON;
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee (
        p_EmployeeID IN NUMBER,
        p_Name IN VARCHAR2,
        p_Position IN VARCHAR2,
        p_Salary IN NUMBER,
        p_Department IN VARCHAR2,
        p_HireDate IN DATE
    );

    PROCEDURE UpdateEmployee (
        p_EmployeeID IN NUMBER,
        p_Name IN VARCHAR2,
        p_Position IN VARCHAR2,
        p_Salary IN NUMBER,
        p_Department IN VARCHAR2,
        p_HireDate IN DATE
    );

    FUNCTION CalculateAnnualSalary (
        p_EmployeeID IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_EmployeeID IN NUMBER,
        p_Name IN VARCHAR2,
        p_Position IN VARCHAR2,
        p_Salary IN NUMBER,
        p_Department IN VARCHAR2,
        p_HireDate IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: EmployeeID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END HireEmployee;

    PROCEDURE UpdateEmployee (
        p_EmployeeID IN NUMBER,
        p_Name IN VARCHAR2,
        p_Position IN VARCHAR2,
        p_Salary IN NUMBER,
        p_Department IN VARCHAR2,
        p_HireDate IN DATE
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_Name,
            Position = p_Position,
            Salary = p_Salary,
            Department = p_Department,
            HireDate = p_HireDate
        WHERE EmployeeID = p_EmployeeID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: EmployeeID not found.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary (
        p_EmployeeID IN NUMBER
    ) RETURN NUMBER IS
        v_Salary NUMBER;
    BEGIN
        SELECT Salary INTO v_Salary
        FROM Employees
        WHERE EmployeeID = p_EmployeeID;

        RETURN v_Salary * 12;  
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;  
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            RETURN NULL;
    END CalculateAnnualSalary;

END EmployeeManagement;
/
BEGIN
    EmployeeManagement.HireEmployee(
        p_EmployeeID => 3,
        p_Name => 'Parambrata Chatterjee',
        p_Position => 'Junior Developer',
        p_Salary => 40000,
        p_Department => 'IT',
        p_HireDate => SYSDATE
    );
END;
/
BEGIN
    EmployeeManagement.UpdateEmployee(
        p_EmployeeID => 3,
        p_Name => 'Parambrata Chatterjee',
        p_Position => 'Senior Developer',
        p_Salary => 70000,
        p_Department => 'IT',
        p_HireDate => SYSDATE
    );
END;
/
DECLARE
    v_AnnualSalary NUMBER;
BEGIN
    v_AnnualSalary := EmployeeManagement.CalculateAnnualSalary(p_EmployeeID => 3);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_AnnualSalary);
END;
/


