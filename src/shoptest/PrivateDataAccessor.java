package shoptest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Slezak Attila on 2016.09.23..
 */
public class PrivateDataAccessor {

    public static Object getObjectFromCertainMethod(String methodName, Method[] methods, Object fromObj)
            throws InvocationTargetException, IllegalAccessException {
        Object result = null;
        for (Method oneMethod : methods) {
            if (oneMethod.getName().equals(methodName)) {
                oneMethod.setAccessible(true);
                result = oneMethod.invoke(fromObj);
                oneMethod.setAccessible(false);
                break;
            }
        }
        return result;
    }

    public static void setObjectInCertainMethod(String methodName, Method[] methods, Object fromObj, Object newObj)
            throws InvocationTargetException, IllegalAccessException {
        for (Method oneMethod : methods) {
            if (oneMethod.getName().equals(methodName)) {
                oneMethod.setAccessible(true);
                oneMethod.invoke(fromObj, newObj);
                oneMethod.setAccessible(false);
                break;
            }
        }
    }
}
