package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
