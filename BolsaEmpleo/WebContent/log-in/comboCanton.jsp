<%@page import="administraccion.ControladorAdm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%
	String s_area = request.getParameter("f_canton");
	String s_opc = request.getParameter("f_opc");
	if (s_opc.equals("1")) {
		ArrayList parroquias = ControladorAdm.listarParroquias(s_area);
%>
	<label for="canton">Parroquia</label> <select name="f_parroquia"
		class="form-control">
		<option value="0">----Escoja una opción----</option>
		<%
			for (int i = 0; i < parroquias.size(); i++) {
					Vector parroquia = (Vector) parroquias.get(i);
					String idParroquia = parroquia.get(0).toString().trim();
					String nombreParroquia = parroquia.get(1).toString().trim();
		%>
		<option value="<%=idParroquia%>"><%=nombreParroquia%>
		</option>
		<%
			}
		%>
	</select>
<%
	}
%>