package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Activity;
import cs319.spring.proje.berk.entity.Comment;
import cs319.spring.proje.berk.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> listAllComments() {
        return commentRepository.findAll();
    }

    public Comment getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);

        if(comment == null)
            throw new IllegalStateException("comment does not exist");

        return comment;
    }

    @Transactional
    public void addNewComment(Comment comment) {
        Comment commentById = null;
        if(comment.getId() != null)
            commentById = commentRepository.findById(comment.getId()).orElse(null);

        if(commentById != null) {
            commentById.setTextComment(comment.getTextComment());
            commentById.setStudent(comment.getStudent());
        }

        else
            commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);

        if(comment == null)
            throw new IllegalStateException("comment does not exist");

        commentRepository.deleteById(commentId);
    }

    // TODO: Check logic of this method, check comment attributes

    @Transactional
    public void addActivityToComment(Activity activity, Comment comment) {
        List<Comment> commentList = activity.getCommentList();

        // if comment is in activity's comment list, add activity to that comment
        for (Comment value : commentList) {
            if (Objects.equals(value.getId(), comment.getId())) {
                comment.setActivity(activity);
            }
        }
    }
}
