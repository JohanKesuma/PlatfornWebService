/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.UserHelper;
import java.util.List;
import pojos.User;

/**
 *
 * @author Johan
 */
public class TestUser {
    public static void main(String[] args) {
        UserHelper test = new UserHelper();
        List<User> list = test.getAllUser();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}