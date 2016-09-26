package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ExportarTo;
import ejb.ActorEjb;
import entity.Actor;

@WebServlet({"/ServletAutor.html","/insertarSvr.html","/buscarSvr.html","/eliminarSvr.html","/actualizarSvr.html","/listarSvr.html","/exportarExcelSvr.html","/crudActorSvr.html"})
public class ServletActor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url = "";
	private static final int NUEVO      = 1; 
	private static final int BUSCAR     = 2;
	private static final int ELIMINAR   = 3;
	private static final int ACTUALIZAR = 4;
	private static final int LISTAR     = 5;
	private static final int CRUD       = 6;
	private static final int DEFAULT    = 7;
	
	
	private String      mensaje           = null;
	private List<Actor> lista             = null;
	private String      urlDestino        = "";
	private String      txtNombreRecordar = null;
	private int         idActor           = 0;
	private String      nombreActor       = "";
	private int         edadActor         = 0;
	
	private List<String[]> listaExcel        = null;
	private String[]       tituloExcel       = null;
	private String[]       tipoDateExcel     = null;
	private String[]       longitudExcel     = null;
	private String         fileName          = null;
	private String         btnAccion         = null;
	private int            posicionrow         = 0;
	
	@EJB
	ActorEjb actorEjb;
    public ServletActor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		processRequest( request, response);
        url     = request.getServletPath();
		try {
			
			urlDestino ="/actor.jsp";
			if(url.equals("/insertarSvr.html")){
				request.setAttribute("ACCION", NUEVO);
				
			}else if(url.equals("/buscarSvr.html")){
				request.setAttribute("ACCION", BUSCAR);
				request.setAttribute("listaActor", lista);
				request.setAttribute("txtNombreR", txtNombreRecordar);
				
			}else if(url.equals("/eliminarSvr.html")){
				request.setAttribute("ACCION", ELIMINAR);
				request.setAttribute("listaActor", lista);
				request.setAttribute("txtNombreR", txtNombreRecordar);
				
			}else if(url.equals("/actualizarSvr.html")){
				request.setAttribute("ACCION", ACTUALIZAR );
				request.setAttribute("listaActor", lista);
				request.setAttribute("txtNombreR", txtNombreRecordar);
			}else if(url.equals("/listarSvr.html")){
				request.setAttribute("ACCION", LISTAR);
				lista = actorEjb.listarAll();
				request.setAttribute("listaActor", lista);
			}else if(url.equals("/exportarExcelSvr.html")){
				fileName = "ExcelActor.xls";
				lista    = actorEjb.listarAll();
				if(txtNombreRecordar!= null && txtNombreRecordar.trim().length() > 0){
					lista = actorEjb.buscarPorNombre(txtNombreRecordar);
				}
				listaExcel        = new ArrayList<String[]>();
				
				tituloExcel       = new String[]{"ID","NOMBRE","EDAD"};
				tipoDateExcel     = new String[]{"NUMBER","VARCHAR2","NUMBER"};
				longitudExcel     = new String[]{"5","45","2"};
				
				listaExcel.add(tituloExcel);
				listaExcel.add(tipoDateExcel);
				listaExcel.add(longitudExcel);
				
				for(Actor a:lista){
					listaExcel.add(new String[]{a.getId()+"",a.getNombre(),a.getEdad()+""});
				}
				ExportarTo.toExcel(request, response, listaExcel, fileName);//Genera el excel.
			}else if(url.equals("/crudActorSvr.html")){
				
				if(btnAccion!=null && btnAccion.equalsIgnoreCase("Nuevo")){
					request.setAttribute("paramSvr", "NuevaFila");
					
				}else if(btnAccion!=null && btnAccion.equalsIgnoreCase("Actualizar")){
					
					request.setAttribute("paramSvr", "UpdateFila"+"-"+posicionrow);
					
				}			
				
				
				request.setAttribute("txtNombreR", txtNombreRecordar);
				request.setAttribute("ACCION", CRUD);
				request.setAttribute("listaActor", lista);
			} else if(url.equals("/ServletAutor.html")){
				request.setAttribute("ACCION", DEFAULT);
			}
			
			
			
		} catch (Exception ex) {
			mensaje = ex.getMessage()!=null?"MENSAJE:<br/>"+mensaje+".<br/>":"";
			mensaje ="1---"+ mensaje+"CAUSA:<br/>  "+ex.getCause();
			
		}finally{
			request.setAttribute("MENSAJE", mensaje);
			mensaje = null;
			lista   = null;
			if(!url.equals("/exportarExcelSvr.html")){
				request.getRequestDispatcher(urlDestino).forward(request, response);	
			}
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		processRequest( request, response);
        url = request.getServletPath();
        
		try {
			
			if(url.equals("/insertarSvr.html")){
					 urlDestino ="insertarSvr.html";
					 Actor actor = new Actor();
					 actor.setNombre(request.getParameter("txtNombre"));
					 actor.setEdad(Integer.parseInt(request.getParameter("txtEdad")));
					 actorEjb.insertActor(actor);
					 mensaje = "0---Se guardo satisfactoriamente.";
				
			}else if(url.equals("/buscarSvr.html")){
					 urlDestino = "buscarSvr.html";
					 lista      = actorEjb.buscarPorNombre(request.getParameter("txtNombre"));
					 mensaje    = "0---Resultado(s) de busqueda"+": "+lista.size()+"";
					 txtNombreRecordar = request.getParameter("txtNombre");
				
			}else if(url.equals("/eliminarSvr.html")){
				     urlDestino = "eliminarSvr.html";
						if(request.getParameter("idactor") != null){
							idActor     = Integer.parseInt(request.getParameter("idactor"));
							Actor actor = new Actor();
							actor.setId(idActor);
							actorEjb.deleteActor(actor);
							mensaje = "0---Se elimino satisfactoriamente.";
							lista   = actorEjb.buscarPorNombre(request.getParameter("txtNombre"));
						}else{
							lista             = actorEjb.buscarPorNombre(request.getParameter("txtNombre"));
							txtNombreRecordar = request.getParameter("txtNombre");
							mensaje           = "0---Resultado(s) de busqueda"+": "+lista.size()+"";	
						}
			}else if(url.equals("/actualizarSvr.html")){
					urlDestino = "actualizarSvr.html";
					if(request.getParameter("btnActualizar") != null){
						idActor     = Integer.parseInt(request.getParameter("txtidactor"));
						nombreActor = request.getParameter("txtnombreactor");
						edadActor   = Integer.parseInt(request.getParameter("txtedadactor"));
						Actor actor = new Actor();
						actor.setId(idActor);
						actor.setNombre(nombreActor);
						actor.setEdad(edadActor);
						actorEjb.updateActor(actor);
						mensaje = "0---Se actualizo satisfactoriamente.";
						lista   = actorEjb.buscarPorNombre(request.getParameter("txtNombre"));
					}else{
						lista             = actorEjb.buscarPorNombre(request.getParameter("txtNombre"));
						txtNombreRecordar = request.getParameter("txtNombre");
						mensaje           = "0---Resultado(s) de busqueda"+": "+lista.size()+"";
					}
				
				
			}else if(url.equals("/listarSvr.html")){
				
			}else if(url.equals("/crudActorSvr.html")){
					urlDestino ="crudActorSvr.html";
				    btnAccion  = request.getParameter("btnaccion");
				if(btnAccion!=null && btnAccion.equalsIgnoreCase("Nuevo")){
					 Actor actor = new Actor();
					 actor.setNombre(request.getParameter("txtNombre1"));
					 actor.setEdad(Integer.parseInt(request.getParameter("txtEdad1")));
					 actorEjb.insertActor(actor);
					 mensaje = "0---Se guardo satisfactoriamente.";
					 lista             = actorEjb.listarAll();
					 
				}else if(btnAccion!=null && btnAccion.equalsIgnoreCase("Actualizar")){
					    posicionrow       = Integer.parseInt(request.getParameter("txtposicionrow"));
					    txtNombreRecordar = request.getParameter("txtNombre");
						idActor     = Integer.parseInt(request.getParameter("txtId2"));
						nombreActor = request.getParameter("txtNombre2");
						edadActor   = Integer.parseInt(request.getParameter("txtEdad2"));
						Actor actor = new Actor();
						actor.setId(idActor);
						actor.setNombre(nombreActor);
						actor.setEdad(edadActor);
						
						actorEjb.updateActor(actor);
						mensaje = "0---Se actualizo satisfactoriamente.";
						lista   = actorEjb.buscarPorNombre(request.getParameter("txtNombre"));
				    
			     }else if(btnAccion!=null && btnAccion.equalsIgnoreCase("Buscar")){
			    	 lista             = actorEjb.buscarPorNombre(request.getParameter("txtNombre"));
					 txtNombreRecordar = request.getParameter("txtNombre");
					 mensaje           = "0---Resultado(s) de busqueda"+": "+lista.size()+"";
				    
			     }else if(btnAccion!=null && btnAccion.equalsIgnoreCase("Delete")){
				    	 if(request.getParameter("idactor") != null){
								idActor     = Integer.parseInt(request.getParameter("idactor"));
								Actor actor = new Actor();
								actor.setId(idActor);
								actorEjb.deleteActor(actor);
								mensaje = "0---Se elimino satisfactoriamente.";
								lista   = actorEjb.buscarPorNombre(request.getParameter("txtNombre"));
							}
				    
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
