package auxiliary.testclasses;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Slezak Attila on 2016.09.23..
 */
public class PrivateDataAccessor {

    public static Object getObjectFromCertainMethod(Method method, Object fromObj, Object args)
            throws InvocationTargetException, IllegalAccessException {
        Object result;
        method.setAccessible(true);

        if (args == null)
            result = method.invoke(fromObj);
        else if (args.getClass() == Object[].class)
            result = method.invoke(fromObj, (Object[]) args);
        else
            result = method.invoke(fromObj, args);
        method.setAccessible(false);
        return result;
    }

    public static Object getObjectFromCertainMethod(String methodName, Method[] methods, Object fromObj, Object args)
            throws InvocationTargetException, IllegalAccessException {
        Method method = searchForProperMethod(methodName, methods, args);
        if (method != null)
            return getObjectFromCertainMethod(method, fromObj, args);
        else
            return null;
    }

    public static Object getObjectFromCertainMethod(String methodName, Method[] methods, Object fromObj)
            throws InvocationTargetException, IllegalAccessException {
        return getObjectFromCertainMethod(methodName, methods, fromObj, null);
    }

    public static Object getObjectFromCertainMethod(Method method, Object fromObj)
            throws InvocationTargetException, IllegalAccessException {
        return getObjectFromCertainMethod(method, fromObj, null);
    }

    public static void setObjectInCertainMethod(String methodName, Method[] methods, Object fromObj, Object args)
            throws InvocationTargetException, IllegalAccessException {
        Method method = searchForProperMethod(methodName, methods, args);
        if (method != null)
            setObjectInCertainMethod(method, fromObj, args);
    }

    public static void setObjectInCertainMethod(Method method, Object fromObj, Object args)
            throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);

        if (args == null)
            method.invoke(fromObj);
        else if (args.getClass() == Object[].class)
            method.invoke(fromObj, (Object[]) args);
        else
            method.invoke(fromObj, args);
        method.setAccessible(false);
    }

    private static boolean isCastable(Class castTo, Class castFrom) {
        if (castTo.equals(Object.class))
            return true;
        else if (castTo.equals(castFrom))
            return true;
        else if (castTo.isAssignableFrom(castFrom))
            return true;
        else if (castTo.equals(int.class)
                && (castFrom.equals(Integer.class) || castFrom.equals(Character.class)))
            return true;
        else if (castTo.equals(long.class) && castFrom.equals(Long.class))
            return true;
        else if (castTo.equals(Integer.class) && castFrom.equals(int.class))
            return true;
        else if (castTo.equals(Long.class) && castFrom.equals(long.class))
            return true;
        else
            return false;
    }

    private static Method searchForProperMethod(String methodName, Method[] methods, Object args) {
        outerForCycle:
        for (Method oneMethod : methods) {
            if (!oneMethod.getName().equals(methodName))
                continue;

            if (args == null) {
                if (oneMethod.getParameterCount() == 0) {
                    return oneMethod;
                }
            } else if (args.getClass() == Object[].class) {
                if (oneMethod.getParameterCount() == ((Object[]) args).length) {
                    for (int i = 0; i < oneMethod.getParameterCount(); i++) {
                        if (!isCastable(oneMethod.getParameterTypes()[i], ((Object[]) args)[i].getClass())) {
                            continue outerForCycle;
                        }
                    }
                    return oneMethod;
                }
            } else if (oneMethod.getParameterCount() == 1 && isCastable(oneMethod.getParameterTypes()[0],
                    args.getClass()))
                return oneMethod;
        }
        return null;
    }
}
