<main class="inner cover">
      <#if username = "anonymousUser">
            <h1 class="cover-heading">Witaj nieznajomy. <br> Zaloguj lub zarejestruj się aby skorzystać z serwisu</h1>
            <button class="btn btn-lg btn-block" onclick="locationReplace('/login')">Logowanie</button>
            <button class="btn btn-lg btn-block" onclick="locationReplace('/pay-registration')">Rejestracja</button>
      <#else >
            <h1 class="cover-heading">Witaj ${username}</h1>
      </#if>

</main>