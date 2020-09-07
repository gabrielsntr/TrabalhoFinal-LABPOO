<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="Sistema_de_Reserva_de_Passagens_de_nibus_0"></a>Sistema de Reserva de Passagens de Ônibus</h1>
<p class="has-line-data" data-line-start="2" data-line-end="3">Sistema de reserva de passagens de ônibus desenvolvido utilizando conceitos de Programação Orientada a Objetos como requisito para aprovação na disciplina de Laboratório de Programação Orientada a Objetos do PLSE 2020/3 do curso de Sistemas de Informação da UNEMAT - Universidade do Estado de Mato Grosso.</p>
<h3 class="code-line" data-line-start=4 data-line-end=5 ><a id="Tecnologias_utilizadas_4"></a>Tecnologias utilizadas</h3>
<ul>
<li class="has-line-data" data-line-start="6" data-line-end="7">Java SE -  JDK 8u111</li>
<li class="has-line-data" data-line-start="7" data-line-end="8">Hibernate 4.3</li>
<li class="has-line-data" data-line-start="8" data-line-end="10">MySQL 8 Community Edition</li>
</ul>
<h1 class="code-line" data-line-start=10 data-line-end=11 ><a id="Primeiro_acesso_10"></a>Primeiro acesso</h1>
<p class="has-line-data" data-line-start="12" data-line-end="13">Antes da primeira execução do programa é necessário a alteração de login e senha de acesso da base de dados no arquivo <strong>src\META-INF\persistence.xml</strong> nas seguintes propriedades:</p>
<pre><code>&lt;property name=&quot;javax.persistence.jdbc.user&quot; value=&quot;root&quot;/&gt;
&lt;property name=&quot;javax.persistence.jdbc.password&quot; value=&quot;&quot;/&gt;
</code></pre>
<p class="has-line-data" data-line-start="17" data-line-end="18">Após isso é necessário a criação da base de dados no MySQL com o seguinte comando:</p>
<pre><code>CREATE DATABASE IF NOT EXISTS onibus;
</code></pre>
<p class="has-line-data" data-line-start="21" data-line-end="22">Após isso o Hibernate e JPA se encarregará de criar o restante do Schema. Para o login, pode-se usar o seguinte usuário e senha para acesso:</p>
<pre><code>Username: admin
Password: admin
</code></pre>