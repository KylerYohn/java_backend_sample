package levvel.io.controller;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private BlogService blogService;

    @PostMapping("/post")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
        return ResponseEntity.ok().body(blog);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable String id) {
        Blog blog = blogService.getBlog(id);
        return ResponseEntity.ok().body(blog);
    }

    // this will return the comment that the user created with author and the text
    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Comment> addComment(@PathVariable String id, @RequestBody Comment comment) {
        blogService.addComment(id, comment);
        return ResponseEntity.ok().body(comment);

    }

    @GetMapping("post/{id}/comment")
    // this will return the list of all of the comments attached to one blog
    public ResponseEntity<List<Comment>> getComment(@PathVariable String id) {
        // grab the blog with the ID passed in from the parameter
        Blog blog = blogService.getBlog(id);
        // return all of the comments that are attached to that blog
        return ResponseEntity.ok().body(blog.comments);

    }
}
