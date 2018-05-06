package gr.aueb.softeng.project1804.memorydao;

import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.project1804.domain.User;

/**
 * Created by Stratos on 5/5/2018.
 */

public class UserDAOMemory {
    public static Map<String, String> user_code_pairs = new HashMap<String, String>();

    public void addPair(String mail, String password){

        user_code_pairs.put("username", mail);
        user_code_pairs.put("password", password);


    }
}
