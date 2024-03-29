package org.wcci.campuslibraries;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CampusController {
    Map<String, Campus> campuses = new HashMap<>();

    public CampusController(){
        Book book1 =new Book("Head First Java", "Kathy Sierra", "4440333044-2","Good book to learn Java.");
        Book book2 =new Book("Test Driven Development by Example", "Kent Beck", "44443333044-2","Good book to learn TDD.");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        campuses.put("Columbus", new Campus("Columbus", "North Campus", books));
    }

    @RequestMapping("campuses/{campusName}")
    public String showSingleCampus(@PathVariable String campusName, Model model){
        model.addAttribute("campus", campuses.get(campusName));
        return "campus-template";
    }
}
