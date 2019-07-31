<%@page import="administraccion.ControladorAdm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%
	String s_area = request.getParameter("f_provincia");
	String s_opc = request.getParameter("f_opc");
	if (s_opc.equals("1")) {
		ArrayList canton = ControladorAdm.listarCantones(s_area);
%>
	<label for="canton">Cantón</label> <select name="f_canton"
		class="form-control">
		<option value="0">----Escoja una opción----</option>
		<%
			for (int i = 0; i < canton.size(); i++) {
					Vector cantones = (Vector) canton.get(i);
					String idCanton = cantones.get(0).toString().trim();
					String nombreCanton = cantones.get(1).toString().trim();
		%>
		<option value="<%=idCanton%>"><%=nombreCanton%>
		</option>
		<%
			}
		%>
	</select>

<%
	}
%>