package shoptest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Slezak Attila on 2016.09.23..
 */
class PrivateDataAccessor {

    static Object getObjectFromCertainMethod(String methodName, Method[] methods, Object fromObj, Object arg)
            throws InvocationTargetException, IllegalAccessException {
        Object result = null;
        for (Method oneMethod : methods) {
            if (oneMethod.getName().equals(methodName)) {
                oneMethod.setAccessible(true);
                if (arg == null)
                    result = oneMethod.invoke(fromObj);
                else
                    result = oneMethod.invoke(fromObj, arg);
                oneMethod.setAccessible(false);
                break;
            }
        }
        return result;
    }

    static Object getObjectFromCertainMethod(String methodName, Method[] methods, Object fromObj)
            throws InvocationTargetException, IllegalAccessException {
        return getObjectFromCertainMethod(methodName, methods, fromObj, null);
    }

    static void setObjectInCertainMethod(String methodName, Method[] methods, Object fromObj, Object newObj)
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
