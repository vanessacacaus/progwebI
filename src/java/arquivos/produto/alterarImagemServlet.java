/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos.produto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author vanes
 */
public class alterarImagemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nomeArquivo = "";
            int idp = Integer.parseInt(request.getParameter("idp"));
            boolean success = false;
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                try {
                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    factory.setRepository(new File("C:/Users/vanes/Documents/Ecommerce/web/imgProdutos" + File.separator + "temp"));
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
                    Iterator<FileItem> iter = items.iterator();
                    while (iter.hasNext()) {
                        FileItem item = iter.next();
                        if (!item.isFormField()) {
                            String fileName = item.getName();
                            nomeArquivo = fileName;
                            item.write(new File("C:/Users/vanes/Documents/Ecommerce/web/imgProdutos" + File.separator + fileName));
                            success = true;
                        }
                    }
                } catch (Exception ex) {
                    success = false;
                }
                if (success) {
                    request.setAttribute("nomeArquivo", nomeArquivo);
                    request.setAttribute("idp", idp);
                    request.setAttribute("mensagem", "Arquivo recebido com sucesso");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/produto/editarProdutos.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "Não foi possível receber o arquivo");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/produto/editarProdutos.jsp");
                    dispatcher.forward(request, response);
                }
        }
    }

}
