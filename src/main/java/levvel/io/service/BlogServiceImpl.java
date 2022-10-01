package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlog(String id) {
        return blogRepository.findById(id).orElseGet(null);
    }

    @Override
    public void addComment(String id, Comment comment) {
        // find the specific blog with its Id and Store it in a variable
        Blog blogComment = blogRepository.findById(id).orElseGet(null);
        // add the comments to the blog
        blogComment.comments.add(comment);
        // update and resave that blog in the database
        blogRepository.save(blogComment);
    }

    public void getComments(String id) {
        Blog blog = blogRepository.findById(id).orElseGet(null);
        for (int i = 0; i <= blog.comments.size(); i++)
            System.out.println(blog.comments.get(i));
    }

}
