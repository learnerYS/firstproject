package com.yesong.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Java8 {
    @Test
    public void test(){
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setAddress("hangzhou");
        user1.setName("yesong");
        User user2 = null;
        users.add(user1);
        users.add(user2);
        ArrayList<User> users1 = new ArrayList<>();
        users.stream().forEach(n -> {
            User user = Optional.ofNullable(n).map(m -> {
                m.setName("zhaojiaxin");
                m.setAddress("beijing");
                return m;
            }).orElse(new User("yesong","hangzhou"));
            users1.add(user);
        });
        Iterator<User> iterator = users1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
