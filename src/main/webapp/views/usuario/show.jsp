<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="background: #48762A">
    <div class="chamada row">
        <div class="twelve columns">
            <h3 style="color: white;">Detalhes do usuário</h3>
        </div>
    </div>
    <div class="row">
        <h4>Dados básicos:</h4>
    </div>

    <div class="row">
        <div class="two columns"><b>Avatar: </b></div>
        <div class="ten columns">
            <img style="width:128px; height:128px;" src='<c:url value="/usuario/avatar/${usuario.login}"/> '>
        </div>
    </div>

    <div class="row">
        <div class="two columns">Nome: </div>
        <div class="two columns">${usuario.nome}</div>
    </div>

    <div class="row">
        <div class="two columns">Login: </div>
        <div class="two columns">${usuario.login}</div>
    </div>

    <div class="row">
        <div class="two columns">E-mail: </div>
        <div class="two columns"><a href="mailto:${usuario.email}">${usuario.email}</a></div>
    </div>

    <div class="row">
        <div class="two columns">Twitter: </div>
        <div class="two columns"><a href="http://www.twitter.com/${usuario.twitter}">${usuario.twitter}</a></div>
    </div>

    <div class="row">
        <h4>Últimos posts:</h4>
        <a href="javascript:exporPosts('${usuario.login}')">Expor posts</a>
        <div id="posts"></div>
    </div>

    <script type="application/javascript">
        function exporPosts(login) {
            var url = "<c:url value="/usuario/posts/"/>" + login
            $("#posts").load(url);
        }
    </script>
</div>