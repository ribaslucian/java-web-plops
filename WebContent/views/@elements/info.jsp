<table>
    <tr>
        <td style="text-align: center;">
            <b><small>JSTL</small></b>
        </td>

        <td>
            <c:choose>
                <c:when test="${!Session.authorized()}">
                    <span style="color: red;">Você não está conectado</span>
                </c:when>

                <c:otherwise>
                    <span style="color: blue;">
                        Você está conectado como
                        <b>
                            ${Session.getUser()}
                        </b>
                    </span>
                </c:otherwise>
            </c:choose>
        </td>
</tr>

<tr>
    <td style="text-align: center;">
        <b><small>COOKIE</small> ${cook.get("time_execution_start")}</b>
        
    </td>

    <td>
        <span style="color: #999;">
            Requisição efetuada em:
        </span>
    </td>
</tr>

<tr>
    <td style="text-align: center;">
        <small><b>TAGLIB</b></small>
    </td>

    <td>
        <span style="color: #999;">
            Token de requisição: 
            <b style="color: limegreen;">
                <tag:token/>
            </b>
        </span>
    </td>
</tr>
</table>

<hr/>