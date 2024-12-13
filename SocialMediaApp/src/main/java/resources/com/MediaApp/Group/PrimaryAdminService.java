/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

import com.MediaApp.ContentManagement.Content;

/**
 *
 * @author ay654
 */
public interface PrimaryAdminService {
    void promoteToAdmin(String groupId, String userId);
    void demoteAdmin(String groupId, String adminId);
    void removeMember(String groupId, String memberId);
    void deleteGroup(String groupId);
    void editPost(String groupId, String postId, String userId, Content newContent);
    void deletePost(String groupId, String postId, String userId);
}