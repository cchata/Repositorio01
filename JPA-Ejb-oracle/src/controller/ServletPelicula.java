package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ExportarTo;
import ejb.ActorEjb;
import ejb.PeliculaEjb;
import entity.Actor;
import entity.Pelicula;

@WebServlet({"/ServletPelicula.html","/insertarPSvr.html","/buscarPSvr.html","/eliminarPSvr.html","/actualizarPSvr.html","/listarPSvr.html","/exportarExcelPSvr.html","/crudPelucilaSvr.html"})
public class ServletPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url = "";
	private static final int NUEVO      = 1; 
	private static final int BUSCAR     = 2;
	private static final int ELIMINAR   = 3;
	private static final int ACTUALIZAR = 4;
	private static final int LISTAR     = 5;
	private static final int CRUD       = 6;
	private String      mensaje         = null;
	private List<Pelicula> lista        = null;
	private List<Actor> listaActor      = null;
	private String      urlDestino      = "";
	
	private String      txtNombreRecordar = null;
	private int         idPelicula        = 0;
	private String      nombrePelicula    = "";
	private Date        estreno           = null;
	
	private List<String[]>   listaExcel    = null;
	private String[]         tituloExcel   = null;
	private String[]         tipoDateExcel = null;
	private String[]         longitudExcel = null;
	private SimpleDateFormat sdf           = null;
	private String           fileName      = null;
	private String           btnAccion     = null;
	private int              posicionrow   = 0;
	@EJB
	PeliculaEjb peliculaEjb;
	
	@EJB
	ActorEjb actorEjb;
    public ServletPelicula() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		processRequest( request, response);
        url     = request.getServletPath();
		try {
			urlDestino ="/peliculas.jsp";
			if(url.equals("/insertarPSvr.html")){
				listaActor = actorEjb.listarAll();
				request.setAttribute("ACCION", NUEVO);
				request.setAttribute("listaActor", listaActor);
				
			}else if(url.equals("/buscarPSvr.html")){
				request.setAttribute("ACCION", BUSCAR);
				request.setAttribute("listaPelicula", lista);
				request.setAttribute("txtNombreR", txtNombreRecordar);
				
			}else if(url.equals("/eliminarPSvr.html")){
				request.setAttribute("ACCION", ELIMINAR);
				request.setAttribute("listaPelicula", lista);
				request.setAttribute("txtNombreR", txtNombreRecordar);
				
			}else if(url.equals("/actualizarPSvr.html")){
				request.setAttribute("ACCION",ACTUALIZAR );
				request.setAttribute("listaPelicula", lista);
				request.setAttribute("listaActor", listaActor);
				request.setAttribute("txtNombreR", txtNombreRecordar);
				
			}else if(url.equals("/listarPSvr.html")){
				request.setAttribute("ACCION", LISTAR);
				lista = peliculaEjb.listarAll();
				request.setAttribute("listaPelicula", lista);
				
			}else if(url.equals("/exportarExcelPSvr.html")){
				fileName  = "ExcelPelicula.xls";
				sdf       = new SimpleDateFormat("dd/MM/yyyy");
				lista     = peliculaEjb.listarAll();
				if(txtNombreRecordar!= null && txtNombreRecordar.trim().length() > 0){
					lista = peliculaEjb.buscarPorNombre(txtNombreRecordar);
				}
				listaExcel        = new ArrayList<String[]>();
				
				tituloExcel       = new String[]{"ID","NOMBRE","ESTRENO","ACTOR"};
				tipoDateExcel     = new String[]{"NUMBER","VARCHAR2","DATE","VARCHAR2"};
				longitudExcel     = new String[]{"5","45","0","45"};
				
				listaExcel.add(tituloExcel);
				listaExcel.add(tipoDateExcel);
				listaExcel.add(longitudExcel);
				
				for(Pelicula p:lista){
					listaExcel.add(new String[]{p.getId()+"",p.getNombre(),sdf.format(p.getEstreno())+"",p.getActor().getNombre()});
				}
				ExportarTo.toExcel(request, response,listaExcel,fileName,sdf);//Genera el excel.
			}else if(url.equals("/crudPelucilaSvr.html")){
				if(btnAccion!=null && btnAccion.equalsIgnoreCase("Nuevo")){
					request.setAttribute("paramSvr", "NuevaFila");
					
				}else if(btnAccion!=null && btnAccion.equalsIgnoreCase("Actualizar")){
					
					request.setAttribute("paramSvr", "UpdateFila"+"-"+posicionrow);
					
				}		
				
				
				listaActor        = actorEjb.listarAll();
				request.setAttribute("txtNombreR", txtNombreRecordar);
				request.setAttribute("ACCION", CRUD);
				request.setAttribute("listaPelicula", lista);
				request.setAttribute("listaActor", listaActor);
			} 
			
		} catch (Exception ex) {
			mensaje = ex.getMessage()!=null?"MENSAJE:<br/>"+mensaje+".<br/>":"";
			mensaje ="1---"+ mensaje+"CAUSA:<br/>  "+ex.getCause();			
		}finally{
			request.setAttribute("MENSAJE", mensaje);
			mensaje = null;
			lista   = null;
			if(!url.equals("/exportarExcelPSvr.html")){
				request.getRequestDispatcher(urlDestino).forward(request, response);	
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		processRequest( request, response);
        url = request.getServletPath();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			if(url.equals("/insertarPSvr.html")){
					 urlDestino ="insertarPSvr.html";
					 Pelicula pelicula = new Pelicula();
					 pelicula.setNombre(request.getParameter("txtNombre"));
					 pelicula.setEstreno(sdf.parse(request.getParameter("dateEstreno")));
					 pelicula.setActor(actorEjb.buscarPorId(Integer.parseInt(request.getParameter("selectActor"))));
					 peliculaEjb.insertPelicula(pelicula);
					 mensaje = "0---Se guardo satisfactoriamente.";
				
			}else if(url.equals("/buscarPSvr.html")){
					 urlDestino = "buscarPSvr.html";
					 lista      = peliculaEjb.buscarPorNombre(request.getParameter("txtNombre"));
					 mensaje    = "0---Resultado(s) de busqueda"+": "+lista.size()+"";
					 txtNombreRecordar = request.getParameter("txtNombre");
			}else if(url.equals("/eliminarPSvr.html")){
				     urlDestino = "eliminarPSvr.html";
						if(request.getParameter("idpelicula") != null){
							idPelicula = Integer.parseInt(request.getParameter("idpelicula"));
							Pelicula pelicula = new Pelicula();
							pelicula.setId(idPelicula);
							peliculaEjb.deletePelicula(pelicula);
							mensaje = "0---Se elimino satisfactoriamente.";
							lista   = peliculaEjb.buscarPorNombre(request.getParameter("txtNombre"));
						}else{
							lista             = peliculaEjb.buscarPorNombre(request.getParameter("txtNombre"));
							txtNombreRecordar = request.getParameter("txtNombre");
							mensaje           = "0---Resultado(s) de busqueda"+": "+lista.size()+"";	
						}
			}else if(url.equals("/actualizarPSvr.html")){
					urlDestino = "actualizarPSvr.html";
					if(request.getParameter("btnActualizar") != null && request.getParameter("btnActualizar").trim().length()>0){
							idPelicula     = Integer.parseInt(request.getParameter("txtidpelicula"));
							nombrePelicula = request.getParameter("txtnombrepelicula");
							estreno        = sdf.parse(request.getParameter("dateestreno"));
							Actor actor    = new Actor();
							actor.setId(Integer.parseInt(request.getParameter("selectActor")));
							
							Pelicula pelicula = new Pelicula();
							pelicula.setId(idPelicula);
							pelicula.setNombre(nombrePelicula);
							pelicula.setEstreno(estreno);
							pelicula.setActor(actor);
							peliculaEjb.updatePelicula(pelicula);
							mensaje = "0---Se actualizo satisfactoriamente.";
							lista   = peliculaEjb.buscarPorNombre(request.getParameter("txtNombre"));
					}else{
							lista             = peliculaEjb.buscarPorNombre(request.getParameter("txtNombre"));
							listaActor        = actorEjb.listarAll();
							txtNombreRecordar = request.getParameter("txtNombre");
							mensaje           = "0---Resultado(s) de busqueda"+": "+lista.size()+"";
					}
				
				
			}else if(url.equals("/listarPSvr.html")){
				
			}else if(url.equals("/crudPelucilaSvr.html")){
				urlDestino ="crudPelucilaSvr.html";
			    btnAccion  = request.getParameter("btnaccion");
			if(btnAccion!=null && btnAccion.equalsIgnoreCase("Nuevo")){
				 Pelicula pelicula = new Pelicula();
				 pelicula.setNombre(request.getParameter("txtNombre1"));
				 pelicula.setEstreno(sdf.parse(request.getParameter("dateEstreno1")));
				 pelicula.setActor(actorEjb.buscarPorId(Integer.parseInt(request.getParameter("selectActor1"))));
				 peliculaEjb.insertPelicula(pelicula);
				 mensaje = "0---Se guardo satisfactoriamente.";
				 lista             = peliculaEjb.listarAll();
			}else if(btnAccion!=null && btnAccion.equalsIgnoreCase("Actualizar")){
				    posicionrow    = Integer.parseInt(request.getParameter("txtposicionrow"));
					idPelicula     = Integer.parseInt(request.getParameter("txtid2"));
					nombrePelicula = request.getParameter("txtNombre2");
					estreno        = sdf.parse(request.getParameter("dateEstreno2"));
					Actor actor    = new Actor();
					actor.setId(Integer.parseInt(request.getParameter("selectActor2")));
					
					Pelicula pelicula = new Pelicula();
					pelicula.setId(idPelicula);
					pelicula.setNombre(nombrePelicula);
					pelicula.setEstreno(estreno);
					pelicula.setActor(actor);
					peliculaEjb.updatePelicula(pelicula);
					mensaje = "0---Se actualizo satisfactoriamente.";
					lista   = peliculaEjb.buscarPorNombre(request.getParameter("txtNombre"));
			    
		     }else if(btnAccion!=null && btnAccion.equalsIgnoreCase("Buscar")){
		    	 lista      = peliculaEjb.buscarPorNombre(request.getParameter("txtNombre"));
				 mensaje    = "0---Resultado(s) de busqueda"+": "+lista.size()+"";
				 txtNombreRecordar = request.getParameter("txtNombre");
			    
		     }else if(btnAccion!=null && btnAccion.equalsIgnoreCase("Delete")){
			    	 if(request.getParameter("idpelicula") != null){
			    		 idPelicula = Integer.parseInt(request.getParameter("idpelicula"));
							Pelicula pelicula = new Pelicula();
							pelicula.setId(idPelicula);
							peliculaEjb.deletePelicula(pelicula);
							mensaje = "0---Se elimino satisfactoriamente.";
							lista   = peliculaEjb.buscarPorNombre(request.getParameter("txtNombre"));
						}
			    
		     }else if(url.equals("/ServletPelicula.html")){
			 }
		
		}
			
			
		} catch (Exception ex) {
			mensaje = ex.getMessage()!=null?"MENSAJE:<br/>"+mensaje+".<br/>":"";
			mensaje ="1---"+ mensaje+"CAUSA:<br/>  "+ex.getCause();
			
		}finally{
			response.sendRedirect(urlDestino);
		}
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<hmtl>");
		out.println("<head><title>Servlet glassfish</title></head>");
		out.println("<body>");
		out.println("<h1>Dentro del servlet</h1>");
		out.println("</body>");
		out.println("</hmtl>");
	}

}
