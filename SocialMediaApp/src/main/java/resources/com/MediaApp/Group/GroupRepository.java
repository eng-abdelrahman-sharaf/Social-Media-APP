/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

/**
 *
 * @author ay654
 */
import java.util.*;

public class GroupRepository {
    private static GroupRepository instance;
    private final Map<String, Group> groupStore = new HashMap<>();

    private GroupRepository() {}

    public static GroupRepository getInstance() {
        if (instance == null) {
            synchronized (GroupRepository.class) {
                if (instance == null) {
                    instance = new GroupRepository();
                }
            }
        }
        return instance;
    }

    public void save(Group group) {
        groupStore.put(group.getGroupId(), group);
    }

    public Group findById(String groupId) {
        return groupStore.get(groupId);
    }

    public void delete(String groupId) {
        groupStore.remove(groupId);
    }

    public List<Group> findAll() {
        return new ArrayList<>(groupStore.values());
    }
}
