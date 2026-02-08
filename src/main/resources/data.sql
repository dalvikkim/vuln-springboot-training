-- A02: 평문 비밀번호 (교육용)
INSERT INTO users (username, password, role) VALUES ('user1', 'password1', 'USER');
INSERT INTO users (username, password, role) VALUES ('admin', 'admin', 'ADMIN');

INSERT INTO documents (title, content, owner_id) VALUES ('Secret Doc 1', 'Content for user 1', 1);
INSERT INTO documents (title, content, owner_id) VALUES ('Secret Doc 2', 'Content for user 2', 2);