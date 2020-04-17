<h2> Wysokość płatności: ${amount}zł </h2> <br>
    <h4>Zmień wysokośc opłaty:</h4>
    <form id="changeAmountOfPayment" action="/pay-change-amount" method="post"
          class="form-control d-flex w-25 p-3 mx-auto flex-column">
        <label for="amount" class="sr-only">Amount</label>
        <input id="amount" name="amount" type="number" class="form-control" placeholder="${amount}" required
               autofocus>
        <button class="btn btn-sm btn-block " type="submit">Zmień</button>
    </form>