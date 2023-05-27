package cn.edu.guet.ioc;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {

    /**
     * ����ģʽ
     */
    private static BeanFactory instance = new BeanFactory();
    public static Map<String, Object> map = new HashMap<String, Object>();

    public static void parseElement(Element ele) {
        try {
            /**
             * ͨ�����䴴������
             */
            Object beanObj = null;
            Class clazz = null;
            String id = ele.attributeValue("id");
            if (map.get(id) == null) {
                clazz = Class.forName(ele.attributeValue("class"));
                beanObj = clazz.newInstance();
                map.put(id, beanObj);
            }

            //ele�Ƿ�����Ԫ��
            Object obj = null;
            String ref = "";
            List<Element> childElements = ele.elements();//�õ�ele����Ԫ�ؼ���
            for (Element childEle : childElements) {
                ref = childEle.attributeValue("ref");
                obj = map.get(ref);
                if (obj == null) {
                    for (Element el : list) {
                        String ids = el.attributeValue("id");
                        if (ids.equals(ref)) {
                            parseElement(el);// �ݹ鴦��  ��һ��ѭ��el��ʾpermissionDao
                        }
                    }
                }
                obj = map.get(ref);
                if (clazz != null) {
                    Method methods[] = clazz.getDeclaredMethods();
                    for (Method m : methods) {
                        if (m.getName().startsWith("set") && m.getName().toLowerCase().contains(ref.toLowerCase())) {
                        /*
                        ����������setXXX����ʵ��bean���Զ�ע��
                         */
                            m.invoke(beanObj, obj);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalArgumentException | InvocationTargetException | SecurityException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    static List<Element> list;

    //��̬�飺JVM������̬���ֱ��ִ��
    static {
        try {
            SAXReader reader = new SAXReader();
            InputStream in = Class.forName("cn.edu.guet.ioc.BeanFactory")
                    .getResourceAsStream("/applicationContext.xml");
            Document doc = reader.read(in);
            // xPathExpression��xPath���ʽ
            list = doc.selectNodes("/beans/bean");
            for (Element ele : list) {
                parseElement(ele);
            }
        } catch (ClassNotFoundException | DocumentException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private BeanFactory() {
    }

    public static BeanFactory getInstance() {
        return instance;
    }

    public Object getBean(String id) {
        return map.get(id);
    }
}
