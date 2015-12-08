package Services;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VolumesDAO;
import Entidades.Volumes;

@WebServlet("/cadastroVolumes")
public class cadastroVolumes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
     
    public cadastroVolumes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VolumesDAO bd = new VolumesDAO();
		Volumes vol = new Volumes ();
		
		String home = new String("boasVindas.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(home);

		vol.setTitulo(request.getParameter("titulo"));
		vol.setAutor(request.getParameter("autor"));
		vol.setDescricao(request.getParameter("descricao"));
		vol.setTipo(request.getParameter("tipo"));
		vol.setPaginas(request.getParameter("paginas"));
		vol.setAno(request.getParameter("ano"));
		vol.setEditora(request.getParameter("editora"));
		
		bd.insereVolumes(vol);
		
		dispatcher.forward(request, response);
	}

}
