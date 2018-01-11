<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="background:  #48762A">
    <div class="row">
        <div class="twelve column">
            <img src="/recursos/images/chamada.png" />
        </div>
    </div>

    <div class="row">
        <div class="two columns">
            <h5>Assuntos</h5>
            <ul class="side-nav">
                <c:forEach items="${assuntos}" var="assunto">
                    <li><a href="assunto/${assunto.id}">${assunto.nome}</a></li>
                </c:forEach>
            </ul>
        </div>

        <div class="eight columns">
            <h5>O que é isto?</h5>
            <p>O projeto Spring Fórum é um gerenciador de comunidades (a la GUJ) baseado no livro Vire o Jogo com Spring Framework</p>
            <p>Seu código fonte é totalmente aberto e você é livre para explorá-lo da maneira que achar melhor.</p>
        </div>

        <div class="two columns">
            <h5>Usuários</h5>
            <ul class="side-nav">
                <c:forEach items="${usuarios}" var="usuario">
                    <li><a href="usuario/show/${usuario.id}">${usuario.nome}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>

</div>