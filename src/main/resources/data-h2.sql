INSERT INTO users (username, password, email, phone, name, profile) VALUES ('admin1', 'abc123', 'admin@admin.com', '+556198998988', 'Usuario Administrador', 'ADMIN');
INSERT INTO users (username, password, email, phone, name, profile) VALUES ('manager1', 'abc123', 'manager@manager.com', '+556198998986', 'Usuario Gerente', 'MANAGER');
INSERT INTO users (username, password, email, phone, name, profile) VALUES ('seller1', 'abc123', 'seller@seller.com', '+556198998984', 'Usuario Vendedor', 'SELLER');
INSERT INTO users (username, password, email, phone, name, profile) VALUES ('user1', 'abc123', 'user@user.com', '+556198998983', 'Usuario Comum', 'USER');

INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'Manager role', 'MANAGER');
INSERT INTO role (id, description, name) VALUES (3, 'Seller role', 'SELLER');
INSERT INTO role (id, description, name) VALUES (4, 'User role', 'USER');

INSERT INTO user_roles(user_id, role_id) VALUES (1,1);
INSERT INTO user_roles(user_id, role_id) VALUES (2,2);
INSERT INTO user_roles(user_id, role_id) VALUES (3,3);
INSERT INTO user_roles(user_id, role_id) VALUES (4,4);