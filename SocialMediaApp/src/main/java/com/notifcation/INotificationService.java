
package com.notifcation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author abdah
 */
public interface INotificationService {
    void sendNotification(INotification notification);
    public List<INotification> getNotifications(String userId);
}



