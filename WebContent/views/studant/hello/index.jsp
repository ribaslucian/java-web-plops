<%@include file="/views/@elements/page/header.jsp" %>
<%@include file="/views/@elements/menu/studant.jsp" %>

<div style="text-align: center;">
    <h1>
        Olá 
        <b>
            ${Session.getUser()}
        </b>
        !
    </h1>

    <p style="color: blueviolet; font-size: 20px;">
        Seja bem vindo a área de <b>Alunos</b>!
    </p>
</div>

<%@include file="/views/@elements/page/footer.jsp" %>