<form id="registrationForm" action="/pay-change-password" method="post" class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal">Wprowadź hasło</h1>
    <#if status??><h3 class="alert-danger"> Podano dwa różne hasła spróbuj ponownie</h3></#if>
    <label for="password" class="sr-only">Hasło</label>
    <input id="password" name="password" type="password" class="form-control" placeholder="hasło" required autofocus>
    <br>
    <label for="password2" class="sr-only">Hasło2</label>
    <input id="password2" name="password2" type="password" class="form-control" placeholder="Powtórz hasło"
           onkeyup="checkPass()" required autofocus> <br>
    <input type="hidden" name="code" value="${code}">
    <input type="hidden" name="username" value="${username}">
    <span id="confirmMessage"></span>
    <button class="btn btn-lg btn-block">Zmień hasło</button>
</form>
