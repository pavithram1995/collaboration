package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/listBlogComments/{blogId}")
	public ResponseEntity<List<BlogComment>> listBlogComments(@PathVariable("blogId")int blogId)
	{
		List<BlogComment> listBlogs=blogcommentDAO.listBlogComments(blogId);
		
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
	
	
	@PostMapping(value="/addBlogComment",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blogComment)
	{
	
		blogComment.setCommentDate(new java.util.Date());
					
		if(blogcommentDAO.addBlogComment(blogComment))
		{
			return new ResponseEntity<String>("Blog comment Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping(value="/deleteBlogComment/{commentId}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteBlogComment(@PathVariable("commentId")int commentId)
	{
		BlogComment blogcomment=(BlogComment)blogcommentDAO.getBlogComment(commentId);
				
		if(blogcommentDAO.deleteBlogComment(blogcomment))
		{
			return new ResponseEntity<String>("Blog Comment Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value="/updateBlogComment/{commentId}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateBlog(@PathVariable("commentId")int commentId)
	{
		BlogComment blogcomment=(BlogComment)blogcommentDAO.getBlogComment(commentId);
		blogcomment.setBlogComment("nice");
				
		if(blogcommentDAO.updateBlogComment(blogcomment))
		{
			return new ResponseEntity<String>("Blog Comment Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
}
