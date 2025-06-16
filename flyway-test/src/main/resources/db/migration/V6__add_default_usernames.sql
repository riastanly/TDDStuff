UPDATE users
SET username = SUBSTRING(RAND(), 3, 10)
WHERE username IS NULL;
