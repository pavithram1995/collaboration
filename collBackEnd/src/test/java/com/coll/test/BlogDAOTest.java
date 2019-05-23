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
	
	
	@Test
	public void addblogtest() {
		Blog blog=new Blog();
		blog.setBlogName("new blog");
		blog.setBlogContent("third content");
		blog.setCreateDate(new java.util.Date());
	
		assertTrue("problem in adding blog",blogDAO.addBlog(blog));
	}
	
	@Test
	public void getblogtest() {
		assertNotNull("problem in getting blog",blogDAO.getBlog(1001));
	}
	@Ignore
	@Test
	public void updateblogtest() {
		Blog blog=blogDAO.getBlog(1001);
		blog.setBlogName("second blog");
		blog.setBlogContent("Second");
		blog.setLikes("1");
		assertTrue("problem in updating blog",blogDAO.updateBlog(blog));
	}
	@Ignore
	@Test
	public void deleteblogtest() {
		Blog blog=blogDAO.getBlog(1002);
		assertTrue("problem in deleting blog",blogDAO.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void listblogtest() {
		List<Blog> listBlogs=blogDAO.listBlogs();
		for(Blog blog:listBlogs) {
			System.out.println("id:"+blog.getBlogid());
		}
	}
	@Test
	public void incrementlikestest() 
	{
		assertTrue("problem in incrementing likes",blogDAO.incrementLikes(1001));
	}
	@Test
	public void incrementdislikestest() {
		assertTrue("problem in incrementing likes",blogDAO.incrementDisLikes(1001));
	}
	@Test
	public void approveblogtest() {
		assertTrue("problem in incrementing likes",blogDAO.approveBlog(1001));
	}
	@Test
	public void rejectblogtest() {
		assertTrue("problem in incrementing likes",blogDAO.rejectBlog(1001));
	}
	
}
