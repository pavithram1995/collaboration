package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.ForumCommentDAO;
import com.coll.model.ForumComment;

@RestController
public class ForumCommentRestController 
{
@Autowired 
ForumCommentDAO forumcommentDAO;

@GetMapping("/showAllForumComments")
public ResponseEntity<List<ForumComment>> showAllForums()
{
	List<ForumComment> listForumComment=forumcommentDAO.getForumComments();
	
	if(listForumComment.size()>0)
	{
		return new ResponseEntity<List<ForumComment>>(listForumComment,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<ForumComment>>(listForumComment,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/getForumComment/{commentId}")

	public ResponseEntity<ForumComment> getBlog(@PathVariable("commentId")int commentId)
	{
	ForumComment forumcomment=(ForumComment)forumcommentDAO.getForumComment(commentId);
	
	return new ResponseEntity<ForumComment>(forumcomment,HttpStatus.OK);
	}
}
