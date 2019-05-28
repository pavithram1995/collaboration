package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.BlogCommentDAO;

import com.coll.model.BlogComment;

@RestController
public class BlogCommentRestController
{
	@Autowired
	BlogCommentDAO blogcommentDAO;

	@GetMapping("/showAllBlogComments")
	public ResponseEntity<List<BlogComment>> showAllBlogComments()
	{
		List<BlogComment> listBlogs=blogcommentDAO.getBlogComments();
		
		if(listBlogs.size()>0)
		{
			return new ResponseEntity<List<BlogComment>>(listBlogs,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<BlogComment>>(listBlogs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getBlogComment/{commentId}")
	
		public ResponseEntity<BlogComment> getBlog(@PathVariable("commentId")int commentId)
		{
		BlogComment blogcomment=(BlogComment)blogcommentDAO.getBlogComment(commentId);
		return new ResponseEntity<BlogComment>(blogcomment,HttpStatus.OK);
		}
}
