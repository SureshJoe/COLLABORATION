package com.Collaboration.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Collaboration.dao.BlogCommentDAO;
import com.Collaboration.model.BlogComment;

@RestController
public class BlogCommentRestController {

	@Autowired
	BlogCommentDAO blogcommentDAO;
	
	@GetMapping("/getBlogComments") 
	public ResponseEntity<List<BlogComment>> getBlogComments() 
	{
		List<BlogComment> listBlogComments=blogcommentDAO.getBlogComments();
		if(listBlogComments.size()>0) {
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getBlogComment/{commentId}") 
	public ResponseEntity<BlogComment> getBlogComment(@PathVariable("commentId") int commentId)
	{
		BlogComment blogcomment=blogcommentDAO.getBlogComment(commentId);
		return new ResponseEntity<BlogComment>(blogcomment,HttpStatus.OK);
	}
}
