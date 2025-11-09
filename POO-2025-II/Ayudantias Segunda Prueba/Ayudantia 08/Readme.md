# Octava Ayudantía

### Objetivos

* Comprender e implementar patrones ***Visitor y Strategy***.
* Aplicar conceptos de forma simple y clara en el contexto de Albion Online.

<img align="right" width=280px alt="Library" src="https://media.tenor.com/V0OhYaTPcv8AAAAi/reading-books.gif" />

## Ejercicio 1

En Albion Online, los jugadores recolectan recursos en diferentes zonas y pueden usar distintas estrategias de recolección según la zona y el peligro. Además, necesitas un sistema que analice los recursos recolectados para calcular valores, aplicar bonificaciones y generar reportes.

Por lo cual se te entrega el siguiente archivo txt:

***Recursos.txt***

```
1;Madera de Roble;MADERA;50;AZUL;3
2;Mineral de Hierro;MINERAL;75;AMARILLA;4
3;Fibra de Algodón;FIBRA;40;AZUL;2
4;Cuero Crudo;CUERO;60;AMARILLA;3
5;Piedra Caliza;PIEDRA;55;AZUL;2
```
***ID;Nombre;Tipo;Cantidad;Zona;Tier***
Zonas: AZUL (segura), AMARILLA (riesgo medio), ROJA (riesgo alto), NEGRA (máximo riesgo)

## Requisitos

Ahora se te pide crear el siguiente menu:

````
========== ALBION ONLINE - SISTEMA DE RECURSOS ==========

1) 📦 Gestión de Recursos
   a) Ver todos los recursos recolectados
   b) Recolectar recurso con estrategia actual
   c) Cambiar estrategia de recolección
   
2) 🔍 Análisis de Inventario (Visitor)
   a) Calcular valor total en plata
   b) Aplicar bonificación premium
   
3) 🚪 Salir
````

## Consideraciones
- El patrón Strategy debe implementar 2 estrategias
  - Estrategia segura: 
    - Solo recolecta en zonas VERDES
    - Cantidad base: x1.0
    - Riesgo de muerte: 0%
    - Tiempo: Normal
  - Estrategia arriesgada:
    - Recolecta en zonas AMARILLAS/ROJAS
    - Cantidad base: x1.5
    - Riesgo de muerte: 30%
    - Tiempo: Rápido
  
---

- El patrón Visitor debe implementar 3 visitantes
  - ValorCalculadorVisitor
    - Calcula el valor en plata de cada recurso:
  - BonificacionPremiumVisitor
    - Aplica bonificación del 50% si el jugador tiene cuenta premium:

***Aclaraciones***

- El sistema debe permitir cambiar estrategias sin reiniciar
- Strategy se usa para cambiar CÓMO se recolectan recursos
- Visitor se usa para ANALIZAR los recursos sin modificar su clase
- El menú debe ser simple y directo