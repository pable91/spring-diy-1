package com.diy.app;

import com.diy.framework.web.beans.factory.BeanInitializer;
import com.diy.framework.web.beans.factory.BeanScanner;
import com.diy.framework.web.mvc.Controller;
import com.diy.framework.web.server.TomcatWebServer;
import com.diy.framework.web.servlet.DispatcherServlet;
import java.util.HashMap;
import java.util.Map;

public class LectureApplication {
    public static void main(String[] args) throws Exception {
        BeanScanner beanScanner = new BeanScanner("com.diy.app");
        BeanInitializer beanInitializer = new BeanInitializer(beanScanner);

        final Map<String, Controller> controllerMapping = new HashMap<>();
        controllerMapping.put("/lectures", new LectureController());

        final DispatcherServlet servlet = new DispatcherServlet(controllerMapping);
        final TomcatWebServer tomcatWebServer = new TomcatWebServer();
        tomcatWebServer.start();
    }
}
