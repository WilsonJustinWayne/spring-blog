USE blogs_db;

INSERT INTO users (username, password, email)
VALUES ('user1', '1', '1@1.1'),
  ('user2', '1', '2@2.2'),
  ('user3', '1', '3@3.3'),
  ('user4', '1', '4@4.4');

INSERT INTO posts (title, body, user_id)
VALUES
  ('Post1', 'Body1', 1),
  ('Post2', 'Body2', 2),
  ('Post3', 'Body3', 3),
  ('Post4', 'Body4', 4);

