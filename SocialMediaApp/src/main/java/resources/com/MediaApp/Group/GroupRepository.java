/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

/**
 *
 * @author ay654
 */
import com.MediaApp.ContentManagement.IPost;
import com.MediaApp.DataHandlers.*;
import com.MediaApp.UserAccountManagement.IUserInfo;

import java.io.IOException;
import java.util.*;

public class GroupRepository extends DataBase<IGroup> {

    private static GroupRepository instance;

    private GroupRepository(MapStorageHandler<String, IGroup> handler) {
        super(handler);
    }

    // Singleton pattern
    public static GroupRepository getInstance(MapStorageHandler<String, IGroup> handler) {
        if (instance == null) {
            instance = new GroupRepository(handler);
        }
        return instance;
    }
    @Override
    public IGroup[] getData() {
        return getObjectsStore().values().stream()
                .map(IGroup::clone)
                .toArray(IGroup[]::new);
    }
}
