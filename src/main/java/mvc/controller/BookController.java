package mvc.controller;

import mvc.enity.BookEnity;
import mvc.enity.CategoryEntity;

import mvc.repository.BookRepository;
import mvc.repository.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping(value="/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepo categoryRepository;

    @RequestMapping(method = RequestMethod.GET)

    public String showBooks(Model model){
        List<BookEnity> bookEntityList = (List<BookEnity>) bookRepository.findAll();
        model.addAttribute("bookList", bookEntityList);
        return "Book/home";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search (@RequestParam("searchInput") String searchInput, Model model){
        List<BookEnity> resultList;
        if (searchInput.isEmpty()){
            resultList = (List<BookEnity>) bookRepository.findAll();
        }else {
            resultList = bookRepository.findByNameContainingOrAuthorContaining(searchInput, searchInput);
        }
        model.addAttribute("bookList", resultList);
        return "Book/home";
    }
    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public String showNewBook(Model model){
        model.addAttribute("book", new BookEnity());
        model.addAttribute("msg", "Add a new book");
        model.addAttribute("action", "newBook");

        setCategoryDropDownlist(model);
        return "Book/book";
    }

    @RequestMapping(value = "/newBook", method = POST, produces = "text/plain;charset=UTF-8")
    public String saveBook(BookEnity book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = GET)
    public String showEditBook(Model model, @PathVariable int id){
        model.addAttribute("book", bookRepository.findById(id).get());
        model.addAttribute("msg", "Update book information");
        model.addAttribute("type", "update");
        model.addAttribute("action", "/updateBook");

        setCategoryDropDownlist(model);
        return "Book/book";
    }
    @RequestMapping(value = "/updateBook", method = POST)
    public String updateBook(@ModelAttribute BookEnity book){
        bookRepository.save(book);
        return "redirect:/";

    }
    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteBook(@PathVariable  int id){
        bookRepository.deleteById(id);
        return "redirect:/";

    }
    @InitBinder
    public void innitBinder(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    private void setCategoryDropDownlist (Model model){
        List<CategoryEntity> cateList = (List<CategoryEntity>) categoryRepository.findAll();
        if (!cateList.isEmpty()){
            Map<Integer, String> cateMap = new LinkedHashMap<>();
            for (CategoryEntity categoryEntity : cateList){
                cateMap.put(categoryEntity.getId(), categoryEntity.getName());
            }
            model.addAttribute("categoryList", cateMap);
        }
    }
}