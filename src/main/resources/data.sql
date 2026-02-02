-- CATEGORIES
INSERT INTO categories (id, name) VALUES (1, 'Programming');

-- USERS
INSERT INTO users (id, name, email, role) VALUES
  (1, 'Teacher One', 'teacher@example.com', 'TEACHER'),
  (2, 'Student One', 'student@example.com', 'STUDENT');

-- COURSE
INSERT INTO courses (id, title, description, teacher_id, category_id) VALUES
  (1, 'Hibernate Basics', 'Intro course to Hibernate and JPA', 1, 1);

-- MODULES (без description!)
INSERT INTO modules (id, title, order_index, course_id) VALUES
  (1, 'Module 1: ORM basics', 1, 1),
  (2, 'Module 2: Hibernate sessions', 2, 1);

-- LESSONS
INSERT INTO lessons (id, title, content, video_url, module_id) VALUES
  (1, 'Lesson 1: Entities', 'What is an entity. @Entity basics.', NULL, 1),
  (2, 'Lesson 2: Relations', 'OneToMany / ManyToOne / ManyToMany.', NULL, 1),
  (3, 'Lesson 3: Lazy loading', 'LazyInitializationException and fixes.', NULL, 2);

-- ENROLLMENTS (без status!)
INSERT INTO enrollments (id, user_id, course_id, enrolled_at) VALUES
  (1, 2, 1, CURRENT_DATE);

-- TAGS + M-M course_tag
INSERT INTO tags (id, name) VALUES
  (1, 'hibernate'),
  (2, 'jpa');

INSERT INTO course_tag (course_id, tag_id) VALUES
  (1, 1),
  (1, 2);

-- PROFILE 1-1
INSERT INTO profiles (id, user_id, avatar_url, bio) VALUES
  (1, 2, NULL, 'Student profile bio');

-- ASSIGNMENT + SUBMISSION
INSERT INTO assignments (id, title, description, due_date, max_score, lesson_id) VALUES
  (1, 'HW1: Entities', 'Create 3 entities and relations', CURRENT_DATE, 100, 1);

INSERT INTO submissions (id, content, submitted_at, score, feedback, assignment_id, student_id) VALUES
  (1, 'My solution text...', CURRENT_TIMESTAMP, 90, 'Good job', 1, 2);

-- QUIZ + QUESTIONS + OPTIONS + QUIZ_SUBMISSION
INSERT INTO quizzes (id, title, time_limit, module_id) VALUES
  (1, 'Quiz: ORM Basics', 10, 1);

INSERT INTO questions (id, text, type, quiz_id) VALUES
  (1, 'What annotation marks an entity?', 'SINGLE', 1);

INSERT INTO answer_options (id, text, is_correct, question_id) VALUES
  (1, '@Entity', TRUE, 1),
  (2, '@Table', FALSE, 1);

INSERT INTO quiz_submissions (id, score, taken_at, quiz_id, student_id) VALUES
  (1, 1, CURRENT_TIMESTAMP, 1, 2);

-- COURSE REVIEW
INSERT INTO course_reviews (id, rating, comment, created_at, course_id, student_id) VALUES
  (1, 5, 'Nice course', CURRENT_TIMESTAMP, 1, 2);