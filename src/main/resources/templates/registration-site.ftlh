<!doctype html>
<html lang="pl">
<#include "fragments/head.ftlh">

<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">

  <#include "fragments/header.ftlh">

<form id="registrationForm" action="/pay-registration" method="post" class="form-signin">
  <h1 class="h3 mb-3 font-weight-normal">Zarejestruj się</h1>
  <label for="name" class="sr-only">Imię</label>
  <input id="name" name="name" type="text" class="form-control" placeholder="Imie" required autofocus>
  <label for="surname" class="sr-only">Nazwisko</label>
  <input id="surname" name="surname" type="text" class="form-control" placeholder="Nazwisko" required autofocus>
  <label for="username" class="sr-only">Nazwa użytkownika</label>
  <input id="username" name="username" type="text" class="form-control" placeholder="Nazwa użytkownika" required autofocus>
  <div id="error"></div>
  <label for="password" class="sr-only">Hasło</label>
  <input id="password" name="password" type="password"  class="form-control" placeholder="Hasło" required>
  <label for="password2" class="sr-only">Powtórz Hasło</label>
  <input id="password2" name="password2" type="password"  class="form-control" placeholder="Powtórz hasło" onkeyup="checkPass()" required>
  <span id="confirmMessage"></span>
  <button class="btn btn-lg btn-block" type="submit">Rejestracja</button>
</form>
  <#include "fragments/footer.ftlh">
</div>
<#include "fragments/scriptImport.ftlh">
<script defer src="js/passwordValidation.js"></script>
<script src="/js/locationActions.js"></script>

</body>
</html>