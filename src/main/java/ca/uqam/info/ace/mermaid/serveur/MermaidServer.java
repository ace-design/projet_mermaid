package ca.uqam.info.ace.mermaid.serveur;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;


public class MermaidServer {


    public  void start(int port) throws Exception {

        Server server = new Server(port);
        ServletContextHandler ctx =
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        ctx.setContextPath("/mermaid");
        ctx.setAllowNullPathInfo(true);
        server.setHandler(ctx);

        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages",
                "ca.uqam.info.ace.mermaid.serveur");
        server.start();

    }
}
