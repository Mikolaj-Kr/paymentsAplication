<header class="masthead mb-auto">
  <div class="inner">
    <h3 class="masthead-brand">Płatności On-line</h3>
    <nav class="nav nav-masthead justify-content-center">
        <#if username = "anonymousUser">
          <a class="nav-link <#if site="main">active</#if>" href="/pay-main">Strona główna</a>
          <a class="nav-link" href="/login">Zaloguj się</a>
          <a class="nav-link <#if site="registration">active</#if> " href="/pay-registration">Zarejestruj
            się</a>
        <#else >
          <a class="nav-link <#if site="main">active</#if>" href="">Strona główna</a>
          <a class="nav-link" href="#">Płatności</a>
          <a class="nav-link" href="#">Konto</a>
          <a class="nav-link" href="/logout">Wyloguj</a>
        </#if>
    </nav>
  </div>
</header>