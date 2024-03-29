package com.mresitcagan.blog.config;

import com.mresitcagan.blog.model.Account;
import com.mresitcagan.blog.model.Post;
import com.mresitcagan.blog.service.AccountService;
import com.mresitcagan.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception{
        List<Post> posts = postService.getAll();

        if (posts.isEmpty()){
            Account account1 = new Account();
            account1.setEmail("mresitcagan@gmail.com");
            account1.setPassword("password");
            account1.setFirstName("user");
            account1.setLastName("user");
            accountService.save(account1);

            Account account2 = new Account();
            account2.setEmail("mresitcagan@outlook.com");
            account2.setPassword("password");
            account2.setFirstName("admin");
            account2.setLastName("admin");
            accountService.save(account2);


            Post post1 = new Post();
            post1.setTitle("title article 1");
            post1.setBody("Content of article 1");
            post1.setAccount(account1);
            postService.save(post1);

            Post post2 = new Post();
            post2.setTitle("title article 2");
            post2.setBody("Content of article 2");
            post2.setAccount(account2);
            postService.save(post2);
        }
    }
}
