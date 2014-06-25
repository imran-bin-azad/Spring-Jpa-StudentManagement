package net.therap.controller;

import net.therap.controller.util.ClassParser;
import net.therap.domain.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by imran.azad on 6/24/14.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public ModelAndView redirectToAddPage(ModelMap model) {
        List<String> fieldsOfTeacher = ClassParser.getDeclaredFieldNamesOf(Teacher.class);
        fieldsOfTeacher.remove("id");
        System.out.println("Fields of Teacher : " + fieldsOfTeacher);

//        model.addAttribute("teacher", new Teacher());
        return new ModelAndView("teacher/add", "teacher", new Teacher());
//        model.addAttribute("fieldsOfTeacher", fieldsOfTeacher);
//        return "teacher/add";

    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public String onSubmit(@Valid @ModelAttribute("teacher") Teacher teacher,
                           BindingResult bindingResult,
                           ModelMap model) {
        if(bindingResult.hasErrors()){
            logger.info("Total errors : " + bindingResult.getFieldErrorCount());
            logger.info(bindingResult.getFieldErrors().toString());
            return "teacher/add";
        }
        return "teacher/showAll";
    }
}
