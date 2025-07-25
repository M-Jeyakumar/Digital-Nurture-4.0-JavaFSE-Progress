CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER, p_to_account   IN NUMBER, p_amount       IN NUMBER
) IS
    v_balance NUMBER;
BEGIN

    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;
END;

BEGIN
    TransferFunds(1, 2, 500);
END;

SELECT * FROM Accounts