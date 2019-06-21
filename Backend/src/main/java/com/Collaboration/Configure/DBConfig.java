package com.Collaboration.Configure;

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

import com.Collaboration.dao.BlogCommentDAO;
import com.Collaboration.dao.BlogCommentDAOImpl;
import com.Collaboration.dao.BlogDAO;
import com.Collaboration.dao.BlogDAOImpl;
import com.Collaboration.dao.ForumCommentDAO;
import com.Collaboration.dao.ForumCommentDAOImpl;
import com.Collaboration.dao.ForumDAO;
import com.Collaboration.dao.ForumDAOImpl;
import com.Collaboration.dao.FriendDAO;
import com.Collaboration.dao.FriendDAOImpl;
import com.Collaboration.dao.JobDAO;
import com.Collaboration.dao.JobDAOImpl;
import com.Collaboration.dao.UserDetailDAO;
import com.Collaboration.dao.UserDetailDAOImpl;
import com.Collaboration.model.Blog;
import com.Collaboration.model.BlogComment;
import com.Collaboration.model.Forum;
import com.Collaboration.model.ForumComment;
import com.Collaboration.model.Friend;
import com.Collaboration.model.Job;
import com.Collaboration.model.ProfilePicture;
import com.Collaboration.model.UserDetail;



@Configuration
@EnableTransactionManagement
@ComponentScan("com.Collaboration.*")
public class DBConfig 
{
	@Bean(name="datasource")
	public DataSource getoracleDataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:JOE");
		datasource.setUsername("joe");
		datasource.setPassword("joe");
		System.out.println(">>>>>>Datasource object created<<<<<<");
		return datasource;
	}

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateprop=new Properties();
		
		hibernateprop.put("hibernate.hbm2ddl.auto","update");
		hibernateprop.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getoracleDataSource());

		factory.addProperties(hibernateprop);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Blog.class);
		factory.addAnnotatedClass(BlogComment.class);
		factory.addAnnotatedClass(Forum.class);
		factory.addAnnotatedClass(ForumComment.class);
		factory.addAnnotatedClass(Friend.class);
		factory.addAnnotatedClass(Job.class);
		factory.addAnnotatedClass(ProfilePicture.class);
		
		System.out.println(">>>>>>SessionFactory Object created<<<<<<");

		return factory.buildSessionFactory();
		
	}
@Bean(name="TransactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	System.out.println(">>>>>TransactionManager Object created<<<<<<");
	return new HibernateTransactionManager(sessionFactory);
}
@Bean(name="userdetailDAO") 
public UserDetailDAO getUserDetailDAO() {
	return new UserDetailDAOImpl();
}
@Bean(name="blogDAO") 
public BlogDAO getBlogDAO() {
	return new BlogDAOImpl();
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
