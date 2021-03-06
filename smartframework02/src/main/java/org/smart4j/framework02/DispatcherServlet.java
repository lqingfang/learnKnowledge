package org.smart4j.framework02;

import org.smart4j.framework02.bean.Data;
import org.smart4j.framework02.bean.Handler;
import org.smart4j.framework02.bean.Param;
import org.smart4j.framework02.bean.View;
import org.smart4j.framework02.helper.BeanHelper;
import org.smart4j.framework02.helper.ConfigHelper;
import org.smart4j.framework02.helper.ControllerHelper;
import org.smart4j.framework02.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        HelperLoader.init();
        ServletContext servletContext = servletConfig.getServletContext();
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath()+"*");
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() +"*");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath= req.getPathInfo();
        //获取执行bean
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if(handler != null) {
            //获取到执行实体
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            Map<String, Object> paramMap = new HashMap<String, Object>();
            //获取所有的请求参数名
            Enumeration<String> parameterNames = req.getParameterNames();
            //遍历请求参数
            while(parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }
            //获取输入流中的请求参数
            String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
            if (StringUtil.isNotEmpty(body)) {
                String[] params = StringUtil.splitString(body, "&");
                if (ArrayUtil.isNotEmpty(params)) {
                    for(String param:params) {
                        String[] array = StringUtil.splitString(param, "=");
                        if (ArrayUtil.isNotEmpty(array) && array.length ==2) {
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName,paramValue);
                        }
                    }
                }
            }
            //请求参数从此以后 就是 param 了
            Param param = new Param(paramMap);
            //获取 处理类的方法
            Method actionMethod = handler.getActionMethod();
            //处理，获得结果
            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
            if (result instanceof View) {
                View view = (View) result;
                String path = view.getPath();
                if(StringUtil.isNotEmpty(path)) {
                    if (path.startsWith("/")) {
                        resp.sendRedirect(req.getContextPath()+path);
                    } else {
                        Map<String, Object> model = view.getModel();
                        for (Map.Entry<String, Object> entry:model.entrySet()) {
                            req.setAttribute(entry.getKey(), entry.getValue());
                        }
                        req.getRequestDispatcher(ConfigHelper.getAppJspPath()+path).forward(req,resp);
                    }
                }
            } else if(result instanceof Data) {
                Data data = (Data) result;
                Object model = data.getModel();
                if(model != null) {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter writer = resp.getWriter();
                    String json = JsonUtil.toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }


        }
    }
}
