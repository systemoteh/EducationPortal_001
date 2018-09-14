CREATE SCHEMA `education_portal` DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

CREATE TABLE education_portal.users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE education_portal.roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE education_portal.user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),
  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Insert data
-- login: admin     password: admin
-- login: user      password: user
INSERT INTO education_portal.users VALUES (1, 'admin', '$2a$04$cMJ4Hhur5MQuyn41MbNRLOuYyhtq5VUucAf8uw0g.CXbjb.jtWWR2');
INSERT INTO education_portal.users VALUES (2, 'user', '$2a$04$TA3vJwtPAcBzSXBVUFIRou9qymYuKd.qF97Ia8dc1tzRpTss9roTG');
INSERT INTO education_portal.roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO education_portal.roles VALUES (2, 'ROLE_USER');
INSERT INTO education_portal.user_roles VALUES (1, 1);
INSERT INTO education_portal.user_roles VALUES (2, 2);
