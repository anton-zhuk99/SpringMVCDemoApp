package ua.antonzhuk.springmvcdemoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.antonzhuk.springmvcdemoapp.dao.NoteDAO;
import ua.antonzhuk.springmvcdemoapp.model.Note;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private NoteDAO noteDAO;

    @RequestMapping("/")
    public ModelAndView listNotes(ModelAndView modelAndView) throws IOException {
        List<Note> noteList = noteDAO.list();
        modelAndView.addObject("noteList", noteList);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value="/addNewNote", method=RequestMethod.GET)
    public ModelAndView addNewNote(ModelAndView modelAndView) {
        Note note = new Note();
        modelAndView.addObject("note", note);
        modelAndView.setViewName("newNoteForm");
        return modelAndView;
    }

    @RequestMapping(value="/editNote", method=RequestMethod.GET)
    public ModelAndView editNote(HttpServletRequest request) {
        Note note = noteDAO.get(
                Integer.parseInt(request.getParameter("id"))
        );

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("note", note);
        modelAndView.setViewName("editNoteForm");
        return modelAndView;
    }

    @RequestMapping(value = "/saveNote", method = RequestMethod.POST)
    public ModelAndView saveNote(@ModelAttribute Note note) {
        note.setDate(new Date(new java.util.Date().getTime()));
        note.setTime(new Time(new java.util.Date().getTime()));
        noteDAO.save(note);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/updateNote", method = RequestMethod.POST)
    public ModelAndView updateNote(@ModelAttribute Note note) {
        note.setDate(note.getDate());
        note.setTime(note.getTime());
        noteDAO.update(note);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteNote", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        noteDAO.delete(id);
        return new ModelAndView("redirect:/");
    }

}
