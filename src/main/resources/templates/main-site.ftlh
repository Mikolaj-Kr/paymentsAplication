<!doctype html>
<html lang="pl">
<#include "fragments/head.ftlh">

<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <#include "fragments/header.ftlh">

  <main authorities="main" class="inner cover">
      <#if username = "anonymousUser">
    <h1 class="cover-heading">Witaj nieznajomy. <br> Zaloguj lub zarejestruj się aby skorzystać z serwisu</h1>
          <button class="btn btn-lg btn-block" onclick="locationReplace('/login')">Logowanie</button>
          <button class="btn btn-lg btn-block" onclick="locationReplace('/pay-registration')">Rejestracja</button>
          <#else >
    <h1 class="cover-heading">Witaj ${username}</h1>
      </#if>

  </main>

  <#include "fragments/footer.ftlh">
</div>
<#include "fragments/scriptImport.ftlh">
<script src="js/bootstrap.min.js"></script>
<script src="/js/locationActions.js"></script>

</body>
</html>