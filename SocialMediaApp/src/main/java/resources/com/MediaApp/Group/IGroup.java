package resources.com.MediaApp.Group;

import com.MediaApp.ContentManagement.IGroupPost;
import com.MediaApp.ContentManagement.IMediumFactory;
import com.MediaApp.DataHandlers.IDataObject;

import java.util.List;

public interface IGroup extends IDataObject {

    // Getters
    String getGroupId();
    String getName();
    String getDescription();
    String getGroupPhoto();
    String getPrimaryAdminId();
    List<String> getAdminIds();
    List<String> getMemberIds();
    List<String> getPosts();
    List<String> getRequestsUserIDs();

    // Setters
    void setID(String ID);
    void setGroupId(String groupId);
    void setName(String name);
    void setDescription(String description);
    void setGroupPhoto(String groupPhoto);
    void setPrimaryAdminId(String primaryAdminId);
    void setAdminIds(List<String> adminIds);
    void setMemberIds(List<String> memberIds);
    void setPosts(List<String> posts);
    void setRequestsUserIDs(List<String> requestsUserIDs);

    // Clone method
    IGroup clone();
}
