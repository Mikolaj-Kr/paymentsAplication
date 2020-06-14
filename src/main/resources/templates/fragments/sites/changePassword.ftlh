<form id="registrationForm" action="/pay-account-change-password" method="post" class="form-signin">
    <#if status??>
        <#if status == "2"> <h3 class="alert-danger"> Wprowadzono złe stare hasło </h3>
        <#elseif status == "3"> <h3 class="alert-danger"> Hasła nie zgadzają się, wprowadź ponownie</h3>
            <label for="oldPassword" class="sr-only"></label>
            <input id="oldPassword" name="oldPassword" type="password" class="form-control" placeholder="stare hasło"
                   required autofocus>
            <label for="password" class="sr-only">Hasło</label>
            <input id="password" name="password" type="password" class="form-control" placeholder="hasło" required
                   autofocus>
            <br>
            <label for="password2" class="sr-only">Hasło2</label>
            <input id="password2" name="password2" type="password" class="form-control" placeholder="Powtórz hasło"
                   onkeyup="checkPass()" required autofocus> <br>
            <input type="hidden" name="username" value="${username}">
            <button class="btn btn-lg btn-block">Zmień hasło</button>
        <#elseif status == "1"> <h3 class="alert-success"> Hasło zmieniono poprawnie </h3>
        </#if>
    <#else>
        <h1 class="h3 mb-3 font-weight-normal">Zmiana hasła</h1>
        <label for="oldPassword" class="sr-only"></label>
        Wprowadź stare hasło
        <input id="oldPassword" name="oldPassword" type="password" class="form-control" placeholder="stare hasło"
               required autofocus>
        <label for="password" class="sr-only">Hasło</label>
        Wprowadź hasło
        <input id="password" name="password" type="password" class="form-control" placeholder="hasło" required
               autofocus>
        <label for="password2" class="sr-only">Hasło2</label>
        Powtórz hasło
        <input id="password2" name="password2" type="password" class="form-control" placeholder="Powtórz hasło"
               onkeyup="checkPass()" required autofocus> <br>
        <span id="confirmMessage"></span>
        <input type="hidden" name="username" value="${username}">
        <button class="btn btn-lg btn-block">Zmień hasło</button>
    </#if>
</form>
