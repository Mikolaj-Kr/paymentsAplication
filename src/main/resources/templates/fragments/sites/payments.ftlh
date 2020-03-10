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
                <th scope="row"> ${payment.monthOfPayment} </th>
                <td>
                    <form id="payment" action="/pay-pay" method="post">
                        <input type="hidden" name="paymentId" value="${payment.id}">
                       <#if !payment.regulated>  <button> Zapłać </button> </#if>
                    </form>
                </td>
            </tr>
        </#items>
    </#list>

    </tbody>
</table>