package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.BlogCommentDAO;
import com.coll.model.BlogComment;

public class BlogCommentDAOTest 
{
static BlogCommentDAO blogcommentDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogcommentDAO=(BlogCommentDAO)context.getBean("blogcommentDAO");
	}
	@Ignore
	@Test
	public void addblogcommenttest() {
		BlogComment blogcomment=new BlogComment();
		blogcomment.setBlogId(1002);
		blogcomment.setBlogComment("good");
		blogcomment.setCommentDate(new java.util.Date());
		blogcomment.setUsername("pavithra");
		assertTrue("problem in adding blog comment",blogcommentDAO.addBlogComment(blogcomment));
	}
	@Ignore
	@Test
	public void getblogcommenttest() {
		assertNotNull("problem in getting blogcomment",blogcommentDAO.getBlogComment(501));
	}
	
	@Test
	public void updateblogcommenttest() {
		BlogComment blogcomment=blogcommentDAO.getBlogComment(1002);
		blogcomment.setBlogId(1003);
		assertTrue("problem in adding blog comment",blogcommentDAO.updateBlogComment(blogcomment));
	}
	@Ignore
	@Test
	public void deleteblogcomment() {
		BlogComment blogcomment=blogcommentDAO.getBlogComment(501);
		assertTrue("problem in deleting blog comment",blogcommentDAO.deleteBlogComment(blogcomment));
	}
	@Test
	public void listblogcomment() {
		List<BlogComment> listComments=blogcommentDAO.getBlogComments();
	    for(BlogComment blogcomment:listComments) {
	    	System.out.println("id:"+blogcomment.getCommentId());
	    }
	}
}
