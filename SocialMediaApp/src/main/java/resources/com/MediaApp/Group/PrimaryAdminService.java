/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.com.MediaApp.Group;

/**
 *
 * @author ay654
 */
public interface PrimaryAdminService {
    void promoteToAdmin(String groupId, String userId);
    void demoteAdmin(String groupId, String adminId);
    void removeMember(String groupId, String memberId);
    void deleteGroup(String groupId);
}
