BEGIN
    FOR loan IN (
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 5000
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || loan.CustomerID ||
                             ' has a loan (ID: ' || loan.LoanID || ') due on ' || TO_CHAR(loan.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;