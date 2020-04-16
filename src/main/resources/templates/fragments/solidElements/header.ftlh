<header class="masthead mb-auto">
    <div class="inner">
        <h3 class="masthead-brand">Płatności On-line</h3>
        <nav class="nav nav-masthead justify-content-center">
            <#if username = "anonymousUser">
                <a class="nav-link <#if site="main">active</#if>" href="/pay-main">Strona główna</a>
                <a class="nav-link <#if site="login">active</#if>" href="/login">Zaloguj się</a>
                <a class="nav-link <#if site="registration">active</#if> " href="/pay-registration">Zarejestruj
                    się</a>
            <#elseif username = "mikolak25@gmail.com">
                <a class="nav-link <#if site="main">active</#if>" href="/pay-main">Strona główna</a>
                <a class="nav-link <#if site="users">active</#if>" href="/pay-users">Użytkownicy</a>
                <a class="nav-link <#if site="paymentsSettings">active</#if>" href="/pay-payments-settings">Płatności</a>
                <a class="nav-link <#if site="account">active</#if>" href="/pay-account">Konto</a>
                <a class="nav-link" href="/logout">Wyloguj</a>
            <#else>
                <a class="nav-link <#if site="main">active</#if>" href="/pay-main">Strona główna</a>
                <a class="nav-link <#if site="payments">active</#if>" href="/pay-payments">Płatności</a>
                <a class="nav-link <#if site="account"> active </#if>" href="/pay-account">Konto</a>
                <a class="nav-link" href="/logout">Wyloguj</a>
            </#if>
        </nav>
    </div>
</header>