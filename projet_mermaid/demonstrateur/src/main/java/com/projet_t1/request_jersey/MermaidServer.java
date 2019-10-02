package com.projet_t1.request_jersey;

import com.projet_t1.ihm.MermaidVisualizer;
import com.projet_t1.mermaid_model.Listener;
import javafx.application.Application;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import static com.projet_t1.mermaid_model.Pump.PUMP_NUMBER;
import static com.projet_t1.mermaid_model.Pump.PUMP_STATUS;

public class MermaidServer {


    public  void start(int port) throws Exception {

        Server server = new Server(port);
        ServletContextHandler ctx =
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        ctx.setContextPath("/");
        server.setHandler(ctx);

        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages",
                "com.projet_t1");
        server.start();

    }
}
