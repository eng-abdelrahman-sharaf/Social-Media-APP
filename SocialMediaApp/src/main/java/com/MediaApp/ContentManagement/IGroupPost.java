
package com.MediaApp.ContentManagement;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

@JsonDeserialize(as = GroupPost.class)
public interface IGroupPost extends IPost {
    public String getGroupID();
    public void setGroupID(String groupID);
}
//
//class GroupPostDeserializer extends JsonDeserializer<IGroupPost> {
//    @Override
//    public IGroupPost deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
//        JsonNode node = p.getCodec().readTree(p);
//
//        // Assuming your GroupPost has a "content" field, map it here
//        Content content = new Content();
//        content.setText(node.get("content").get("text").asText());
//
//        String attachments
//        if (clientNamesNode != null && clientNamesNode.isArray()) {
//            List<String> clientNames = new ArrayList<>();
//            for (JsonNode clientNameNode : clientNamesNode) {
//                clientNames.add(clientNameNode.asText());  // Add each client name to the list
//            }
//            ((ClientGroupPost) groupPost).setClientNames(clientNames);
//        }
//
//
//        content.setAttachments(node.get("content").get("attachments").as);
//
//
//        return new GroupPost();
//    }
//}