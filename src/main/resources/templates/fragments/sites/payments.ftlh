<table class="table table-dark">
    <thead>
    <tr>
        <th>Miesiąc</th>
        <th>Płatność</th>
    </tr>
    </thead>
    <tbody>
    <#list paymentsList>
        <#items as payment>

            <tr>
                <th scope="row" bgcolor="<#if payment.status == "paid" > #006633 <#elseif payment.status == "unpaid"> #CC6666 <#elseif payment.status == "inProgress"> #6699FF </#if>"> ${payment.monthOfPayment} </th>
                <td>
                    <form id="payment" <#if payment.status= "unpaid"> action="/pay-pay" <#elseif payment.status == "inProgress"> action="pay-unpaid" </#if>  method="post">
                        <input type="hidden" name="paymentId" value="${payment.id}">
                        <input type="hidden" name="username" value="${user.username}">
                       <#if payment.status == "unpaid">  <button class="btn-sm btn-success" > Zapłać </button> <#elseif payment.status == "inProgress"> W trakcie(poczekaj na potwierdzenie przelewu) <a href="/pay-pay?paymentId=${payment.id}" class="btn-outline-info">Informacje do przelewu</a>  <#else> Opłacono </#if>
                    </form>
                </td>
            </tr>
        </#items>
    </#list>

    </tbody>
</table>