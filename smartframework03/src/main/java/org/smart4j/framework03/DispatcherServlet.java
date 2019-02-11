package org.smart4j.framework03;

import org.smart4j.framework03.bean.Data;
import org.smart4j.framework03.bean.Handler;
import org.smart4j.framework03.bean.Param;
import org.smart4j.framework03.bean.View;
import org.smart4j.framework03.helper.*;
import org.smart4j.framework03.util.*;

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
        UploadHelper.init(servletContext);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletHelper.init(req,resp);
        try{
            String requestMethod = req.getMethod().toLowerCase();
            String requestPath= req.getPathInfo();
            if(requestPath.equals("/favicon.ico")) {return;}
            //获取执行bean
            Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
            if(handler != null) {
                //获取到执行实体
                Class<?> controllerClass = handler.getControllerClass();
                Object controllerBean = BeanHelper.getBean(controllerClass);
                Param param;
                if(UploadHelper.isMultipart(req)) {
                    param = UploadHelper.createParam(req);
                } else {
                    param = RequestHelper.createParam(req);
                }

                Object result;
                Method actionMethod = handler.getActionMethod();
                if (param.isEmpty()) {
                    result = ReflectionUtil.invokeMethod(controllerBean, actionMethod);
                } else {
                    result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
                }

                if (result instanceof View) {
                    handleViewResult((View) result, req, resp);
                } else if (result instanceof Data) {
                    handleDataResult((Data) result, resp);
                }

            }
        }finally {
            ServletHelper.destroy();
        }

    }
    private void handleViewResult(View view,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String path = view.getPath();
        if(StringUtil.isNotEmpty(path)) {
            if(path.startsWith("/")) {
                response.sendRedirect(request.getContextPath()+ path);
            } else {
                Map<String,Object> moedl = view.getModel();
                for (Map.Entry<String, Object> entry:moedl.entrySet()) {
                    request.setAttribute(entry.getKey(),entry.getValue());
                }
                request.getRequestDispatcher(ConfigHelper.getAppJspPath()+path).forward(request,response);
            }
        }
    }
    private void handleDataResult(Data data, HttpServletResponse response) throws IOException {
        Object model = data.getModel();
        if (model != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            String json = JsonUtil.toJson(model);
            writer.write(json);
            writer.flush();
            writer.close();
        }
    }
}
