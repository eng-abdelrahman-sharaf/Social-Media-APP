package resources.com.MediaApp.Group;

import com.MediaApp.DataHandlers.JsonMapStorageHandler;
import com.MediaApp.UserAccountManagement.UserRoleDataBase;

public class test {
    public static void main(String[] args) {

//        System.out.println(UserRoleDataBase.getInstance(null).getData()[0].getUserID());

        new GroupPostServiceImpl().addPost(GroupRepository.getInstance(null).getData()[0].getGroupId() , UserRoleDataBase.getInstance(null).getData()[0].getUserID() ,null  );
    }
}
