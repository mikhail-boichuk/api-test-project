<html>
<#-- @ftlvariable name="data" type="io.qameta.allure.attachment.http.HttpResponseAttachment" -->
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.5.0/styles/monokai.min.css" integrity="sha512-RLF8eOxhuwsRINc7r56dpl9a3VStqrXD+udWahutJrYdyh++2Ghnf+s4jFsOyryKZt/GNjPwbXVPH3MJpKrn2g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.5.0/highlight.min.js" integrity="sha512-BNc7saQYlxCL10lykUYhFBcnzdKMnjx5fp5s5wPucDyZ7rKNwCoqJh1GwEAIhuePEK4WM9askJBRsu7ma0Rzvg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.5.0/languages/bash.min.js" integrity="sha512-gXQ69/0a3+hfqM8YwiRW6mK7SIi6bSO2dXmFatm9ct/zD0etY70SdUJgBtATMQgB8O9gn7hwo6RklHaGlg2b+A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.5.0/languages/json.min.js" integrity="sha512-CYNXYs/v5lf987Bm4mWE+5ZnOdxNoKqBrro4AtHg012BQDFj7b1V3YQyAPhYF/jGcxqkPpudoe8dCkkdmAH+cQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.5.0/languages/xml.min.js" integrity="sha512-+bb1+kzXMhHsUlA+lQfd4nSdOlgxtCvUYY5Q31pd4kloJ1fuzaplaepw+k8uGPyjO3ZzKCYe8NsTuVl29IG4wg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script>hljs.highlightAll();</script>

    <style>
        pre {
            white-space: pre-wrap;
        }
    </style>
</head>
<body>
<div><h4><b>Status code:</b></h4> <#if data.responseCode??>
    <pre><code><b>${data.responseCode}</b></code></pre>
<#else>Unknown</#if></div>
<#if data.url??>

<div>
    <pre><code>${data.url}</code></pre>
</div></#if>

<#if (data.headers)?has_content>
<h4><b>Headers:</b></h4>
<div>
    <#list data.headers as name, value>
        <div>
            <pre><code><b>${name}</b>: ${value}</code></pre>
        </div>
    </#list>
</div>
</#if>

<#if data.body??>
<h4><b>Body:</b></h4>
<div>
    <pre><code>${data.body}</code></pre>
</div>
</#if>

<#if (data.cookies)?has_content>
    <h4><b>Cookies:</b></h4>
<div>
    <#list data.cookies as name, value>
        <div>
            <pre><code><b>${name}</b>: ${value}</code></pre>
        </div>
    </#list>
</div>
</#if>
</body>
</html>