# La media de Programación Avanzada

### Un grupo de estudiantes de la materia de Programación Avanzada actualmente se encuentra en riesgo de repitencia. Este grupo necesita revisar y analizar su probabilidad de aprobar la materia basándose en sus calificaciones actuales, asistencia y el desempeño histórico del curso.

## Objetivos de aprendizaje
-   Aplicar Programación Orientada a Objetos (Clases, Interfaces, Herencia)
-   Implementar patrones de diseño: **Singleton** y **Factory Pattern**
-   Utilizar estructuras de datos: `List`, `ArrayList` y `LinkedList`
-   Comprender cuándo y cómo aplicar patrones de diseño
-   Manejar lectura y procesamiento de archivos de texto

## Archivos a usar
Para poblar el sistema se tienen los siguientes archivos de texto.

**alumnos.txt**
```
John Doe:5.2:6.0:7
Yuki Tanaka:3.5:3.8:5
Alessandro Rossi:4.8:4.5:8
Priya Patel:3.2:5.5:4
Mohammed Al-Rashid:6.0:4.2:9
Emma Schmidt:2.8:3.5:3
Javier Hernández:5.5:6.5:10
Amélie Dubois:4.0:3.9:6
Chen Wei:3.0:5.0:5
Sophia Kowalski:5.8:5.2:7
Ivan Petrov:2.5:2.8:2
Fatima Ibrahim:6.5:6.8:9
Rajesh Kumar:4.2:4.0:7
Anastasia Volkov:3.8:3.2:4
Lucas Da Silva:5.0:5.5:8
Aisha Okonkwo:4.5:4.8:6
Noah Johnson:3.6:5.9:7
Mei Lin Zhang:5.9:6.2:9
Santiago Morales:2.9:3.1:3
Olivia Anderson:6.2:5.8:8
```
El archivo tiene la siguiente estructura:
- Nombre alumno
- Nota examen 1
- Nota taller
- Clases asistidas


## Requerimientos funcionales
1. Calcular nota necesaria de cada alumno.
2. Calcular asistencia necesaria de cada alumno.
3. Predecir estatus de cada alumno.
4. Calcular y comparar tasas de aprobación.
5. Salir.

## Aclaraciones
- Para calcular la nota final es:  Nf​=(((N1​×P1​)+(N2​×P2​) x 0.65) + (T x 0.35))
- Para cumplir con la asistencia sobre 60%: 
	- ((Clases asistidas + Clases necesitadas) / Clases totales) ≥ 0.6
- Para calcular el porcentaje de inasistencia es: (faltas totales / clases totales) * 100
- Para predecir el estatus de cada alumno: La nota final debe ser sobre 4, la asistencia actual sobre 60%, y la aprobación de exámenes y taller es independiente.
- Para calcular la tasa de aprobación: (N° alumnos aprobados / N° alumnos total) * 100
- La tasa de aprobación del semestre anterior fue 25%
- Hay 10 clases totales.
- Los porcentajes son 47% y 53% de los exámenes 1 y 2 respectivamente.