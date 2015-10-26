<%@include file="/views/@elements/page/header.jsp" %>

<br/>
<small><b>SESSION [CONTROLE HIERARQUICO]</b></small>

<h1>
    Conecte-se
</h1>

<br/>

<form method="post" action="${html.url("/anonymous/users/createsession")}">
    <table>
        <tbody>
            <tr>
                <td>Usuário</td>
                <td>
                    <input type="text" name="user" />
                </td>
            </tr>

            <tr>
                <td>Senha</td>
                <td>
                    <input type="password" name="password" />
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button type="submit" style="float: right;">
                        Conectar
                    </button>
                </td>
            </tr>
        </tbody>
    </table>
</form>

<br/>
<br/>
<hr/>

<table style="text-align: left;">
    <caption style="text-align: left;">
        <h3>
            <b>
                Usuários
            </b>
        </h3>
    </caption>

    <thead>
        <tr>
            <th>HIERARQUIA</th>
            <th>USUÁRIO</th>
            <th>SENHA</th>
            <th>DEFINIDO EM</th>
        </tr>
    </thead>

    <tbody>
        <tr>
            <td>Professor</td>
            <td>roni</td>
            <td>1234</td>
            <td>
                <small>
                    <i><b>properties</b></i>
                </small>
            </td>
        </tr>

        <tr>
            <td>Aluno</td>
            <td>lucian</td>
            <td>1234</td>
            <td>
                <small>
                    <i><b>properties</b></i>
                </small>
            </td>
        </tr>
    </tbody>

    <tfoot>
        <tr>
            <td colspan="4" style="font-size: 12px; color: #777;">
                - O usuário pode conter letras maiúsculas e espaços em branco; <br/>
                - Sua sessão expira em 1 hora.
            </td>
        </tr>
    </tfoot>
</table>

<%@include file="/views/@elements/page/footer.jsp" %>