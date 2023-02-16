package next.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.ResultSetMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import next.model.Question;
import next.model.User;

public class QuestionDao {
    static final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public static void insert(Question question) throws SQLException {
        String sql = "INSERT INTO QUESTIONS(writer, title, contents, createdDate, countOfAnswer) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(sql,
                question.getWriter(),
                question.getTitle(),
                question.getContents(),
                question.getCreatedDate(),
                question.getCountOfAnswer());
    }

    public static List<Question> findAll() throws SQLException {
        ResultSetMapper<List<Question>> resultSetMapper = rs -> {
            List<Question> questions = new ArrayList<>();
            while (rs.next()) {
                questions.add(new Question(
                        rs.getLong("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getInt("countOfAnswer"),
                        rs.getTimestamp("createdDate")
                ));
            }
            return questions;
        };

        String sql = "SELECT questionId, writer, title, contents, countOfAnswer, createdDate FROM QUESTIONS";
        return jdbcTemplate.select(sql, resultSetMapper);
    }

    public static Question findByQuestionId(Long questionId) throws SQLException {
        ResultSetMapper<Question> resultSetMapper = rs -> {
            if (rs.next()) {
                return new Question(
                        rs.getLong("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getInt("countOfAnswer"),
                        rs.getTimestamp("createdDate")
                );
            }
            return null;
        };

        String sql = "SELECT questionId, writer, title, contents, countOfAnswer, createdDate FROM QUESTIONS WHERE questionId = ?";
        return jdbcTemplate.select(sql, resultSetMapper, questionId);
    }

    public static int update(Question question) throws SQLException {
        String sql = "UPDATE QUESTIONS SET title=?, contents=?, countOfAnswer=? WHERE questionId = ?";
        return jdbcTemplate.executeUpdate(sql,
                question.getTitle(),
                question.getContents(),
                question.getCountOfAnswer(),
                question.getQuestionId());
    }

    public static int deleteAll() throws SQLException {
        String sql = "DELETE FROM QUESTIONS";
        return jdbcTemplate.executeUpdate(sql);
    }
}
