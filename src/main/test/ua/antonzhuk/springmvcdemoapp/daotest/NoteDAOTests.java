package ua.antonzhuk.springmvcdemoapp.daotest;

import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ua.antonzhuk.springmvcdemoapp.dao.NoteDAO;
import ua.antonzhuk.springmvcdemoapp.dao.NoteDAOImpl;
import ua.antonzhuk.springmvcdemoapp.model.Note;

import javax.sql.DataSource;

public class NoteDAOTests {

    @Test
    public void testCRUD() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/notes_db");
        dataSource.setUsername("root");
        dataSource.setPassword("olenenok1009");

        NoteDAO noteDAO = new NoteDAOImpl(dataSource);
        noteDAO.save(new Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Vivamus scelerisque erat nec arcu volutpat pharetra. " +
                "Etiam non ullamcorper turpis, vitae porttitor est. In et varius tellus. Maecenas ut diam eu."));

    }


}