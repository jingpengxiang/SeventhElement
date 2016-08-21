package com.example.jing.seventhelement.api;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称： SeventhElement
 * 创建人： Jing
 * 创建时间： 16/8/14  16:39
 * 修改备注：
 */
public class Factory {

    public static BaseHttpService provideHttpService() {
        return provideService(BaseHttpService.class);
    }

    private static Map<Class, Object> m_service = new HashMap();

    private static <T> T provideService(Class cls) {
        Object serv = m_service.get(cls);
        if (serv == null) {
            synchronized (cls) {
                serv = m_service.get(cls);
                if (serv == null) {
                    serv = HttpClient.getIns(ApiConstant.BASE_URL).createService(cls);
                    m_service.put(cls, serv);
                }
            }
        }
        return (T) serv;
    }
}
