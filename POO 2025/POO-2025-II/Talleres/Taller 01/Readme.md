# Programación Orientada a Objetos 
## Taller N°1
**II Semestre - 2025**
**ITI - ICCI**

**Docentes:**
- Alejandro Paolini Godoy
- Cristhian Rabi Reyes

**Ayudantes:**
- Daniel Durán García
- Nicolás Rojas Bustos

---

## Contexto: Análisis de modelos de IA
La humanidad se encuentra en el año 2089, en medio de una crisis tecnológica: los sistemas de Inteligencia Artificial que regulan el tráfico aéreo han comenzado a fallar, clasificando de manera incorrecta vuelos autorizados y no autorizados.  

Un grupo de ingenieros de datos debe analizar el rendimiento de distintos modelos experimentales de IA, verificando su precisión mediante cálculos matemáticos a partir de matrices de confusión.  

Usted, como analista designado, debe desarrollar un sistema en **Java** que permita: 
- Cargar datos de predicciones.
- Calcular métricas de evaluación.
- Presentarlas tanto a un usuario general como a un administrador.

---

## Archivos
### `experimentos.txt`
Contiene la información general de cada experimento.
- **ID**: Identificador único.
- **Descripción**: Breve descripción.

### `metricas.txt`
Define las métricas a calcular.  
- **Métrica**: Tipo de métrica a evaluar.  

### `predicciones.txt`
Contiene registros con valores reales y predichos.  
- **ID**: Experimento asociado.  
- **Valor 1**: Valor real.  
- **Valor 2**: Valor predicho.

### (Extra) `verificacion_docente_confusiones.csv`  
Muestra la matriz de confusión calculada previamente.  
- **Experimento**: ID.  
- **TP**: Verdaderos positivos.  
- **FP**: Falsos positivos.  
- **TN**: Verdaderos negativos.  
- **FN**: Falsos negativos.   

---

## Requerimientos

### Menú Admin (62 pts)  
- Ver la matriz completa de métricas (15 pts).  
- Identificar el experimento con mejor **F1-Score** (12 pts).  
- Calcular promedio global de cada métrica (15 pts).  
- Comparar dos experimentos lado a lado (20 pts).  
- **(EXTRA)** Comparar CSV con matriz de confusión generada (15 pts).  

### Menú Usuario (45 pts)  
- Ver lista de experimentos (6 pts).  
- Mostrar matriz de confusión de un experimento (TP, FP, TN, FN) (10 pts).  
- Ver métricas de un experimento (Accuracy, Precision, Recall, F1) (17 pts).  
- Ver promedio de Accuracy de todos los modelos (12 pts).  

---

## Aclaraciones
- La matriz es el eje central: ahí deben almacenarse los resultados.  
- Los cálculos deben hacerse manualmente, sin librerías externas.  
- **Matriz de confusión**:  
  - TP: Real = 1, Predicho = 1  
  - FP: Real = 0, Predicho = 1  
  - TN: Real = 0, Predicho = 0  
  - FN: Real = 1, Predicho = 0  
- **Fórmulas**:  
  - Accuracy = (TP + TN) / (TP + FP + TN + FN)  
  - Precision = TP / (TP + FP)  
  - Recall = TP / (TP + FN)  
  - F1-Score = 2 * (Precision * Recall) / (Precision + Recall)  
- Comparación de modelos:  
  - Si Accuracy, Precision y Recall son altos → es buen modelo.  
  - Si un modelo tiene mayor F1-Score → generalmente es mejor.  
- El archivo CSV es **extra** (puntaje adicional).  

---

## Consideraciones
- Taller en parejas (2 personas).  
- Solo sintaxis **Java (sin POO)**.  
- Directorio debe tener el nombre de los integrantes, de lo contrario serán evaluados con notas 1.0 (uno coma cero). Fromat: nombreYApellidoIntregrante1_nombreYApellidoIntegrante2_Taller1POO.zip.  
- En las primeras 5 líneas del código deben estar: nombres, RUT y carrera, de lo contrario serán evaluados con nota 1.0 (uno coma cero).  
- Entrega en `.zip` o repositorio GitHub (**puntaje extra** si usan GitHub). Si escogen la primera opción debe ser en formato `.zip`, si no serán evaluados con nota 1.0 (uno coma cero).  
- No se aceptan entregas atrasadas.  
- Proyecto debe ejecutarse en **Eclipse**.  
- En el caso de hacer el `.zip`, **solo 1** debe hacer la **entrega**.
- Código debe estar comentado, con descripción breve de cada función.  

---

## Entregables
- Código fuente.  
- Archivos de entrada usados.  

---

## Criterios de Evaluación

| Criterio                   | Puntaje | Descripción |
|-----------------------------|---------|-------------|
| Orden en nombres de variables | 0-10  | Uso de nombres significativos (`truePositives`, `falseNegatives`). Evitar abreviaturas confusas. |
| Estructura de código        | 0-20   | Código modular, funciones, comentarios claros. Penaliza desorden y redundancia. |
| Menú Admin                  | 0-62   | Implementación completa y fluida de funciones. |
| Menú Usuario                | 0-45   | Funcionalidad clara, comparación de modelos, salida entendible. |
| (EXTRA) Uso de GitHub       | 0-20   | Uso de repositorio con buen manejo. |

**Puntaje total:** 137  
**Puntaje nota mínima:** 81  

---

## Fechas
- **Inicio:** Lunes 25 de agosto.  
- **Entrega:** Viernes 12 de septiembre.  

---

## Contactos
- daniel.duran02@alumnos.ucn.cl  
- nicolas.rojas11@alumnos.ucn.cl  
- [Grupo de WhatsApp](https://chat.whatsapp.com/GvnkfE5RUViJ0AgVtyusbs?mode=ac_t)  
