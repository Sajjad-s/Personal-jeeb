INSERT INTO users (email, password_hash, status, created_at)
VALUES ('demo@jeeb.local', '$2a$10$7EqJtq98hPqEX7fNZaFWoOhi5N0X1sQqK9M7mE3E0SSw5qvHX8N0m', 'active', CURRENT_TIMESTAMP());

INSERT INTO transactions (user_id, amount, description, date)
VALUES (1, 150000.00, 'حقوق ماهانه', CURRENT_DATE());

INSERT INTO incomes (user_id, name, amount, date)
VALUES (1, 'حقوق', 150000.00, CURRENT_DATE());

INSERT INTO expenses (user_id, name, amount, date)
VALUES (1, 'خرید روزانه', 45000.00, CURRENT_DATE());

INSERT INTO reminders (user_id, type, reference_id, medium, time, status)
VALUES (1, 'note', 1, 'email', CURRENT_TIMESTAMP(), 'pending');
