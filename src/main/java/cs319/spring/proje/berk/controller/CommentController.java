package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.Comment;
import cs319.spring.proje.berk.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path = "listAllComments")
    public List<Comment> listAllComments() {
        return commentService.listAllComments();
    }

    @GetMapping(path = "getComment/{commentId}")
    public Comment getComment(@PathVariable("commentId") Long commentId) {
        return commentService.getComment(commentId);
    }

    @PutMapping(path = "addNewComment")
    public void addNewComment(@RequestBody Comment comment) {
        commentService.addNewComment(comment);
    }

    @DeleteMapping(path = "deleteComment/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
    }
}
