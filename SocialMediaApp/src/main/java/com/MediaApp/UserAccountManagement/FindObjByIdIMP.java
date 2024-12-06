// this class no is no needed any more replaced by UserRole

package com.MediaApp.UserAccountManagement;

import com.MediaApp.DataHandlers.IDataObject;
import java.util.List;

// The code take id as paramter and return tge obj or null if not exissssst 
public class FindObjByIdIMP implements IFindObjById {
    
 @Override
    public IDataObject findObjById(String id, List<IDataObject> list) {
        for (IDataObject obj : list) {
            if (obj.getID().equalsIgnoreCase(id)) {
                return obj; // Return the found object
            }
        }
        return null; // Return null if no match is found
    }
}

