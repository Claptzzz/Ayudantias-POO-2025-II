# Sexta Ayudantía

### Objetivos

* Implementar Interfaces.
* Comprender la arquitectura.

<img align="right" width=250px alt="Unicorn" src="https://media.tenor.com/dg7Th23TzFUAAAAi/cat-vodk.gif" />

## Ejercicio 1

PetPapuVet es una clinica veterinaria de alto calibre donde las personas tienen una alta confianza para dejar a sus seres más queridos. Ultimamente tienen problemas en su sistema para calcular los precios de hospitalizacion post-operatorio, por lo cual se te contrata para que desarrolles un sistema para calcular los precios dependiendo del animal.

La veterinaria trabaja con las siguientes especies: Perros, Gatos, Cobayas, Hurones, Erizos.

Cada una tiene una formula diferente para calcular su precio:

***Perros***
````
40000+(Peso*Dias)
````

<img align="right" width=200px alt="Unicorn" src="https://media.tenor.com/SdZ_Tv4QBI0AAAAi/%D1%85%D0%BE%D0%BC%D1%8F%D0%BA-dance.gif" />

***Gatos***
````
30000+(Dias/Peso)
````
***Cobayas***
````
20000+(Edad/Peso)
````
***Hurones***
````
50000+(Edad*Peso)
````

<img align="right" width=200px alt="Unicorn" src="https://media.tenor.com/fAvWtyDOklYAAAAj/perky-ferret.gif" />

***Erizos***
````
45000+(Edad/Dias)
````

Ahora se te entrega el siguiente txt con la informacion de los animales tratados recientemente:

***Datos.txt***
````
1;Max;Perro;5;24.3;3;SI
2;Luna;Gato;2;4.1;1;NO
3;Coco;Cobaya;1;0.9;5;SI
5;Milo;Hurón;3;1.8;7;SI
6;Nina;Erizo;4;0.6;4;NO
````

***ID;Nombre;Especie;Edad;Peso;DiasHospitalizado;Frecuente***

Donde Frecuente indica ***SI*** o ***NO*** dando a entender si el animal ha estado hospitalizado antes en la clinica, en caso de ser cliente regular entonces se le aplica un descuento del 25%.

Se te pide generar un menu con las siguentes opciones:
````
1) Imprimir informacion animales.
2) Calcular precio hospitalizacion por ID.
3) Menor y Mayor precio encontrado.
4) Salir.
````

***Aclaraciones***
* Debe usar una arquitectura aceptable.
* Debe usar Interfaces.
* No debe usar Herencia.