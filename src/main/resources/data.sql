
CREATE TABLE TB_USER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) DEFAULT NULL
);

INSERT INTO TB_USER (first_name, last_name, email) VALUES ('Carlos', 'Perez', 'perez@app.com.ar');
INSERT INTO TB_USER (first_name, last_name, email) VALUES ('Bill', 'Gates', 'gates@app.com.ar');
INSERT INTO TB_USER (first_name, last_name, email) VALUES ('Juana', 'Reyna', 'reyna@app.com.ar');
INSERT INTO TB_USER (first_name, last_name, email) VALUES ('Maria', 'gonzalez', 'gonzalez@app.com.ar');
INSERT INTO TB_USER (first_name, last_name, email) VALUES ('Julian', 'Alvarez', 'alvarez@app.com.ar');
INSERT INTO TB_USER (first_name, last_name, email) VALUES ('Pedro', 'Garcia', 'garcia@app.com.ar');

CREATE TABLE TB_LOAN (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  total DECIMAL(19, 2) NOT NULL,
  user_id int NOT NULL 
);

INSERT INTO TB_LOAN (total, user_id) VALUES (2500, 1);
INSERT INTO TB_LOAN (total, user_id) VALUES (65120.75, 2);
INSERT INTO TB_LOAN (total, user_id) VALUES (35698, 2);
INSERT INTO TB_LOAN (total, user_id) VALUES (4569836, 3);
INSERT INTO TB_LOAN (total, user_id) VALUES (458962, 4);
INSERT INTO TB_LOAN (total, user_id) VALUES (458633, 5);
INSERT INTO TB_LOAN (total, user_id) VALUES (596253.45, 6);
  
  
 
  
 
  