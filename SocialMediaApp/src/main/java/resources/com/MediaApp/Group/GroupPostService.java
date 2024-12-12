/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

/**
 *
 * @author ay654
 */
import com.MediaApp.ContentManagement.Content;

public interface GroupPostService {
    void addPost(String groupId, String authorId, Content content);
    void editPost(String groupId, String postId, String userId, Content newContent);
    void deletePost(String groupId, String postId, String userId);
}