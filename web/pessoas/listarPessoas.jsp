<%@page import="br.com.DTO.PhoneDTO"%>
<%@page import="br.com.DAO.PhoneDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Contatos</title>
    </head>
    <body>
        <h1>Meus Contatos no Supabase</h1>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Telefone</th>
            </tr>
            <%
                try {
                    PhoneDAO objPhoneDAO = new PhoneDAO();
                    ArrayList<PhoneDTO> lista = objPhoneDAO.pesquisarPhones();

                    for (int i = 0; i < lista.size(); i++) {
                        out.print("<tr>");
                        out.print("<td>" + lista.get(i).getnome() + "</td>");
                        out.print("<td>" + lista.get(i).gettelefone() + "</td>");
                        out.print("</tr>");
                    }
                } catch (Exception e) {
                    out.print("Erro: " + e.getMessage());
                }
            %>
        </table>
    </body>
</html>