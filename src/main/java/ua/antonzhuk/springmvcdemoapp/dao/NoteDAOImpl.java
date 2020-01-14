package ua.antonzhuk.springmvcdemoapp.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import ua.antonzhuk.springmvcdemoapp.model.Note;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NoteDAOImpl implements NoteDAO {

    private JdbcTemplate jdbcTemplate;

    public NoteDAOImpl(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Note note) {
        jdbcTemplate.update(
                "INSERT INTO notes (text, date, time) VALUES (?, ?, ?)",
                note.getText(),
                note.getDate(),
                note.getTime()
        );
    }

    @Override
    public void update(Note note) {
        jdbcTemplate.update(
                "UPDATE notes SET text = ?, date = ?, time = ? WHERE id = ?",
                note.getText(),
                note.getDate(),
                note.getTime(),
                note.getId()
        );
    }

    @Override
    public void delete(int noteId) {
        jdbcTemplate.update(
                "DELETE FROM notes WHERE id = ?",
                noteId
        );
    }

    @Override
    public Note get(int noteId) {
        return jdbcTemplate.query(
                "SELECT * FROM notes WHERE id=" + noteId,
                resultSet -> {
                    return new Note(
                            resultSet.getInt("id"),
                            resultSet.getString("text"),
                            resultSet.getDate("date"),
                            resultSet.getTime("time")
                    );
                }
        );
    }

    @Override
    public List<Note> list() {
        return jdbcTemplate.query(
                "SELECT * FROM notes",
                (resultSet, i) -> new Note(
                        resultSet.getInt("id"),
                        resultSet.getString("text"),
                        resultSet.getDate("date"),
                        resultSet.getTime("time")
                )
        );
    }
}
