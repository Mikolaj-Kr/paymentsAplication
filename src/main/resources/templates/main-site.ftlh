<!doctype html>
<html lang="pl">
<#include "fragments/solidElements/head.ftlh">

<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <#include "fragments/solidElements/header.ftlh">

    <#include "fragments/sites/${site}.ftlh">

  <#include "fragments/solidElements/footer.ftlh">
</div>
<#include "fragments/solidElements/scriptImport.ftlh">

</body>
</html>