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

public class GroupFactory implements IGroupFactory {
    @Override
    public Group createGroup(String name, String description, String groupPhoto, String creatorId) {
        return new Group.Builder()
                .setGroupId(UUID.randomUUID().toString())
                .setName(name)
                .setDescription(description)
                .setGroupPhoto(groupPhoto)
                .setPrimaryAdminId(creatorId)
                .addMember(creatorId)
                .build();
    }
}