package ua.antonzhuk.springmvcdemoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.antonzhuk.springmvcdemoapp.dao.NoteDAO;
import ua.antonzhuk.springmvcdemoapp.model.Note;

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

    @RequestMapping(value = "/saveNote", method = RequestMethod.POST)
    public ModelAndView saveNote(@ModelAttribute Note note) {
        note.setDate(new Date(new java.util.Date().getTime()));
        note.setTime(new Time(new java.util.Date().getTime()));
        noteDAO.save(note);
        return new ModelAndView("redirect:/");
    }

}
