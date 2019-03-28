package br.ufrn.imd.obama.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/oai/")
public final class OAImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OAImageServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Tem de definir qual será o diretório em que ficarão armazenadas
        // as imagens no Servidor.
//		String pathBase = "C:/Users/amandamaria/Documents/copias/";
//		String pathBase = "/Users/nelson/git/oas-miniaturas/";
        String pathBase = "/opt/obama-files/oas-miniaturas/";

        try {

            // Recupera o id o OA para o qual solicita-se a imagem.
            String file = pathBase+request.getParameter("file")+".png";

            // Procura em disco o arquivo.
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            // Get image contents.
            byte[] bytes = new byte[in.available()];

            in.read(bytes);
            in.close();

            // Write image contents to response.
            response.getOutputStream().write(bytes);

        } catch (IOException e) {
            System.err.println("-> Imagem do OA de ID " + request.getParameter("file") + " não encontrado.");
            System.err.println("-> Retornando imagem default.");
            String file = pathBase + "oa-default.png";

            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            // Get image contents.
            byte[] bytes = new byte[in.available()];

            in.read(bytes);
            in.close();

            // Write image contents to response.
            response.getOutputStream().write(bytes);

            // Imprimindo stackTrace
//			e.printStackTrace();

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}

