package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.BlogDAO;
import com.coll.model.Blog;

public class BlogDAOTest
{
static BlogDAO blogDAO;
	
	@BeforeClass
	public static void executefirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	
	@Ignore
	@Test
	public void addblogtest() {
		Blog blog=new Blog();
		blog.setBlogName("books");
		blog.setBlogContent("Most useful motivational contents");
		blog.setStatus("NA");
		blog.setLikes(0);
		blog.setDislikes(0);
		blog.setCreateDate(new java.util.Date());
	
		assertTrue("problem in adding blog",blogDAO.addBlog(blog));
	}
	
	@Test
	public void getblogtest()
	{
		assertNotNull("problem in getting blog",blogDAO.getBlog(1002));
	}
	
	@Test
	public void updateblogtest()
	{
		Blog blog=blogDAO.getBlog(1003);
		blog.setUsername("pavithra");
		assertTrue("problem in updating blog",blogDAO.updateBlog(blog));
	}
	@Ignore
	@Test
	public void deleteblogtest() 
	{
		Blog blog=blogDAO.getBlog(1002);
		assertTrue("problem in deleting blog",blogDAO.deleteBlog(blog));
	}
	
	@Test
	public void listblogtest()
	{
		List<Blog> listBlogs=blogDAO.listBlogs();
		for(Blog blog:listBlogs)
		{
			System.out.println("id:"+blog.getBlogid());
		}
	}
	@Ignore
	@Test
	public void incrementlikestest() 
	{
		assertTrue("problem in incrementing likes",blogDAO.incrementLikes(1002));
	}
	
	@Ignore
	@Test
	public void incrementdislikestest() 
	{
		assertTrue("problem in incrementing dislikes",blogDAO.incrementDisLikes(1003));
	}
	@Ignore
	@Test
	public void approveblogtest() 
	{
		Blog blog=blogDAO.getBlog(1002);
		assertTrue("problem in incrementing likes",blogDAO.approveBlog(blog));
	}
	
	@Ignore
	@Test
	public void rejectblogtest()
	{
		Blog blog=blogDAO.getBlog(1003);
		assertTrue("problem in incrementing likes",blogDAO.rejectBlog(blog));
	}
	
}
