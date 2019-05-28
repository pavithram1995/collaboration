package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.ForumDAO;
import com.coll.model.Forum;

@RestController
public class ForumRestController 
{
	
		@Autowired
		ForumDAO forumDAO;
		
		@GetMapping("/showAllForum")
		public ResponseEntity<List<Forum>> showAllForums()
		{
			List<Forum> listForums=forumDAO.getForums();
			
			if(listForums.size()>0)
			{
				return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<List<Forum>>(listForums,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/getBlog/{forumId}")
		
			public ResponseEntity<Forum> getForum(@PathVariable("forumId")int forumId)
			{
			Forum forum=(Forum)forumDAO.getForum(forumId);
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
			}
	}

