# payclip-cch
Payclip's Code Challenge

By Fabian Salamanca Dominguez, 2018

User guide:

From root directory run ./application wrapper script.

./application &lt;userid&gt; add &lt;transaction-json&gt; <br/>
./application &lt;userid&gt; list <br/>
./application &lt;userid&gt; sum <br/>
./application &lt;transaction-id&gt; <br/>


<br/>
<h3>DOCKER VERSION</h3>

<p>Examples: (docker image is already in the public docker hub)</p>

docker pull fabstao/fabs_payclip

docker run -it fabstao/fabs_payclip ./application 3323 list <br>
docker run -it fabstao/fabs_payclip ./application 3323 sum  <br>
