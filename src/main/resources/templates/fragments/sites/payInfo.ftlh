<h1>Wykonaj przelew na konto: </h1> <br>
<h3>Mikołaj Krawczak</h3>
<h3>Numer konta: 22156000132085086950000001</h3>
<h3>Temat: Netflix + miesiąć/miesiące </h3>
<h3>Kwota: 11zl </h3> <br>
<h4>Po potwierdzeniu przelewu status płatności zmieni się. Może to potrwać do 2 dni</h4><br>
<#if paymentId??>
<form id="dotPayForm" action="/pay-dot" method="post">
    <input type="hidden" value="${username}" name="username">
    <input type="hidden" value="${paymentId}" name="paymentId">
    <button class="btn btn-lg btn-block" type="submit" onclick="dotPay()">Zapłać przy pomocy DotPay</button>
</form>
</#if>
<a href="/pay-payments" class="alert-success">Powrót do płatności</a>