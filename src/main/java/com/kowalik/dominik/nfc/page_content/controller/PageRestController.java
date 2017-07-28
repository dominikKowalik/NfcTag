package com.kowalik.dominik.nfc.page_content.controller;

import com.kowalik.dominik.nfc.page_content.domain.Page;
import com.kowalik.dominik.nfc.page_content.exception.DocumentNotFoundException;
import com.kowalik.dominik.nfc.page_content.repository.PageMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by dominik on 28.07.17.
 */
@RestController
@RequestMapping(value = "/page")
public class PageRestController {
    PageMongoRepository pageMongoRepository;

    @Autowired
    public PageRestController(PageMongoRepository pageMongoRepository){
        this.pageMongoRepository = pageMongoRepository;
    }

    @PostMapping
    public Page save(@Valid @RequestBody Page page){
        return pageMongoRepository.save(page);
    }

    @GetMapping(value = "/{id}")
    public Page find(@PathVariable("id") Long id){
        Page page = pageMongoRepository.findOne(id);
        return Optional.ofNullable(page).orElseThrow(() -> new DocumentNotFoundException("Page with id: " + id + " can not be found."));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Page> find(){
        return pageMongoRepository.findAll();
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String documentNotFoundExceptionHandler(DocumentNotFoundException ex){
        return ex.toString();
    }
}
