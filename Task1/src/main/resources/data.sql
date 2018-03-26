INSERT INTO users
(id, email, password, status, role)
  SELECT
    1,
    'admin@admin.com',
    '$2a$10$5Mn/h9QquCaVBZF4BOyx5O4Ar2y6HUtdn8YIxN2Ht8vTPcdG5IxEW',
    'CONFIRMED',
    'ADMIN'
  WHERE
    NOT EXISTS(
        SELECT id
        FROM users
        WHERE id = 1
    );

CREATE TABLE IF NOT EXISTS persistent_logins (
  username  VARCHAR(64)             NOT NULL,
  series    VARCHAR(64) PRIMARY KEY NOT NULL,
  token     VARCHAR(64)             NOT NULL,
  last_used TIMESTAMP               NOT NULL
)