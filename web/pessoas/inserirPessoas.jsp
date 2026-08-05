<%@page import="br.com.DTO.PhoneDTO"%>
<%@page import="br.com.DAO.PhoneDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processando...</title> 
    </head>
    <body>
        <%
            // 1. Pegando os dados que vêm do frmPessoas.html
            String nome = request.getParameter("nome"); // Use o 'name' que está no seu <input>
            String telefone = request.getParameter("telefone");

            // 2. Populando o nosso DTO (a ficha)
            PhoneDTO objPhoneDTO = new PhoneDTO();
            objPhoneDTO.setnome(nome);
            objPhoneDTO.settelefone(telefone); 

            // 3. Chamando o DAO (o motor) para gravar no Supabase
            try {
                PhoneDAO objPhoneDAO = new PhoneDAO();
                objPhoneDAO.cadastrarPhone(objPhoneDTO);
                
                // Se deu certo, manda para a lista ou volta para o form
                response.sendRedirect("listarPessoas.jsp"); 
                
            } catch (Exception e) {
                out.print("Erro ao processar: " + e.getMessage());
            }
        %>
    </body>
</html>
    