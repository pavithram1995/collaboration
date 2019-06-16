package com.coll.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.DAO.BlogCommentDAO;
import com.coll.DAO.BlogCommentDAOImpl;
import com.coll.DAO.BlogDAO;
import com.coll.DAO.BlogDAOImpl;
import com.coll.DAO.ForumCommentDAO;
import com.coll.DAO.ForumCommentDAOImpl;
import com.coll.DAO.ForumDAO;
import com.coll.DAO.ForumDAOImpl;
import com.coll.DAO.FriendDAO;
import com.coll.DAO.FriendDAOImpl;
import com.coll.DAO.JobDAO;
import com.coll.DAO.JobDAOImpl;
import com.coll.DAO.UserDetailDAO;
import com.coll.DAO.UserDetailDAOImpl;
import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Forum;
import com.coll.model.ForumComment;
import com.coll.model.Friend;
import com.coll.model.Job;
import com.coll.model.ProfilePicture;
import com.coll.model.UserDetail;



@Configuration
@ComponentScan
@EnableTransactionManagement


public class DBConfig 
{
	
	@Bean (name="dataSource")
	public DataSource getDataSource()
	{
		System.out.println("Data Source Object Creating");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORACLE");
		dataSource.setUsername("coll");
		dataSource.setPassword("coll");
		System.out.println("Data Source Object Created");
		return dataSource;
	}
	
	private Properties getHibernateProperties() 
	{
		System.out.println("Hibernate Properties Object Creating");
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto","update");
	
		
		
		System.out.println("Hibernate Properties Object Created");
		System.out.println("Table Source Created");
		
		return properties;
	}
	
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		System.out.println("Session Factory Object Creating");
		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(UserDetail.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(ForumComment.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(ProfilePicture.class);
		
		System.out.println("Session Factory Object Created");
		return sessionBuilder.buildSessionFactory();
	}	
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		System.out.println("Transaction Manager Object Creating");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction Manager Object Created");
		return transactionManager;
	}
	@Bean(name="blogDAO") 
	public BlogDAO getBlogDAO()
	{
		return new BlogDAOImpl();
	}
	@Bean(name="userdetailDAO") 
	public UserDetailDAO getUserDetailDAO() {
		return new UserDetailDAOImpl();
	}
	@Bean(name="blogcommentDAO") 
	public BlogCommentDAO getBlogCommentDAO() {
		return new BlogCommentDAOImpl();
	}
	@Bean(name="forumDAO") 
	public ForumDAO getForumDAO() {
		return new ForumDAOImpl();
	}
	@Bean(name="forumcommentDAO") 
	public ForumCommentDAO getForumCommentDAO() {
		return new ForumCommentDAOImpl();
	}
	@Bean(name="friendDAO") 
	public FriendDAO getFriendDAO() {
		return new FriendDAOImpl();
	}
	@Bean(name="jobDAO") 
	public JobDAO getJobDAO() {
		return new JobDAOImpl();
	}

}
