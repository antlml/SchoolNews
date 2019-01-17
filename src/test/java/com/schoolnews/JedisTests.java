package com.schoolnews;

import com.schoolnews.dao.CommentDAO;
import com.schoolnews.dao.LoginTicketDAO;
import com.schoolnews.dao.NewsDAO;
import com.schoolnews.dao.UserDAO;
import com.schoolnews.model.*;
import com.schoolnews.util.JedisAdapter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
public class JedisTests {
    @Autowired
    JedisAdapter jedisAdapter;

    @Test
    public void testObject() {
        User user = new User();
        user.setHeadUrl("http://image.schoolnews.com/head/100t.png");
        user.setName("user1");
        user.setPassword("pwd");;
        user.setSalt("salt");

        jedisAdapter.setObject("user1xx", user);

        User u = jedisAdapter.getObject("user1xx", User.class);

        System.out.println(ToStringBuilder.reflectionToString(u));

    }

}
