// // this interface is no needed any more replaced by UserRole

package com.MediaApp.UserAccountManagement;

import com.MediaApp.DataHandlers.IDataObject;
import java.util.List;

/**
 *
 * @author abdah
 */
public interface IFindObjById {
    IDataObject findObjById(String id, List<IDataObject> list);

}
