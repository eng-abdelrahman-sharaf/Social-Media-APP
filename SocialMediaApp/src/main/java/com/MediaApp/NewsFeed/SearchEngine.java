package com.MediaApp.NewsFeed;

import com.MediaApp.DataHandlers.IDataObject;
import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.DataHandlers.MapStorageHandler;
import com.MediaApp.UserAccountManagement.IUserInfo;
import com.MediaApp.UserAccountManagement.UserInfo;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private String query;
    private String type;

    public SearchEngine() {
    }

    public List<UserInfo> search(String query, String type) {
        List<UserInfo> results = new ArrayList<>();
        if (type.equalsIgnoreCase("users")) {
            MapStorageHandler<String, IUserInfo> userHandler = new JsonMapStorageHandler<>(String.class, UserInfo.class, "user.json");
            UserRoleDataBase.getInstance(userHandler);
            IUserInfo[] users = UserRoleDataBase.getInstance(null).getData();


                for (IUserInfo user :  users) {
                    if (((UserInfo)user).getName().toLowerCase().contains(query.toLowerCase())) {
                        results.add((UserInfo)user);
                    }
                }
            } else {
                throw new IllegalArgumentException("Unexpected data type returned by UserRoleDataBase.");
            }

        return results;
    }

    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        List<UserInfo> results = searchEngine.search("a","users");

        for(UserInfo user: results)
            System.out.println(" "+user);

    }
}
