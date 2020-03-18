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
                    <form id="payment" action="/pay-pay" method="post">
                        <input type="hidden" name="paymentId" value="${payment.id}">
                        <input type="hidden" name="username" value="${user.username}">
                       <#if payment.status == "unpaid">  <button> Zapłać </button> <#else> ${payment.status}  </#if>
                    </form>
                </td>
            </tr>
        </#items>
    </#list>

    </tbody>
</table>