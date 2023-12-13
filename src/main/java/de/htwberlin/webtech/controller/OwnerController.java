package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.entity.*;
import de.htwberlin.webtech.repository.BlogRepository;
import de.htwberlin.webtech.repository.FileRepository;
import de.htwberlin.webtech.repository.OwnerRepository;
import de.htwberlin.webtech.repository.PatientRepository;
import de.htwberlin.webtech.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping("/saveOwner")
    public String saveOwner(@RequestBody Owner owner) {
        System.out.println("Owner save called...");

        // a new Owner
        Owner ownerIn = new Owner(owner.getName(), owner.getEmail());

        // list of Blog
        List<Blog> blogs = new ArrayList<>();
        for (Blog blogIn : owner.getBlogList()) {
            // new Blog
            Blog blog = new Blog(blogIn.getTitle(), blogIn.getCategory(), blogIn.getContent());
            // set owner to Blog
            blog.setOwner(ownerIn);
            // add blog to list
            blogs.add(blog);
        }

        // add blog list to Owner
        ownerIn.setBlogList(blogs);

        // save Owner
        Owner ownerOut = ownerRepository.save(ownerIn);
        System.out.println("Owner out :: " + ownerOut);

        System.out.println("Saved!!!");
        return "Owner saved!!!";
    }

    @PostMapping("/saveBlog")
    public String saveBlog(@RequestParam(name = "id") String id) {
        System.out.println("Blog save called...");

        // fetch Ower
        Owner ownerTemp = ownerRepository.getById(Integer.valueOf(id));

        // list of Blog
        List<Blog> blogs = new ArrayList<>();

        // new Blog
        Blog blog = new Blog("Build application server using NodeJs", "nodeJs",
                "We will build REStful api using nodeJs.");
        // set owner to blog
        blog.setOwner(ownerTemp);
        // add Blog to list
        blogs.add(blog);

        blog = new Blog("Single Page Application using Angular", "Angular",
                "We can build robust application using Angular framework.");
        // set owner to blog
        blog.setOwner(ownerTemp);
        blogs.add(blog);

        // add Blog list to Owner
        ownerTemp.setBlogList(blogs);

        // save Owner
        ownerRepository.save(ownerTemp);

        System.out.println("Saved!!!");
        return "Blog saved!!!";
    }

    @GetMapping("/getOwner/{id}")
    public String getOwner(@PathVariable(name = "id") String id) {
        System.out.println("Owner get called...");

        // fetch Owner
        Owner ownerOut = ownerRepository.getById(Integer.valueOf(id));
        System.out.println("\nOwner details :: \n" + ownerOut);
        System.out.println("\nList of Blogs :: \n" + ownerOut.getBlogList());

        System.out.println("\nDone!!!");
        return "Owner fetched...";
    }

    @GetMapping("/getBlog/{id}")
    public String getBlog(@PathVariable(name = "id") String id) {
        System.out.println("Blog get called...");

        // fetch Blog
        Blog blogOut = blogRepository.getById(Integer.valueOf(id));
        System.out.println("\nBlog details :: \n" + blogOut);
        System.out.println("\nOwner details :: \n" + blogOut.getOwner());

        System.out.println("\nDone!!!");
        return "Blog fetched...";
    }
}
