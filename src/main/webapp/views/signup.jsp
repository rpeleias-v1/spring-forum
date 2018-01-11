
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="row">
    <div class="four columns">
        <h4>Bem-vindo(a) ao Spring Fórum</h4>
        <p>
            Esperamos poder lhe ajudar a dominar o máximo possível todos os conceitos por trás do Spring
            Framework e seus projetos relacionados
        </p>
    </div>

    <div class="eight columns">
        <sf:form modelAttribute="usuario" action="executarRegistro" enctype="multipart/form-data">
            <label for="nome">Nome: <sf:errors path="nome" cssClass="erro" /> </label>
            <sf:input path="nome" cssClass="four" />

            <label for="email">Email: <sf:errors path="email" cssClass="erro" /> </label>
            <sf:input path="email" cssClass="four" />

            <label for="login">Nome do usuário (login): <sf:errors path="login" cssClass="erro" /> </label>
            <sf:input path="login" cssClass="four" />

            <label for="senha">Senha:</label>
            <sf:password path="senha" cssClass="four" />

            <label for="avatar">Avatar: </label>
            <input type="file" name="avatar" id="avatar" />

            <input type="submit" value="Faça a sua parte!" class="tiny button success">
        </sf:form>
    </div>
</div>