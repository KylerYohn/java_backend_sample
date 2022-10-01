package levvel.io.service;

import levvel.io.model.Comment;

import levvel.io.model.Blog;

public interface BlogService {

    void addBlog(Blog blog);

    Blog getBlog(String id);

    void addComment(String id, Comment comment);

}
