DROP TABLE IF EXISTS `todos`;

CREATE TABLE `todos` (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  is_done BOOLEAN NOT NULL DEFAULT 0,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO todos (title, description, is_done)
VALUES
  ('買い物をする', '牛乳、卵、パンを買う', FALSE),
  ('勉強する', '英語と数学の復習をする', FALSE),
  ('メールを送る', '取引先への見積もりを送信する', FALSE);
