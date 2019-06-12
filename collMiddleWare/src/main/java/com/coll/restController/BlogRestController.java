package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.BlogDAO;
import com.coll.model.Blog;

@RestController
public class BlogRestController
{
	@Autowired
	BlogDAO blogDAO;
	
	@GetMapping("/demo")
	public String showdemo()
	{
		return "Hello!! From rest url";
	}
	
	@GetMapping("/showAllBlogs")
	public ResponseEntity<List<Blog>> showAllBlogs()
	{
		List<Blog> listBlogs=blogDAO.listBlogs();
		
		if(listBlogs.size()>0)
		{
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getBlog/{blogid}")
	
		public ResponseEntity<Blog> getBlog(@PathVariable("blogid")int blogid)
		{
		Blog blog=(Blog)blogDAO.getBlog(blogid);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
	
	@PostMapping(value="/addBlog",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setDislikes(0);
		blog.setStatus("NA");
		
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value="/updateBlog/{blogid}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateBlog(@PathVariable("blogid")int blogid)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogid);
		
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(1);
		blog.setDislikes(1);
		blog.setStatus("NA");
		blog.setBlogName("NIITTnagar");
		
		if(blogDAO.updateBlog(blog))
		{
			return new ResponseEntity<String>("Blog Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/deleteBlog/{blogid}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteBlog(@PathVariable("blogid")int blogid)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogid);
		
		if(blogDAO.deleteBlog(blog))
		{
			return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/approveBlog/{blogId}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> approveBlog(@PathVariable("blogId")int blogid)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogid);
		if(blogDAO.approveBlog(blog))
		{
			return new ResponseEntity<String>("Approved",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);				
	}
	
	@GetMapping(value="/rejectBlog/{blogId}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId")int blogid)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogid);
		
		if(blogDAO.rejectBlog(blog))
		{
			return new ResponseEntity<String>("Approved",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);				
	}
	
	@GetMapping(value="/incrementLikes/{blogId}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> incrementLikes(@PathVariable("blogId")int blogId)
	
	{
		if(blogDAO.incrementLikes(blogId))
		{
			return new ResponseEntity<String>("Incremented likes",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/incrementDisLikes/{blogId}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> incrementDisLikes(@PathVariable("blogId")int blogId)
	
	{
		if(blogDAO.incrementDisLikes(blogId))
		{
			return new ResponseEntity<String>("Incremented Dislikes",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
