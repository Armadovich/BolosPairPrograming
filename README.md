# Bowling Score Calculator

Este script en Java implementa un calculador de puntuación para el juego de bolos. Se compone de dos clases principales:

### Clases

#### 1. `ScoreCard`

La clase principal que maneja la puntuación del juego de bolos. Contiene métodos para inicializar un marcador, calcular la puntuación total y calcular los frames individuales.

- **Constructores:**
  - `public ScoreCard()`: Inicializa un marcador vacío.
  - `public ScoreCard(String scoreCard)`: Inicializa un marcador con una cadena de texto.

- **Métodos Principales:**
  - `public int calculateScore(String scoreCard)`: Calcula y devuelve la puntuación total del juego.
  - `private Frame[] calculateFrame(String scoreCard)`: Divide la cadena del marcador en frames y crea instancias de la clase `Frame`.

#### 2. `Frame`

Clase que representa un frame individual del juego de bolos. Contiene información sobre los lanzamientos y la puntuación del frame.

- **Constructores:**
  - `public Frame()`: Constructor sin argumentos.
  - `public Frame(char pin1, char pin2)`: Constructor para frames regulares con dos lanzamientos.
  - `public Frame(char pin1, char pin2, char pinExtra)`: Constructor para el último frame con tres lanzamientos.

- **Métodos Principales:**
  - `public int getScore()`: Devuelve la puntuación del frame.
  - `public void setScore(int score)`: Establece la puntuación del frame.

### Funcionamiento

El script utiliza la lógica del juego de bolos para calcular la puntuación total. Se identifican strikes, spares y lanzamientos regulares, y se asignan puntuaciones en consecuencia. La clase `ScoreCard` utiliza streams para sumar las puntuaciones de cada frame individual. Asegúrate de ingresar marcadores válidos para obtener resultados precisos.