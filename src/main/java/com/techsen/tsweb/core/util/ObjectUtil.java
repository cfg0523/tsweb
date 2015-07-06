package com.techsen.tsweb.core.util;

import static com.techsen.tsweb.core.util.CloseUtil.close;
import static com.techsen.tsweb.core.util.Const.EMPTY_STRING;
import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;
import static com.techsen.tsweb.core.util.ValidUtil.isValid;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

import org.apache.log4j.Logger;

public class ObjectUtil {

    private static Logger logger = Log4jUtil.getLogger(ObjectUtil.class);

    /**
     * 将obj对象中的属性序列化成一种类似JSON的字符串 属性的类型必须为数字，字符，日期，逻辑值才会序列化
     * 序列化的深度为superClass指定的类
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return EMPTY_STRING;
        }
        Class<?> clazz = obj.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getSimpleName()).append("[");
        try {
            Field[] fs = clazz.getDeclaredFields();
            for (int i=0; i<fs.length; i++) {
                Field f = fs[i];
                Class<?> fieldType = f.getType();
                if (CharSequence.class.isAssignableFrom(fieldType)
                        || Boolean.class.isAssignableFrom(fieldType)
                        || Date.class.isAssignableFrom(fieldType)
                        || Number.class.isAssignableFrom(fieldType)
                        || Class.class.isAssignableFrom(fieldType)
                        || fieldType.isEnum()) {
                    f.setAccessible(true);
                    String filedName = f.getName();
                    sb.append(filedName).append("=").append(f.get(obj)).append(", ");
                }
            }
        } catch (Exception e) {
            throwRuntimeException(e);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 取得对象的泛型类型
     */
    public static Class<?> getGenericType(Object obj) {
        Class<?> retVal = null;
        try {
            ParameterizedType type = (ParameterizedType) obj.getClass()
                    .getGenericSuperclass();
            if (type != null) {
                Type[] types = type.getActualTypeArguments();
                if (isValid(types)) {
                    retVal = (Class<?>) types[0];
                }
            }
        } catch (Exception e) {
        }
        return retVal;
    }

    /**
     * 深度复制技术克隆对象
     * 
     * @exception 如果克隆失败会抛出运行期异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T clone(Serializable serializable) {
        T retVal = null;
        if (serializable != null) {
            ByteArrayOutputStream baos = null;
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;
            ByteArrayInputStream bais = null;
            try {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(serializable);
                byte[] bytes = baos.toByteArray();
                bais = new ByteArrayInputStream(bytes);
                ois = new ObjectInputStream(bais);
                retVal = (T) ois.readObject();
            } catch (Exception e) {
                logger.error("clone Object[" + serializable + "] failure");
                throwRuntimeException(e);
            } finally {
                close(ois);
                close(bais);
                close(oos);
                close(baos);
            }
        }
        return retVal;
    }

}
