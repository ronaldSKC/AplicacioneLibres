package administraccion;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioCorreo {

	 public static boolean enviarCorreo(String para, String mensaje){
	        boolean enviado = false;
	            try{
	            
	                  
	                Properties prop = System.getProperties();
	                
	                prop.put("mail.smtp.starttls.enable","true");
	                prop.put("mail.smtp.host", "smtp.gmail.com");
	                prop.put("mail.smtp.user","applibresepn@gmail.com");
	                prop.put("mail.smtp.password", "applibres2019");
	                prop.put("mail.smtp.port",587);
	                prop.put("mail.smtp.auth","true");
	                prop.put("mail.smtp.starttls.enable", "true");
	                
	                Session sesion = Session.getDefaultInstance(prop,null);
	                
	                MimeMessage message = new MimeMessage(sesion);
	                
	                message.setFrom(new InternetAddress("applibresepn@gmail.com"));
	                
	                message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
	                
	                message.setSubject("Bolsa de Empleo");
	                message.setText(mensaje);
	                
	                Transport transport = sesion.getTransport("smtp");
	                
	                transport.connect("smtp.gmail.com","applibresepn@gmail.com","applibres2019");
	                
	                transport.sendMessage(message, message.getAllRecipients());
	                
	                transport.close();
	                
	                enviado = true;
	                
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	        
	        return enviado;
	    }
	
}
