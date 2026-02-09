# Quinta Ayudantía

### Objetivos

* Implementar Herencia.
* Reforzar resolución de problemas.

<img align="right" width=280px alt="Unicorn" src="https://media.tenor.com/uyO45fvchzIAAAAi/dinocop-dancing.gif" />

## Ejercicio 1

Hace millones de años existian especies que dominaban tanto la tierra, el mar, y el cielo. Hoy los conocemos como "Dinosaurios", existian muchisimas especies de estos, que ha pesar de no tener ejemplares al día de hoy se han investigado a fondo para conocer el pasado de nuestro planeta. 

Se nos pide recopilar información de como estos Dinosaurios se adaptaban y su tasa de supervivencia por especie, a partir del siguiente txt:

***Dinosaurios.txt***
````
1;Velociraptor;Terrestre;22;39;75;13
2;Tyrannosaurus Rex;Terrestre;30;27;8500;88
3;Triceratops;Terrestre;25;18;100;190
4;Brachiosaurus;Terrestre;40;15;9;21
````

***ID;Especie;Hábitat;EsperanzaVida;VelocidadPromedio;AtributoUnico***  ---> Puede ser 1 o más atributos unicos dependiendo de la especie.

En esta ocasión se nos presentan 4 especies: Velociraptor, Tyrannosaurus Rex, Triceratops, Brachiosaurus. Cada una presenta diferentes atributos adicionales y formula distinta para calcular su adaptabilidad.

***Velociraptor***
````
InteligenciaColectiva;GarrasAfiladas
((VelocidadPromedio+InteligenciaColectiva)/EsperanzaVida)*GarrasAfiladas
````

***Tyrannosaurus Rex***
````
FuerzaMordida;DurezaEscamas
(FuerzaMordida+DurezaEscamas+VelocidadPromedio)/EsperanzaVida
````

***Triceratops***
````
CuernosDefensivos
(EsperanzaVida*CuernosDefensivos)/VelocidadPromedio
````

***Brachiosaurus***
````
LargoCuello
(EsperanzaVida*LargoCuello)/VelocidadPromedio
````

Ahora se nos pide generar el siguiente menu:

````
1) Filtrar Info de ejemplares por especie
2) Calcular adaptabilidades acumuladas de cada especie
3) Mostrar dinosaurio con mejor adaptabilidad
4) Salir
````

***Aclaraciones***
* Usar Herencia.
* Guardar todas las especies en una misma ArrayList.
