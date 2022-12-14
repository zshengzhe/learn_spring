package org.zsz.learnspring.e_cachedfactory.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zsz.learnspring.e_cachedfactory.factory.BeanFactory;
import org.zsz.learnspring.e_cachedfactory.service.DemoService;

/**
 * @author Zhang Shengzhe
 * @create 2022-10-26 14:41
 */
@WebServlet(urlPatterns = "/hello-servlet5")
public class HelloServlet5 extends HttpServlet {

  private final DemoService service = (DemoService) BeanFactory.getBean("demoService");

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().println(service.findAll().toString());
  }

}
