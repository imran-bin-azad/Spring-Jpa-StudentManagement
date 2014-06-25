package net.therap.controller.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by imran.azad on 6/24/14.
 */
public class ClassParser {
    public static List<String> getDeclaredFieldNamesOf(Class targetClass) {
        List<String> declaredFieldNames = new ArrayList<String>();

        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {
            declaredFieldNames.add(field.getName());
        }
        return declaredFieldNames;
    }
}
